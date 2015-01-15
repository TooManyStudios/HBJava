package JeuDeDame;

import framework.game.Player;
import framework.unit.Piece;

public class CheckersPiece extends Piece {
	
	public CheckersPiece(){
		super();
	}
	
	public CheckersPiece(Player player){
		super(player);
	}
	
	public CheckersPiece(String name){
		super();
		this.setName(name);
	}
	
}
