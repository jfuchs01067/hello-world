package simpleapp;

import org.bson.Document;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * https://stackoverflow.com/questions/7413985/unit-testing-with-mongodb
 * 
 * @author JFUCHS
 *
 */
public class MongoDbAdderIT {

	@Test
	public void test() {
		MongoClient mongo = EasyMock.mock(MongoClient.class);
	    MongoDatabase database = EasyMock.mock(MongoDatabase.class);
		MongoCollection<Document> databaseCollection = EasyMock.mock(MongoCollection.class);

		EasyMock.expect(mongo.getDatabase("foo")).andReturn(database);
		EasyMock.expect(database.getCollection("bar")).andReturn(databaseCollection);

		EasyMock.replay(mongo);
		EasyMock.replay(database);
		
		MongoDatabase mongoDatabase = mongo.getDatabase("foo");
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("bar");
	}
	
}
