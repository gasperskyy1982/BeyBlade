package com.windows;

import java.util.concurrent.Exchanger;

import javafx.scene.image.ImageView;

/**
 * This class for Wybron Bey extends from BeyBladeDefense abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class Wybron extends BeyBladeDefense{

	public Wybron (GameField field, Exchanger<Double> ex1) {
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
		beyBigImage = new ImageView("/images/wybron.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/wybron_small.png");
	}

	@Override
	public void setEndurance() {
		endurance = 6;
	}

	@Override
	public void setAttack() {
		attack = 7;
	}

	@Override
	public void setDefense() {
		defense = 10;
	}

	@Override
	public void setName() {
		name = "Wibron";
	}
	
}
