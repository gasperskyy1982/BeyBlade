package com.windows;

import java.util.concurrent.Exchanger;

import javafx.scene.image.ImageView;

/**
 * This class for Xcalibur Bey extends from BeyBladeAttack abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class Xcalibur extends BeyBladeAttack{

	public Xcalibur (GameField field, Exchanger<Double> ex1) {
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
		beyBigImage = new ImageView("/images/xcalibur.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/xcalibur_small.png");
	}

	@Override
	public void setEndurance() {
		endurance = 5;
	}

	@Override
	public void setAttack() {
		attack = 10;
	}

	@Override
	public void setDefense() {
		defense = 9;
	}

	@Override
	public void setName() {
		name = "Xcalibur";
	}
		
}
