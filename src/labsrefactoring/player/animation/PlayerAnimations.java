package labsrefactoring.player.animation;

import labsrefactoring.animation.Animations;

public class PlayerAnimations extends Animations{

	
	public PlayerAnimations() {
		super();
		//expect the init(); method here..
		init();
	}
	
	@Override
	protected void init() {
		// put animations here..
		
		animations.put(0, new StandAnimation());
		animations.put(1, new WalkAnimation());
	}

}
