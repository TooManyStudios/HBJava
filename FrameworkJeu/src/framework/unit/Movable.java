package framework.unit;

import java.util.ArrayList;

import framework.board.Cell;
import framework.game.Game;

public interface Movable {
	
	public void moveTo(Cell destination);
	public ArrayList<Cell> getPossibleMoves(Game game);
	public void addPossibleMove(Cell cell);
	public void clearPossibleMoves();
	
}
