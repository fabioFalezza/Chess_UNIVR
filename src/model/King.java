package model;

//	RE
public class King extends Piece {

	public King(boolean colore) {
		super(colore);
	}

	@Override
	public boolean validMove(Casella start, Casella end) {
		return start.getY() - end.getY() >= -1 && start.getY() - end.getY() <= 1 && start.getX() - end.getX() >= -1 && start.getX() - end.getX() <= 1;
	}

	@Override
	public String getName() {
		return "re";
	}

}
