package com.windows;

import java.util.concurrent.Exchanger;

/**
 * BeyBladeDefense - this abstract class extends from BeyBlade abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class BeyBladeDefense extends BeyBlade {

	
	public BeyBladeDefense(GameField field, Exchanger<Double> ex1) {
		super(field, ex1);
		
	}

	
	@Override
	public void loseBalanceStep() {
		balance -= 1.0;
	}
	
	@Override
	public void loseBalanceStrike(double strikePower) {
		balance -= strikePower + defense;
	}

	@Override
	public void setStrikePower() {
		strikePower = (int)((attack/2) + endurance);
	}
	
}
