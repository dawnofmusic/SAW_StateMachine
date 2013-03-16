package de.wsdevel.statemachine.trafficlight;

import de.wsdevel.statemachine.SimpleSystemOutStateMachineHandler;
import de.wsdevel.statemachine.State;
import de.wsdevel.statemachine.StateMachine;
import de.wsdevel.statemachine.Transition;

/**
 * Trafficlight created on 21.09.2008. for project: Java__StateMachine
 * 
 * @author <a href="mailto:sweiss@scenejo.org">Sebastian A. Weiss - scenejo.org</a>
 * @version $Author: sweiss $ -- $Revision: 1.1 $ -- $Date: 2008-09-22 08:46:51 $
 * 
 * <br>
 * (c) 2008, scenejo.org - All rights reserved. Scenejo - An Interactive
 * Storytelling Framework
 */
public class Trafficlight extends StateMachine {

	/**
	 * {@link String} COMMENT.
	 */
	private static final String TRANSITION_NEXT_NAME = "next";

	/**
	 * {@link long} COMMENT.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Trafficlight() {
		super("Traffic Light", new SimpleSystemOutStateMachineHandler());
		State red = new State("Red");
		addState(red);
		State redYellow = new State("RedYellow");
		addState(redYellow);
		State yellow = new State("Yellow");
		addState(yellow);
		State green = new State("Green");
		addState(green);
		red.addTransition(new Transition(TRANSITION_NEXT_NAME, redYellow));
		redYellow.addTransition(new Transition(TRANSITION_NEXT_NAME, green));
		green.addTransition(new Transition(TRANSITION_NEXT_NAME, yellow));
		yellow.addTransition(new Transition(TRANSITION_NEXT_NAME, red));

		setInitialState(red);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			tryTransition(TRANSITION_NEXT_NAME);
		}
	}

	/**
	 * COMMENT.
	 * 
	 * @param args
	 *            {@link String}[]
	 */
	public static final void main(final String[] args) {
		new Trafficlight();
	}

}
//
// $Log: Trafficlight.java,v $
// Revision 1.1  2008-09-22 08:46:51  sweiss
// first release
//
//
