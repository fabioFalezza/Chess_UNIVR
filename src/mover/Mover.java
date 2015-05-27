package mover;

import java.io.FileInputStream;
import java.io.InputStream;

import model.Casella;
import model.ChessBoard;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import view.ChessFrame;
import controller.Controller;

public class Mover {
	private ChessBoard model;
	private Controller controller;
	private Casella start , end;
	private boolean firstClick = true;
	private boolean isMoved;
	
	
	public Mover(ChessBoard model){
		this.model = model;
	}

	public void setModel(ChessBoard model){
		this.model = model;
	}
	
	public Casella getCasellaStart(){
		return start;
	}
	
	public Casella getCasellaEnd(){
		return end;
	}
	
	public void setCasellaStart(Casella casella){
		this.start = casella;
	}
	
	public void setCasellaEnd(Casella casella){
		this.end = casella;
	}
	
	public boolean getClick(){
		return firstClick;
	}
	
	public void setClick(boolean click){
		firstClick = click;
	}
	
	public void newGame(){
		model = controller.newGame();
	}
	
	// muove il pezzo dopo aver controllato se è possibile farlo tramite le rules
	public void move(int fromY, int fromX, int atY, int atX, ChessFrame frame) {
		Rules rules = new Rules(model);
		
		if(rules.isValidMove(start, end, start.getPedina())){

			// prova a riprodurre il suono della mossa
			if(frame.getAudio()){
				try 
					{audio("move");} 	
				catch (Exception e) 
					{e.printStackTrace();}
			}	
			
			model.at(atY,atX).setPedina(start.getPedina());
			model.at(fromY,fromX).setPedina(null);
			model.setTurn(!model.getTurn());
			isMoved = true;
			
			/*
			//***	 PER CREAZIONE JTESTUNIT
			System.out.println("panel.getMover().setCasellaStart(panel.getModel().at(" + fromY + ", " +  fromX + "));");
			System.out.println("panel.getMover().setCasellaEnd(panel.getModel().at(" + atY + ", " +  atX + "));");
			System.out.println("panel.getMover().move(" + fromY + ", " + fromX + ", " + atY + ", " + atX + ", frame);\n");
			//***
			//*/
		}
	}
	
	public ChessBoard getChessBoard(){
		return model;
	}
	
	private void audio(String strAudio) throws Exception {
		InputStream in = new FileInputStream("src/wav/" + strAudio + ".wav");
		AudioStream audio = new AudioStream(in);
		AudioPlayer.player.start(audio);
	}
	
	// modifica la configurazione grafica solo dopo aver modificato il modello
	public boolean getIsMoved(){
		return isMoved;
	}
}
