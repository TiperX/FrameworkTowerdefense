package states;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import data.Constants;
import data.Settings;
import data.Tileset;

public class Preloader implements State {
	int i;
	int total;
	
	public Preloader(){
		i = Settings.toBeLoadedTilesets.length + Settings.toBeLoadedSpritesheets.length + Settings.toBeLoadedBackGrounds.length;
		total = i;
		
		Constants.tilesets = new ArrayList<Tileset>();
		Constants.spriteSheets = new ArrayList<Image>();
		Constants.backGrounds = new ArrayList<Image>();
	}
	
	
	@Override
	public void update(long dt) {
		if (i < Settings.toBeLoadedTilesets.length){
			try {
				Image img = ImageIO.read(new URL(Settings.toBeLoadedTilesets[i]));
				Constants.tilesets.add(new Tileset(img, new Dimension(img.getWidth(null), img.getHeight(null))));
			} catch (IOException e) {
				StateManager.exception(e);
				i = -1;
			}
		}else if (i - Settings.toBeLoadedTilesets.length < Settings.toBeLoadedSpritesheets.length){
			int j = i - Settings.toBeLoadedTilesets.length;
			try {
				Image img = ImageIO.read(new URL(Settings.toBeLoadedSpritesheets[j]));
				Constants.spriteSheets.add(img);
			} catch (IOException e) {
				StateManager.exception(e);
				i = -1;
			}
		}else if (i - Settings.toBeLoadedTilesets.length - Settings.toBeLoadedSpritesheets.length < Settings.toBeLoadedBackGrounds.length){
			int j = i - Settings.toBeLoadedTilesets.length - Settings.toBeLoadedSpritesheets.length;
			try {
				Image img = ImageIO.read(new URL(Settings.toBeLoadedBackGrounds[j]));
				Constants.backGrounds.add(img);
			} catch (IOException e) {
				StateManager.exception(e);
				i = -1;
			}
		}
		if (i == 0){
			StateManager.changeState(Settings.STATES.menu);
		}else if (i < 0){
			StateManager.exception(new IOException("File not found."));
		}

		i--;
	}

	@Override
	public void draw(Graphics g) {
		double percentage = 1/total * (total-(i+1));
		if (i != -1){
			g.setColor(Color.white);
			g.drawRect(150, 310, Constants.stageWidth-300, 20);
			
			g.setColor(Color.blue);
			g.fillRect(151, 311, (int) ((Constants.stageWidth-301)*percentage), 19);
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
