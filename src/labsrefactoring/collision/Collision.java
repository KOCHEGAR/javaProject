package labsrefactoring.collision;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import labsrefactoring.World.TestMap;
import labsrefactoring.mapElement.GroundElement;
import labsrefactoring.player.Entity;

public class Collision {

	static TestMap map;
	
	
	public void setMapToUpdateCollision(TestMap testMap) {
		map = testMap;
	}
	
	public static void col(Entity actor) {
	
		
		
		for (GroundElement element : map.getGround()) {
			
			if (actor.getRect().overlaps(element.getGround())) {
				System.out.println("overlapsed");
				
				float previousFrameY = actor.getPosition().y + actor.getVelocity().y * Gdx.graphics.getDeltaTime();
				float previousFrameBottom = previousFrameY - actor.getRect().height/2;
				float platformTop = element.getTop();
			
				if (previousFrameBottom <= platformTop) {
					
					actor.setPosY(platformTop+actor.getRect().height/2);
					actor.setVelY(0);
					actor.getCurrentAnimation().resetAnimation(); //сбрасываем анимацию прыжка, так как она останавливается на последнем кадре
					actor.setCurrentState(Entity.ON_GROUND_STATE);
					actor.setCurrentGround(element);
					System.out.println("onGroundState");
					return;
				}
			}
		}
	}
}
