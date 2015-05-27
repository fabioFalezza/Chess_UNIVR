package model;

//	PEDINA
public abstract class Piece{
	private boolean colore;

	public Piece(boolean colore){
		this.colore = colore;
	}
	
	public boolean getColore(){
		return colore;
	}
	
	//controlla se la mossa è valida da start a end senza considerare
	//eventuali pezzi in mezzo e nella cassella finale
	public abstract boolean validMove(Casella start, Casella end);//controlla per ogni pedina se è valida la mossa

	public abstract String getName();
}
