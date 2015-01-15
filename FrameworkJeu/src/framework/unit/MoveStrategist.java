package framework.unit;

import java.util.ArrayList;

public interface MoveStrategist extends Movable {

	public void addMoveStrategy(MoveStrategy move);
	public ArrayList<MoveStrategy> getMoveStrategies();
	
}
