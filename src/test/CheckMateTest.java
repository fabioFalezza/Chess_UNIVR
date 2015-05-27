package test;

import static org.junit.Assert.*;
import model.ChessBoard;
import mover.CheckMate;

import org.junit.Test;

import view.ChessBoardFrame;
import view.ChessFrame;

public class CheckMateTest {
	
	CheckMate c = new CheckMate();
	
	@Test
	public void barbiereCheckMate(){

		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		//	PEDONE B
		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));	
		panel.getMover().move(6, 4, 5, 4, frame);
		
		//	PEDONE N
		panel.getMover().setCasellaStart(panel.getModel().at(1, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 0));	
		panel.getMover().move(1, 0, 2, 0, frame);
		
		//	REGINA B
		panel.getMover().setCasellaStart(panel.getModel().at(7, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));	
		panel.getMover().move(7, 3, 5, 5, frame);
		
		//	PEDONE N
		panel.getMover().setCasellaStart(panel.getModel().at(2, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 0));	
		panel.getMover().move(2, 0, 3, 0, frame);
		
		//	ALFIERE B
		panel.getMover().setCasellaStart(panel.getModel().at(7, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));	
		panel.getMover().move(7, 5, 4, 2, frame);
		
		//	PEDONE N
		panel.getMover().setCasellaStart(panel.getModel().at(3, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 0));	
		panel.getMover().move(3, 0, 4, 0, frame);
		
		//	REGINA B
		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 5));	
		panel.getMover().move(5, 5, 1, 5, frame);
		
		assertTrue(c.isCheckMate(scacchiera, true));
	}
	
	@Test
	public void stoltoCheckMate(){
		
		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("onepiece","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "onepiece", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));	
		panel.getMover().move(6, 5, 5, 5, frame);
		
		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));	
		panel.getMover().move(1, 4, 2, 4, frame);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 6));	
		panel.getMover().move(6, 6, 5, 6, frame);
		
		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));	
		panel.getMover().move(2, 4, 3, 4, frame);
		
		panel.getMover().setCasellaStart(panel.getModel().at(5, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 6));	
		panel.getMover().move(5, 6, 4, 6, frame);
		
		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 7));	
		panel.getMover().move(0, 3, 4, 7, frame);

		assertTrue(c.isCheckMate(scacchiera, false));
	}
	
	@Test
	public void legalCheckMate(){

		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(6, 4, 5, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(5, 4, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(2, 4, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(7, 6, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(1, 3, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));
		panel.getMover().move(7, 5, 4, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(0, 1, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 2));
		panel.getMover().move(7, 1, 5, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 6));
		panel.getMover().move(0, 2, 4, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(5, 5, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(7, 3));
		panel.getMover().move(4, 6, 7, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 5));
		panel.getMover().move(4, 2, 1, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(0, 4, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 3));
		panel.getMover().move(5, 2, 3, 3, frame);

		assertTrue(c.isCheckMate(scacchiera, true));
	}
	
	@Test
	public void mattodelCorridoio(){

		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(6, 4, 5, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));
		panel.getMover().move(7, 5, 4, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 2));
		panel.getMover().move(0, 5, 3, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(7, 3, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(0, 6, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(5, 4, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(2, 4, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 1));
		panel.getMover().move(4, 2, 3, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(0, 4, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 6));
		panel.getMover().move(5, 5, 5, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 4));
		panel.getMover().move(0, 7, 0, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 3));
		panel.getMover().move(6, 3, 5, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(1, 4, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 2));
		panel.getMover().move(6, 2, 5, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(0, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 3));
		panel.getMover().move(5, 3, 4, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(2, 5, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 2));
		panel.getMover().move(4, 3, 3, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 5));
		panel.getMover().move(1, 4, 0, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));
		panel.getMover().move(5, 2, 4, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(0, 5, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 7));
		panel.getMover().move(5, 6, 4, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 6));
		panel.getMover().move(0, 3, 3, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(6, 5, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(7, 2));
		panel.getMover().move(3, 6, 7, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 5));
		panel.getMover().move(7, 4, 6, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));
		panel.getMover().move(7, 2, 4, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(4, 7, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 6));
		panel.getMover().move(2, 7, 4, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(7, 4));
		panel.getMover().move(6, 5, 7, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(4, 6, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(1, 1, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 4));
		panel.getMover().move(2, 4, 0, 4, frame);

		assertTrue(c.isCheckMate(scacchiera, true));
	
	}
	
	@Test
	public void mattoDellAffogato(){

		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(6, 4, 5, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(1, 6, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 1));
		panel.getMover().move(7, 5, 3, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(0, 6, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(7, 6, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 6));
		panel.getMover().move(0, 5, 1, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 6));
		panel.getMover().move(5, 5, 3, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 1));
		panel.getMover().move(1, 6, 6, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 1));
		panel.getMover().move(7, 2, 6, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 5));
		panel.getMover().move(0, 7, 0, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(5, 4, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(2, 7, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 7));
		panel.getMover().move(3, 6, 5, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(0, 6, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(6, 5, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(2, 5, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 4));
		panel.getMover().move(7, 3, 6, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 6));
		panel.getMover().move(2, 6, 3, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(6, 4, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 6));
		panel.getMover().move(3, 6, 4, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 6));
		panel.getMover().move(5, 7, 3, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(1, 1, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 2));
		panel.getMover().move(7, 1, 5, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(4, 6, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 3));
		panel.getMover().move(5, 2, 3, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 6));
		panel.getMover().move(5, 5, 6, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(3, 3, 2, 5, frame);

		assertTrue(c.isCheckMate(scacchiera, true));
	
	}
	
	@Test
	public void mattoDelleSpalline(){		

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
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 7));
		panel.getMover().move(7, 3, 3, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(2, 4, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 6));
		panel.getMover().move(6, 6, 5, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(1, 6, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(3, 7, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(0, 6, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 6));
		panel.getMover().move(3, 4, 1, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(1, 4, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(1, 6, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 6));
		panel.getMover().move(0, 5, 1, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 6));
		panel.getMover().move(2, 6, 1, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(1, 7, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(1, 6, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(1, 5, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(2, 7, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(0, 6, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(2, 5, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 5));
		panel.getMover().move(0, 7, 0, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(2, 4, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(1, 1, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(2, 2, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(1, 2, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(2, 1, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(0, 2, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(2, 2, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(0, 3, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(1, 1, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 3));
		panel.getMover().move(0, 2, 0, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 0));
		panel.getMover().move(0, 1, 1, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(0, 3, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(1, 0, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(1, 4, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 1));
		panel.getMover().move(0, 1, 3, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(0, 2, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(3, 1, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 3));
		panel.getMover().move(0, 0, 0, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 7));
		panel.getMover().move(6, 7, 5, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(1, 3, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 7));
		panel.getMover().move(5, 7, 4, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 3));
		panel.getMover().move(2, 3, 3, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 7));
		panel.getMover().move(4, 7, 3, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 3));
		panel.getMover().move(3, 3, 4, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 7));
		panel.getMover().move(7, 7, 4, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 3));
		panel.getMover().move(4, 3, 5, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 6));
		panel.getMover().move(4, 7, 4, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 2));
		panel.getMover().move(5, 3, 6, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(4, 6, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(7, 1));
		panel.getMover().move(6, 2, 7, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(2, 6, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(7, 0));
		panel.getMover().move(7, 1, 7, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 7));
		panel.getMover().move(2, 7, 1, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(7, 2));
		panel.getMover().move(7, 0, 7, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 4));
		panel.getMover().move(7, 4, 6, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 1));
		panel.getMover().move(7, 2, 6, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(2, 1, 2, 4, frame);
		
		assertTrue(c.isCheckMate(scacchiera, true));
	
	}
	
	@Test
	public void mattoDellCirco(){		

		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(6, 4, 5, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(1, 3, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(5, 4, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 3));
		panel.getMover().move(2, 3, 3, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));
		panel.getMover().move(7, 5, 4, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 5));
		panel.getMover().move(0, 2, 3, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 4));
		panel.getMover().move(7, 3, 6, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 3));
		panel.getMover().move(0, 3, 1, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(6, 5, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(0, 1, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 3));
		panel.getMover().move(6, 4, 5, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 3, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 1));
		panel.getMover().move(6, 1, 5, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 3));
		panel.getMover().move(0, 0, 0, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(4, 4, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 3));
		panel.getMover().move(0, 3, 1, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 5));
		panel.getMover().move(5, 5, 4, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 3));
		panel.getMover().move(0, 4, 0, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 3));
		panel.getMover().move(4, 2, 3, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(0, 3, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(3, 3, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(0, 2, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 5));
		panel.getMover().move(2, 4, 3, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 3));
		panel.getMover().move(1, 3, 0, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(3, 5, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(0, 3, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));
		panel.getMover().move(2, 4, 4, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 3));
		panel.getMover().move(2, 2, 4, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 0));
		panel.getMover().move(6, 0, 5, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(4, 3, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 0));
		panel.getMover().move(5, 0, 4, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 3));
		panel.getMover().move(2, 2, 4, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 0));
		panel.getMover().move(4, 0, 3, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(4, 3, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 0));
		panel.getMover().move(3, 0, 2, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 3));
		panel.getMover().move(2, 2, 4, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 3));
		panel.getMover().move(5, 3, 4, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(1, 1, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 3));
		panel.getMover().move(4, 3, 3, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(3, 3, 1, 1, frame);

		
		assertTrue(c.isCheckMate(scacchiera, true));
	
	}
	
	@Test
	public void mattoArabo(){

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

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(1, 3, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(5, 5, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(1, 2, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 0));
		panel.getMover().move(1, 1, 0, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 0));
		panel.getMover().move(1, 0, 2, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 0));
		panel.getMover().move(0, 0, 2, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 2));
		panel.getMover().move(2, 2, 3, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(2, 0, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(0, 2, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 2));
		panel.getMover().move(2, 3, 3, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(1, 5, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(3, 2, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 5));
		panel.getMover().move(0, 4, 1, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 3));
		panel.getMover().move(0, 2, 0, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(2, 4, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(0, 3, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(1, 1, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(0, 1, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(1, 5, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 1));
		panel.getMover().move(2, 1, 3, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(1, 4, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 1));
		panel.getMover().move(3, 1, 4, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 2));
		panel.getMover().move(2, 3, 1, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));
		panel.getMover().move(4, 1, 4, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(1, 2, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 3));
		panel.getMover().move(4, 2, 4, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 0));
		panel.getMover().move(0, 1, 0, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 0));
		panel.getMover().move(6, 0, 5, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 0));
		panel.getMover().move(0, 5, 5, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 0));
		panel.getMover().move(7, 0, 5, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(0, 0, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 2));
		panel.getMover().move(7, 1, 5, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(3, 4, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 1));
		panel.getMover().move(5, 2, 3, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 5));
		panel.getMover().move(2, 5, 3, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(7, 6, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 5));
		panel.getMover().move(3, 5, 4, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(5, 5, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(4, 5, 5, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(3, 4, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(0, 1, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(3, 1, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 2));
		panel.getMover().move(1, 1, 1, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 4));
		panel.getMover().move(2, 3, 0, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(1, 2, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 3));
		panel.getMover().move(4, 3, 3, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(1, 6, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 0));
		panel.getMover().move(5, 0, 1, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(1, 1, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 0));
		panel.getMover().move(1, 0, 6, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(2, 1, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 0));
		panel.getMover().move(6, 0, 5, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 6));
		panel.getMover().move(2, 6, 3, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 1));
		panel.getMover().move(5, 0, 5, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 0));
		panel.getMover().move(1, 1, 0, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(5, 1, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 6));
		panel.getMover().move(3, 6, 4, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 0));
		panel.getMover().move(1, 1, 1, 0, frame);
		
		assertTrue(c.isCheckMate(scacchiera, true));
	}
	
	@Test
	public void mattoConDueAlfierieRe(){	

		ChessBoard scacchiera = new ChessBoard();
		ChessFrame frame = new ChessFrame("classico","TEST1","TEST2");
		ChessBoardFrame panel = new ChessBoardFrame(scacchiera, frame, "classico", 100);
		
		panel.getMover().setCasellaStart(panel.getModel().at(6, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 3));
		panel.getMover().move(6, 3, 5, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(1, 3, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 3));
		panel.getMover().move(5, 3, 4, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 3));
		panel.getMover().move(2, 3, 3, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 4));
		panel.getMover().move(6, 4, 5, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(5, 4, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(3, 3, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(7, 3, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(2, 4, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(5, 5, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(1, 5, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 4));
		panel.getMover().move(4, 4, 3, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(0, 3, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(7, 3));
		panel.getMover().move(7, 4, 7, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(1, 4, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(3, 4, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(1, 6, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(2, 5, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 5));
		panel.getMover().move(2, 4, 1, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 0));
		panel.getMover().move(2, 6, 2, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(1, 1, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(2, 0, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(1, 2, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 0));
		panel.getMover().move(2, 1, 1, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 3));
		panel.getMover().move(0, 1, 1, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 0));
		panel.getMover().move(1, 0, 0, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(1, 3, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(0, 0, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 2));
		panel.getMover().move(2, 2, 3, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(0, 1, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(0, 4, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 2));
		panel.getMover().move(0, 2, 3, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 3));
		panel.getMover().move(1, 4, 0, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 1));
		panel.getMover().move(7, 5, 3, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(1, 5, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 6));
		panel.getMover().move(3, 2, 3, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(0, 3, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 3));
		panel.getMover().move(7, 3, 6, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(0, 2, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 2));
		panel.getMover().move(6, 3, 5, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 0));
		panel.getMover().move(0, 1, 0, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 2));
		panel.getMover().move(5, 2, 4, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(2, 6, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 3));
		panel.getMover().move(3, 1, 1, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 4));
		panel.getMover().move(0, 5, 1, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 1));
		panel.getMover().move(4, 2, 3, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 1));
		panel.getMover().move(1, 4, 4, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 1));
		panel.getMover().move(3, 1, 4, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(0, 6, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 0));
		panel.getMover().move(4, 1, 3, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(2, 5, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(3, 6, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(4, 4, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 0));
		panel.getMover().move(3, 0, 2, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 4));
		panel.getMover().move(2, 5, 4, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 5));
		panel.getMover().move(7, 2, 4, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(0, 7, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(1, 3, 2, 2, frame);


		assertTrue(c.isCheckMate(scacchiera, true));
	}
	
	@Test
	public void mattoReeRegina(){
		
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
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 7));
		panel.getMover().move(7, 3, 3, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(1, 6, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(3, 7, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(1, 7, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 7));
		panel.getMover().move(2, 6, 2, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 5));
		panel.getMover().move(1, 5, 2, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 7));
		panel.getMover().move(2, 7, 0, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 5));
		panel.getMover().move(2, 5, 3, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(0, 7, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(1, 3, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 5));
		panel.getMover().move(0, 6, 0, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 3));
		panel.getMover().move(0, 4, 1, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 5));
		panel.getMover().move(0, 5, 3, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(1, 3, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 4));
		panel.getMover().move(3, 5, 2, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 4));
		panel.getMover().move(0, 3, 0, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 4));
		panel.getMover().move(2, 4, 0, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 1));
		panel.getMover().move(2, 2, 2, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 2));
		panel.getMover().move(0, 4, 0, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(1, 2, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 1));
		panel.getMover().move(0, 2, 0, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 0));
		panel.getMover().move(1, 0, 2, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 0));
		panel.getMover().move(0, 1, 0, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 2));
		panel.getMover().move(2, 1, 1, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 0));
		panel.getMover().move(0, 0, 2, 0, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 3));
		panel.getMover().move(1, 2, 0, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 0));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 1));
		panel.getMover().move(2, 0, 1, 1, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 4));
		panel.getMover().move(0, 3, 0, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 1));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 2));
		panel.getMover().move(1, 1, 2, 2, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 5));
		panel.getMover().move(0, 4, 0, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 2));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 3));
		panel.getMover().move(2, 2, 2, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(0, 5, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(7, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(6, 4));
		panel.getMover().move(7, 4, 6, 4, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 7));
		panel.getMover().move(0, 6, 0, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(6, 4));
		panel.getMover().setCasellaEnd(panel.getModel().at(5, 5));
		panel.getMover().move(6, 4, 5, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(0, 7, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(5, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(4, 5));
		panel.getMover().move(5, 5, 4, 5, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 7));
		panel.getMover().move(0, 6, 0, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(4, 5));
		panel.getMover().setCasellaEnd(panel.getModel().at(3, 6));
		panel.getMover().move(4, 5, 3, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(0, 7, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(2, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 3));
		panel.getMover().move(2, 3, 1, 3, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 7));
		panel.getMover().move(0, 6, 0, 7, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(3, 6));
		panel.getMover().setCasellaEnd(panel.getModel().at(2, 6));
		panel.getMover().move(3, 6, 2, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(0, 7));
		panel.getMover().setCasellaEnd(panel.getModel().at(0, 6));
		panel.getMover().move(0, 7, 0, 6, frame);

		panel.getMover().setCasellaStart(panel.getModel().at(1, 3));
		panel.getMover().setCasellaEnd(panel.getModel().at(1, 6));
		panel.getMover().move(1, 3, 1, 6, frame);


		assertTrue(c.isCheckMate(scacchiera, true));
	}
	
}