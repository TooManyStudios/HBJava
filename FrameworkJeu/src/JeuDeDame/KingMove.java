package JeuDeDame;

import framework.board.Cell;
import framework.game.Game;
import framework.game.Player;
import framework.unit.MoveStrategy;
import framework.unit.Piece;


public class KingMove extends MoveStrategy {

	public KingMove(){
		super();
	}
	
	
	public void computePossibleMoves(Game game, Piece piece) {
		CheckersBoard board = (CheckersBoard) game.getBoard();
		Player player = piece.getPlayer();
		if(player == null)
			return;
			
		findPath(piece, board, -1, 1);
		
		findPath(piece, board, 1, 1);
		
		findPath(piece, board, -1, -1);

		findPath(piece, board, 1, -1);
		
	}

	private void findPath(Piece piece, CheckersBoard board, int stepX, int stepY) {
		Cell theCell = piece.getCell();
		int xOrigin, yOrigin;
		Cell possible;
		int x;
		int y;
		boolean empty;
		
		xOrigin = theCell.getX();
		yOrigin = theCell.getY();
		x=xOrigin;
		y=yOrigin;
		empty = true;
		do
		{
			x=x+stepX;
			y=y+stepY;
			possible = board.getCell(x, y);
			if((possible == null) || (possible.getContent().size()!=0))
				empty = false;
			else
				piece.addPossibleMove(possible);	
		} while( empty );
	}
}
