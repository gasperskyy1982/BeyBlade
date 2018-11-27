package com.windows;

import java.util.concurrent.Exchanger;
import javafx.scene.image.ImageView;

/**
 * This class for Fafnir Bey extends from BeyBladeEndurance abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class Fafnir extends BeyBladeEndurance{

	public Fafnir (GameField field, Exchanger<Double> ex1) {
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
		beyBigImage = new ImageView("/images/fafnir.jpg");
	}

	@Override
	public void setbeySmallImage() {
		beySmallImage = new ImageView ("/images/fafnir_small.png");
	}

	@Override
	public void setEndurance() {
		endurance = 10;
	}

	@Override
	public void setAttack() {
		attack = 5;
	}

	@Override
	public void setDefense() {
		defense = 8;
	}

	@Override
	public void setName() {
		name = "Fafnir";
	}
	
}