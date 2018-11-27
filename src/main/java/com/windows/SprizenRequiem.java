package com.windows;

import java.util.concurrent.Exchanger;

import javafx.scene.image.ImageView;

/**
 * This class for SprizenRequiem Bey extends from BeyBladeDefense abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class SprizenRequiem extends BeyBladeDefense{
	
	public SprizenRequiem (GameField field, Exchanger<Double> ex1) {
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
		beyBigImage = new ImageView("/images/sprizen_requiem.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/sprizenRequiem_small.png");
	}

	@Override
	public void setEndurance() {
		endurance = 9;
	}

	@Override
	public void setAttack() {
		attack = 9;
	}

	@Override
	public void setDefense() {
		defense = 10;
	}

	@Override
	public void setName() {
		name = "Sprizen Requiem";
	}

}
