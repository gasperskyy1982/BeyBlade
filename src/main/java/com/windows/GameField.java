package com.windows;

import javafx.scene.image.ImageView;

/**
 * This class is Gamefield for Bey's battle
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class GameField {
	private ImageView bangImage = new ImageView ("/images/bang.jpg");
	private volatile boolean bey1 = false;
	private volatile boolean bey2 = false;
	private volatile int bey1placeX;
	private volatile int bey1placeY;
	private volatile int bey2placeX;
	private volatile int bey2placeY;
	private volatile int fieldSizeX;
	private volatile int fieldSizeY;
	
	public GameField(int fieldSizeX, int fieldSizeY) {
		this.fieldSizeX = fieldSizeX;
		this.fieldSizeY = fieldSizeY;
	}

	public void setBey1(boolean bey1) {
		this.bey1 = bey1;
	}

	public void setBey2(boolean bey2) {
		this.bey2 = bey2;
	}

	public void setBey1placeX(int bey1placeX) {
		this.bey1placeX = bey1placeX;
	}

	public void setBey1placeY(int bey1placeY) {
		this.bey1placeY = bey1placeY;
	}

	public void setBey2placeX(int bey2placeX) {
		this.bey2placeX = bey2placeX;
	}

	public void setBey2placeY(int bey2placeY) {
		this.bey2placeY = bey2placeY;
	}

	public boolean isBey1() {
		return bey1;
	}

	public boolean isBey2() {
		return bey2;
	}

	public int getFieldSizeX() {
		return fieldSizeX;
	}

	public int getFieldSizeY() {
		return fieldSizeY;
	}

	public int getBey1placeX() {
		return bey1placeX;
	}

	public int getBey1placeY() {
		return bey1placeY;
	}

	public int getBey2placeX() {
		return bey2placeX;
	}

	public int getBey2placeY() {
		return bey2placeY;
	}
	
	public ImageView getBangImage() {
		return bangImage;
	}
		
}