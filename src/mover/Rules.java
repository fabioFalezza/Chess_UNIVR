package mover;

import model.Bishop;
import model.Casella;
import model.Knight;
import model.ChessBoard;
import model.Piece;
import model.Pawn;
import model.King;
import model.Queen;
import model.Rook;
 
public class Rules {
        private ChessBoard scacchiera;
        private boolean turn; //true = bianco
        
        // costruttore usato all'inizio della partita: nuova scacchiera e turno ai bianchi
		public Rules(){
                this.scacchiera = new ChessBoard();
                turn = true;
        }
       
		// costruttore che prende la scacchiera e il turno aggiornati
        public Rules(ChessBoard scacchiera){
                this.scacchiera = scacchiera;
                this.turn = scacchiera.getTurn();
        }
       
        public boolean getTurno(){
                return turn;
        }
       
        public void setTurno(boolean turn){
                this.turn = turn;
        }
       
        //sceglie il controllo della mossa da effettuare in base alla pedina passata come argomento
        public boolean isValidMove(Casella start, Casella end, Piece pedina){
                if(pedina instanceof Pawn)
                        return PedoneMover((Pawn)pedina,start,end);
                if(pedina instanceof Knight)
                        return CavalloMover((Knight)pedina,start, end);
                if(pedina instanceof King)
                        return ReMover((King)pedina,start, end);
                if(pedina instanceof Queen)
                        return reginaMover((Queen)pedina,start, end);
                if(pedina instanceof Bishop)
                        return alfiereMover((Bishop)pedina,start, end);
                if(pedina instanceof Rook)
                        return torreMover((Rook)pedina,start, end);
                else
                        return false;
        }
       
       // Controllo della validità della mossa effettuata da un RE, da start a end
        private boolean ReMover(King re, Casella start, Casella end) {

        		Casella startTemp = new Casella(start); 
        		Casella endTemp = new Casella(end);
        		
        			// controllo che la mossa non sia in una casella adiacente all'altro re
        			if(!checkReAround(re.getColore(), end))
        				return false;
        			
        			if(!re.validMove(start, end))
        				return false;
        		
        			// controllo che nella casella end non ci sia una pedina dello stesso colore 				
        			if(!end.isEmpty())
                        if(end.getPedina().getColore() == re.getColore())
                                return false;
                        else{ //controllo che il re, anche se mangia una pedina, non possa essere mangiato a sua volta
                        	scacchiera.at(start.getY(),start.getX()).setPedina(null);
                        	scacchiera.at(end.getY(),end.getX()).setPedina(re);  //modifico temporaneamente sacchiera
                        	for(Casella[] riga : scacchiera.getCaselle())
                                for(Casella casella : riga)
                                        if(!casella.isEmpty()){
                                                if(casella.getPedina().getColore() != re.getColore())
                                                        if(isValidMove(casella, end, casella.getPedina())){
                                                        	// riporto la scacchiera alle condizioni iniziali
                                                        	scacchiera.at(start.getY(),start.getX()).setCasella(startTemp);
                                                        	scacchiera.at(end.getY(),end.getX()).setCasella(endTemp); 
                                                        	return false;
                                                        }}
                        }
        			
        		scacchiera.at(start.getY(),start.getX()).setPedina(re);
        		scacchiera.at(end.getY(),end.getX()).setPedina(endTemp.getPedina());
        		
                return true && checkScaccoRe(re.getColore(), start, end);
        }
        
        
        public boolean checkScaccoRe(boolean colore, Casella start, Casella end){
        		//controllo che la casella di end non sia un re, per evitare scacchi al re ciclici.
        		if(end.getPedina() instanceof King){
        			return true;	
        		}
        		
        	
                Casella delRe = null;
                Casella startTemp = new Casella(start);    //mi copio la casella iniziale di spostamento
                Casella endTemp = new Casella(end);        //mi copio la casella finale di spostamento
                
                
                
                scacchiera.at(end.getY(),end.getX()).setPedina(start.getPedina());
                scacchiera.at(start.getY(),start.getX()).setPedina(null);    //setto la pedina della casella precedente a null come se si fosse già spostato
                scacchiera.toString();
                
               //CERCO IL RE DELLO STESSO COLORE DEL PEZZO MOSSO
                for(Casella[] riga : scacchiera.getCaselle())
                        for(Casella casella : riga)
                                if(!casella.isEmpty())
                                        if(casella.getPedina() instanceof King && casella.getPedina().getColore() == colore)
                                                delRe = new Casella(casella.getX(),casella.getY(),casella.getPedina(),casella.getColore());
                								//MI SALVO LA CASELLA DEL RE
               
                
                for(Casella[] riga : scacchiera.getCaselle())
                        for(Casella casella : riga)
                                if(!casella.isEmpty()) //LA CASELLA NON E' VUOTA?
                                        if(casella.getPedina().getColore() != colore) //PEZZO DIVERSO DAL COLORE DEL RE'?
                                                if(isValidMove(casella, delRe, casella.getPedina())){ //la mossa è valida(pedone come se si fosse spostato)

                                                	//risetto le caselle come erano prima
                                                	scacchiera.at(start.getY(),start.getX()).setCasella(startTemp);        
                                                	scacchiera.at(end.getY(),end.getX()).setCasella(endTemp);
                                                	
                                                	return false;
                                                } 
                
                scacchiera.at(start.getY(),start.getX()).setCasella(startTemp);//risetto le caselle come erano prima      
                scacchiera.at(end.getY(),end.getX()).setCasella(endTemp);
                return true;
        }
        
