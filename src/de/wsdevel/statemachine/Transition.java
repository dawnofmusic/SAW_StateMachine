package de.wsdevel.statemachine;

import java.io.Serializable;

import de.wsdevel.tools.common.interfaces.Named;
import de.wsdevel.tools.common.interfaces.impl.NamedImpl;

/**
 * Created on 18.03.2008.
 * 
 * for project: Java__Tools
 * 
 * @author <a href="mailto:sweiss@weissundschmidt.de">Sebastian A. Weiss - Weiss
 *         und Schmidt, Mediale Systeme GbR</a>
 * @version $Author: sweiss $ -- $Revision: 1.5 $ -- $Date: 2008-09-22 08:46:48 $
 * 
 * <br>
 * (c) 2007, Weiss und Schmidt, Mediale Systeme GbR - All rights reserved.
 * 
 */
public class Transition extends NamedImpl implements Named {

	/**
	 * <code>long</code> serial version unique id.
	 */
	private static final long serialVersionUID = 8455370928414269057L;

	/**
	 * {@link State} the next state.
	 */
	private State nextState;

	/**
	 * {@link TransitionCommand} COMMENT.
	 */
	private TransitionCommand transitionCommand;

	/**
	 * Default constructor.
	 */
	public Transition() {
	}

	/**
	 * COMMENT.
	 * 
	 * @param nameVal
	 *            {@link String}
	 * @param nextStateRef
	 *            {@link State}
	 */
	public Transition(final String nameVal, final State nextStateRef) {
		this(nameVal, nextStateRef, null);
	}

	/**
	 * @param nameVal
	 *            {@link String}
	 * @param nextStateRef
	 *            {@link State}
	 * @param transitionCommandRef
	 *            {@link TransitionCommand}
	 */
	public Transition(final String nameVal, final State nextStateRef,
			final TransitionCommand transitionCommandRef) {
		setName(nameVal);
		setNextState(nextStateRef);
		setTransitionCommand(transitionCommandRef);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.wsdevel.tools.common.interfaces.Identifiable#getId()
	 */
	public final Serializable getId() {
		return getName();
	}

	/**
	 * @return {@link State} the nextState.
	 */
	public final State getNextState() {
		return this.nextState;
	}

	/**
	 * @return {@link TransitionCommand} the transitionCommand.
	 */
	public final TransitionCommand getTransitionCommand() {
		return this.transitionCommand;
	}

	/**
	 * @param nextStateRef
	 *            {@link State} the nextState to set.
	 */
	public final void setNextState(final State nextStateRef) {
		this.nextState = nextStateRef;
	}

	/**
	 * @param transitionCommandRef
	 *            {@link TransitionCommand} the transitionCommand to set.
	 */
	public final void setTransitionCommand(
			final TransitionCommand transitionCommandRef) {
		this.transitionCommand = transitionCommandRef;
	}

}
//
// $Log: Transition.java,v $
// Revision 1.5  2008-09-22 08:46:48  sweiss
// first release
//
// Revision 1.4 2008-06-10 10:41:07 sweiss
// cleanup
//
// Revision 1.3 2008-06-10 10:28:30 sweiss
// added simple implementation of handler and smaller changes
//
// Revision 1.2 2008-03-26 23:30:32 sweiss
// added betwixt support
//
// Revision 1.1 2008-03-25 19:48:04 sweiss
// *** empty log message ***
//
// Revision 1.2 2008-03-18 19:57:17 sweiss
// FlashStreamClient uses statemachine
//
//
