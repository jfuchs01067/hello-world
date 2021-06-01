package simpleapp;

import java.util.Arrays;

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
		
		databaseCollection.insertOne(EasyMock.anyObject(Document.class));
		
		EasyMock.expect(databaseCollection.countDocuments()).andReturn(0L);
		EasyMock.expect(databaseCollection.countDocuments()).andReturn(1L);

		EasyMock.replay(mongo, database, databaseCollection);
		
		MongoDatabase mongoDatabase = mongo.getDatabase("foo");
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("bar");
		
		System.err.println(mongoCollection.countDocuments());
		
		// create a document
		Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
		
		mongoCollection.insertOne(doc);
		
		System.err.println(mongoCollection.countDocuments());
	}
	
}
