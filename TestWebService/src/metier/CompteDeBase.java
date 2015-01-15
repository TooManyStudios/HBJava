package metier;

public class CompteDeBase {
	private long code;

	public CompteDeBase() {
		this(0);
	}
	
	public CompteDeBase(long code) {
		this.code = code;
	}
	
	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}
}
