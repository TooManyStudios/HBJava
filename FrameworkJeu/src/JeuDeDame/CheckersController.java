package JeuDeDame;

import java.util.ArrayList;
import java.util.Scanner;

import framework.board.Cell;
import framework.game.Player;
import framework.unit.Piece;

public class CheckersController {

	private Scanner scanner;
	private CheckersGame game;
	
	public CheckersController() {
		this.scanner = new Scanner(System.in);
	}
	
	public void setGame(CheckersGame game) {
		this.game = game;
	}

	public void waitForPlayerInput(Player currentPlayer) {
		do {
			System.out.println("\n" + currentPlayer.getName() + ", please input your next move (turn #" + game.getCurrentTurn() + ")");
		} while (!processInput(scanner.nextLine(), currentPlayer));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(game.displayBoard());
		game.endTurn();
	}

	private boolean processInput(String nextLine, Player currentPlayer) {
		ArrayList<Piece> pieces = currentPlayer.getPieces();
		Piece piece; ArrayList<Cell> moves;

		do {
			piece = pieces.get((int)(Math.random()*pieces.size()));
			moves = piece.getPossibleMoves(game);
		} while (moves.isEmpty());
		piece.moveTo(moves.get((int)(Math.random()*moves.size())));
		System.out.println("  Move piece from (" + piece.getCell().getX() + ", " + piece.getCell().getY() + ")");
		return true;
	}

	public void displayGameOver(Player loser) {
		System.out.println("\nGame over, " + loser.getNextPlayer() + " wins!");
		
	}
	
	
}
