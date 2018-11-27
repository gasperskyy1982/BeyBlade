package com.windows;

import java.util.concurrent.Exchanger;

import javafx.scene.image.ImageView;

/**
 * This class for BlackGenius Bey extends from BeyBladeDefense abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class BlackGenius extends BeyBladeDefense{

	public BlackGenius (GameField field, Exchanger<Double> ex1) {
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
		beyBigImage = new ImageView("/images/blackGenius.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/blackGenius_small.png");
	}

	@Override
	public void setEndurance() {
		endurance = 60;
	}

	@Override
	public void setAttack() {
		attack = 60;
	}

	@Override
	public void setDefense() {
		defense = 80;
	}

	@Override
	public void setName() {
		name = "BlackGenius";
	}
		
}
