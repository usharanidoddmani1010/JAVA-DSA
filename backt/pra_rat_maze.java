package backt;

public class pra_rat_maze {

    static boolean vis[][];

    public static int gridway(int maze[][], int x, int y, String path, int n, int m) {
        // boundary + invalid checks
        if (x < 0 || y < 0 || x >= n || y >= m || maze[x][y] == 0 || vis[x][y]==true) {
            return 0;
        }

        // base case (destination reached)
        if (x == n - 1 && y == m - 1) {
            System.out.println(path); // print path if needed
            return 1;
        }

        // mark visited
        vis[x][y] = true;

        // explore all directions
        int w1 = gridway(maze, x, y + 1, path + "R", n, m);
        int w2 = gridway(maze, x + 1, y, path + "D", n, m);
        int w3 = gridway(maze, x - 1, y, path + "U", n, m);
        int w4 = gridway(maze, x, y - 1, path + "L", n, m);

        // backtrack
        vis[x][y] = false;

        return w1 + w2 + w3 + w4;
    }

    public static void main(String[] args) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        int n = maze.length;
        int m = maze[0].length;

        vis = new boolean[n][m];

        System.out.println("Number of ways: " + gridway(maze, 0, 0, "", n, m));
    }
}