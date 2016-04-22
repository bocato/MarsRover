package com.bocato.mars.commands;

import com.bocato.mars.exception.RoverOutOfBoundsException;
import com.bocato.mars.model.Command;
import com.bocato.mars.model.Plateau;
import com.bocato.mars.model.Rover;

/**
 * @author bocato
 *
 */

public class Move implements Command{

	@Override
	public void execute(Rover rover) {
		switch (rover.getLocation().getDirection()) {
		default:
			break;

		case 1:
			checkUpperRightYBounds(rover);
			rover.getLocation().addY();
			break;

		case 2:
			checkUpperXBounds(rover);
			rover.getLocation().addX();
			break;

		case 3:
			checkLowerYBounds(rover);
			rover.getLocation().subtractY();
			break;

		case 4:
			checkLowerXBounds(rover);
			rover.getLocation().subtractX();
			break;
		}
	}
	
	private void checkUpperRightYBounds(Rover rover){
		if(rover.getLocation().getPosY() + 1 > Plateau.getInstance("").getUpperRightY()){
			throw new RoverOutOfBoundsException();
		}
	}
	
	private void checkUpperXBounds(Rover rover){
		if(rover.getLocation().getPosX() + 1 > Plateau.getInstance("").getUpperRightX()){
			throw new RoverOutOfBoundsException();
		}
	}
	
	private void checkLowerYBounds(Rover rover){
		if(rover.getLocation().getPosY() - 1 < 0){
			throw new RoverOutOfBoundsException();
		}
	}
	
	private void checkLowerXBounds(Rover rover){
		if(rover.getLocation().getPosX() - 1 < 0){
			throw new RoverOutOfBoundsException();
		}
	}

}
