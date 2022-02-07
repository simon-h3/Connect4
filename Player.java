
public class Player {
	
	public Colour turn = Colour.RED;
	
	public Colour altPlayer() {
		
		switch(turn) {				// when the method is called it will flip players each time
		case RED:
			turn = Colour.BLUE;
			break;
		case BLUE:
			turn = Colour.RED;
			break;
		}
		
		return turn;
	}
	
}
