This is a demo for the testcontainers talk in EWS2021.

## Tools:
* [JUnit 5](https://junit.org/junit5/)
* [Testcontainers](testcontainers.org)
* [Awaitility](...)

## Examples

### LocalAdder

This is a simple piece of code with a simple unit test

### RedisAdder :rocket:

This class needs a [Redis](redis.io) database to work properly. The unit test includes testing the redis write operation. To achieve this, a docker container with a redis database is being used.

### CloudAdder :rocket::rocket:

This implementation makes use of AWS APIs. To test it we have to provide the required AWS resources as mocks. This is where [LocalStack](https://github.com/localstack/localstack) comes into play.

