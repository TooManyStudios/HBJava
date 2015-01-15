package JeuDeDame;

import java.util.ArrayList;

import framework.board.Cell;
import framework.game.Game;
import framework.game.Player;
import framework.unit.Piece;


public class CheckersGame extends Game {
	
	private CheckersController controller;
	private GameState gameState;
	
	public CheckersGame(CheckersController controller) {
		super();
		this.controller = controller;
		this.controller.setGame(this);
		gameState = GameState.INITIALIZING;
		Player[] players = {new Player("Teddy"), new Player("Renaud")};
		this.setPlayers(players);
		CheckersBoard board = new CheckersBoard();
		this.setBoard(board);
		this.initPlayerPieces();
		this.setCurrentPlayer(this.players.get(0));
		gameState = GameState.IN_PROGRESS;
		this.startGame();
	}
	
	public void initPlayerPieces() {
		PawnMove pawnMove = new PawnMove();
		PawnCombat pawnCombat = new PawnCombat();
		for (int x = 0; x < CheckersBoard.SIDE_LENGTH; x++) {
			for (int y = 0; y < CheckersBoard.SIDE_LENGTH; y++) {
				if (y < 4 && x%2 != y%2) {
					CheckersPiece unit = new CheckersPiece(this.players.get(0));
					unit.setCell(this.board.getCell(x, y));
					unit.addMoveStrategy(pawnMove);
					unit.addCombatStrategy(pawnCombat);
					this.board.getCell(x, y).addPiece(unit);
				}
				if (y > 5 && x%2 != y%2) {
					CheckersPiece unit = new CheckersPiece(this.players.get(1));
					unit.setCell(this.board.getCell(x, y));
					unit.addMoveStrategy(pawnMove);
					unit.addCombatStrategy(pawnCombat);
					this.board.getCell(x, y).addPiece(unit);
				}
			}
		}
	}
	
	public String displayBoard() {
		String output = new String();
		for (int y = 0; y < CheckersBoard.SIDE_LENGTH; y++) {
			for (int x = 0; x < CheckersBoard.SIDE_LENGTH; x++) {
				
				Cell theCell = this.board.getCell(x, y);
				if (x%2 != y%2) {
					ArrayList<Piece> pieces = theCell.getContent();
					if (pieces.size() == 0) {
						output += "[ ]";
					} else {
						output += "[";
						Piece piece = pieces.get(0);
						Player player = piece.getPlayer();
						if (player == this.players.get(0)) {
							if (pieces.size() == 2) {
								output += "O";
							} else {
								output += "o";
							}
						} else if(player == this.players.get(1)) {
							if (pieces.size() == 2) {
								output += "X";
							} else {
								output += "x";
							}
						}
						output += "]";
					}
				} else output += "   ";
			}
			output += "\n";
		}
		return output;
	}

	protected void triggerActionsBetweenTurns() {
		
	}
	
	@Override
	public void beginTurn() {
		super.beginTurn();
		checkVictoryConditions();
		if (gameState != GameState.IN_PROGRESS)
			return;
		
		controller.waitForPlayerInput(this.getCurrentPlayer());
	}

	
	protected void checkVictoryConditions() {
		if (this.getCurrentPlayer().getPieces().size() == 0) {
			this.gameOver();
		}
		//no more possible moves
		boolean possibleMovement = false;
		for (Piece piece: this.getCurrentPlayer().getPieces()) {
			if (piece.getPossibleMoves(this).size() != 0){
				possibleMovement = true;
			}
		}
		if(!possibleMovement)
			this.gameOver();
	}

	@Override
	public void gameOver() {
		this.gameState = GameState.GAMEOVER;
		this.controller.displayGameOver(this.getCurrentPlayer());
	}
}
