package data;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import states.StateManager;

import data.exceptions.tilesetOutOfBoundsException;

public class Tile {
	public Settings.tilesetFormat tileID;
	public int tilesetID;
	public int collisionData;
	
	public Tile(Settings.tilesetFormat tileID, int tilesetID){
		this.tileID = tileID;
		this.tilesetID = tilesetID;
	}

	public void draw(Graphics g, Point location) {
		try {
			Image img = Constants.tilesets.get(tilesetID).getTile(tileID.value);
			g.drawImage(img, location.x, location.y, null);
		} catch (tilesetOutOfBoundsException | NullPointerException e) {
			StateManager.exception(e);
		}
	}
}
