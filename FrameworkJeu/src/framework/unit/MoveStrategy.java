package framework.unit;

import framework.game.Game;


public abstract class MoveStrategy {
	
	public MoveStrategy(){
		
	}

	public abstract void computePossibleMoves(Game game, Piece piece);
	
}
