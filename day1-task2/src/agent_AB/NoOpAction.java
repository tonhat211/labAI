package agent_AB; 

public class NoOpAction extends Action {
	public static final NoOpAction NO_OP = new NoOpAction();

	public boolean isNoOp() {
		return true;
	}
	
	public String toString() {
		return "NO_OP";
	}
}