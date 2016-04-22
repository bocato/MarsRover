package com.bocato.mars.commands;

import com.bocato.mars.model.Command;
import com.bocato.mars.model.Rover;

public class RotateLeft implements Command{

	@Override
	public void execute(Rover rover) {
		rover.getLocation().subtractDirection();
		if (rover.getLocation().getDirection() == 0)
			rover.getLocation().setDirection(4);
		if (rover.getLocation().getDirection() == 5)
			rover.getLocation().setDirection(1);
	}

}
