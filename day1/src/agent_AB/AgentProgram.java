package agent_AB; 

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
		if (p.getLocationState().equals(Environment.LocationState.DIRTY)) return Environment.SUCK_DIRT;
		else if (p.getLocationState().equals(Environment.LocationState.CLEAN)) {
			if(p.getAgentLocation().equals(Environment.LOCATION_A)) return Environment.MOVE_RIGHT;
			else
				return Environment.MOVE_LEFT;
		}
		return NoOpAction.NO_OP;
		
	}
	
	public static void main(String[] args) {
		
		Environment en = new Environment(Environment.LocationState.DIRTY, Environment.LocationState.DIRTY);
		Percept p = new Percept(Environment.LOCATION_A, Environment.LocationState.DIRTY);
		AgentProgram pro = new AgentProgram();
		pro.execute(p);
	}
}