package com.windows;

import java.util.concurrent.Exchanger;

import javafx.scene.image.ImageView;

/**
 * This class for Zeitron Bey extends from BeyBladeEndurance abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class Zeitron extends BeyBladeEndurance{
	
	public Zeitron (GameField field, Exchanger<Double> ex1) {
		super(field, ex1);
		setName();
		setEndurance();
		setAttack();
		setDefense();
		setbeySmallImage();
		setbeyBigImage();
		setStrikePower();
	}
	
	@Override
	public void setbeyBigImage() {
		beyBigImage = new ImageView("/images/zeitron.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/zeitron_small.png");
	}


	@Override
	public void setEndurance() {
		endurance = 8;
	}

	@Override
	public void setAttack() {
		attack = 5;
	}

	@Override
	public void setDefense() {
		defense = 6;
	}

	@Override
	public void setName() {
		name = "Zeitroon";
	}
	
}
