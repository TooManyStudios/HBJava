package framework.unit;

import framework.game.Game;

public abstract class CombatStrategy {
	
	public CombatStrategy(){
		
	}
	
	public abstract void computePossibleTargets(Game game, Piece piece);
}
