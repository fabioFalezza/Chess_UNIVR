package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Casella;
import model.ChessBoard;
import model.Model;
import mover.Mover;
import mover.Rules;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import controller.ChessController;
import controller.Controller;

public class ChessBoardFrame extends JPanel implements View {

	private static final long serialVersionUID = 1L;
	private ChessFrame frame;
	private ChessBoard model;
	private String theme;
	private Rules rules; 
	private Controller controller;
	private JButton[][] caselle = new JButton[8][8];
	private Mover mover; 
	private int casellaDim;
	private int pieceDim;
	private ImageIcon casellaWhite;
	private ImageIcon casellaBlack;
	
	
	// costruttore per il tema delle pedine e le dimensioni delle caselle
	public ChessBoardFrame(ChessBoard model, ChessFrame frame, String theme, int casellaDim) {
		this.frame = frame;
		this.model = model;
		this.theme = theme; 
		this.casellaDim = casellaDim;
		casellaWhite = new ImageIcon((new ImageIcon("src/img/scacchiera/classico/casella_bianca.png")).getImage().getScaledInstance(casellaDim, casellaDim, Image.SCALE_FAST));
		casellaBlack = new ImageIcon((new ImageIcon("src/img/scacchiera/classico/casella_nera.png")).getImage().getScaledInstance(casellaDim, casellaDim, Image.SCALE_FAST));
		this.pieceDim = 98*casellaDim/110;	// contiene la dimensione dei pezzi adattati alla risoluzione schermo
		
		this.rules = new Rules(model);
		createScacchiera();
		mover = new Mover(model);

	}

	// inizializza la scacchiera graficamente
	private void createScacchiera() {

		// creazione layout 8x8
		setLayout(new GridLayout(8, 8));

		// aggiungiamo ad ogni casella un bottone con la funzione mkButton
		for (int j = 0; j < 8; j++)
			for (int i = 0; i < 8; i++) {
				caselle[j][i] = mkButton(model.at(j, i));
				add(caselle[j][i]);
			}
		}

	private JButton mkButton(Casella at) {
		JButton button = new JButton(casellaColor(at.getColore()));
		button.setBorder(null);
		button.add(new JLabel(chooseImage(at)));
		((JLabel) button.getComponent(0)).setAlignmentX(CENTER_ALIGNMENT);
		((JLabel) button.getComponent(0)).setAlignmentY(CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(casellaDim, casellaDim));
		button.addActionListener(event -> {
			
			//	controllo che il giocatore non voglia cambiare la pedina da muovere			
			if( !at.isEmpty() && (at.getPedina().getColore() == model.getTurn()) ){
				mover.setClick(true);			
				setNormalCaselle();
			}

			// se è il primo click e la casella non è vuota
			if (mover.getClick()) {
				if (!at.isEmpty()) {
					if (model.getTurn() == at.getPedina().getColore()) {
						mover.setCasellaStart(at);	// setta il campo casella start del mover

						// Ci permette una volta cliccato una pedina di evidenziare tutte le possibili caselle in cui può muoversi
						for (int j = 0; j < 8; j++)
							for (int i = 0; i < 8; i++) {
								if(rules.isValidMove(at,model.at(j,i),at.getPedina())) // se la mossa in una determinata casella è valida...
									setLigthCasella(model.at(j,i));
							}
						mover.setClick(false);
					}
				}
			} 	
			
			else 
			{
				controller = new ChessController(this, model);
				mover.setCasellaEnd(at);				
				setNormalCaselle();									
				controller.onClick(mover.getCasellaStart().getY(), mover.getCasellaStart().getX(), mover.getCasellaEnd().getY(), mover.getCasellaEnd().getX(), frame);					
				mover.setClick(true);
				frame.setTurnImg(model.getTurn()); // modifica il label dove viene mostrato il turno con quello attuale		

			}
		});
		return button;
		
	}

	// riporta le immagini evidenziate alla normalità
	private void setNormalCaselle(){
		for (int j = 0; j < 8; j++)
			for (int i = 0; i < 8; i++)
				if(!caselle[j][i].getIcon().toString().equals("src/img/scacchiera/classico/casella_"+ (model.at(j,i).getColore() ? "bianca" : "nera") + "/.png"))
					caselle[j][i].setIcon(casellaColor(model.at(j,i).getColore()));
	}
	
