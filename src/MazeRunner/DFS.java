package MazeRunner;

import java.util.Scanner;

public class DFS {

    public static char[][] grid;
    static int[] dx = {0, 0, 1, -1}; // Possible X changes for our four moves.
    static int[] dy = {1, -1, 0, 0}; // Possible Y changes for our four moves.
    static int r, c; // Useful arguements.
    static boolean found; // Tells us when to kill the function.

    public DFS (char[][] grid, int startr, int startc) {
        // TODO Auto-generated method stub
        /*
        Scanner scan = new Scanner(System.in); Legacy code for when we scanned it in manually, like plebs.
        r = scan.nextInt();
        c = scan.nextInt();
*/
        
        //grid = new char[r][c];
        //scan.nextLine();
        for (int i = 0; i < r; i++) {
            //String s = scan.nextLine();
            for (int j = 0; j < c; j++) {
                //grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'S') {
                    startr = i;
                    startc = j;
                }
            }
        }
        System.out.println("Three");
        found = false;
        find(startr, startc);
        System.out.println(found);
    }

    public static void find(int x, int y) {
        System.out.println("Four");
        if (grid[x][y] == 'E') {
            found = true;
            return;
        }
        grid[x][y] = 'X';
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (inBounds(tx, ty) && grid[tx][ty] != 'X') {
                System.out.println("Running another function. I'm currently at " + tx + " - " + ty);
                find(tx, ty
                );
            }
        }
    }

    static boolean inBounds(int x, int y) {
        if (x >= 0 && x < r && y >= 0 && y < c) {
            return true;
        }
        return false;
    }

}
