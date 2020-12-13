package prMasterMind;

public class MasterMindException extends RuntimeException {
	public MasterMindException(){
		super();
	}
	
	public MasterMindException(String msg){
		super(msg);
	}
}
