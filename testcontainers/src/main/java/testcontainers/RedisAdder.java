package testcontainers;

import redis.clients.jedis.Jedis;

public class RedisAdder implements ISolver<Integer, Integer, Boolean> {

	private String host;
	private int port;
	
	public RedisAdder(String host, int port) {
		this.host = host;
		this.port = port;
	} 

	@Override
	public IResult<Boolean> solve(IArgument<Integer, Integer> arg) {

		storeInRedis(arg);

		int sum = arg.getA() + arg.getB();

		boolean even = sum % 2 == 0;

		return BooleanResult.of(even);
	}

	private void storeInRedis(IArgument<Integer, Integer> arg) {

		try (Jedis jedis = new Jedis(host, port)) {

			jedis.set("a", String.valueOf(arg.getA()));
			jedis.set("b", String.valueOf(arg.getB()));
		}

	}

}
