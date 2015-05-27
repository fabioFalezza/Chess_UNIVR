package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Start extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel panelimg;
	private ScreenLocation screenlocation;

	// costruttore del frame contenente l'immagine di presentazione di inizio partita
	public Start(String theme){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);	// toglie il bordo al frame
		setIconImage(new ImageIcon("src/img/iconStart.png").getImage());
		
		panelimg = new JPanel();
		panelimg.add(new JLabel(new ImageIcon("src/img/start/" + theme + ".gif")));
		add(panelimg,BorderLayout.CENTER);
		this.setVisible(true);
		pack();
		
		// POSITION OF FRAME
		screenlocation = new ScreenLocation();
		setLocation(screenlocation.getPoint(getWidth(), getHeight()));
	}
}

