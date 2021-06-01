package simpleapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocalAdderTest {

	private LocalAdder sut;
	
	@BeforeEach
	public void setUp() {
		sut = new LocalAdder();
	}
	
	@AfterEach
	public void tearDown() {
		sut = null;
	}
	
	@Test
	public void test() {
		
		int a = 1;
		int b = 2;
		int expected = a + b;
		
		int result = sut.add(a, b);
		
		assertEquals(expected, result);
	}
	
}
