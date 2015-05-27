package controller;

import model.ChessBoard;
import model.Pawn;
import mover.CheckMate;
import mover.Stalemate;
import mover.Mover;
import view.ChessFrame;
import view.Promotion;
import view.View;
import view.End;

public class ChessController implements Controller{
	private Mover mover;
	private View view;
	private ChessBoard chessboard;
	//private boolean checkMate;
	
	
	public ChessController(View view){
		this.view = view;
		this.chessboard = new ChessBoard();
		
	}
	
	public ChessController(View view, ChessBoard chessboard){
		this.view = view;
		this.chessboard = chessboard;
		this.mover = new Mover(chessboard);
	}
	
	@Override
	public void onClick(int fromY, int fromX, int toY, int toX, ChessFrame frame) {

		Stalemate d = new Stalemate(chessboard);
		CheckMate c = new CheckMate();
		boolean turn = chessboard.at(fromY, fromX).getPedina().getColore();
		

		mover.setCasellaStart(chessboard.at(fromY,fromX));
		mover.setCasellaEnd(chessboard.at(toY,toX));
		mover.move(fromY, fromX, toY, toX, frame);
		//condizione che evita la ristampa grafica nel caso in cui il giocatore 
		//clicca su una pedina e poi su un'altra dello stesso colore sostituendola con quella iniziale
		if(mover.getIsMoved()) 
			
			// modifica la parte grafica in base al nuovo modello scacchiera
			view.onConfigurationChange(fromY, fromX, toY, toX);
		
			// se il pedone si trova nell'ultima riga
            if(chessboard.at(toY,toX).getPedina() instanceof Pawn)
                	if( chessboard.at(toY,toX).getPedina().getColore() ? mover.getCasellaEnd().getY() == 0 : mover.getCasellaEnd().getY() == 7 ){
            									do{//appertura joptionpane promozione
                                                	Promotion.scegliPezzo(chessboard.at(toY,toX),chessboard.at(toY,toX).getPedina().getColore(),view.getTheme());
                                                }
                                                while(chessboard.at(toY,toX).getPedina() instanceof Pawn);
                                                view.onConfigurationChange(toY, toX);
                   }

            	//controllo se è scacco matto
                if(c.isCheckMate(chessboard, turn)){
                		//checkMate=true;
                		End winFrame = new End(view,chessboard,true);
                		winFrame.setVisible(true);
                }
                
                // controllo se è stallo
                else if(d.isStallo(chessboard.getTurn(), chessboard)){
                	//checkMate=false;
                	End winFrame = new End(view,chessboard,false);
            		winFrame.setVisible(true);
				}
        }
	
	@Override
	public ChessBoard newGame() {
		return chessboard.newGame();
	}

	public ChessBoard getChessBoard(){
		return chessboard;
	}

}
