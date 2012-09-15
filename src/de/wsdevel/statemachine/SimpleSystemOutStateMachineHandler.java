package de.wsdevel.statemachine;

/**
 * Created on 10.06.2008 for project: Java__StateMachine. (c) 2008-2010,
 * Sebastian A. Weiss - All rights reserved.
 * 
 * @author <a href="mailto:sebastian@scenejo.org">Sebastian A. Weiss -
 *         scenejo.org</a>
 */
public class SimpleSystemOutStateMachineHandler implements StateMachineHandler {

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
		System.out.println("Statemachine [" + statemachine.getName()
				+ "] entered state [" + newState.getName() + "].");
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
		System.err.println("Statemachine [" + statemachine.getName()
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
		System.err.println("Statemachine [" + statemachine.getName() + "]: "
				+ message);
		t.printStackTrace(System.err);
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
		System.out.println("Statemachine [" + statemachine.getName()
				+ "] exited state [" + oldState.getName() + "].");
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
		System.err.println("Statemachine [" + statemachine.getName()
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
		System.err.println("Statemachine [" + statemachine.getName()
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
		System.out.println("Statemachine [" + statemachine.getName()
				+ "]: Try to enter state [" + newState.getName() + "].");
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
		System.out.println("Statemachine [" + statemachine.getName()
				+ "]: Try to exit state [" + oldState.getName() + "].");
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
		System.out.println("Statemachine [" + statemachine.getName()
				+ "]: Try to execute transition [" + transitionName + "].");
	}

}
//
// $Log: SimpleSystemOutStateMachineHandler.java,v $
// Revision 1.1 2008-09-22 08:46:49 sweiss
// first release
//
// Revision 1.1 2008-06-10 10:28:30 sweiss
// added simple implementation of handler and smaller changes
//
//
