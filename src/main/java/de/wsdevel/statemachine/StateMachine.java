package de.wsdevel.statemachine;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

import de.wsdevel.tools.commands.CommandWithThrowable;
import de.wsdevel.tools.common.interfaces.Named;
import de.wsdevel.tools.common.interfaces.impl.NamedImpl;

/**
 * Created on 18.03.2008.
 * 
 * for project: Java__Tools
 * 
 * @author <a href="mailto:sweiss@weissundschmidt.de">Sebastian A. Weiss - Weiss
 *         und Schmidt, Mediale Systeme GbR</a>
 * @version $Author: sweiss $ -- $Revision: 1.4 $ -- $Date: 2008-10-01 14:55:38
 *          $
 * 
 * <br>
 *          (c) 2007, Weiss und Schmidt, Mediale Systeme GbR - All rights
 *          reserved.
 * 
 */
public class StateMachine extends NamedImpl implements Named {

	/**
	 * <code>long</code> serial version unique id.
	 */
	private static final long serialVersionUID = -1087829824880395995L;

	/**
	 * {@link State} the currentState.
	 */
	private State currentState;

	/**
	 * {@link StateMachineHandler} handler for errors.
	 */
	private final StateMachineHandler handler;

	/**
	 * {@link State} the initial state.
	 */
	private State initialState;

	/**
	 * {@link Timer} thread used by this state machine.
	 */
	private Timer stateMachineThread;

	/** {@link ExecutorService} The executorService. */
	private final ExecutorService executorService;

	/**
	 * {@link HashMap<String,State>} COMMENT.
	 */
	private final HashMap<String, State> states = new HashMap<String, State>();

	/**
	 * Default constructor.
	 */
	public StateMachine() {
		this("", new SimpleLogStateMachineHandler());
	}

	/**
	 * @param nameVal
	 *            {@link String} name of this instance.
	 * @param handlerRef
	 *            {@link StateMachineHandler}
	 */
	public StateMachine(final String nameVal,
			final StateMachineHandler handlerRef) {
		this(nameVal, handlerRef, null);
	}

	/**
	 * @param nameVal
	 *            {@link String} name of this instance.
	 * @param handlerRef
	 *            {@link StateMachineHandler}
	 */
	public StateMachine(final String nameVal,
			final StateMachineHandler handlerRef,
			final ExecutorService executorServiceRef) {
		setName(nameVal);
		this.executorService = executorServiceRef;
		if (this.executorService == null) {
			this.stateMachineThread = new Timer(nameVal + "-THREAD", false);
		}
		this.handler = handlerRef;
	}

	/**
	 * @param state
	 *            {@link State} to be added.
	 */
	public final void addState(final State state) {
		this.states.put(state.getName(), state);
		if (this.states.size() == 1) {
			setInitialState(state);
		}
	}

	/**
	 * @return {@link State} the initialState.
	 */
	public final State getInitialState() {
		return this.initialState;
	}

	/**
	 * @return {@link Collection} containing all states;
	 */
	public final Collection<State> getStates() {
		return new LinkedList<State>(this.states.values());
	}

	/**
	 * @param initialStateRef
	 *            {@link State} the initialState to set.
	 */
	public final void setInitialState(final State initialStateRef) {
		this.initialState = initialStateRef;
		this.currentState = initialStateRef;
	}

	/**
	 * @param trans
	 *            {@link Transition} the transition it should be tried to be
	 *            invoked.
	 */
	public final void tryTransition(final String transitionName) {
		tryTransition(transitionName, null);
	}

	/**
	 * @param trans
	 *            {@link Transition} the transition it should be tried to be
	 *            invoked.
	 * @param parameters
	 *            {@link Object}[]
	 */
	public final void tryTransition(final String transitionName,
			final Object[] parameters) {
		final TimerTask task = new TimerTask() {
			/**
			 * COMMENT.
			 * 
			 * @param state
			 *            {@link State}
			 */
			private void enterState(final State state) {
				StateMachine.this.handler.tryToEnterState(StateMachine.this,
						state);
				StateMachine.this.currentState = state;
				final CommandWithThrowable entryCommand = state
						.getEntryCommand();
				if (entryCommand != null) {
					try {
						entryCommand.run();
					} catch (final Throwable e1) {
						StateMachine.this.handler.entryFailed(
								StateMachine.this, state);
					}
				}
				StateMachine.this.handler
						.enteredState(StateMachine.this, state);
			}

			/**
			 * COMMENT.
			 * 
			 * @param state
			 *            {@link State}
			 */
			private void exitState(final State state) {
				StateMachine.this.handler.tryToExitState(StateMachine.this,
						state);
				final CommandWithThrowable exitCommand = state.getExitCommand();
				if (exitCommand != null) {
					try {
						exitCommand.run();
					} catch (final Throwable e) {
						StateMachine.this.handler.exitFailed(StateMachine.this,
								state);
					}
				}
				StateMachine.this.handler.exitedState(StateMachine.this, state);
			}

			/**
			 * @see java.util.TimerTask#run()
			 */
			@Override
			public final void run() {
				if (StateMachine.this.currentState
						.hasTransition(transitionName)) {
					final Transition trans = StateMachine.this.currentState
							.getTransition(transitionName);
					StateMachine.this.handler.tryTransition(StateMachine.this,
							transitionName);
					synchronized (StateMachine.this.currentState) {
						final State oldState = StateMachine.this.currentState;
						exitState(oldState);
						StateMachine.this.currentState = null;
						final TransitionCommand transitionCommand = trans
								.getTransitionCommand();
						if (transitionCommand != null) {
							try {
								transitionCommand.run(parameters);
							} catch (final Throwable e) {
								StateMachine.this.handler
										.errorOccured(
												StateMachine.this,
												parameters,
												"Error during transition: "
														+ e.getLocalizedMessage()
														+ " - Return to previous state ["
														+ oldState.getName()
														+ "]", e);

								enterState(oldState);
								return;
							}
						}
						enterState(trans.getNextState());
					}
				} else {
					StateMachine.this.handler.invalidTransition(
							StateMachine.this, StateMachine.this.currentState,
							transitionName);
				}
			}

		};
		if (this.executorService != null) {
			this.executorService.execute(task);
		} else if (this.stateMachineThread != null) {
			this.stateMachineThread.schedule(task, 0);
		}

	}

}
//
// $Log: StateMachine.java,v $
// Revision 1.4 2008-10-01 14:55:38 sweiss
// setting first state added as initial state
//
// Revision 1.3 2008-09-22 08:46:48 sweiss
// first release
//
// Revision 1.2 2008-03-26 23:30:32 sweiss
// added betwixt support
//
// Revision 1.1 2008-03-25 19:48:04 sweiss
// *** empty log message ***
//
// Revision 1.1 2008-03-18 19:57:17 sweiss
// FlashStreamClient uses statemachine
//
//
