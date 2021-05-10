package simpleapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import redis.clients.jedis.Jedis;

@Testcontainers
public class RedisAdderTest {

	@Container
	public GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:5.0.3-alpine")).withExposedPorts(6379);
	
	@Test
	public void test() {
		
		RedisAdder instance = new RedisAdder(redis.getHost(), redis.getFirstMappedPort());
		
		Random random = new Random();
		
		int a = random.nextInt() / 2;
		int b = random.nextInt() / 2;
		int sum = a + b;
		boolean expected = sum % 2 == 0;
		
		assertEquals(expected, instance.solve(IntegerArgument.of(a, b)).get());
		
		Jedis jedis = new Jedis(redis.getHost(), redis.getFirstMappedPort());
		
		Object redisA = jedis.get("a");
		Object redisB = jedis.get("b");
		
		assertEquals(String.valueOf(a), redisA);
		assertEquals(String.valueOf(b), redisB);
	}
}
