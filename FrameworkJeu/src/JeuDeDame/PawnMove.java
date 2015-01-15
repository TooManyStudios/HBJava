package JeuDeDame;

import framework.board.Cell;
import framework.game.Game;
import framework.game.Player;
import framework.unit.MoveStrategy;
import framework.unit.Piece;

public class PawnMove extends MoveStrategy{
	
	public PawnMove(){
		super();
	}

	@Override
	public void computePossibleMoves(Game controller, Piece piece) {
		CheckersGame controller2 = (CheckersGame) controller;
		CheckersBoard board = (CheckersBoard) controller2.getBoard();
		Player player = piece.getPlayer();
		if (player == null)
			return;
		
		Cell theCell = piece.getCell();
		int pas = 1;
		if (player == controller2.getPlayers().get(1)){
			pas = -1;
		}
		int x, y;
		x = theCell.getX();
		y = theCell.getY();
		Cell possible1, possible2;
		possible1 = board.getCell(x-1, y+pas);
		if ((possible1 != null) && (possible1.getContent().size() == 0))
			piece.addPossibleMove(possible1);
		possible2 = board.getCell(x+1, y+pas);
		if ((possible2 != null) && (possible2.getContent().size() == 0))
			piece.addPossibleMove(possible2);
	}
	
}
