import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by sergej on 12.09.15.
 */
public class UnionFind {

    private int[] ids;

    public UnionFind(int numberOfPoints) {
        ids = new int[numberOfPoints];

        for(int i = 0; i < numberOfPoints; i++) {
            ids[i] = i;
        }
    }

    private void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];

        for(int i = 0; i < ids.length; i++) {
            if(ids[i] == pid)
                ids[i] = qid;
        }
    }

    private boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

    private static class Connection {
        private int left;
        private int right;

        public Connection(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(8);

        Collection<Connection> connections = new ArrayList<Connection>();

        connections.add(new Connection(1, 4));
        connections.add(new Connection(4, 5));
        connections.add(new Connection(2, 3));
        connections.add(new Connection(3, 7));
        connections.add(new Connection(2, 6));
        connections.add(new Connection(6, 3));

        for (Connection connection : connections) {
            int p = connection.getLeft();
            int q = connection.getRight();

            if (!uf.isConnected(p, q)) {
                uf.union(p, q);
                System.out.println("Connecting p(" + p + ") and q(" + q + ")");
            }
        }
    }


}
