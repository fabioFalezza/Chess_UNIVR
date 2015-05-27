package model;

//	PEDONE
public class Pawn extends Piece {
	
	
	public Pawn(boolean colore) {
		super(colore);
	}

	public boolean validMove(Casella start, Casella end){
		//controllo se è possibile spostarlo
		if(end.isEmpty()){
			if((this.getColore() == true ? (start.getY()- end.getY() == 1) : (start.getY() - end.getY() == -1)) && ((start.getX() == end.getX())))
				return true;
		}
		else{
			if((this.getColore() == true ? (start.getY()- end.getY() == 1) : (start.getY() - end.getY() == -1))  && (Math.abs(start.getX() - end.getX())== 1))
				if(end.getPedina().getColore() != start.getPedina().getColore())
						return true;
		}
		return false;
		}

	@Override
	public String getName() {
		return "pedone";
	}
	
}


