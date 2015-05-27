package model;

//	REGINA
public class Queen extends Piece {
	
	public Queen(boolean colore) {
		super(colore);
	}

	@Override
	public boolean validMove(Casella start, Casella end) {
		//si sono implementate le mosse della regina, controllando se rispetta le condizioni di una torre
		//o di un alfiere, in quanto la regina ha mossse valide uguali alle 2 precedenti 

		Rook torre = new Rook(getColore());
		Bishop alfiere = new Bishop(getColore());
		return torre.validMove(start, end) || alfiere.validMove(start, end);
	}

	@Override
	public String getName() {
		return "regina";
	}

}
