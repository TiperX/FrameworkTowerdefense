package data;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Constants {
	public static int windowWidth = Settings.width + (Settings.undecorated ? 0 : 16);
	public static int windowHeight = Settings.height + (Settings.undecorated ? 0 : 38);

	public static int stageWidth = (int) (Settings.width * Settings.scaling);
	public static int stageHeight = (int) (Settings.height * Settings.scaling);
	
	public static Image image;
	public static Graphics graphics;
	
	public static boolean running = true;
	
	public static Point mouseLocation;
	public static Point gridBaseLocation = new Point(0,0);
	
	public static ArrayList<Tileset> tilesets;
	public static ArrayList<Image> spriteSheets;
	public static ArrayList<Image> backGrounds;
	
	public static JFrame window = new JFrame(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			g.drawImage(image, (Settings.undecorated ? 0 : 8), (Settings.undecorated ? 0 : 30), (int) (stageWidth/Settings.scaling), (int) (stageHeight/Settings.scaling), null);
		}
	};
}
