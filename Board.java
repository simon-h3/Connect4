import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board{
	
public Piece[][] board = new Piece[6][7];
public JButton[][] buttonArray = new JButton[6][7];

private JLabel currentPlayer;
public JFrame frame;
	
	public void placePiece(Piece piece) {				//adds a piece where described
		
		board[piece.position.row][piece.position.col] = piece;	//tells the board to do the same as the buttonArray
		
		switch(piece.colour) {
		case RED:
			buttonArray[piece.position.row][piece.position.col].setBackground(Color.RED);
			break;
		
		case BLUE:
			buttonArray[piece.position.row][piece.position.col].setBackground(Color.BLUE);
			break;
		}
	}

	public Board() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 770);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		currentPlayer = new JLabel(Connect4.player.turn + "'s turn");
		currentPlayer.setBounds(232, 0, 335, 66);
		currentPlayer.setFont(new Font("Arial Black", Font.BOLD, 22));
		currentPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(currentPlayer);
		
		int y = 600; // declare distance down for first button
		
		for (int row = 0; row < 6; row++) {
			
			int x = 50; //to reset itself xd
			
				for (int col = 0; col < 7; col++) {
					JButton Button = new JButton();
					Button.setEnabled(false);	// to tell the buttons to disable so they dont do anything
					Button.setBounds(x, y, 100, 100); // x and y change coords creating the board
					frame.getContentPane().add(Button);
					Button.setBackground(Color.LIGHT_GRAY); //declaring background is gray by default
					buttonArray[row][col] = Button;	// setting the button in the buttonArray
					
					x += 100;
				}
			y -= 100;
		}
		
		int x2 = 50;
		int col;
		
		for (col = 0; col < 7; col++) {
			
			final int column = col;			//sets the variable as won't be changed (shouldn't be changed)
			
			JButton interactButton = new JButton("V");
			interactButton.setBounds(x2, 50, 100, 25);	// same as previous j button for loop maker, for the top panel
			frame.getContentPane().add(interactButton);
			interactButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {  // what is triggered when button is pressed

                    colSelect(column);
                }
            });
			
			x2 += 100;
		}
		
	}

	
	public void colSelect(int column) {		//take in column as an int for the y axis
		
		if(isValid(new Position(5,column))){	//stops before column fills!		
			
			int counter = 0;
			
				while(!isValid(new Position(counter, column))){
					counter++;
				}
				
			Position location = new Position(counter, column);
				
			Piece piece = new Piece(Connect4.player.turn, location); //object piece, stores: current player's colour & i + column
			placePiece(piece); //finally putting the piece.
			
				if(checkForWin(piece)) {
					System.out.println("Winner is: " + Connect4.player.turn);
					WinScreen.loadWinScreen();
					
				}
			
				Connect4.player.altPlayer();
				currentPlayer.setText(Connect4.player.turn + "'s turn");
			
				}
		else {
			System.out.println("Col full");
			
		}
	
	}
	
	public boolean isValid(Position pos) {	//takes input from Position class > pos, can then be used by pos.row
		
		if (board[pos.row][pos.col] == null){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkForWin(Piece piece){
		
	    for (int i = 0; i < 6; i++) { // iterate rows, bottom to top
	        for (int o = 0; o < 7; o++) { // iterate columns, left to right
	        	Colour playerCheck = piece.colour;
	             
	            // > check
	            if (o + 3 < 7 &&
	            	compareColour(new Position(i, o), playerCheck) &&
	            	compareColour(new Position(i, o+1), playerCheck) &&
	            	compareColour(new Position(i, o+2), playerCheck) &&
	            	compareColour(new Position(i, o+3), playerCheck))
	            	
	                return true;
	            
	            // < check
	            if (i + 3 < 7) {
	            	if (compareColour(new Position(i, o), playerCheck) &&	
	            		compareColour(new Position(i+1, o), playerCheck) &&
	            		compareColour(new Position(i+2, o), playerCheck) &&
	            		compareColour(new Position(i+3, o), playerCheck))
	                	
	                    return true;
	                
	                // checking diagonal up-right
	                if (o + 3 < 7 &&
	                	compareColour(new Position(i, o), playerCheck) &&	
	                	compareColour(new Position(i+1, o+1), playerCheck) &&
	                	compareColour(new Position(i+2, o+2), playerCheck) &&
	                	compareColour(new Position(i+3, o+3), playerCheck))
	                	
	                    return true;
	                
	                // checking diagional up left
	                if (o - 3 >= 0 &&
	                	compareColour(new Position(i, o), playerCheck) &&
	                	compareColour(new Position(i+1, o-1), playerCheck) &&
	                	compareColour(new Position(i+2, o-2), playerCheck) &&
	                	compareColour(new Position(i+3, o-3), playerCheck))
	                	
	                    return true;
	            	}
	            }
	        }
	        
		return false;
	}
	
	private boolean compareColour(Position checkPosition, Colour playerCheck) {
		if(!isValid(checkPosition)) {		//avoids null pointer exception in comparing empty stuff
			if(playerCheck == board[checkPosition.row][checkPosition.col].colour) {
				return true;
			}
		}

		return false;
	}
	
}

