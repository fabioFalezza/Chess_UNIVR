package test;

import static org.junit.Assert.*;
import model.*;
import mover.CheckMate;

import org.junit.Test;

import view.ChessBoardFrame;
import view.ChessFrame;

public class ValidMoves {

	CheckMate c = new CheckMate();

	@Test
	public void knightJumpOthersPiece() {	// IL CAVALLO PUO' SALTARE ALTRI PEZZI
		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(7, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(7, 6, 5, 5, frame);
		
		assertTrue(scacchiera.at(5, 5).getPedina() instanceof Knight);		
	}
	
	@Test
	public void turnChange() {	// CAMBIO TURNO
		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(7, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(7, 6, 5, 5, frame);
		
		assertTrue(!scacchiera.getTurn()); // TOCCA AI NERI
	}
	
	@Test
	public void canMoveOtherPieceDuringCheckMated() { // MUOVERE PEZZI CON IL RE' SOTTO SCACCO
		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(6, 4, 5, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(7, 3, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(2, 4, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 5));
		panel.getMover().move(5, 5, 1, 5, frame);
				
		assertFalse(panel.getRules().isValidMove(scacchiera.at(1, 0), scacchiera.at(2, 0), scacchiera.at(1, 0).getPedina())); // TOCCA AI NERI
	}
	
	
	@Test
	public void canPawnComeBack() {	// PUO' IL PEDONE TORNARE INDIETRO
		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(6, 4, 5, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);
		
		assertFalse(panel.getRules().isValidMove(scacchiera.at(5, 4), scacchiera.at(6, 4), scacchiera.at(5, 4).getPedina()));
	}
	
	@Test
	public void cantItEatAPieceOfTheSameColor(){	// NON SI POSSSONO MANGIARE PEZZI DELLO STESSO COLORE
		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		assertFalse(panel.getRules().isValidMove(scacchiera.at(7, 0), scacchiera.at(6, 0), scacchiera.at(7, 0).getPedina()));
	}
	
	@Test
	public void cantItEatAPieceThatPutsInCheck(){	// POSSO MANGIARE IL PEZZO CHE METTE SOTTO SCACCO IL RE
		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(6, 4, 5, 4, frame);
		
		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 4));
		panel.getMover().move(7, 3, 6, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(1, 7, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 3));
		panel.getMover().move(6, 4, 5, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(2, 4, 3, 4, frame);
	
		panel.getMover().setCasellaStart(panel.getModel().at(5, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 3));
		panel.getMover().move(5, 3, 1, 3, frame);

		assertTrue(panel.getRules().isValidMove(scacchiera.at(0, 3), scacchiera.at(1, 3), scacchiera.at(0, 3).getPedina()));
		
	}
}
