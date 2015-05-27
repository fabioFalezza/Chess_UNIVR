package model;

//	TORRE
public class Rook extends Piece {
	
	public Rook(boolean colore) {
		super(colore);
	}

	public boolean validMove(Casella start, Casella end){
		return (end.getY() == start.getY() || end.getX() == start.getX());
	}

	@Override
	public String getName() {
		return "torre";
	}
}
