package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Bishop;
import model.Casella;
import model.Knight;
import model.Queen;
import model.Rook;

public class Promotion {

	// joptionpane con buttons che modificano il pedone promosso con la pedina scelta
	public static Casella scegliPezzo(Casella at, boolean color, String theme) {

		JButton regina = new JButton(new ImageIcon(chooseIcon(at.getPedina().getColore(), theme) + "regina.png"));
		regina.addActionListener(event -> {
			at.setPedina(new Queen(color));
			JOptionPane.getRootFrame().dispose();
		});

		JButton alfiere = new JButton(new ImageIcon(chooseIcon(at.getPedina().getColore(), theme) + "alfiere.png"));
		alfiere.addActionListener(event -> {
			at.setPedina(new Bishop(color));
			JOptionPane.getRootFrame().dispose();
		});

		JButton cavallo = new JButton(new ImageIcon(chooseIcon(at.getPedina().getColore(), theme) + "cavallo.png"));
		cavallo.addActionListener(event -> {
			at.setPedina(new Knight(color));
			JOptionPane.getRootFrame().dispose();
		});

		JButton torre = new JButton(new ImageIcon(chooseIcon(at.getPedina().getColore(), theme) + "torre.png"));
		torre.addActionListener(event -> {
			at.setPedina(new Rook(color));
			JOptionPane.getRootFrame().dispose();
		});

		JLabel label = new JLabel("Con che pezzo vuoi sostituire il tuo pedone?", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.ITALIC, 15));

		JButton[] segli = { regina, alfiere, cavallo, torre };
		for (JButton button : segli) {
			button.setPreferredSize(new Dimension(110, 110));
			delteDefault(button);
		}

		JOptionPane.showOptionDialog(null, label, "PEZZO", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, segli, null);
		return at;
	}

	// sceglie il colore delle pedine che vengono mostrate nel joptionpane
	private static String chooseIcon(boolean colore, String theme) {
		return "src/img/pezzi/" + theme + (colore ? "/bianchi/" : "/neri/");
	}

	private static void delteDefault(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
}
