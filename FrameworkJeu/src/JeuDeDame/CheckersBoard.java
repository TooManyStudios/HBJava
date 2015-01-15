package JeuDeDame;

import framework.board.Board;

public class CheckersBoard extends Board {
	
	public final static int SIDE_LENGTH = 10; 
	
	public CheckersBoard(){
		super(CheckersBoard.SIDE_LENGTH, CheckersBoard.SIDE_LENGTH);
	}
	
}
