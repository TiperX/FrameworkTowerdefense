package data.calc;


import objects.entities.Entity;
import data.Tile;
import data.doublePoint;
import data.calc.pathfinding.NodeData;

public class Collision {
	private static int tileCollisionData;
	private static doublePoint v;
	
	public static doublePoint checkOnTile(Entity e, Tile t){
		doublePoint answer = new doublePoint(0, 0);
		tileCollisionData = t.collisionData;
		v = e.getVelocity().getDelta();
		
		if (checkSquare(v.x, true)){
			answer.x = 0-v.x;
		}
		
		if (checkSquare(v.y, false)){
			answer.y = 0-v.y;
		}
		
		return answer;
	}
	
	public static doublePoint checkOnSquareEntity(Entity e, Entity e2){
		doublePoint answer = new doublePoint(0, 0);
		tileCollisionData = e2.getHitbox().collisionData;
		v = e.getVelocity().getDelta();
		
		if (checkSquare(v.x, true)){
			answer.x = 0-v.x;
		}
		
		if (checkSquare(v.y, false)){
			answer.y = 0-v.y;
		}
		
		return answer;
	}
	
	private static boolean checkSquare(double check, boolean x){
		int checking = -2;
		
		if (check > 0){
			checking = 0;
		}else if (check < 0){
			checking = 2;
		}
		
		if (x)
			checking++;
		
		return (checkSquareData(checking));
		
	}

	private static boolean checkSquareData(int checking){
		if (checking < 0){
			return false;
		}
		return NodeData.collisionData[tileCollisionData][checking];
	}
}
