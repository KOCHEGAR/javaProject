package labsrefactoring.animation;

import java.util.Collection;
import java.util.HashMap;

public abstract class Animations {

	
	protected HashMap<Integer, IAnimation> animations;

	public Animations() {
		animations = new HashMap<Integer, IAnimation>();
	}
	
	protected abstract void init();
	
	public IAnimation get(int anim){
		
		if (animations.containsKey(anim)) {	return animations.get(anim); }
		else { return null; }
	}
	public Collection<IAnimation> getAll(){
		return animations.values();
	}
}
