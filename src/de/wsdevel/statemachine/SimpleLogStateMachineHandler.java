package de.wsdevel.statemachine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created on 10.06.2008.
 * 
 * for project: Java__StateMachine
 * 
 * @author <a href="mailto:sweiss@weissundschmidt.de">Sebastian A. Weiss - Weiss
 *         und Schmidt, Mediale Systeme GbR</a>
 * @version $Author: sweiss $ -- $Revision: 1.2 $ -- $Date: 2008-09-22 08:46:48
 *          $
 * 
 * <br>
 *          (c) 2007, Weiss und Schmidt, Mediale Systeme GbR - All rights
 *          reserved.
 * 
 */
public class SimpleLogStateMachineHandler implements StateMachineHandler {

	/** {@link Log} The logToBeUsed. */
	private final Log logToBeUsed;

	/**
	 * {@link Log} the logger.
	 */
	private static final Log LOG = LogFactory
			.getLog(SimpleLogStateMachineHandler.class);

	/**
	 * SimpleLogStateMachineHandler constructor.
	 */
	public SimpleLogStateMachineHandler() {
		this(SimpleLogStateMachineHandler.LOG);
	}

	/**
	 * SimpleLogStateMachineHandler constructor.
	 * 
	 * @param logToBeUsedRef
	 *            {@link Log}
	 */
	public SimpleLogStateMachineHandler(final Log logToBeUsedRef) {
		this.logToBeUsed = logToBeUsedRef;
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#enteredState(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	@Override
	public void enteredState(final StateMachine statemachine,
			final State newState) {
		if (this.logToBeUsed.isDebugEnabled()) {
			this.logToBeUsed.debug("Statemachine [" + statemachine.getName()
					+ "] entered state [" + newState.getName() + "].");
		}
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#entryFailed(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	@Override
	public void entryFailed(final StateMachine statemachine,
			final State newState) {
		this.logToBeUsed.error("Statemachine [" + statemachine.getName()
				+ "]: Error entering state [" + newState.getName() + "]");
	}

	/**
	 * @see de.wsdevel.statemachine.StateMachineHandler#errorOccured(de.wsdevel.statemachine.StateMachine,
	 *      java.lang.Object[], java.lang.String, java.lang.Throwable)
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param parameters
	 *            {@link Object}[]
	 * @param message
	 *            {@link String}
	 * @param t
	 *            {@link Throwable}
	 */
	@Override
	public void errorOccured(final StateMachine statemachine,
			Object[] parameters, final String message, final Throwable t) {
		this.logToBeUsed.error("Statemachine [" + statemachine.getName()
				+ "]: " + message, t);
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#exitedState(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	@Override
	public void exitedState(final StateMachine statemachine,
			final State oldState) {
		if (this.logToBeUsed.isDebugEnabled()) {
			this.logToBeUsed.debug("Statemachine [" + statemachine.getName()
					+ "] exited state [" + oldState.getName() + "].");
		}
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#exitFailed(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	@Override
	public void exitFailed(final StateMachine statemachine, final State oldState) {
		this.logToBeUsed.error("Statemachine [" + statemachine.getName()
				+ "]: Error exiting state [" + oldState.getName() + "]");
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param currentState
	 *            {@link State}
	 * @param nameOfTransitionTried
	 *            {@link String}
	 * @see de.wsdevel.statemachine.StateMachineHandler#invalidTransition(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State, java.lang.String)
	 */
	@Override
	public void invalidTransition(final StateMachine statemachine,
			final State currentState, final String nameOfTransitionTried) {
		this.logToBeUsed.error("Statemachine [" + statemachine.getName()
				+ "]: Error trying transition '" + nameOfTransitionTried
				+ "' in state '" + currentState.getName() + "'.");
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#tryToEnterState(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	@Override
	public void tryToEnterState(final StateMachine statemachine,
			final State newState) {
		if (this.logToBeUsed.isDebugEnabled()) {
			this.logToBeUsed.debug("Statemachine [" + statemachine.getName()
					+ "]: Try to enter state [" + newState.getName() + "].");
		}
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#tryToExitState(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	@Override
	public void tryToExitState(final StateMachine statemachine,
			final State oldState) {
		if (this.logToBeUsed.isDebugEnabled()) {
			this.logToBeUsed.debug("Statemachine [" + statemachine.getName()
					+ "]: Try to exit state [" + oldState.getName() + "].");
		}
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param transitionName
	 *            {@link String}
	 * @see de.wsdevel.statemachine.StateMachineHandler#tryTransition(de.wsdevel.statemachine.StateMachine,
	 *      java.lang.String)
	 */
	@Override
	public void tryTransition(final StateMachine statemachine,
			final String transitionName) {
		if (this.logToBeUsed.isDebugEnabled()) {
			this.logToBeUsed.debug("Statemachine [" + statemachine.getName()
					+ "]: Try to execute transition [" + transitionName + "].");
		}
	}

}
//
// $Log: SimpleLogStateMachineHandler.java,v $
// Revision 1.2 2008-09-22 08:46:48 sweiss
// first release
//
// Revision 1.1 2008-06-10 10:28:30 sweiss
// added simple implementation of handler and smaller changes
//
//
