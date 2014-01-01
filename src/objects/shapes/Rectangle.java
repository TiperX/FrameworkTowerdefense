package objects.shapes;

import java.awt.Point;

public class Rectangle extends Shape {
	private Point topLeft;
	private double width;
	private double height;
	
	public void set(Point topLeft, double w, double h){
		this.topLeft = topLeft;
		width = w;
		height = h;
	}
	
	public Point getTopLeft(){
		return topLeft;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
}
