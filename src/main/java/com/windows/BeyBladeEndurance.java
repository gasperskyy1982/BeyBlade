package com.windows;

import java.util.concurrent.Exchanger;

/**
 * BeyBladeEndurance - this abstract class extends from BeyBlade abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class BeyBladeEndurance extends BeyBlade {

	public BeyBladeEndurance(GameField field, Exchanger<Double> ex1) {
		super(field, ex1);
	}

	@Override
	public void loseBalanceStep() {
		balance -= 0.5;
	}
	
	@Override
	public void loseBalanceStrike(double strikePower) {
		balance -= (strikePower - (endurance/2));
	}

	@Override
	public void setStrikePower() {
		strikePower = (int)((attack/3) + endurance);
	}
	
}
