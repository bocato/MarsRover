package com.bocato.mars.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author bocato
 *
 */

public class Location {

	private int posX;
	private int posY;
	private int direction;

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void addY() {
		this.posY++;
	}

	public void subtractY() {
		this.posY--;
	}

	public void addX() {
		this.posX++;
	}

	public void subtractX() {
		this.posX--;
	}

	public void addDirection() {
		this.direction++;
	}

	public void subtractDirection() {
		this.direction--;
	}

}
