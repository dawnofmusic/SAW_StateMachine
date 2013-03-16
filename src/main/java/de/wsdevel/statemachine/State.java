package de.wsdevel.statemachine;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

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
 * @version $Author: sweiss $ -- $Revision: 1.4 $ -- $Date: 2008-09-22 08:46:49 $
 * 
 * <br>
 * (c) 2007, Weiss und Schmidt, Mediale Systeme GbR - All rights reserved.
 * 
 */
public class State extends NamedImpl implements Named {

	/**
	 * <code>long</code> COMMENT.
	 */
	private static final long serialVersionUID = -1588015111054888618L;

	/**
	 * {@link CommandWithThrowable} COMMENT.
	 */
	private CommandWithThrowable entryCommand;

	/**
	 * {@link CommandWithThrowable} COMMENT.
	 */
	private CommandWithThrowable exitCommand;

	/**
	 * {@link HashMap<String,Transition>} COMMENT.
	 */
	private HashMap<String, Transition> transitions = new HashMap<String, Transition>();

	/**
	 * Default constructor.
	 */
	public State() {
	}

	/**
	 * @param nameVal
	 *            {@link String} name of state.
	 */
	public State(final String nameVal) {
		setName(nameVal);
	}

	/**
	 * @param transition
	 *            {@link Transition} to be added.
	 */
	public final void addTransition(final Transition transition) {
		this.transitions.put(transition.getName(), transition);
	}

	/**
	 * @return {@link CommandWithThrowable} the entryCommand.
	 */
	public final CommandWithThrowable getEntryCommand() {
		return this.entryCommand;
	}

	/**
	 * @return {@link CommandWithThrowable} the exitCommand.
	 */
	public final CommandWithThrowable getExitCommand() {
		return this.exitCommand;
	}

	/**
	 * @return {@link Serializable}
	 * @see de.wsdevel.tools.common.interfaces.Identifiable#getId()
	 */
	public final Serializable getId() {
		return getName();
	}

	/**
	 * COMMENT.
	 * 
	 * @param transitionName
	 *            {@link String}
	 * @return {@link Transition}
	 */
	public Transition getTransition(final String transitionName) {
		return this.transitions.get(transitionName);
	}

	/**
	 * @return {@link Collection}< {@link Transition}> containing all
	 *         transitions.
	 */
	public Collection<Transition> getTransitions() {
		return new LinkedList<Transition>(this.transitions.values());
	}

	/**
	 * @param transitionName
	 *            {@link String}
	 * @return <code>boolean</code> <code>true</code> if transition is valid
	 *         for this state.
	 */
	public boolean hasTransition(final String transitionName) {
		return this.transitions.containsKey(transitionName);
	}

	/**
	 * @param entryCommandRef
	 *            {@link CommandWithThrowable} the entryCommand to set.
	 */
	public final void setEntryCommand(final CommandWithThrowable entryCommandRef) {
		this.entryCommand = entryCommandRef;
	}

	/**
	 * @param exitCommandRef
	 *            {@link CommandWithThrowable} the exitCommand to set.
	 */
	public final void setExitCommand(final CommandWithThrowable exitCommandRef) {
		this.exitCommand = exitCommandRef;
	}

	/**
	 * @return {@link String}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		return getClass().getSimpleName() + " [name: " + getName() + "]";
	}
}
//
// $Log: State.java,v $
// Revision 1.4  2008-09-22 08:46:49  sweiss
// first release
//
// Revision 1.3 2008-06-10 10:41:07 sweiss
// cleanup
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
