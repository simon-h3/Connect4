import java.awt.EventQueue;

public class Connect4 {
	
	public static Board board;
	public static Player player;

	public static void loadBoard() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					board = new Board();
					board.frame.setVisible(true);
				} catch (Exception error) {
					error.printStackTrace();
				}
			}
		});
		
		player = new Player();	//used in board.java for switching turn
	}

}
