package model;

//	CAVALLO
public class Knight extends Piece {

	public Knight(boolean colore) {
		super(colore);
	}

	@Override
	public boolean validMove(Casella start, Casella end) {
		return ((end.getY() == start.getY() + 2 || end.getY() == start.getY() -2) && (end.getX() == start.getX() +1 || end.getX() == start.getX() -1)) || 
			((end.getX() == start.getX() + 2 || end.getX() == start.getX() -2) && (end.getY() == start.getY() +1 || end.getY() == start.getY() -1));
		}

	public String getName() {
		return "cavallo";
	}
}
