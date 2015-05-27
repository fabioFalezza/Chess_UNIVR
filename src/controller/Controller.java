package controller;

import view.ChessFrame;
import model.ChessBoard;

public interface Controller {
	//sposta le pedine, se è possibile, controllando eventuali scacchi matti e patte
	public void onClick(int fromY, int fromX, int toY, int toX, ChessFrame frame); 
	
	//ritorna un nuovo chessboard riportando la configurazione iniziale
	public ChessBoard newGame();
}
