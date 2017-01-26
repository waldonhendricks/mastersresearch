package mastersreserach.cassandradb.Java;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class MultiDCClient {
    private Session session;

    public MultiDCClient() {
    }

    public void connect(String node) {
        Cluster cluster = Cluster.builder()
                .addContactPoint(node)
                .build();
        Metadata metadata = cluster.getMetadata();
        System.out.printf("Connected to cluster: %s\n",
                metadata.getClusterName());
        session = cluster.connect();
        for ( Host host : metadata.getAllHosts() ) {
            System.out.printf("Host IP: %s, Data Center: %s, Rack: %s\n",
                    host.getAddress(), host.getDatacenter(), host.getRack());
        }
    }

    public static void main(String[] args) {
        MultiDCClient client = new MultiDCClient();
        client.connect("10.47.3.102");
        client.session.close();
    }

}