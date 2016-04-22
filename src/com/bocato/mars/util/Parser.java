package com.bocato.mars.util;

import java.util.HashMap;

import java.util.Map;

import com.bocato.mars.exception.ParserException;
import com.bocato.mars.model.Direction;
import com.bocato.mars.model.Location;

/**
 * @author bocato
 *
 */

public class Parser {

	private static Map<String, Integer> DIRECTION_STRING_TO_INT = null;
	private static Map<Integer, String> DIRECTION_INT_TO_STRING = null;

	static {
		populateDirectionsStringToInt();
		populateDirectionsIntToString();
	}
	
	private static void populateDirectionsStringToInt(){
		DIRECTION_STRING_TO_INT = new HashMap<String, Integer>();
		DIRECTION_STRING_TO_INT.put(Direction.N.charValue(), Direction.N.intValue());
		DIRECTION_STRING_TO_INT.put(Direction.E.charValue(), Direction.E.intValue());
		DIRECTION_STRING_TO_INT.put(Direction.W.charValue(), Direction.W.intValue());
		DIRECTION_STRING_TO_INT.put(Direction.S.charValue(), Direction.S.intValue());
	}
	
	private static void populateDirectionsIntToString(){
		DIRECTION_INT_TO_STRING = new HashMap<Integer, String>();
		DIRECTION_INT_TO_STRING.put(Direction.N.intValue(), Direction.N.charValue());
		DIRECTION_INT_TO_STRING.put(Direction.E.intValue(), Direction.E.charValue());
		DIRECTION_INT_TO_STRING.put(Direction.W.intValue(), Direction.W.charValue());
		DIRECTION_INT_TO_STRING.put(Direction.S.intValue(), Direction.S.charValue());
	}

	public static Location parseInputs(String inputs) {

		Location location = new Location();

		String inputArray[] = inputs.split(" ");
		if (inputArray.length != 3)
			throw new ParserException("A entrada de dados precisa ser da forma: 'posicao_x posicao_y coordenada'\nOnde:\nposicao_x = inteiro\nposicao_y = inteiro\ncoordenada = N, S, W, E\nExemplo: 1 2 N");
		int posX = Integer.valueOf(inputArray[0]).intValue();
		int posY = Integer.valueOf(inputArray[1]).intValue();

		location.setPosX(posX);
		location.setPosY(posY);

		if (!DIRECTION_STRING_TO_INT.containsKey(inputArray[2].toUpperCase())) {
			throw new ParserException("Direcao invalida.");
		} else {
			int direction = ((Integer) DIRECTION_STRING_TO_INT.get(inputArray[2].toUpperCase())).intValue();
			location.setDirection(direction);
		}

		return location;
	}

	public static String locationToString(Location location) {
		String locationString = location.getPosX() + " " + location.getPosY() + " " + translateDirection(location.getDirection()); 
		return locationString;
	}
	
	private static String translateDirection(int direction){
		direction = Math.abs(direction);
		String translation  = DIRECTION_INT_TO_STRING.get(new Integer(direction));
		return translation;
	}
}
