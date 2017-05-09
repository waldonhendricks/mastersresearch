package mastersreserach.mongodb;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class Main {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("10.47.2.8", 27017);

        long startTime = System.currentTimeMillis();

        DB db = mongoClient.getDB("test");
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Total time (in mill seconds) : " + (diff));


        /**** Get collection / table from 'test' ****/
        // if collection doesn't exists, MongoDB will create it for you
        DBCollection table = (DBCollection) db.getCollection("user");

        /**** Insert ****/
        // create a document to store key and value
        BasicDBObject document = new BasicDBObject();
        document.put("name", "user1qwerty");
        long startTime2 = System.currentTimeMillis();
        table.insert(document);

        long endTime2 = System.currentTimeMillis();
        long diff2 = endTime2 - startTime2;
        System.out.println("Total time (in mill seconds) : " + (diff2));

        /**** Find and display ****/
        BasicDBObject query = new BasicDBObject();
        query.put("name", "user1");

        long startTime3 = System.currentTimeMillis();
        DBCursor cursor = table.find(query);

        long endTime3 = System.currentTimeMillis();
        long diff3 = endTime3 - startTime3;
        System.out.println("Total time (in mill seconds) : " + (diff3));

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        // Retrieve to ensure object was inserted
        ;
    }
}