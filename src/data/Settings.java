package data;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.EnumMap;

import states.*;

public class Settings {
	public static boolean undecorated = false;
	public static int width = 640;
	public static int height = 640;
	public static float scaling = 1;
	
	public static boolean useMouse = true;
	public static boolean useKeyboard = false;
	
	public static Dimension tileDimensions = new Dimension(16,16);
	
	public static Font[] fonts = new Font[]{new Font("DIALOG", Font.BOLD, 72)};
	
	public static enum STATES{
		menu, game, preloader;
	}
	
	@SuppressWarnings("rawtypes")
	public static EnumMap<STATES, Class> states = new EnumMap<STATES, Class>(STATES.class);

	public static void setStateMap(){
		states.put(STATES.preloader, Preloader.class);
		states.put(STATES.menu, Menu.class);
		states.put(STATES.game, Game.class);
	}
	
	public static enum tilesetFormat{
		grass(0,0), dirt(1,0), mud(2,0), foundation(0,1), water(1,1), lava(2,1);
		public final Point value;
		
		tilesetFormat(int x, int y){
			this.value = new Point(x, y);
		}
	}
	
	public static String[] toBeLoadedTilesets = new String[]{
		"https://dl.dropboxusercontent.com/u/4664803/FullminTilesets/simpleTileset.png"
	};
	
	public static String[] toBeLoadedSpritesheets = new String[]{
		"https://dl.dropboxusercontent.com/u/4664803/FullminTilesets/simpleTileset.png"
	};
	
	public static String[] toBeLoadedBackGrounds = new String[]{
		"https://dl.dropboxusercontent.com/u/4664803/FullminTilesets/simpleTileset.png"
	};
	
}
