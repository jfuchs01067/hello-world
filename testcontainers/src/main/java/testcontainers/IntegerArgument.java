package testcontainers;

public class IntegerArgument implements IArgument<Integer, Integer> {

	private final Integer a;
	private final Integer b;
	
	private IntegerArgument(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public static IntegerArgument of(int a, int b) {
		return new IntegerArgument(a, b);
	}
	
	@Override
	public Integer getA() {
		return a;
	}

	@Override
	public Integer getB() {
		return b;
	}

}
