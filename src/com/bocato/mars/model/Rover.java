
package com.bocato.mars.model;

import com.bocato.mars.util.CommandController;
import com.bocato.mars.util.Parser;

/**
 * @author bocato
 *
 */

public class Rover {

	private Location location = null;

	public Rover(String inputs) {
		this.location = Parser.parseInputs(inputs.toUpperCase());
	}

	public String executeCommand(String commands) {
		for (char c : commands.toUpperCase().toCharArray()) {
			CommandController.getInstance().executeCommand(c, this);
		}
		return Parser.locationToString(location);
	}
	
	public Location getLocation() {
		return location;
	}
}