package simpleapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MockedRedisAdderTest {

	private ISolver<Integer, Integer, Boolean> instance;
	
	@BeforeEach
	public void setUp() {
		instance = new RedisAdder(null, 0) {
			@Override
			protected void storeInRedis(IArgument<Integer, Integer> arg) {			
			}
		};
	}
	
	@AfterEach
	public void tearDown() {
		instance = null;
	}
	
	@Test
	public void test() {
		
		Random random = new Random();
		
		int a = random.nextInt() / 2;
		int b = random.nextInt() / 2;
		int sum = a + b;
		boolean expected = sum % 2 == 0;
		
		boolean result = instance.solve(IntegerArgument.of(a, b)).get();
		
		assertEquals(expected, result);
	}
}
