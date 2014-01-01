package data;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import data.exceptions.tilesetOutOfBoundsException;

public class Tileset {
	private Image image;
	private Dimension tilesetSize;
	
	public Tileset(Image img, Dimension tilesetSize){
		image = img;
		this.tilesetSize = tilesetSize;
	}
	
	
	public Image getTile(Point tileLocation) throws tilesetOutOfBoundsException{
		Image img = Constants.window.createImage(Settings.tileDimensions.width, Settings.tileDimensions.height);
		Graphics g = img.getGraphics();
		if(tileLocation.x < 0 || tileLocation.x >= tilesetSize.width
		|| tileLocation.y < 0 || tileLocation.y >= tilesetSize.height){
			throw new tilesetOutOfBoundsException();
		}
		else
		{
			g.drawImage(image, 0, 0, Settings.tileDimensions.width, Settings.tileDimensions.height, Settings.tileDimensions.width*tileLocation.x, Settings.tileDimensions.height*tileLocation.y, Settings.tileDimensions.width*(tileLocation.x+1), Settings.tileDimensions.height*(tileLocation.y+1), null);
			return img;
		}
	}
}