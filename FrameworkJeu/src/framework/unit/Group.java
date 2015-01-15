package framework.unit;

import java.util.*;

import framework.board.Cell;
import framework.game.*;

public class Group implements Movable {

	protected ArrayList<Piece> pieces;
	protected ArrayList<MoveStrategy> moveStrategies;
	protected ArrayList<Cell> possibleMoves;
	protected Player owner;
	
	public Group(Player player){
		this.pieces = new ArrayList<Piece>();
		this.owner = player;
	}
	
	public Group(ArrayList<Piece> pieces){
		this.pieces = pieces;
		this.setPlayer(this.pieces.get(0).getPlayer());
	}
	
	public void add(Piece piece){
		if(this.getPlayer() == piece.getPlayer())
			this.pieces.add(piece);
	}
	
	public void remove(Piece piece){
		this.pieces.remove(piece);
	}
	
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	public void setPlayer(Player player){
		this.owner = player;
	}
	
	public Player getPlayer(){
		return this.owner;
	}

	@Override
	public void moveTo(Cell destination) {
		for (Piece piece: this.pieces){
			piece.moveTo(destination);
		}
	}

	@Override
	public ArrayList<Cell> getPossibleMoves(Game game) {
		// TODO Auto-generated method stub
		ArrayList<Cell> origin = new ArrayList<Cell>();
		for (Piece piece: this.pieces){
			origin = (ArrayList<Cell>) getCommonCells(origin, piece.getPossibleMoves(game));
		}
		return origin;
	}
	
	@Override
	public void addPossibleMove(Cell cell) {
		for (Piece piece: this.pieces){
			piece.addPossibleMove(cell);
		}
	}
	
	@Override
	public void clearPossibleMoves() {
		this.possibleMoves.clear();
	}
	
	private ArrayList<Cell> getCommonCells(ArrayList<Cell> listA, ArrayList<Cell> listB){
		ArrayList<Cell> arrayToHash;
		ArrayList<Cell> arrayToSearch;
		 
		if( listA.size() < listB.size() ) {
			arrayToHash = listA;
			arrayToSearch = listB;
		} else {
			arrayToHash = listB;
			arrayToSearch = listA;
		}
		HashSet<Cell> intersection = new HashSet<Cell>();
		HashSet<Cell> hashedArray = new HashSet<Cell>();
		for( Cell entry : arrayToHash ) {
		    hashedArray.add( entry );
		}
		for( Cell entry : arrayToSearch ) {
		    if( hashedArray.contains( entry ) ) {
		        intersection.add( entry );
		    }
		}
		return new ArrayList<Cell>(intersection);
	}

}
