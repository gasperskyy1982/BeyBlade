package com.windows;

import java.util.concurrent.Exchanger;

import javafx.scene.image.ImageView;

/**
 * This class for Horusood Bey extends from BeyBladeEndurance abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */


public class Horusood extends BeyBladeEndurance{
	
	public Horusood (GameField field, Exchanger<Double> ex1) {
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
		beyBigImage = new ImageView("/images/horusood.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/horusood_small.png");
	}


	@Override
	public void setEndurance() {
		endurance = 9;
	}

	@Override
	public void setAttack() {
		attack = 4;
	}

	@Override
	public void setDefense() {
		defense = 7;
	}

	@Override
	public void setName() {
		name = "Horusood";
	}
		
}
