package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import data.Constants;


public class ErrorReport implements State{
	private Exception exception;
	private StackTraceElement[] stackTrace;
	
	public ErrorReport(Exception e) {
		exception = e;
		stackTrace = e.getStackTrace();
	}

	@Override
	public void update(long dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(50, 50, Constants.stageWidth-100, Constants.stageHeight-100);
		g.drawString(exception.getClass().getName(), 55, 65);
		if (exception.getMessage() != null)
			g.drawString(exception.getMessage(), 55, 80);
		
		for (int i = 0; i < stackTrace.length; i++){
			g.drawString(stackTrace[i].toString(), 55, 95 + 12*i);
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}


}
