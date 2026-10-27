public class HamiltonianCycle {

    static int V = 5;

    static int[][] graph = {
        {0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 1},
        {0, 1, 1, 1, 0}
    };

    static int[] path = new int[V];

    static boolean isSafe(int v, int pos) {
        // Check connection with previous vertex
        if (graph[path[pos - 1]][v] == 0)
            return false;

        // Vertex must not already exist in path
        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    static boolean hamCycleUtil(int pos) {
        // All vertices have been added
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos)) {
                path[pos] = v;

                if (hamCycleUtil(pos + 1))
                    return true;

                // Backtrack
                path[pos] = -1;
            }
        }

        return false;
    }

    static void hamCycle() {
        for (int i = 0; i < V; i++)
            path[i] = -1;

        path[0] = 0;

        if (!hamCycleUtil(1)) {
            System.out.println("No Hamiltonian Cycle exists");
            return;
        }

        System.out.println("Hamiltonian Cycle:");
        for (int i = 0; i < V; i++)
            System.out.print(path[i] + " -> ");

        System.out.println(path[0]);
    }

    public static void main(String[] args) {
        hamCycle();
    }
}
