package springbootapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class SimpleMessageListenerTest {

	@Test
	public void test() {
		System.err.println("This is a unit test.");
		
		SimpleMessageListener instance = new SimpleMessageListener(null, null, null);
				
		assertNotNull(instance);
	}
	
}
