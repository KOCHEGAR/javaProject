package labsrefactoring.player.animation;

import labsrefactoring.animation.Animations;
import labsrefactoring.player.Entity;

public class PlayerAnimations extends Animations{

	
	public PlayerAnimations() {
		super();
		//expect the init(); method here..
		init();
	}
	
	@Override
	protected void init() {
		// put animations here..
		
		animations.put(Entity.ANIM_STAND, new StandAnimation());
		animations.put(Entity.ANIM_WALK, new WalkAnimation());
		animations.put(Entity.ANIM_JUMP, new JumpAnimation());
	}
}
