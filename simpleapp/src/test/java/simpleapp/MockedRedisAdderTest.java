package simpleapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MockedRedisAdderTest {

	private IAdder<Integer> sut;
	
	@BeforeEach
	public void setUp() {
		sut = new RedisAdder(null, 0) {
			@Override
			protected void storeInRedis(Integer a, Integer b) {			
			}
		};
	}
	
	@AfterEach
	public void tearDown() {
		sut = null;
	}
	
	@Test
	public void test() {
		
		Random random = new Random();
		
		int a = random.nextInt() / 2;
		int b = random.nextInt() / 2;
		int expected = a + b;
		
		int result = sut.add(a, b);
		
		assertEquals(expected, result);
	}
}
