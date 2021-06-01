package simpleapp;

public class LocalAdder implements IAdder<Integer> {

	@Override
	public Integer add(Integer a, Integer b) {
		
		return a + b;
	}

}
