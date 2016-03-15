package labsrefactoring.World;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import labsrefactoring.mapElement.GroundElement;
import labsrefactoring.mapElement.MapElement;
import labsrefactoring.tools.Constants;

public class TestMap {

	private ArrayList<MapElement> mapElements;
	private ArrayList<Rectangle> ground;
	
	public TestMap() {

		mapElements = new ArrayList<MapElement>();
		ground = new ArrayList<Rectangle>();
	}
	
	public void loadMap(){
		
		// ��� ��������� ������� ����� � �������� � ���
		mapElements.add(new MapElement(32, 0, Constants.testSprite, 8, 1));
		ground.add(new Rectangle(32, 0, 256, 32));
	}
	
	
	public ArrayList<Rectangle> getGround() {
		return ground;
	}
	
	public void drawMap(SpriteBatch batch) {
		
		for (MapElement mapElement : mapElements) {
			mapElement.draw(batch);
		}
	}
}
