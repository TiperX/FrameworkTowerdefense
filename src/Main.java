import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

import states.StateManager;

import data.Constants;
import data.Settings;


public class Main {
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		setWindowSettings();
		
		Constants.mouseLocation = new Point(0,0);

		StateManager.launch(Settings.STATES.preloader);
	}
	
	private void setWindowSettings(){
		Constants.window.setUndecorated(Settings.undecorated);
		Constants.window.setBackground(Color.black);
		Constants.window.setSize(Constants.windowWidth, Constants.windowHeight);
		Constants.window.setVisible(true);
		Constants.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constants.window.setLocationRelativeTo(null);
	}
}