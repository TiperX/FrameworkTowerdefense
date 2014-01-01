package objects.interfaceObjects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import states.StateManager;

public class ButtonSidebar implements Sidebar{
	private Image sidebarBackGround;
	
	@SuppressWarnings("static-access")
	public ButtonSidebar(Point location, Dimension dimensions, Button[] buttons, Image sidebarBackGround){
		this.location.x = location.x;
		this.location.y = location.y;
		this.dimensions.width = dimensions.width;
		this.dimensions.height = dimensions.height;
		this.sidebarBackGround = sidebarBackGround;
		
		for (int i = 0; i < buttons.length; i++){
			buttons[i].location.x += this.location.x;
			buttons[i].location.y += this.location.y;
			this.buttons.add(buttons[i]);
			StateManager.getState().buttons.add(this.buttons.get(i));
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(sidebarBackGround, location.x, location.y, dimensions.width, dimensions.height, null);
	}

	@Override
	public void update(long dt) {
		// TODO Auto-generated method stub
		
	}
}
