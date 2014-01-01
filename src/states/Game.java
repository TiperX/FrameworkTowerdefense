package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import data.Constants;
import data.Tile;
import data.Settings;
import data.calc.Grid;

public class Game implements State{
	
	int money;
	
	Point gridLocation;
	Tile[][] grid;
	Point mouseGridLocation;
	boolean drawMouseTile;
	
	Point selected;
	
	public Game(){
		selected = null;
		grid = new Tile[32][32];
		Constants.window.setBackground(Color.white);
		gridLocation = new Point(64, 64);
		drawMouseTile = false;
		mouseGridLocation = new Point(0,0);
		
		for (int i = 0; i < 32; i++)
		for (int j = 0; j < 32; j++){
			grid[i][j] = new Tile(Settings.tilesetFormat.grass, 0);
		}
		
		money = 300;
	}

	@Override
	public void update(long dt) {
		mouseGridLocation = Grid.toGridLocation(Constants.mouseLocation, gridLocation, Settings.tileDimensions);
		if(mouseGridLocation.x >= 0 && mouseGridLocation.y >= 0
		&& mouseGridLocation.x <= grid.length && mouseGridLocation.y <= grid[0].length){
			drawMouseTile = true;
		}else{
			drawMouseTile = false;
		}
		
		if (selected != null){
			
		}
	}

	@Override
	public void draw(Graphics g) {
		for (int i = 0; i < grid.length; i++)
		for (int j = 0; j < grid[i].length; j++){
			int x = gridLocation.x + i *Settings.tileDimensions.width;
			int y = gridLocation.y + j *Settings.tileDimensions.height;
			grid[i][j].draw(g, new Point(x, y));
		}
		
		if (drawMouseTile){
			Point coords = Grid.toPixelLocation(mouseGridLocation, gridLocation, Settings.tileDimensions);
			g.setColor(Color.white);
			g.drawRect(coords.x, coords.y, Settings.tileDimensions.width-1, Settings.tileDimensions.height-1);
		}
		
		if (selected != null){
			Point coords = Grid.toPixelLocation(selected, gridLocation, Settings.tileDimensions);
			g.setColor(Color.red);
			g.drawRect(coords.x, coords.y, Settings.tileDimensions.width-1, Settings.tileDimensions.height-1);
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
		selected = mouseGridLocation;
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}


}
