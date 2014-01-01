package data;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import data.exceptions.tilesetOutOfBoundsException;

public class Spritesheet {
	private Image image;
	private Point imageSize;
	private int[] animationLengths;
	
	public Spritesheet(Image img, int[] animationLengths){
		image = img;
		this.imageSize = new Point(img.getWidth(null), img.getHeight(null));
		this.animationLengths = animationLengths;
	}
	
	public Image getTile(int animation, int frame) throws tilesetOutOfBoundsException{
		Image img = Constants.window.createImage(imageSize.x/animationLengths[animation], imageSize.y/animationLengths.length);
		Graphics g = img.getGraphics();
		
		if(frame < 0 || frame >= animationLengths[animation]
		|| animation < 0 || animation >= animationLengths.length){
			throw new tilesetOutOfBoundsException();
		}
		else
		{
			int w = img.getWidth(null);
			int h = img.getHeight(null);
			g.drawImage(image, 0, 0, w, h, w*frame, h*animation, w*(frame+1), h*(animation+1), null);
			return img;
		}
	}
}
