package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ChessBoard;
import controller.ChessController;
import controller.Controller;

public class ChessFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	ChessBoard scacchiera = new ChessBoard();
	private Controller controller;
	private String theme;
	private ScreenLocation screenlocation;
	private View view;
	private ChessBoardFrame panel;
	private JPanel panelNorth;

	// NORTH
	private boolean audio;	//stato dell'audio
	private JButton audioButton;
	
	private String nameWhite;
	private JLabel nameWhiteLabel;

	private String nameBlack;
	private JLabel nameBlackLabel;

	private JLabel turnImg;

	private JLabel nameWhiteLabelImg;
	private JLabel nameBlackLabelImg;
	private JPanel panelWest;
	private JPanel panelSouth;
	
	// calcoliamo l'altezza dello schermo e lo si divide per 10
	// la variabile casellaDim quindi conterra un parametro di grandezza che verra usato anche con altri oggetti del frame.
	// non calcoliamo il parametro usando la larghezza dello schermo perchè quest'ultima non sarà mai più piccola della larghezza del frame
	private int casellaDim = Toolkit.getDefaultToolkit().getScreenSize().height / 10;

	public ChessFrame(String theme, String nameWhite, String nameBlack) {
		this.theme = theme;
		this.nameWhite = nameWhite;
		this.nameBlack = nameBlack;

		setTitle("SCACCHI");

		setGamersState(); // BARRA DI STATO UTENTI + VOLUME

		setNumbersColumn(); // COLONNA CON I NUMERI

		view = addChessBoardFrame(); // SCACCHIERA

		setLettersRow(); // RIGA CON LE LETTERE

		controller = new ChessController(view);
		controller.newGame();

		setIconImage(new ImageIcon("src/img/iconStart.png").getImage());
		setResizable(false);
		pack();

		// POSITION OF FRAME ON SCREEN
		screenlocation = new ScreenLocation();
		setLocation(screenlocation.getPoint(getWidth(),Toolkit.getDefaultToolkit().getScreenSize().height));
	}

	private void setNumbersColumn() {
		panelWest = new JPanel(new GridBagLayout());
		panelWest.setPreferredSize(new Dimension(casellaDim/2, casellaDim*8));	
		panelWest.add(new JLabel(new ImageIcon((new ImageIcon("src/img/numbersborder.png")).getImage().getScaledInstance(casellaDim/2, casellaDim*8, Image.SCALE_SMOOTH))));

		add(panelWest, BorderLayout.WEST);
	}

	private void setLettersRow() {
		panelSouth = new JPanel(new GridBagLayout());
		panelSouth.setPreferredSize(new Dimension(casellaDim*17/2, casellaDim/2));
		panelSouth.add(new JLabel(new ImageIcon((new ImageIcon("src/img/lettersborder.png")).getImage().getScaledInstance(casellaDim*17/2, casellaDim/2, Image.SCALE_SMOOTH))));

		add(panelSouth, BorderLayout.SOUTH);
	}

	public void setGamersState() {
		panelNorth = new JPanel(new GridBagLayout());
		panelNorth.setPreferredSize(new Dimension(casellaDim*8, casellaDim/2));
		
		//	button per attivazione e spegnimento dell'audio
		audioButton = new JButton(new ImageIcon((new ImageIcon("src/img/audiooff.png")).getImage().getScaledInstance(casellaDim/2, casellaDim/2, Image.SCALE_SMOOTH)));
		
		audioButton.setPreferredSize(new Dimension(casellaDim/2, casellaDim/2));
		audioButton.addActionListener(event->{
			if(audio){
				audio=false;
				audioButton.setIcon(new ImageIcon((new ImageIcon("src/img/audiooff.png")).getImage().getScaledInstance(casellaDim/2, casellaDim/2, Image.SCALE_SMOOTH)));
			}
			
			else{
				audio=true;
				audioButton.setIcon(new ImageIcon((new ImageIcon("src/img/audioon.png")).getImage().getScaledInstance(casellaDim/2, casellaDim/2, Image.SCALE_SMOOTH)));

			}
		});
		
		nameWhiteLabelImg = new JLabel(new ImageIcon((new ImageIcon("src/img/turn/" + theme + "/bianco.png")).getImage().getScaledInstance(casellaDim/2, casellaDim/2, Image.SCALE_SMOOTH)));
		nameWhiteLabelImg.setPreferredSize(new Dimension(casellaDim, casellaDim/2));
		nameWhiteLabelImg.setBackground(Color.WHITE);
		nameWhiteLabelImg.setOpaque(true);
		

		nameWhiteLabel = new JLabel();
		nameWhiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameWhiteLabel.setBackground(Color.WHITE);
		nameWhiteLabel.setOpaque(true);
		nameWhiteLabel.setText(nameWhite);
		nameWhiteLabel.setFont(new Font("Serif", Font.ITALIC, 20));
		nameWhiteLabel.setPreferredSize(new Dimension(casellaDim*5/2, casellaDim/2));

		nameBlackLabelImg = new JLabel(new ImageIcon((new ImageIcon("src/img/turn/" + theme + "/nero.png")).getImage().getScaledInstance(casellaDim/2, casellaDim/2, Image.SCALE_SMOOTH)));
		nameBlackLabelImg.setPreferredSize(new Dimension(casellaDim, casellaDim/2));
		nameBlackLabelImg.setBackground(Color.BLACK);
		nameBlackLabelImg.setOpaque(true);
		
		nameBlackLabel = new JLabel();
		nameBlackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameBlackLabel.setBackground(Color.BLACK);
		nameBlackLabel.setOpaque(true);
		nameBlackLabel.setText(nameBlack);
		nameBlackLabel.setFont(new Font("Serif", Font.ITALIC, 20));
		nameBlackLabel.setForeground(Color.WHITE);
		nameBlackLabel.setPreferredSize(new Dimension(casellaDim*5/2, casellaDim/2));

		//	stampa l'immagine del turno iniziale (bianchi)
		turnImg = new JLabel(new ImageIcon((new ImageIcon("src/img/turn/" + theme + "/bianco.png")).getImage().getScaledInstance(casellaDim/2, casellaDim/2, Image.SCALE_SMOOTH)));
		turnImg.setPreferredSize(new Dimension(casellaDim, casellaDim/2));
		turnImg.setBackground(Color.WHITE);
		turnImg.setOpaque(true);

		panelNorth.add(audioButton);
		panelNorth.add(nameWhiteLabelImg);
		panelNorth.add(nameWhiteLabel);
		panelNorth.add(turnImg);
		panelNorth.add(nameBlackLabel);
		panelNorth.add(nameBlackLabelImg);

		add(panelNorth, BorderLayout.NORTH);

	}

	public View addChessBoardFrame() {
		panel = new ChessBoardFrame(scacchiera, this, theme, casellaDim);
		add(panel, BorderLayout.CENTER);

		return panel;
	}

	// setta l'immagine del turno
	public void setTurnImg(boolean turn) {
		turnImg.setIcon(new ImageIcon( (new ImageIcon("src/img/turn/" + theme + "/" + (turn ? "bianco" : "nero")  + ".png")).getImage().getScaledInstance(casellaDim/2, casellaDim/2, Image.SCALE_SMOOTH)));
		turnImg.setBackground((turn ? Color.WHITE : Color.BLACK));
	}
	
	// restituisce lo stato dell'audio (on/off)
	public boolean getAudio(){
		return audio;
	}
}
