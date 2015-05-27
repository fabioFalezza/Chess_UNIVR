package model;

public class ChessBoard implements Model{
	private Casella[][] caselle;
	private boolean turn;
	
	// costruttore che crea una matrice composta da caselle che rappresenta la scacchiera
	public ChessBoard(){
		caselle = new Casella[8][8];
		createCaselle();
		turn = true;
	}
	
	public void createCaselle() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				// se y+x è pari la casella sarà bianca, altrimenti se è dispari sarà nera
				caselle[j][i] = new Casella(i,j,null, (j+i)%2 == 0 ? true : false); 
			}
		}
		this.newGame();
	}
	
	// setta le pedine di ogni casella in base alla configurazione iniziale della scacchiera
	public ChessBoard newGame() {
		
		//creo le pedine NERE
		at(0,0).setPedina(new Rook(false));
		at(0,1).setPedina(new Knight(false));
		at(0,2).setPedina(new Bishop(false));
		at(0,3).setPedina(new Queen(false));
		at(0,4).setPedina(new King(false));
		at(0,5).setPedina(new Bishop(false));
		at(0,6).setPedina(new Knight(false));
		at(0,7).setPedina(new Rook(false));
		
		for(int i = 0; i < 8; i++)
			at(1,i).setPedina(new Pawn(false));
		
		//creo le pedine BIANCHE
		at(7,0).setPedina(new Rook(true));
		at(7,1).setPedina(new Knight(true));
		at(7,2).setPedina(new Bishop(true));
		at(7,3).setPedina(new Queen(true));
		at(7,4).setPedina(new King(true));
		at(7,5).setPedina(new Bishop(true));
		at(7,6).setPedina(new Knight(true));
		at(7,7).setPedina(new Rook(true));
		
		
		for(int i = 0; i < 8; i++)
			at(6,i).setPedina(new Pawn(true));
	
		
		return this;
	
	}
	
	public Casella[][] getCaselle(){
		return caselle;
	}

	@Override
	public Casella at(int y, int x) {
		return caselle[y][x];
	}


	// restituisce il turno attuale
	public boolean getTurn() {
		return turn;
	}

	// setta il turno
	public void setTurn(boolean turn) {
		this.turn=turn;
	}

}
