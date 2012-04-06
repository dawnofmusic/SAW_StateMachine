package de.wsdevel.statemachine;

/**
 * Created on 21.09.2008 for project: Java__StateMachine. (c) 2008-2010,
 * Sebastian A. Weiss - All rights reserved.
 * 
 * @author <a href="mailto:sebastian@scenejo.org">Sebastian A. Weiss -
 *         scenejo.org</a>
 */
public class StateMachineAdapter implements StateMachineHandler {

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#enteredState(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	public void enteredState(final StateMachine statemachine,
			final State newState) {
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#entryFailed(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	public void entryFailed(final StateMachine statemachine,
			final State newState) {
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param message
	 *            {@link String}
	 * @param t
	 *            {@link Throwable}
	 * @see de.wsdevel.statemachine.StateMachineHandler#errorOccured(de.wsdevel.statemachine.StateMachine,
	 *      java.lang.String, java.lang.Throwable)
	 */
	public void errorOccured(final StateMachine statemachine,
			final String message, final Throwable t) {
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#exitedState(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	public void exitedState(final StateMachine statemachine,
			final State oldState) {
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#exitFailed(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	public void exitFailed(final StateMachine statemachine, final State oldState) {
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
	public void invalidTransition(final StateMachine statemachine,
			final State currentState, final String nameOfTransitionTried) {
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#tryToEnterState(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	public void tryToEnterState(final StateMachine statemachine,
			final State newState) {
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 * @see de.wsdevel.statemachine.StateMachineHandler#tryToExitState(de.wsdevel.statemachine.StateMachine,
	 *      de.wsdevel.statemachine.State)
	 */
	public void tryToExitState(final StateMachine statemachine,
			final State oldState) {
	}

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param transitionName
	 *            {@link String}
	 * @see de.wsdevel.statemachine.StateMachineHandler#tryTransition(de.wsdevel.statemachine.StateMachine,
	 *      java.lang.String)
	 */
	public void tryTransition(final StateMachine statemachine,
			final String transitionName) {
	}

}
//
// $Log: StateMachineAdapter.java,v $
// Revision 1.1 2008-09-22 08:46:49 sweiss
// first release
//
//