        private boolean checkReAround(boolean colore, Casella end){
      
        	for(int i = end.getY() -1; i <= end.getY() +1; i++)
        		for(int j = end.getX() -1; j <= end.getX() +1; j++)
        			if(coordinateInChess(i, j))
        				if(!scacchiera.at(i,j).isEmpty())
        					if(scacchiera.at(i, j).getPedina() instanceof King && scacchiera.at(i, j).getPedina().getColore() != colore)
        						return false;
        	
        	return true;
        }
       
        private boolean coordinateInChess(int i, int j){
        	return i >= 0 && i <= 7 && j >= 0 && j <= 7;
        }

        // Controllo della validità della mossa effettuata da una REGINA, da start a end
        private boolean reginaMover(Queen regina, Casella start, Casella end) {
                Bishop alfiere = new Bishop(regina.getColore());
                Rook torre= new Rook(regina.getColore());
                return (alfiereMover(alfiere,start,end) || torreMover(torre, start, end)) && checkScaccoRe(regina.getColore(),start,end);
        }
 
     // Controllo della validità della mossa effettuata da un ALFIERE, da start a end
        private boolean alfiereMover(Bishop alfiere, Casella start, Casella end) {
 
                if(!alfiere.validMove(start, end))
                        return false;
               
                 int incY = (start.getY() < end.getY()) ? 1 : -1;
                 int incX = (start.getX() < end.getX()) ? 1 : -1;
                 // variabili utilizzate per iniziare la ricorsione senza considerare la casella attuale dove si trova l'alfiere
                 
                return alfiereMoverAux(alfiere, scacchiera.at(start.getY() + incY,start.getX() + incX), end) && checkScaccoRe(alfiere.getColore(),start,end);
        }
       
        //Muovo ricordivamente l'alfiere controllando le sue possibili 4 direzioni e che non abbia pedine nel percorso dalla casella 
        //start alla casella end.
        private boolean alfiereMoverAux(Bishop alfiere, Casella start, Casella end) {
               
                if(start.getY() == end.getY() && start.getX() == end.getX())
                        return end.isEmpty() || end.getPedina().getColore() != alfiere.getColore();
               
                //ho modificato end.isEmpty perchè si deve controllare se è vuota la casella attuale ma non l'ultima
                else if(start.getY() > end.getY() && start.getX() > end.getX())
                        return start.isEmpty() && alfiereMoverAux(alfiere, scacchiera.at(start.getY()-1, start.getX()-1), end);
                else if(start.getY() > end.getY() && start.getX() < end.getX())
                        return start.isEmpty() && alfiereMoverAux(alfiere, scacchiera.at(start.getY()-1, start.getX()+1), end);
                else if(start.getY() < end.getY() && start.getX() < end.getX())
                        return start.isEmpty() && alfiereMoverAux(alfiere, scacchiera.at(start.getY()+1, start.getX()+1), end);
                else // if(start.getX() < end.getX() && start.getY() > end.getY())
                        return start.isEmpty() && alfiereMoverAux(alfiere, scacchiera.at(start.getY()+1, start.getX()-1), end);
               
        }
 
     // Controllo della validità della mossa effettuata da una TORRE, da start a end
        private boolean torreMover(Rook torre, Casella start, Casella end) {
                int incremento;
                if(!torre.validMove(start, end))
                        return false;
                if(end.getPedina() != null)
                        if(end.getPedina().getColore() == torre.getColore())
                                return false;
               
                incremento = (start.getX() > end.getX() || start.getY() > end.getY()) ? -1 : 1;
               
                if(end.getY() == start.getY()){
                        for(int i = start.getX() + incremento; i != end.getX(); i += incremento){ //controllo fino alla casella end-1
                                if(!scacchiera.at(start.getY(),i).isEmpty())
                                        return false;
                                }
                }
                if(end.getX() == start.getX()){
                        for(int i = start.getY() + incremento; i != end.getY(); i += incremento){ //controllo fino alla casella end-1
                                if(!scacchiera.at(i,start.getX()).isEmpty())
                                        return false;
                                }
                }      
                return checkScaccoRe(torre.getColore(),start,end);
        }
       
     // Controllo della validità della mossa effettuata da un CAVALLO, da start a end
        private boolean CavalloMover(Knight cavallo, Casella start, Casella end) {
                if(!cavallo.validMove(start,end))
                        return false;
                if(!end.isEmpty() && end.getPedina().getColore() == cavallo.getColore())
                        return false;
                return checkScaccoRe(cavallo.getColore(),start,end);
        }
 
     // Controllo della validità della mossa effettuata da un PEDONE, da start a end
        private boolean PedoneMover(Pawn pedone, Casella start, Casella end){ 
			return pedone.validMove(start,end) && checkScaccoRe(pedone.getColore(),start,end);
        }
       
}