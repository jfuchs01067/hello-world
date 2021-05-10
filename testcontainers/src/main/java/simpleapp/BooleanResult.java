package simpleapp;

public class BooleanResult implements IResult<Boolean> {

	private boolean result;

	private BooleanResult(boolean b) {
		this.result = b;
	}

	public static BooleanResult of(boolean b) {
		return new BooleanResult(b);
	}

	@Override
	public Boolean get() {
		return result;
	}

}
