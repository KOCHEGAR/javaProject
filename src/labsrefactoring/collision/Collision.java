package labsrefactoring.collision;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import labsrefactoring.World.TestMap;
import labsrefactoring.player.Entity;

public class Collision {

	public static void col(Entity entity, TestMap map) {
	
		
		
		for (Rectangle rectangle : map.getGround()) {
			
			if (entity.getRect().overlaps(rectangle)) {
			System.out.println("overlaps");
			float previousFrameY = entity.getPosition().y + entity.getVelocity().y * Gdx.graphics.getDeltaTime();
			float previousFrameBottom = previousFrameY - entity.getRect().height;
			float platformTop = rectangle.y;
			
			if (previousFrameBottom <= platformTop) {
				System.out.println("here!!!!!!!!");
				entity.setVelocity(0, 0);
			}
		  }
		}
		
	}
}
