package com.windows;

import java.util.concurrent.Exchanger;

import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * BeyBlade - this main abstract class for all BeyBlade`s types
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public abstract class BeyBlade {

	protected int imBey;
	protected int beyRadius = 25;
	protected String name;
	protected ImageView beyBigImage;  
	protected ImageView beySmallImage;  
	protected ImageView bangbeySmallImage = new ImageView("/images/bang.png");  
	protected double endurance;
	protected volatile double balance = 1000;
	protected double attack;
	protected double defense;
	protected double strikePower;
	protected volatile int currentPositionX;
	protected volatile int currentPositionY;
	protected volatile int previousPositionX;
	protected volatile int previousPositionY;
	protected volatile int nextMove;
	protected GameField field;
	protected Exchanger<Double> ex1;
	
	
	public BeyBlade(GameField field, Exchanger<Double> ex1) {
		this.field = field;
		this.ex1 = ex1;
		setStartPositionX(this.field.getFieldSizeX());
		setStartPositionY(this.field.getFieldSizeY());
	}
	
		
	public void setBangbeySmallImage() {
		beySmallImage = bangbeySmallImage;	
	}
	
	public void setStrikePower() {}
	
	public void setbeyBigImage() {}
	
	public void setbeySmallImage() {}
	
	public void loseBalanceStep() {}
	
	public void loseBalanceStrike(double StrikePower) {}

	public void setName() {}
	
	public void setEndurance() {}

	public void setAttack() {}

	public void setDefense () {}

	public void setCurrentPositionY(int i) {
		this.currentPositionY = i;
	}

	public void setCurrentPositionX(int j) {
		this.currentPositionX = j;
	}

	public void setPreviousPositionY(int i) {
		this.previousPositionY = i;
	}

	public void setPreviousPositionX(int j) {
		this.previousPositionX = j;
	}

	public void setStartPositionX(int fieldSizeX) {
		this.currentPositionX = (int) (Math.random() * fieldSizeX-beyRadius);
	}

	public void setStartPositionY(int fieldSizeY) {
		this.currentPositionY = (int) (Math.random() * fieldSizeY-beyRadius);
	}

	public void setNextMove() {
		if (currentPositionX == previousPositionX && currentPositionY == previousPositionY)
			nextMove = (int) (Math.random() * 4);
		if (currentPositionX < previousPositionX && currentPositionY < previousPositionY)
			nextMove = 0;
		if (currentPositionX > previousPositionX && currentPositionY < previousPositionY)
			nextMove = 1;
		if (currentPositionX > previousPositionX && currentPositionY > previousPositionY)
			nextMove = 2;
		if (currentPositionX < previousPositionX && currentPositionY > previousPositionY)
			nextMove = 3;
	}

	public void setMove(int x) {
		switch (x) {
		case 0:
			setMoveLeftUp();
			break;
		case 1:
			setMoveRightUp();
			break;
		case 2:
			setMoveRightDown();
			break;
		case 3:
			setMoveLeftDown();
			break;
		default:
			break;

		}
	}
		
	public void setMoveAfterBang(int x) {
		switch (x) {
		case 0:
			setMoveRightDown();
			break;
		case 1:
			setMoveLeftDown();
			break;
		case 2:
			setMoveLeftUp();
			break;
		case 3:
			setMoveRightUp();
			break;
		default:
			break;
		}
	}
	

	public void turnBey() {
		RotateTransition rt = new RotateTransition(Duration.millis(10), beySmallImage);
		rt.setByAngle(360);
		rt.setCycleCount(10);
		rt.play();
	}
	
	public void setStartBey() {
		if (field.isBey1() == false) {
			field.setBey1placeX(currentPositionX);
			field.setBey1placeY(currentPositionY);
			beySmallImage.setX(currentPositionX);
			beySmallImage.setY(currentPositionY);
			imBey = 1;
			field.setBey1(true);
		} else {
			setStartPositionX(this.field.getFieldSizeX());
			setStartPositionY(this.field.getFieldSizeY());
			field.setBey2placeX(currentPositionX);
			field.setBey2placeY(currentPositionY);
			beySmallImage.setX(currentPositionX);
			beySmallImage.setY(currentPositionY);
			imBey = 2;
			field.setBey2(true);
		}
		
		if (imBey == 1) {
			System.out.println("isBey 1: " + field.isBey1());
			System.out.println("isBey 2: " + field.isBey2());
			System.out.println("Field Bey1 Placex: " + field.getBey1placeX());
			System.out.println("Field Bey1 Placey: " + field.getBey1placeY());
		} else {
			System.out.println("isBey 1: " + field.isBey1());
			System.out.println("isBey 2: " + field.isBey2());
			System.out.println("Field Bey2 Placex: " + field.getBey2placeX());
			System.out.println("Field Bey2 Placey: " + field.getBey2placeY());
		}

	}

	public void setBey() {
		if (imBey == 1) {
			beySmallImage.setX(currentPositionX);
			beySmallImage.setY(currentPositionY);
			field.setBey1placeX(currentPositionX);
			field.setBey1placeY(currentPositionY);
		} else {
			beySmallImage.setX(currentPositionX);
			beySmallImage.setY(currentPositionY);
			field.setBey2placeX(currentPositionX);
			field.setBey2placeY(currentPositionY);
		}

	}

	
	public void setMoveLeftUp() {
		if (currentPositionX > beyRadius && currentPositionY > beyRadius) {
			currentPositionX -= 1;
			currentPositionY -= 1;
		} else {
			if (currentPositionX == beyRadius && currentPositionY > beyRadius) {
				setMoveRightUp();
			} else {
				if (currentPositionX == beyRadius && currentPositionY == beyRadius) {
					setMoveRightDown();
				} else {
					if (currentPositionX > beyRadius && currentPositionY == beyRadius) {
						setMoveLeftDown();
					}

				}
			}
		}
	}

	public void setMoveLeftDown() {
		if (currentPositionY < field.getFieldSizeY()-beyRadius && currentPositionX > beyRadius) {
			currentPositionX -= 1;
			currentPositionY += 1;
		} else {
			if (currentPositionY < field.getFieldSizeY()-beyRadius && currentPositionX == beyRadius) {
				setMoveRightDown();
			} else {
				if (currentPositionY == field.getFieldSizeY()-beyRadius && currentPositionX == beyRadius) {
					setMoveRightUp();
				} else {
					if (currentPositionY == field.getFieldSizeY()-beyRadius && currentPositionX > beyRadius) {
						setMoveLeftUp();
					}
				}
			}
		}
	}

	public void setMoveRightUp() {
		if (currentPositionY > beyRadius && currentPositionX < field.getFieldSizeX()-beyRadius) {
			currentPositionX += 1;
			currentPositionY -= 1;
		} else {
			if (currentPositionY > beyRadius && currentPositionX == field.getFieldSizeX()-beyRadius) {
				setMoveLeftUp();
			} else {
				if (currentPositionY == beyRadius && currentPositionX == field.getFieldSizeX()-beyRadius) {
					setMoveLeftDown();
				} else {
					if (currentPositionY > beyRadius && currentPositionX < field.getFieldSizeX()-beyRadius) {
						setMoveRightDown();
					}
				}
			}
		}
	}

	public void setMoveRightDown() {
		if (currentPositionY < field.getFieldSizeY()-beyRadius && currentPositionX < field.getFieldSizeX()-beyRadius) {
			currentPositionX += 1;
			currentPositionY += 1;
		} else {
			if (currentPositionY < field.getFieldSizeY()-beyRadius && currentPositionX == field.getFieldSizeX()-beyRadius) {
				setMoveLeftDown();
			} else {
				if (currentPositionY == field.getFieldSizeY()-beyRadius && currentPositionX == field.getFieldSizeX()-beyRadius) {
					setMoveLeftUp();
				} else {
					if (currentPositionY == field.getFieldSizeY()-beyRadius && currentPositionX < field.getFieldSizeX()-beyRadius) {
						setMoveRightUp();
					}
				}
			}
		}
	}

	
	
	public String getName() {
		return name;
	}

	public double getEndurance() {
		return endurance;
	}

	public ImageView getBeyBigImage() {
		return beyBigImage;
	}

	public ImageView getBeySmallImage() {
		return beySmallImage;
	}

	public double getAttack() {
		return attack;
	}

	public double getDefense() {
		return defense;
	}

	public double getBalance() {
		return balance;
	}
		
	public double getStrikePower() {
		return strikePower;
	}

	public int getCurrentPositionX() {
		return currentPositionX;
	}

	public int getCurrentPositionY() {
		return currentPositionY;
	}

	public int getPreviousPositionX() {
		return previousPositionX;
	}

	public int getPreviousPositionY() {
		return previousPositionY;
	}

	public int getNextMove() {
		return nextMove;
	}
		
}
