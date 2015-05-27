package chess;

import java.awt.EventQueue;

import javax.swing.JFrame;

//import view.TilesPanel;
import view.ChooseTheme;

public class Main {
	public static void main(String [] args){
		EventQueue.invokeLater(new Runnable(){		
			public void run(){
				JFrame frame = new ChooseTheme();				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);	
			}
		});
	}
}