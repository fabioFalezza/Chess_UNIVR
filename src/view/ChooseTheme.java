package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseTheme extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelN;

	private JLabel domanda;

	private JPanel panelC;

	private JButton classic;	//	1
	private JButton onePiece;	//	2
	private JButton naruto;		//	3
	private JButton dragonball;	//	4
	
	private JButton random;
	
	private Random randomTheme;
	private String[] strTheme = {"classico","onepiece","naruto","dragonball"};
	
	private ScreenLocation screenlocation;

	// costruttore del frame che premette di scegliere il tema delle pedine di gioco
	public ChooseTheme() {
		
		setTitle("Scacchi - Tema");
		setIconImage(new ImageIcon("src/img/iconStart.png").getImage());

		domanda = new JLabel("Che tema vuoi usare?");
		domanda.setFont(new Font("Serif", Font.ITALIC, 18));
		panelN = new JPanel();

		panelN.add(domanda);

		add(panelN, BorderLayout.NORTH);

		classic = new JButton(new ImageIcon(
				"src/img/theme/classico.png"));
		onePiece = new JButton(new ImageIcon(
				"src/img/theme/onepiece.png"));
		naruto = new JButton(new ImageIcon(
				"src/img/theme/naruto.png"));
		dragonball = new JButton(new ImageIcon(
				"src/img/theme/dragonball.png"));
		random = new JButton(new ImageIcon(
				"src/img/theme/random.png"));
		
		
		panelC = new JPanel(new GridLayout(5, 1));
		panelC.add(classic);
		panelC.add(onePiece);
		panelC.add(naruto);
		panelC.add(dragonball);
		panelC.add(random);
		panelC.setPreferredSize(new Dimension(300, 500));
		add(panelC, BorderLayout.CENTER);

		setResizable(false);

		pack();

		// POSITION OF FRAME -> da mettere dopo il pack();
		screenlocation = new ScreenLocation();
		setLocation(screenlocation.getPoint(getWidth(), getHeight()));
		//

		classic.addActionListener(event -> {
			JFrame frame = new GamersName("classico");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});

		onePiece.addActionListener(event -> {
			JFrame frame = new GamersName("onepiece");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});

		naruto.addActionListener(event -> {
			JFrame frame = new GamersName("naruto");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});
		
		dragonball.addActionListener(event -> {
			JFrame frame = new GamersName("dragonball");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});
		
		// scelta a random del tema
		randomTheme = new Random(); // NUMERI DA 0 A #temi
		random.addActionListener(event->{
			JFrame frame = new GamersName(strTheme[randomTheme.nextInt(4)]);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});
	}

}
