package com.windows;

import java.util.concurrent.Exchanger;

import javafx.scene.image.ImageView;

/**
 * This class for Genesis-Voltraek Bey extends from BeyBladeAttack abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class Voltraek extends BeyBladeAttack{

	public Voltraek (GameField field, Exchanger<Double> ex1) {
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
		beyBigImage = new ImageView("/images/voltraek_genesis.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/voltraek_small.png");
	}

	@Override
	public void setEndurance() {
		endurance = 7;
	}

	@Override
	public void setAttack() {
		attack = 8;
	}

	@Override
	public void setDefense() {
		defense = 8;
	}

	@Override
	public void setName() {
		name = "Genesis Voltraek";
	}
		
}
