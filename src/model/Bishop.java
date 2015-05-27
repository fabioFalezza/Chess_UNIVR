package model;

//	ALFIERE
public class Bishop extends Piece{
	
	public Bishop(boolean colore) {
		super(colore);
		
	}

	public boolean validMove(Casella start, Casella end){
		return !(start.getX()==end.getX() && start.getY()==end.getY()) && 
				Math.abs(start.getX() - end.getX()) == Math.abs(start.getY() - end.getY());
	}

	public String getName() {
		return "alfiere";
	}
}
