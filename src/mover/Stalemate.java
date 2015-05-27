package mover;


import model.Casella;
import model.ChessBoard;
// RE contro RE
import model.King;

//	STALLO
public class Stalemate {
	
	public Stalemate (ChessBoard scacchiera){
		new Rules(scacchiera);
	}
	
	public boolean isStallo(boolean colore, ChessBoard scacchiera){
		// controlliamo se sono rimasti solo i due re 
		for(Casella[] caselle : scacchiera.getCaselle())
			for(Casella casella : caselle)
				if(!casella.isEmpty())
					if(!(casella.getPedina() instanceof King))
						return false;
		return true;
	}
}

