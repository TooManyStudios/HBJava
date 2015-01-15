package framework.game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import framework.board.Board;

public abstract class Game {
	protected Board board;
	protected ArrayList<Player> players;
	private int currentTurn;
	private Player currentPlayer;
	protected long turnTime = 0;
	protected long gameTime = 0;
	protected Timer turnTimer;
	protected Timer gameTimer;
	protected boolean isTurnTimerRunning;
	protected boolean isGameTimerRunning;
	
	public Game() {
		this.isGameTimerRunning = false;
		this.isTurnTimerRunning = false;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
		for (Player player: this.players){
			player.setNextPlayer(this.players.get( (this.players.indexOf(player) == this.players.size()-1) ? 0: this.players.indexOf(player)+1 ));
		}
	}
	
	public void setPlayers(Player players[]) {
		ArrayList<Player> list = new ArrayList<Player>();
		for (int i = 0; i < players.length; ++i) {
			list.add(players[i]);
		}
		this.setPlayers(list);
	}
	
	public int getCurrentTurn() {
		return currentTurn;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void setGameTime(long timeInMS){
		this.gameTime = timeInMS;
	}
	
	public long getGameTime(){
		return this.gameTime;
	}
	
	public void setTurnTime(long timeInMS){
		this.turnTime = timeInMS;
	}
	
	public long getTurnTime(){
		return this.turnTime;
	}
	
	public final void cancelGameTimer() {
		if (this.isGameTimerRunning)
			this.gameTimer.cancel();
	}
	
	public final void cancelTurnTimer() {
		if (this.isTurnTimerRunning)
			this.turnTimer.cancel();
	}
	
	public final void startGame(){
		if (this.gameTime != 0){
			Timer gameTimer = new Timer();
			gameTimer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  gameOver();
					  cancelGameTimer();
				  }
			}, this.gameTime);
			this.isGameTimerRunning = true;
		}
		this.currentTurn = 0;
		nextTurn();
	}

	private void nextTurn() {
		this.currentTurn++;
		this.currentPlayer = (this.currentPlayer != null)? this.currentPlayer.getNextPlayer(): this.players.get(0);
		this.triggerActionsBetweenTurns();
		beginTurn();
	}

	public void beginTurn() {
		if (this.turnTime != 0){
			Timer turnTimer = new Timer();
			turnTimer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  endTurn();
					  cancelTurnTimer();
				  }
			}, this.turnTime);
			this.isTurnTimerRunning = true;
		}
	}
	
	public final void endTurn() {
		this.cancelTurnTimer();
		this.checkVictoryConditions();
		this.nextTurn();
	}

	protected abstract void triggerActionsBetweenTurns();
	protected abstract void checkVictoryConditions();
	public abstract void gameOver();
}
