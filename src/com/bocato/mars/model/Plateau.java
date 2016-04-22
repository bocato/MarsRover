
package com.bocato.mars.model;

import com.bocato.mars.exception.InputException;

/**
 * @author bocato
 *
 */

public class Plateau {

	private static Plateau plateau = null;
	public static final int LOWER_LEFT_X = 0;
	public static final int LOWER_LEFT_Y = 0;
	private int upperRightX;
	private int upperRightY;
	
	private Plateau(String axisBounds) {
		try {
			populateInput(axisBounds);
		} catch (InputException e) {
			e.printStackTrace();
		}
	}

	private void populateInput(String axisvalue) throws InputException {
		String upperArrayCoordinates[] = axisvalue.split(" ");
		if (upperArrayCoordinates.length != 2) {
			throw new InputException("Erro: a entrada deve ser da forma 'eixo_x eixo_y'");
		}
		upperRightX = Integer.valueOf(upperArrayCoordinates[0]).intValue();
		upperRightY = Integer.valueOf(upperArrayCoordinates[1]).intValue();
	}

	public static Plateau getInstance(String axisvalue) {
		synchronized (Plateau.class) {
			if (plateau == null)
				plateau = new Plateau(axisvalue);
		}
		return plateau;
	}

	public int getUpperRightX() {
		return upperRightX;
	}

	public int getUpperRightY() {
		return upperRightY;
	}

}