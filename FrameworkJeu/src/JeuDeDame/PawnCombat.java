package JeuDeDame;

import framework.board.Board;
import framework.board.Cell;
import framework.game.Game;
import framework.unit.CombatStrategy;
import framework.unit.Piece;

public class PawnCombat extends CombatStrategy {
	
	public PawnCombat() {
		super();
	}
	
	@Override
	public void computePossibleTargets(Game game, Piece piece) {
		CheckersGame cgame = (CheckersGame) game;
		if (piece.getPlayer() == null)
			return;
		Board board = cgame.getBoard();
		Cell cell = piece.getCell();
		int pas = 1;
		if (piece.getPlayer() == cgame.getPlayers().get(1)) {
			pas = -1;
		}
		int x = cell.getX();
		int y = cell.getY();

		Cell enemy1, possible1, enemy2, possible2;
		enemy1 = board.getCell(x-1, y+pas);
		if ((enemy1 != null) && (!enemy1.isEmpty()) &&
				(enemy1.getContent().get(0).getPlayer() != piece.getPlayer())) {
			possible1 = board.getCell(x-2, y+pas+pas);
			if(possible1 != null && possible1.isEmpty())
				piece.addPossibleTarget(enemy1);
		}
		enemy2 = board.getCell(x+1, y+pas);
		if ((enemy2 != null) && (!enemy2.isEmpty()) &&
				(enemy2.getContent().get(0).getPlayer() != piece.getPlayer())) {
			possible2 = board.getCell(x+2, y+pas+pas);
			if(possible2 != null && possible2.isEmpty())
				piece.addPossibleTarget(enemy2);
		}
		
	}

}
