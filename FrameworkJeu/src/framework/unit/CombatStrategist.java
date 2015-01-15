package framework.unit;

import java.util.ArrayList;

import framework.board.Cell;
import framework.game.Game;

public interface CombatStrategist {

	public void attack(Cell destination);
	public ArrayList<Cell> getPossibleTargets(Game game);
	public void addPossibleTarget(Cell cell);
	public void clearPossibleTargets();
	public void addCombatStrategy(CombatStrategy combat);
	public ArrayList<CombatStrategy> getCombatStrategies();
}
