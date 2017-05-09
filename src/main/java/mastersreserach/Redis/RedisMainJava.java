package mastersreserach.Redis;

import redis.clients.jedis.Jedis;

/**
 * Created by student on 2017/05/09.
 */
public class RedisMainJava {

    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("10.47.2.1", 6379);
        System.out.println("Connection to server sucessfully");

        long startTime = System.currentTimeMillis();

        //set the data in redis string
        jedis.set("test", "test1");
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("Writing : Total time (in mill seconds) : " + (diff));

        long startTime2 = System.currentTimeMillis();

        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("test"));
        long endTime2 = System.currentTimeMillis();
        long diff2 = endTime2 - startTime2;
        System.out.println("Reading : Total time (in mill seconds) : " + (diff2));

        //check whether server is running or not
        System.out.println("Server is running: " + jedis.ping());
    }

}