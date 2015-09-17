package rfagot.examples.drools_620_conwaysgameoflife.ruleutils;


@SuppressWarnings("serial")
public class RuleException extends Exception {

	public RuleException(String message){
		super(message);
	}

	public RuleException(Throwable cause){
		super(cause);
	}

	public RuleException(String message,Throwable cause){
		super(message, cause);
	}

}
