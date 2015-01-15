package framework.unit;

import java.util.*;

import framework.game.Game;
import framework.game.Player;
import framework.board.*;

public abstract class Piece implements MoveStrategist, CombatStrategist {
	protected String name;
	protected Cell cell;
	protected Player player;
	protected ArrayList<MoveStrategy> moveStrategies;
	protected ArrayList<Cell> possibleMoves;
	protected ArrayList<CombatStrategy> combatStrategies;
	protected ArrayList<Cell> possibleTargets;
	
	public Piece(){
		this.moveStrategies = new ArrayList<MoveStrategy>();
		this.possibleMoves = new ArrayList<Cell>();
		this.combatStrategies = new ArrayList<CombatStrategy>();
		this.possibleTargets = new ArrayList<Cell>();
	}
	
	public Piece(String name){
		this();
		this.setName(name);
	}
	
	public Piece(Player player){
		this();
		this.setPlayer(player);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	

	public void setPlayer(Player player) {
		this.player = player;
		this.player.addPiece(this);
	}

	public Player getPlayer() {
		return this.player;
	}
	
	public Cell getCell() {
		return this.cell;
	}
	
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
	public boolean isOutOfBoard() {
		return (this.cell == Board.OUT_OF_BOARD);
	}
	
	@Override
	public void moveTo(Cell destination) {
		if(!this.possibleMoves.contains(destination))
			return;
		Cell departure = this.getCell();
		departure.removePiece(this);
		this.setCell(destination);
		destination.addPiece(this);
		this.clearPossibleMoves();
	}

	@Override
	public void addMoveStrategy(MoveStrategy move) {
		this.moveStrategies.add(move);
	}
	
	@Override
	public ArrayList<MoveStrategy> getMoveStrategies() {
		return this.moveStrategies;
	}
	
	private void computePossibleMoves(Game game) {
		this.clearPossibleMoves();
		for(MoveStrategy moveStrategy: this.moveStrategies) {
			moveStrategy.computePossibleMoves(game, this);
		}
	}
	
	@Override
	public void addPossibleMove(Cell cell) {
		if (!this.possibleMoves.contains(cell))
			this.possibleMoves.add(cell);
	}
	
	@Override
	public ArrayList<Cell> getPossibleMoves(Game game) {
		this.computePossibleMoves(game);
		return this.possibleMoves;
	}
	
	@Override
	public void clearPossibleMoves() {
		this.possibleMoves.clear();
	}
	
	@Override
	public void attack(Cell destination){
		
	}
	
	public ArrayList<Cell> getPossibleTargets(Game game){
		return this.possibleTargets;
	}
	
	public void addPossibleTarget(Cell cell){
		if (!this.possibleTargets.contains(cell))
			this.possibleTargets.add(cell);
	}
	
	public void clearPossibleTargets(){
		this.possibleTargets.clear();
	}
	
	public void addCombatStrategy(CombatStrategy combat){
		this.combatStrategies.add(combat);
	}
	
	public ArrayList<CombatStrategy> getCombatStrategies(){
		return this.combatStrategies;
	}
	
	
}
