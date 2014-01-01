package objects.shapes;

import java.awt.Point;

public class Square extends Shape{
	private Point topLeft;
	private double size;
	
	public void set(Point topLeft, double size){
		this.topLeft = topLeft;
		this.size = size;
	}
	
	public Point getTopLeft(){
		return topLeft;
	}
	
	public double getSize(){
		return size;
	}
}
