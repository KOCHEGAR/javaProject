package labsrefactoring.collision;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import labsrefactoring.World.TestMap;
import labsrefactoring.player.Entity;

public class Collision {

	public static void col(Entity entity, TestMap map) {
	
		
		
		for (Rectangle rectangle : map.getGround()) {
			
			if (entity.getRect().overlaps(rectangle)) {
				System.out.println("overlapsed");
				
				float previousFrameY = entity.getPosition().y + entity.getVelocity().y * Gdx.graphics.getDeltaTime();
				float previousFrameBottom = previousFrameY - entity.getRect().height;
				float platformTop = rectangle.y;
			
				if (previousFrameBottom <= platformTop) {
					
					entity.setVelY(0);
					entity.getCurrentAnimation().resetAnimation(); //сбрасываем анимацию прыжка, так как она останавливается на последнем кадре
					entity.setCurrentState(Entity.ON_GROUND_STATE);
					System.out.println("onGroundState");
					return;
				}
			}
		}
	}
}
