package labsrefactoring.player.states;

import labsrefactoring.collision.Collision;
import labsrefactoring.gravity.Gravitation;
import labsrefactoring.player.Entity;
import labsrefactoring.player.Player;
import labsrefactoring.player.playerInput.PlayerInput;
import labsrefactoring.state.IState;

public class InAirState implements IState{

	Gravitation grav = new Gravitation(-9.8f);
	
	@Override
	public void update(Entity actor, float delta){
		
		grav.applyGravity(actor, delta);
		PlayerInput.moveLeft(-Player.MAX_SPEED);
		PlayerInput.moveRight(Player.MAX_SPEED);

		
		Collision.col(actor);
		// �� ��� ���� - ��� �����(�� �� �������� ����� �������)
		/*if (actor.getPosition().y - actor.getRect().height/2 <= 0){// 
			
			actor.setVelY(0);
			actor.getCurrentAnimation().resetAnimation(); //���������� �������� ������, ��� ��� ��� ��������������� �� ��������� �����
			actor.setCurrentState(Entity.ON_GROUND_STATE);
			System.out.println("onGroundState");
			return;
		}*/
	}
}
