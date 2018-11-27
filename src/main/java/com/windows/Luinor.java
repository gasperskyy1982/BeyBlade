package com.windows;

import java.util.concurrent.Exchanger;

import javafx.scene.image.ImageView;

/**
 * This class for Luinor Bey extends from BeyBladeAttack abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class Luinor extends BeyBladeAttack{

	public Luinor (GameField field, Exchanger<Double> ex1) {
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
		beyBigImage = new ImageView("/images/luinor.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/luinor_small.png");
	}

	@Override
	public void setEndurance() {
		endurance = 6;
	}

	@Override
	public void setAttack() {
		attack = 9;
	}

	@Override
	public void setDefense() {
		defense = 7;
	}

	@Override
	public void setName() {
		name = "Luinor";
	}
	
}
