package mastersreserach.mongodb;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class Main {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("10.47.3.109", 27017);
        MongoDatabase database = mongoClient.getDatabase("boniface");

        try {database.createCollection("test");
        } catch (MongoCommandException e) {

            database.getCollection("test").drop();

        MongoDatabase db = mongoClient.getDatabase("test");
        Employee employee = new Employee(); // Create java object
        employee.setNo(1L);
        employee.setName("waldon");
        Gson gson = new Gson();
        String json = gson.toJson(employee);
        Document doc = Document.parse(json);

        db.getCollection("NameColl").insertOne(doc);

        }

        // Retrieve to ensure object was inserted
       ;
    }
}