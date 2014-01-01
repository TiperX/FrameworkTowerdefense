package objects.entities;

import java.awt.Graphics;
import java.awt.Point;

import data.calc.math.Vector2D;
import objects.shapes.*;

public class Entity {
	protected Vector2D location;
	protected Shape hitbox;
	protected Vector2D velocity;
	
	public Entity(Point location, Shape hitbox){
		//this.location = location;
		this.hitbox = hitbox;
	}

	public void update(long dt){
	
	}

	public void draw(Graphics g){
		
	}
	
	public Point getLocation(){
		return new Point((int)location.getX(), (int)location.getY());
	}
	
	public Shape getHitbox(){
		return hitbox;
	}
	
	public Vector2D getVelocity(){
		return velocity;
	}
}