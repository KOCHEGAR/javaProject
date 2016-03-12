package labsrefactoring.mapElement;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MapElement  {

	private Vector2 position;
	private Sprite sprite;
	private int amountOfSpritesOnX, amountOfSpritesOnY;
	
	public MapElement(float x, float y, Sprite s, int amountOfSpritesOnX, int amountOfSpritesOnY) {  

		position = new Vector2(x, y);
		sprite = s;
		this.amountOfSpritesOnX = amountOfSpritesOnX;
		this.amountOfSpritesOnY = amountOfSpritesOnY;
	}
	
	public void draw(SpriteBatch batch) {
		
		int stepX = amountOfSpritesOnX;
		int stepY = amountOfSpritesOnY;
		float x = position.x;
		float y = position.y;
		float w = sprite.getWidth();
		float h = sprite.getHeight();
		
		for (int i = 0; i < stepY; i++) {
			for (int j = 0; j < stepX; j++) {
				
				sprite.setPosition(x+w*j, y-h*i); // тут "-" потому что в libgdx игрек направлена вверх
				sprite.draw(batch);
			}
		}
	}
}
