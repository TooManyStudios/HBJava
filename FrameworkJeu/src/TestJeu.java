import JeuDeDame.CheckersController;
import JeuDeDame.CheckersGame;


public class TestJeu {

	public static void main(String[] args) {
		
		CheckersController controller = new CheckersController();
		CheckersGame dGame = new CheckersGame(controller);
		System.out.println(dGame.displayBoard());
		dGame.startGame();
		
		
	}
	
}
