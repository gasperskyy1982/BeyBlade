package com.windows;

import java.util.concurrent.Exchanger;

/**
 * BeyBladeAttack - this abstract class extends from BeyBlade abstract class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class BeyBladeAttack extends BeyBlade{
		
	
	public BeyBladeAttack(GameField field, Exchanger<Double> ex1) {
		super(field, ex1);
		
	}
	
	@Override
	public void loseBalanceStep() {
		balance -= 2.0;
	}

	@Override
	public void loseBalanceStrike (double strikePower) {
		balance -= strikePower;
	}

	@Override
	public void setStrikePower() {
		strikePower = (int) (3*attack + endurance);
	}
	
	
}
