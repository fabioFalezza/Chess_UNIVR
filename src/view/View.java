package view;

import model.Model;
import controller.ChessController;

public interface View {
	Model getModel();

	void setController(ChessController controller);

	// modifica l'immagine pedina della casella start(from) e end(to) adattandola alla nuova scacchiera aggiornata dopo la mossa
	void onConfigurationChange(int fromY, int fromX, int toY, int toX);

	// modifica il pedone che viene promosso
	void onConfigurationChange(int fromY, int fromX);

	ChessFrame getFrame();
	
	//restituisce il tema delle pedine
	String getTheme();
	
}
