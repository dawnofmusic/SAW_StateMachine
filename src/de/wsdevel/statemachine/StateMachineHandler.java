package de.wsdevel.statemachine;

/**
 * Created on 30.09.2004 for project: Java__StateMachine. (c) 2010, Sebastian A.
 * Weiss - All rights reserved.
 * 
 * @author <a href="mailto:sebastian@scenejo.org">Sebastian A. Weiss -
 *         scenejo.org</a>
 * @version $Author: sweiss $ -- $Revision: 1.2 $ -- $Date: 2008-09-22 08:46:49$
 */
public interface StateMachineHandler {

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 */
	void enteredState(StateMachine statemachine, State newState);

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 */
	void entryFailed(StateMachine statemachine, State newState);

	/**
	 * will be called if an error occurs.
	 * 
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param parameters
	 *            {@link Object} [] parameters used with transition command.
	 * @param message
	 *            {@link String} the error message
	 * @param t
	 *            {@link Throwable} might be null
	 */
	void errorOccured(StateMachine statemachine, Object[] parameters,
			String message, Throwable t);

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 */
	void exitedState(StateMachine statemachine, State oldState);

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 */
	void exitFailed(StateMachine statemachine, State oldState);

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param currentState
	 *            {@link State} current state of state machine.
	 * @param nameOfTransitionTried
	 *            {@link String} transition tried to be executed.
	 */
	void invalidTransition(StateMachine statemachine, State currentState,
			String nameOfTransitionTried);

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param newState
	 *            {@link State}
	 */
	void tryToEnterState(StateMachine statemachine, State newState);

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param oldState
	 *            {@link State}
	 */
	void tryToExitState(StateMachine statemachine, State oldState);

	/**
	 * @param statemachine
	 *            {@link StateMachine}
	 * @param transitionName
	 *            {@link String}
	 */
	void tryTransition(StateMachine statemachine, String transitionName);
}
//
// $Log: StateMachineHandler.java,v $
// Revision 1.2 2008-09-22 08:46:49 sweiss
// first release
//
// Revision 1.1 2008-03-25 19:48:04 sweiss
// *** empty log message ***
//
// Revision 1.2 2008-03-18 19:57:17 sweiss
// FlashStreamClient uses statemachine
//
// Revision 1.1 2006-05-02 16:06:00 sweissTFH
// cleaned up tools and moved everything to appropriate new packages
//
// Revision 1.3 2006/04/05 18:19:34 sweissTFH
// cleaned up checkstyle errors
//
// Revision 1.2 2005/10/31 18:22:30 sweissTFH
// clean up and commenting
//
//
