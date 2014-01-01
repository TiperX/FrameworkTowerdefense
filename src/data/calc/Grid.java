package data.calc;

import java.awt.Dimension;
import java.awt.Point;

public class Grid {
	public static Point toPixelLocation(Point location, Point baseLocation, Dimension tileDimensions){
		Point answer = new Point();
		
		answer.x = (int) Math.floor(baseLocation.x + location.x * tileDimensions.width);
		answer.y = (int) Math.floor(baseLocation.y + location.y * tileDimensions.height);
		
		return answer;
	}
	
	public static Point toGridLocation(Point location, Point baseLocation, Dimension tileDimensions){
		Point answer = new Point();

		answer.x = (int) Math.floor((location.x - baseLocation.x) / tileDimensions.width);
		answer.y = (int) Math.floor((location.y - baseLocation.y) / tileDimensions.height);
		
		return answer;
	}
	
	public static Point isoDiamondToPixelLocation(Point location, Point baseLocation, Dimension tileDimensions){
		Point answer = new Point();
		
		answer.x = baseLocation.x + location.x * (tileDimensions.width/2) - ((location.y+1) * tileDimensions.width/2);
		answer.y = baseLocation.y + location.x * (tileDimensions.height/2) + location.y * (tileDimensions.height/2);
		
		return answer;
	}
	
	public static Point isoDiamondToGridLocation(Point location, Point baseLocation, Dimension tileDimensions){
		Point answer = new Point();
		
		answer.x = (int)Math.round(-(baseLocation.x-location.x)/tileDimensions.width-(baseLocation.y-location.y)/tileDimensions.height);
		answer.y = (int)Math.round((location.y-baseLocation.y)/tileDimensions.height-(location.x-baseLocation.x)/tileDimensions.width);
		
		return answer;
	}
	
	public static Point isoStaggeredToPixelLocation(Point location, Point baseLocation, Dimension tileDimensions){
		Point answer = new Point();
		
		answer.x = baseLocation.x + location.x * tileDimensions.width / 2;
		answer.y = baseLocation.y + location.y * tileDimensions.height + (location.x%2)*tileDimensions.height/2;
		
		return answer;
	}
	
	public static Point isoStaggeredToGridLocation(Point location, Point baseLocation, Dimension tileDimensions){
		Point answer = new Point();
		
		answer.x = (2*(location.x-baseLocation.x))/tileDimensions.width;
		answer.y = (location.y - baseLocation.y - ((location.x%2) * (tileDimensions.height/2)))/tileDimensions.height;
		
		return answer;
	}
}
