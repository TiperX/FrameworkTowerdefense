package objects.interfaceObjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import data.Settings;

public class Button {
	
	private Image img;
	public Point location;
	private Point dimensions;
	private boolean down;
	private boolean over;
	
	public Button(Image btnImg, Point location, Point dimensions){
		img = btnImg;
		this.location = location;
		this.dimensions = dimensions;
		down = false;
		over = false;
	}
	
	public void checkMouseOver(Point mouseLocation){
		if (mouseLocation.x*Settings.scaling > location.x && mouseLocation.x*Settings.scaling < location.x+dimensions.x
			&& mouseLocation.y*Settings.scaling > dimensions.y && mouseLocation.y*Settings.scaling < location.y+dimensions.y){
			over = true;
		}
	}
	
	public void draw(Graphics g){
		int i = 0;
		if (down){
			i = 2;
		}else if (over){
			i = 1;
		}
		g.drawImage(img, location.x, location.y, location.x + dimensions.x, location.y + dimensions.y, 0, dimensions.y*i, dimensions.x, dimensions.y*(i+1), null);
	}

	public void mouseDown(){
		if (over){
			down = true;
		}
	}

	public void release() {
		down = false;
	}
	
	public boolean isDown(){
		return down;
	}
	
}
