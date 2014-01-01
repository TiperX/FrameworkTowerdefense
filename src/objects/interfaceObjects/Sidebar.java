package objects.interfaceObjects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

public interface Sidebar {
	public ArrayList<Button> buttons = new ArrayList<Button>();
	public Point location = new Point(0,0);
	public Dimension dimensions = new Dimension(0,0);
	
	public void draw(Graphics g);
	public void update(long dt);
}
