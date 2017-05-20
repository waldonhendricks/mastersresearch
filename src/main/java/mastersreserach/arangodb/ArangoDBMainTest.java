package mastersreserach.arangodb;

import com.arangodb.ArangoDB;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hashcode on 2017/01/23.
 */
public class ArangoDBMainTest {
    private   ArangoDB arangoDB;
    @Before
    public void setUp() throws Exception {
        arangoDB = new ArangoDB.Builder()
                .host("10.47.2.1")
                .user("root,")
                .port(1031)
                .build();


    }

    @Test


    public void addRecord() throws Exception {
        System.out.println("\nAdding Record");
        String dbName = "test3";
        long startTime = System.nanoTime();

        arangoDB.createDatabase(dbName);
        long endTime = System.nanoTime();
        long diff = endTime - startTime;
        System.out.println("\nTotal time: " + (diff) + " ns");
        System.out.println("\nDatabase created: " + dbName);
    }

}