	private void setLigthCasella(Casella at){
		caselle[at.getY()][at.getX()].setIcon(new ImageIcon((new ImageIcon("src/img/scacchiera/classico/casella_" + (at.getColore() ? "bianca" : "nera") 
				+ (at.isEmpty() ? "Blu" : "Rosso") + ".png")).getImage().getScaledInstance(casellaDim, casellaDim, Image.SCALE_FAST)));
	}
	
	// assegna al button l'immagine riguardante il colore della casella come sfondo
	private ImageIcon casellaColor(boolean color) {
		return color ? casellaWhite : casellaBlack;
	}

	// assegna al label sul button l'immagine della pedina
	private ImageIcon chooseImage(Casella at) {
		if (!at.isEmpty())
			return new ImageIcon((new ImageIcon("src/img/pezzi/" + theme + "/" + (at.getPedina().getColore() ? "bianchi" : "neri") + "/" 
					+ at.getPedina().getName() + ".png")).getImage().getScaledInstance(pieceDim, pieceDim, Image.SCALE_FAST));
		return null;
	}

	@Override
	public Model getModel() {
		return model;
	}

	@Override
	public void setController(ChessController controller) {
		this.controller = controller;
	}

	// modifica l'immagine pedina della casella start(from) e end(to) adattandola alla nuova scacchiera aggiornata dopo la mossa
	public void onConfigurationChange(int fromY, int fromX, int toY, int toX) {
		if (!(fromY == toY && fromX == toX)) {

			((JLabel) caselle[toY][toX].getComponent(0)).setIcon( ( (JLabel) caselle[fromY][fromX].getComponent(0)).getIcon());
			caselle[fromY][fromX].removeAll();
			caselle[fromY][fromX].add(new JLabel());
	
			revalidate();
			frame.repaint();
		}		
	}

	// modifica il pedone che viene promosso
	public void onConfigurationChange(int fromY, int fromX) {
		caselle[fromY][fromX].removeAll();
		caselle[fromY][fromX].add(new JLabel(new ImageIcon("src/img/cloud.gif")));	// immagine effetto fumo
		caselle[fromY][fromX].add(new JLabel(chooseImage(model.at(fromY,fromX))));
		((JLabel) caselle[fromY][fromX].getComponent(0)).setAlignmentX(CENTER_ALIGNMENT);
		((JLabel) caselle[fromY][fromX].getComponent(0)).setAlignmentY(CENTER_ALIGNMENT);
		((JLabel) caselle[fromY][fromX].getComponent(1)).setAlignmentX(CENTER_ALIGNMENT);
		((JLabel) caselle[fromY][fromX].getComponent(1)).setAlignmentY(CENTER_ALIGNMENT);
		
		revalidate();
		frame.repaint();
		
		if(frame.getAudio()){
			try 
				{audio("promozione");} 	
			catch (Exception e) 
				{e.printStackTrace();}
		}	
		
		// timer che permette all'immagine effetto di rimanere per 0.9 secondi
		Timer t = new Timer(900, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// tutto ciò che è qua dentro il timer è la parte di codice originale, sopra c'è la parte di codice del puf
				caselle[fromY][fromX].removeAll();
				caselle[fromY][fromX].add(new JLabel(chooseImage(model.at(fromY,fromX))));
				((JLabel) caselle[fromY][fromX].getComponent(0)).setAlignmentX(CENTER_ALIGNMENT);
				((JLabel) caselle[fromY][fromX].getComponent(0)).setAlignmentY(CENTER_ALIGNMENT);
				revalidate();
				frame.repaint();
			}
		});
		
		t.setRepeats(false); // il timer parte una volta
		t.start();	// fa partire il timer
		
	}

	private void audio(String strAudio) throws Exception {
		InputStream in = new FileInputStream("src/wav/" + strAudio + ".wav");
		AudioStream audio = new AudioStream(in);
		AudioPlayer.player.start(audio);
	}
	
	public ChessFrame getFrame() {
		return frame;
	}

	public String getTheme() {
		return theme;
	}

	public Rules getRules() {
		return rules;
	}

	public Mover getMover() {
		return mover;
	}

}