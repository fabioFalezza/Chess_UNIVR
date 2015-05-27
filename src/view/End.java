package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import model.ChessBoard;

public class End extends JFrame {

	private static final long serialVersionUID = 1L;
	public ChessBoard scacchiera;
	public ImageIcon img;
	public JLabel label;
	public JButton newGame;
	public JButton end;
	public JPanel pimg;
	public JPanel pbutton;

	public View view;
	private ScreenLocation screenlocation;

	// costruttore del frame di fine partita
	public End(View v, ChessBoard scacchiera, boolean win) {
		setResizable(false);
		setUndecorated(true);	// toglie il bordo al frame
		//colore=this.colore;
		this.view = v;
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		img = new ImageIcon("src/img/win/" + v.getTheme() + (win ? (scacchiera.getTurn() ? "/winBlack" : "/winWhite") + (v.getTheme().equals("classico") ? ".gif" : ".png") : "/stale.png"));

		//	SUONO VITTORIA
		if(view.getFrame().getAudio()){
			try 
				{audio("checkmate");} 	
			catch (Exception e) 
				{e.printStackTrace();}
		}
	
		// CONTENUTO DEL FRAME
		
		label = new JLabel(img);
		
		pimg = new JPanel(new GridBagLayout());
		pimg.add(label);

		add(pimg, BorderLayout.CENTER);

		newGame = new JButton("NEW GAME");
		newGame.setBackground(Color.decode("#FFFFDD"));
		newGame.setForeground(Color.BLACK);
		newGame.setFont(new Font("Serif", Font.BOLD, 25));
		newGame.addActionListener(event -> {
			this.dispose();

			// RICORDA DI USARE PARTE MAIN
			JFrame frame = new ChooseTheme();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			v.getFrame().dispose();
		});
		delteDefault(newGame);
		
		end = new JButton("END");
		end.setBackground(Color.decode("#AE5835"));
		end.setForeground(Color.WHITE);
		end.setFont(new Font("Serif", Font.BOLD, 25));
		end.addActionListener(event->{
			this.dispose();
			v.getFrame().dispose();
		});
		delteDefault(end);

		pbutton = new JPanel(new GridLayout(1,2));
		pbutton.add(newGame);
		pbutton.add(end);

		add(pbutton, BorderLayout.SOUTH);


		setResizable(false);
		pack();

		
		// POSITION OF FRAME
		screenlocation = new ScreenLocation();
		setLocation(screenlocation.getPoint(getWidth(), getHeight()));
	}
	
	private static void delteDefault(JButton button) {
		button.setFocusPainted(false);
	}
	
	private void audio(String strAudio) throws Exception {
		InputStream in = new FileInputStream("src/wav/" + strAudio + ".wav");
		AudioStream audio = new AudioStream(in);
		AudioPlayer.player.start(audio);
	}

}