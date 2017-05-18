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
        System.out.println("\nWriting: " + (diff) + " ms");

        long startTime2 = System.currentTimeMillis();

        // Get the stored data and print it
        System.out.println("\nStored string in redis: "+ jedis.get("test"));
        long endTime2 = System.currentTimeMillis();
        long diff2 = endTime2 - startTime2;
        System.out.println("\nReading: " + (diff2) + " ms");

        //check whether server is running or not
        System.out.println("\nServer is running: " + jedis.ping());
    }

}