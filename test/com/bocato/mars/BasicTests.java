/**
 * 
 */
package com.bocato.mars;

import com.bocato.mars.model.Plateau;
import com.bocato.mars.model.Rover;

import junit.framework.TestCase;

/**
 * @author bocato
 *
 */
public class BasicTests extends TestCase {


	protected void setUp() throws Exception {
		String upperRightCoordinates = "5 5";
		Plateau.getInstance(upperRightCoordinates);
	}

	/**
	 * Test rover for the input below
	 * 
	 * Input:
	 * 5 5
	 * 1 2 N 
	 * LMLMLMLMM
	 * 
	 * Expected Output: 1 3 N
	 * 
	 */
	public void testOutputForInputA() {
		final String currentPosition = "1 2 N";
		final String commands = "LMLMLMLMM";
		final Rover rover = new Rover(currentPosition.toUpperCase());
		final String output = rover.executeCommand(commands);
		System.out.println(output);
		assertEquals(output, "1 3 N");
	}

	/**
	 * Test rover for the input below
	 * 
	 * Input:
	 * 5 5
	 * 3 3 E
	 * MMRMMRMRRM
	 * 
	 * Expected Output: 1 3 N
	 * 
	 */
	public void testOutputForInputB() {
		final String currentPosition = "3 3 E";
		final String commands = "MMRMMRMRRM";
		final Rover rover = new Rover(currentPosition.toUpperCase());
		final String output = rover.executeCommand(commands);
		System.out.println(output);
		assertEquals(output, "5 1 E");
	}
}
