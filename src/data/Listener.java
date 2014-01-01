package data;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import states.StateManager;

public class Listener implements MouseListener, MouseMotionListener, KeyListener{

	@Override
	public void keyPressed(KeyEvent ke) {
		StateManager.getState().keyPressed(ke);
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		StateManager.getState().keyReleased(ke);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		StateManager.getState().keyTyped(ke);
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		StateManager.getState().mouseDragged(me);
		setMouseLocation(me);
		buttonMouseOverCheck();
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		StateManager.getState().mouseMoved(me);
		setMouseLocation(me);
		buttonMouseOverCheck();
	}
	
	public void setMouseLocation(MouseEvent me){
		Constants.mouseLocation = new Point(me.getX() - (Settings.undecorated ? 0 : 8), me.getY() - (Settings.undecorated ? 0 : 30));
	}
	
	@SuppressWarnings("static-access")
	public void buttonMouseOverCheck(){
		for (int i = 0; i < StateManager.getState().buttons.size(); i++){
			StateManager.getState().buttons.get(i).checkMouseOver(Constants.mouseLocation);
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		StateManager.getState().mouseClicked(me);
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		StateManager.getState().mouseEntered(me);
	}

	@Override
	public void mouseExited(MouseEvent me) {
		StateManager.getState().mouseExited(me);
	}

	@Override
	public void mousePressed(MouseEvent me) {
		StateManager.getState().mousePressed(me);
		checkForButtonDown();
	}
	
	@SuppressWarnings("static-access")
	public void checkForButtonDown(){
		for (int i = 0; i < StateManager.getState().buttons.size(); i++){
			StateManager.getState().buttons.get(i).mouseDown();
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		StateManager.getState().mouseReleased(me);
		buttonRelease();
	}
	
	@SuppressWarnings("static-access")
	public void buttonRelease(){
		for (int i = 0; i < StateManager.getState().buttons.size(); i++){
			StateManager.getState().buttons.get(i).release();
		}
	}
}
