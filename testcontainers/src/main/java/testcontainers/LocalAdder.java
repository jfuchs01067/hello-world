package testcontainers;

public class LocalAdder implements ISolver<Integer, Integer, Integer> {

	public IResult<Integer> solve(IArgument<Integer, Integer> arg) {
		
		return IntegerResult.of(arg.getA() + arg.getB());
	}

}
