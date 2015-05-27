package model;

public class Casella {
	private int x, y;
	private Piece pedina;
	boolean colore; // true = casella bianca, false = casella nera;
	
	
	public Casella(int x, int y, Piece pedina, boolean colore){
		this.colore = colore;
		this.pedina = pedina;
		this.setX(x);
		this.setY(y);
	}
	
	
	public Casella(Casella casella){
		this(casella.x, casella.y, casella.pedina, casella.colore);
	}
	
	public Piece getPedina(){
		return pedina;
	}

	// controllo se la casella non contiene nessuna pedina
	public boolean isEmpty() {
		return pedina == null;
	}

	// ritorna il colore della casella
	public boolean getColore(){
		return colore;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// modifica la pedina all'interno della casella
	public void setPedina(Piece pedina) {
		this.pedina = pedina;
	}


	public void setCasella(Casella s) {
		this.setPedina(s.getPedina());
		this.setY(s.y);
		this.setX(s.x);
		this.colore = s.colore;	
	}
	
}
