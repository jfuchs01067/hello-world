package simpleapp;

public class IntegerResult implements IResult<Integer> {

	private final Integer result;
	
	private IntegerResult(Integer i) {
		this.result = i;
	}
	
	public static IntegerResult of(int i) {
		return new IntegerResult(i);
	}
	
	public Integer get() {
		return result;
	}

}
