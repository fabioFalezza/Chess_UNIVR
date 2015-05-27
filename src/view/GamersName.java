package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GamersName extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelN;
	private JLabel domanda;
	private JPanel panelC;
	private JPanel panelS;
	private JButton button;
	private JTextField nameWhite;
	private JTextField nameBlack;
	private ScreenLocation screenlocation;
	private JPanel panelCW;
	private JPanel panelCE;
	private JLabel strBianco;
	private JLabel strNero;

	public GamersName(String theme) {

		setTitle("Scacchi - Giocatori");
		setIconImage(new ImageIcon("src/img/iconStart.png").getImage());
		setResizable(false);

		// NORTH
		panelN = new JPanel();
		domanda = new JLabel("Inserire i nomi dei giocatori.");
		domanda.setFont(new Font("Serif", Font.ITALIC, 18));
		panelN.add(domanda);

		add(panelN, BorderLayout.NORTH);
			
		// i seguenti componenti non vengono inseriti in un grilayout 2x3 perchè altrimenti le dimensioni di quest'ultime non si possono essere modificate
		//	CENTER
			//	WEST
		panelCW = new JPanel();
		
		// immagine corrispondente al colore delle pedine
		panelCW.add(new JLabel(new ImageIcon("src/img/turn/" + theme + "/bianco.png")));
		panelCW.add(new JLabel(new ImageIcon("src/img/turn/" + theme + "/nero.png")));
		
		panelCW.setPreferredSize(new Dimension(100,110));
		
		add(panelCW,BorderLayout.WEST);

			//	CENTER
		panelC = new JPanel();
		
		strBianco = new JLabel("Nome Giocatore Bianco: ");
		strBianco.setPreferredSize(new Dimension(200,50));
		panelC.add(strBianco, BorderLayout.CENTER);
		
		strNero = new JLabel("Nome Giocatore Nero: ");
		strNero.setPreferredSize(new Dimension(200,50));
		panelC.add(strNero, BorderLayout.CENTER);
		
		panelC.setPreferredSize(new Dimension(200,110));
		
		add(panelC,BorderLayout.CENTER);
		
			//	EAST
		panelCE = new JPanel(new GridLayout(2,1));
		panelCE.setPreferredSize(new Dimension(100,25));
		
		nameWhite = new JTextField();
		nameWhite.setPreferredSize(new Dimension(100,25));
		
		nameBlack = new JTextField();
		nameBlack.setPreferredSize(new Dimension(100,25));
		
		panelCE.add(nameWhite);
		panelCE.add(nameBlack);
		
		panelCE.setPreferredSize(new Dimension(200,110));
		
		add(panelCE,BorderLayout.EAST);

		
		// SOUTH ( contiene il bottone dello start)
		panelS = new JPanel(new GridBagLayout());
		button = new JButton(new ImageIcon("src/img/playnow.png"));
		delteDefault(button);
		button.addActionListener(event -> {
			if (nameWhite.getText().length() > 1 && nameWhite.getText().length() < 11 && nameBlack.getText().length() > 1 && nameBlack.getText().length() < 11) {
				dispose();

				// frame con immagine di presentazione di inizio partita
				Start a = new Start(theme);	
				
				// timer (durata 2 secondi) usato per chiudere l'immagine di presentazione e aprire il ChessFrame (frame di gioco)
				Timer t = new Timer(2000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						a.dispose();
						
						JFrame frame = new ChessFrame(theme, nameWhite.getText(), nameBlack.getText());
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				t.setRepeats(false);
				t.start();
			}
			
			else{
				if(nameWhite.getText().length() > 10 || nameBlack.getText().length() > 10)
					if(nameWhite.getText().length() > 10 && nameBlack.getText().length() > 10)
						JOptionPane.showMessageDialog(this, "Entrambi i nomi dei giocatori hanno superato 10 caratteri.");
					else
						JOptionPane.showMessageDialog(this, "Il nome del giocatore " + (nameWhite.getText().length() > 10 ? "bianco" : "nero") + " ha superato i 10 caratteri.");
				
				if(nameWhite.getText().length() < 2 || nameBlack.getText().length() < 2)
					if(nameWhite.getText().length() < 2 && nameBlack.getText().length() < 2)
						JOptionPane.showMessageDialog(this, "Entrambi i nomi dei giocatori sono formati da meno di 2 caratteri.");
					else
						JOptionPane.showMessageDialog(this, "Il nome del giocatore " + (nameWhite.getText().length() < 2 ? "bianco" : "nero") + "  ha meno di 2 caratteri.");
			}

		});
		
		panelS.add(button);

		add(panelS, BorderLayout.SOUTH);
		
		pack();

		// POSITION OF FRAME
		screenlocation = new ScreenLocation();
		setLocation(screenlocation.getPoint(getWidth(), getHeight()));


	}
	

	private static void delteDefault(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
}
