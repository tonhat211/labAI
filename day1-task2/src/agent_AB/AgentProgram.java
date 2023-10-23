package agent_AB;

import java.util.Random;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
		if (p.getLocationState().equals(Environment.LocationState.DIRTY)) return Environment.SUCK_DIRT;
//		neu sach roi thi co the up right down left
		else if (p.getLocationState().equals(Environment.LocationState.CLEAN)) {
			Action movation[] = {Environment.MOVE_UP,Environment.MOVE_RIGHT,
					Environment.MOVE_DOWN,Environment.MOVE_LEFT};
			int random = new Random().nextInt(4);
			Action nextAction = movation[random];
			String currentLocation = p.getAgentLocation();
//			vi tri hien tai la A
			if(currentLocation.equals(Environment.LOCATION_A)) {
				if(nextAction.equals(Environment.MOVE_UP) || nextAction.equals(Environment.MOVE_LEFT))
					return NoOpAction.NO_OP;
			} else 
				
			
//			vi tri hien tai la B
			if(currentLocation.equals(Environment.LOCATION_B)) {
				if(nextAction.equals(Environment.MOVE_UP) || nextAction.equals(Environment.MOVE_RIGHT))
					return NoOpAction.NO_OP;
				
			} else
//			vi tri hien tai la C
			if(currentLocation.equals(Environment.LOCATION_C)) {
				if(nextAction.equals(Environment.MOVE_DOWN) || nextAction.equals(Environment.MOVE_LEFT))
					return NoOpAction.NO_OP;
			} else
//			vi tri hien tai la D
			if(currentLocation.equals(Environment.LOCATION_D)) {
				if(nextAction.equals(Environment.MOVE_DOWN) || nextAction.equals(Environment.MOVE_RIGHT))
					return NoOpAction.NO_OP;
			}
			
			return nextAction;
					
		}
		return NoOpAction.NO_OP;
		
	}
	
	public static void main(String[] args) {
		
//		Environment en = new Environment(Environment.LocationState.DIRTY, Environment.LocationState.DIRTY);
//		Percept p = new Percept(Environment.LOCATION_A, Environment.LocationState.DIRTY);
//		AgentProgram pro = new AgentProgram();
//		pro.execute(p);
	}
}