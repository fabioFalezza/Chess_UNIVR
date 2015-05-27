package mover;

import model.Casella;
import model.ChessBoard;
import model.King;


//CASI DI USCITA DALLO SCACCO
//1 - posso mangiare la pedina che fa scacco // TRUE quando rimane sotto scacco, FALSE quando può mangiare
//2 - spostare il re in una casella non scaccata // TRUE quando rimane sotto scacco, FALSE al contrario
//3 - mettere una pedina tra il pezzo che vuole mangiare il re e il re stesso

public  class CheckMate {
	
	private  Casella casellaSottoScacco = null;
	private  Casella pezzoScacco = null;
	private  Rules rules;
	
	//controlla che nessuno dei 3 casi sopracitati si verifichi. In tal caso restituisce TRUE, cioè il verificarsi dello scacco matto
	public boolean isCheckMate(ChessBoard scacchiera, boolean colore){ //colore del pezzo che ha appena mosso
		rules = new Rules(scacchiera);
		//trova la casella sotto scacco
		for(Casella[] riga1 : scacchiera.getCaselle()){
			if(casellaSottoScacco != null)
				break;
			for(Casella casella1 : riga1){
				if(casellaSottoScacco != null)
					break;
				if(!(casella1.isEmpty()))
					if( casella1.getPedina() instanceof King && casella1.getPedina().getColore() != colore )
					casellaSottoScacco = casella1; }
		}
		return passo1(scacchiera, colore) && passo2(casellaSottoScacco,scacchiera) && passo3(scacchiera);
	}

	//PASSO 1 RESTITUISCE TRUE SE NON PUO ESSERE MANGIATO IL PEZZO CHE METTE SOTTO SCACCO IL RE
	private  boolean passo1(ChessBoard scacchiera, boolean colore){ //colore del pezzo che sta muovendo
		
		//trovo la casella che mette sotto scacco il re		
		for(Casella[] riga : scacchiera.getCaselle())
			for(Casella casella : riga)
				if(!casella.isEmpty())
					if(casella.getPedina().getColore() == colore)
						if(rules.isValidMove(casella,casellaSottoScacco,casella.getPedina()))
							pezzoScacco=casella;
		
		//se non trovo un pezzo che possa mangiare il re, restituisco false, cioè non è scacco
		if(pezzoScacco == null)
			return false;
		
		//il pezzo che mette sotto scacco il re è stato trovato, e cerco tra le mie pedine, se è possibile mangiarlo
			for(Casella[] riga2 : scacchiera.getCaselle())
				for(Casella casella2 : riga2)
					if(!casella2.isEmpty())
						if(casella2.getPedina().getColore() != colore)
							if(rules.isValidMove(casella2, pezzoScacco, casella2.getPedina()))
								return false;
		
				return true;
	}
							//casella del re
	private  boolean passo2(Casella casella, ChessBoard scacchiera) {
		if(pezzoScacco == null)
			return false;
		
		int y = casella.getY();
		int x = casella.getX();
		//rules ha gia il turno successivo, cioe muovo il bianco, e qua sotto il turn == false;
		Rules rules = new Rules(scacchiera);
		
		if(x-1 >= 0)
			if(rules.isValidMove(casella,scacchiera.at(y,x-1),casella.getPedina()))
				return false;
		if(x+1 < 8)
			if(rules.isValidMove(casella,scacchiera.at(y,x+1),casella.getPedina()))
				return false;
		
		if(y-1 >= 0){
				if(rules.isValidMove(casella,scacchiera.at(y-1,x),casella.getPedina()))
					return false;
				if(x-1 >= 0)
					if(rules.isValidMove(casella,scacchiera.at(y-1,x-1),casella.getPedina()))
						return false;
				if(x+1 < 8)
					if(rules.isValidMove(casella,scacchiera.at(y-1,x+1),casella.getPedina()))
						return false;
		}
		
		if(y+1 < 8){
			if(rules.isValidMove(casella,scacchiera.at(y+1,x),casella.getPedina()))
				return false;
			if(x-1 >= 0)
				if(rules.isValidMove(casella,scacchiera.at(y+1,x-1),casella.getPedina()))
					return false;
			if(x+1 < 8)
				if(rules.isValidMove(casella,scacchiera.at(y+1,x+1),casella.getPedina()))
					return false;
		}
		
		return true;	
	}
	
	private  boolean passo3(ChessBoard scacchiera){
		
		if(pezzoScacco == null)
			return false;
			
		//trovo una mia pedina
		for(Casella[] riga1 : scacchiera.getCaselle())
			for(Casella casella1 : riga1)
				if(!casella1.isEmpty())
					if(casella1.getPedina().getColore() == casellaSottoScacco.getPedina().getColore()){ 
						
						// se l'ho trovata, cerco se è possibile muoverla in una casella tra il re e la pedina
						for(Casella[] riga2 : scacchiera.getCaselle())
							for(Casella casella2 : riga2)
								if(casella1.getPedina().getColore() != pezzoScacco.getPedina().getColore())
									if(rules.isValidMove(casella1, casella2, casella1.getPedina()))
										return false;
					}
		
		return true;	
	}

}
	



