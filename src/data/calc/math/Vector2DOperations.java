package data.calc.math;

import data.doublePoint;

public class Vector2DOperations {
	public static Vector2D add(Vector2D v, Vector2D w)throws NullPointerException{
		if (v == null || w == null){
			throw new NullPointerException("Vector2D not given");
		}
		
		doublePoint delta = new doublePoint(v.getX()+w.getX(), v.getY()+w.getY());
		Vector2D answer = new Vector2D(delta);
		
		return answer;
	}
	
	public static Vector2D invertX(Vector2D v)throws NullPointerException{
		if (v == null){
			throw new NullPointerException("Vector2D not given");
		}
		return new Vector2D(new doublePoint(-v.getX(), v.getY()));
	}
	
	public static Vector2D invertY(Vector2D v)throws NullPointerException{
		if (v == null){
			throw new NullPointerException("Vector2D not given");
		}
		return new Vector2D(new doublePoint(v.getX(), -v.getY()));
	}
	
	public static Vector2D reverse(Vector2D v)throws NullPointerException{
		if (v == null){
			throw new NullPointerException("Vector2D not given");
		}
		return new Vector2D(new doublePoint(-v.getX(), -v.getY()));
	}
}
