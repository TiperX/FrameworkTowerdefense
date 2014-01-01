package data.calc.math;

import data.doublePoint;


public class Vector2D {
	private double radius;
	private doublePoint delta;
	private double angle;
	
	public Vector2D(doublePoint delta){
		set(delta);
	}
	
	public Vector2D(double radius, double angle){
		set(radius, angle);
	}
	
	public void set(doublePoint delta){
		this.delta = delta;
		
		this.radius = Math.sqrt(delta.x*delta.x + delta.y*delta.y);
		this.angle = Math.tan(delta.y/delta.x);
	}
	
	public void set(double radius, double angle){
		this.radius = radius;
		this.angle = angle;
		
		this.delta.x = Math.cosh(angle)*radius;
		this.delta.y = Math.sinh(angle)*radius;
	}
	
	public double getX() {
		return delta.x;
	}
	
	public double getY() {
		return delta.y;
	}
	
	public doublePoint getDelta() {
		return delta;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public double getAngle(){
		return angle;
	}
}