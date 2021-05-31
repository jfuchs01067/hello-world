package simpleapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class MockedRedisAdderTest {

	@Test
	public void test() {
		
		RedisAdder instance = new RedisAdder(null, 0) {
			@Override
			protected void storeInRedis(IArgument<Integer, Integer> arg) {			
			}
		};
		
		Random random = new Random();
		
		int a = random.nextInt() / 2;
		int b = random.nextInt() / 2;
		int sum = a + b;
		boolean expected = sum % 2 == 0;
		
		assertEquals(expected, instance.solve(IntegerArgument.of(a, b)).get());
	}
}
