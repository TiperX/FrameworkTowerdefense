package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import objects.interfaceObjects.Button;

public interface State {
	
	public ArrayList<Button> buttons = new ArrayList<Button>();
	
	public void update(long dt);
	
	public void draw(Graphics g);
	
	
	public void keyPressed(KeyEvent ke);

	public void keyReleased(KeyEvent ke);

	public void keyTyped(KeyEvent ke);

	public void mouseDragged(MouseEvent me);

	public void mouseMoved(MouseEvent me);

	public void mouseClicked(MouseEvent me);

	public void mouseEntered(MouseEvent me);

	public void mouseExited(MouseEvent me);

	public void mousePressed(MouseEvent me);

	public void mouseReleased(MouseEvent me);
}
