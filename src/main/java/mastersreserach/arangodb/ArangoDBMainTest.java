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
                .host("10.47.3.105")
                .user("root,")
                .port(1026)
                .build();


    }

    @Test


    public void addRecord() throws Exception {
        System.out.println(" Adding Record");
        String dbName = "test";
        long startTime = System.currentTimeMillis();

            arangoDB.createDatabase(dbName);
            long endTime = System.currentTimeMillis();
            long diff = endTime - startTime;
            System.out.println("Total time (in mill seconds) : "
                    + (diff));
            System.out.println("Database created: " + dbName);

        

    }
}
