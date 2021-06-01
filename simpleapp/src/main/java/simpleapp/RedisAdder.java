package simpleapp;

import redis.clients.jedis.Jedis;

public class RedisAdder implements IAdder<Integer> {

	static final String A = "a";
	static final String B = "b";
	
	private String host;
	private int port;
	
	
	public RedisAdder(String host, int port) {
		this.host = host;
		this.port = port;
	} 

	@Override
	public Integer add(Integer a, Integer b) {

		storeInRedis(a, b);

		return a + b;
	}

	protected void storeInRedis(Integer a, Integer b) {

		try (Jedis jedis = new Jedis(host, port)) {

			jedis.set(A, String.valueOf(a));
			jedis.set(B, String.valueOf(b));
		}

	}

}
