package labsrefactoring.player.animation;

import java.util.HashMap;

import labsrefactoring.animation.IAnimation;

public abstract class Animations {

	
	protected HashMap<Integer, IAnimation> animations;
	// ��������, �� ������� �� ��� ����������� ��� ������������
	public Animations() {

		animations = new HashMap<Integer, IAnimation>();

	}
	
	protected abstract void init();
	
	public abstract IAnimation get();
}
