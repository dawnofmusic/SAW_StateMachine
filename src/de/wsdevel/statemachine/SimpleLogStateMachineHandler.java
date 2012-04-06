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

	/**
	 * {@link Log} the logger.
	 */
	private static final Log LOG = LogFactory
			.getLog(SimpleLogStateMachineHandler.class);

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
		if (SimpleLogStateMachineHandler.LOG.isDebugEnabled()) {
			SimpleLogStateMachineHandler.LOG.debug("Statemachine ["
					+ statemachine.getName() + "] entered state ["
					+ newState.getName() + "].");
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
	public void entryFailed(final StateMachine statemachine,
			final State newState) {
		SimpleLogStateMachineHandler.LOG.error("Statemachine ["
				+ statemachine.getName() + "]: Error entering state ["
				+ newState.getName() + "]");
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
		SimpleLogStateMachineHandler.LOG.error("Statemachine ["
				+ statemachine.getName() + "]: " + message, t);
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
		if (SimpleLogStateMachineHandler.LOG.isDebugEnabled()) {
			SimpleLogStateMachineHandler.LOG.debug("Statemachine ["
					+ statemachine.getName() + "] exited state ["
					+ oldState.getName() + "].");
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
	public void exitFailed(final StateMachine statemachine, final State oldState) {
		SimpleLogStateMachineHandler.LOG.error("Statemachine ["
				+ statemachine.getName() + "]: Error exiting state ["
				+ oldState.getName() + "]");
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
		SimpleLogStateMachineHandler.LOG.error("Statemachine ["
				+ statemachine.getName() + "]: Error trying transition '"
				+ nameOfTransitionTried + "' in state '"
				+ currentState.getName() + "'.");
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
		if (SimpleLogStateMachineHandler.LOG.isDebugEnabled()) {
			SimpleLogStateMachineHandler.LOG.debug("Statemachine ["
					+ statemachine.getName() + "]: Try to enter state ["
					+ newState.getName() + "].");
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
	public void tryToExitState(final StateMachine statemachine,
			final State oldState) {
		if (SimpleLogStateMachineHandler.LOG.isDebugEnabled()) {
			SimpleLogStateMachineHandler.LOG.debug("Statemachine ["
					+ statemachine.getName() + "]: Try to exit state ["
					+ oldState.getName() + "].");
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
	public void tryTransition(final StateMachine statemachine,
			final String transitionName) {
		if (SimpleLogStateMachineHandler.LOG.isDebugEnabled()) {
			SimpleLogStateMachineHandler.LOG.debug("Statemachine ["
					+ statemachine.getName() + "]: Try to execute transition ["
					+ transitionName + "].");
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
