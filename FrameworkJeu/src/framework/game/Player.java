package framework.game;

import java.util.ArrayList;

import framework.unit.Piece;

public class Player {
	protected String name;
	protected Player next;
	protected ArrayList<Piece> pieces;
	
	public Player(String name) {
		this.name = name;
		this.pieces = new ArrayList<Piece>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setNextPlayer(Player player) {
		this.next = player;
	}
	
	public Player getNextPlayer() {
		return this.next;
	}
	
	public void addPiece(Piece piece) {
		this.pieces.add(piece);
	}
	
	public ArrayList<Piece> getPieces() {
		return this.pieces;
	}
	
	public String toString() {
		return this.getName();
	}
	
}
