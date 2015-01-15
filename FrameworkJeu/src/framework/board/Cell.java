package framework.board;

import java.util.*;

import framework.unit.*;
import framework.game.*;

public class Cell {
	protected int x;
	protected int y;
	protected Terrain terrain;
	protected ArrayList<Piece> content;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.content = new ArrayList<Piece>();
		this.terrain = new Terrain();
	}
	
	public Cell(int x, int y, Terrain terrain) {
		this(x, y);
		this.terrain = terrain;
	}
	
	public void addPiece(Piece piece) {
		this.content.add(piece);
	}
	
	public void removePiece(Piece piece) {
		this.content.remove(piece);
	}
	
	public ArrayList<Piece> getContent() {
		return this.content;
	}
	
	public ArrayList<Piece> getContent(Player player) {
		ArrayList<Piece> playerUnits = new ArrayList<Piece>();
		for (Piece piece: this.content ) {
			if (piece.getPlayer() == player) {
				playerUnits.add(piece);
			}
		}
		return playerUnits;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean isEmpty() {
		return this.content.isEmpty();
	}
	
	public String toString() {
		return new String("Cell (" + this.x + ", " + this.y + ")");
	}
	
}
