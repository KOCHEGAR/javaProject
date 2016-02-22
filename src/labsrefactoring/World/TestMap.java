package labsrefactoring.World;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import labsrefactoring.mapElement.MapElement;
import labsrefactoring.tools.Constants;

public class TestMap {

	private ArrayList<MapElement> mapElements;
	
	public TestMap() {

		mapElements = new ArrayList<MapElement>();
	}
	
	public void loadMap(){
		
		// ��� ��������� ������� ����� � �������� � ���
		mapElements.add(new MapElement(32, 0, Constants.testSprite, 8, 1));
//		mapElements.add(new MapElement(-190, 0, Constants.testSprite, 2, 2));
	}
	
	public void drawMap(SpriteBatch batch) {
		
		for (MapElement mapElement : mapElements) {
			mapElement.draw(batch);
		}
	}
}
