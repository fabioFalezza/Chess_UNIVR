package view;

import java.awt.Point;
import java.awt.Toolkit;

public class ScreenLocation {

	public Point getPoint(double widthFrame, double heightFrame) {

		// assegno alle variabili le dimensioni dello schermo
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;	// larghezza
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;	// altezza

		Point p = new Point((int) (x - widthFrame) / 2, (int) (y - heightFrame) / 2);

		return p;

	}

}
