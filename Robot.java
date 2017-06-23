/**
 * Unique Paths from topLeft to bottomRight in NXN grid(all 4 directions are possible)
 * 
 * The idea here was to reach the bottomRight corner first and then recursively backtrack from
 * there and reach the bottomRight Corner with some other path
 */
public class Robot {

	// NxN grid
	private final static int N = 4;
	private static Integer counter = 0;

	public static void main(String args[]) {

		int grid[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = 0;
			}
		}

		Robot robot = new Robot();
		robot.findPaths(grid, 0, 0);
		System.out.println(counter);
	}

	/**
	 * Recursive Backtracking
	 * 
	 * @param grid
	 * @param x
	 * @param y
	 */
	private void findPaths(int grid[][], int x, int y) {

		if (x == N - 1 && y == N - 1) {
			counter++;
			grid[N - 1][N - 1] = 1;
		}

		if (isValid(grid, x, y)) {

			grid[x][y] = 1;
			findPaths(grid, x + 1, y);
			findPaths(grid, x, y + 1);
			findPaths(grid, x, y - 1);
			findPaths(grid, x - 1, y);

			grid[x][y] = 0;
		}
	}

	/**
	 * If current location is valid
	 * 
	 * @param grid
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isValid(int grid[][], int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && grid[x][y] == 0);
	}
}
