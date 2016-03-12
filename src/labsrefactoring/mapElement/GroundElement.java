package labsrefactoring.mapElement;

import com.badlogic.gdx.math.Rectangle;

public class GroundElement {

	private Rectangle ground;
	
	public GroundElement(float x, float y, float width, float height) {

		ground = new Rectangle(x, y, width, height);
	}
	
	public Rectangle getGround() {
		
		return ground; 
	}
}
