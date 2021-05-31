package simpleapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocalAdderTest {

	private LocalAdder instance;
	
	@BeforeEach
	public void setUp() {
		instance = new LocalAdder();
	}
	
	@AfterEach
	public void tearDown() {
		instance = null;
	}
	
	@Test
	public void test() {
		
		int a = 1;
		int b = 2;
		int expected = a + b;
		
		int result = instance.solve(IntegerArgument.of(a, b)).get();
		
		assertEquals(expected, result);
	}
	
}
