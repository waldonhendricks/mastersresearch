package mastersreserach.cassandradb.Java;

import com.datastax.driver.core.*;

import static java.util.UUID.randomUUID;

public class MultiDCClient {
    private Session session;

    public MultiDCClient() {
    }

    public void connect(String node) {
        Cluster cluster = Cluster.builder()
                .addContactPoint(node)
                .build();

        Metadata metadata = cluster.getMetadata();

        System.out.printf("\nConnected to cluster: %s\n\n",
                metadata.getClusterName());

        session = cluster.connect();

        for ( Host host : metadata.getAllHosts() ) {
            System.out.printf("Host IP: %s, Data Center: %s, Rack: %s\n",
                    host.getAddress(), host.getDatacenter(), host.getRack());
        }
    }

    public static void main(String[] args) {
        MultiDCClient client = new MultiDCClient();
        client.connect("10.47.2.151");

        System.out.println("\nAdding Record");
        long startTime = System.currentTimeMillis();

        client.session.execute("INSERT INTO example.tweet (timeline, id, text) VALUES (?, ?, ?)",
                "me", randomUUID(), "Hello World");

        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;

        System.out.println("\nTotal time: " + (diff) + " ms");

        System.out.println("\nData written !");

        client.session.close();
    }

}