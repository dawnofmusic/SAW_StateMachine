package de.wsdevel.statemachine;

/**
 * TransitionCommand created on 21.09.2008. for project: Java__StateMachine
 * 
 * @author <a href="mailto:sweiss@scenejo.org">Sebastian A. Weiss -
 *         scenejo.org</a>
 * @version $Author: sweiss $ -- $Revision: 1.1 $ -- $Date: 2008-09-22 08:46:49
 *          $
 * 
 * <br>
 *          (c) 2008, scenejo.org - All rights reserved. Scenejo - An
 *          Interactive Storytelling Framework
 */
public interface TransitionCommand {

	/**
	 * @param parameters
	 *            {@link Object}[] maybe needed for execution
	 * @throws Throwable
	 *             eventually thrown.
	 */
	void run(Object[] parameters) throws Throwable;

}
//
// $Log: TransitionCommand.java,v $
// Revision 1.1 2008-09-22 08:46:49 sweiss
// first release
//
//
