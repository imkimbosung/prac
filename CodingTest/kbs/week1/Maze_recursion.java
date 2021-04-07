package week1;

/*
 * 21.03.30
 * 문제 : 길은 0, 벽은 1로 된 미로의 길을 찾으세요.
 */

public class Maze_recursion {
	public static void main(String[] args) {

		// case1
		// int[][] maze = {{0,0,0,0,0},{0,1,0,1,0},{0,0,1,1,1},{1,0,0,0,0},{0,0,1,1,0}};

		// case2
		int[][] maze = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 0 }, { 0, 0, 1, 1, 0 }, { 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0 } };

		recursion(maze, 0, 0, 0);
	}

	public static void recursion(int[][] maze, int count, int x, int y) {

		// BaseCase
		if (x == 4 && y == 4) {
			System.out.println(count);
			return;
		}

		if (x + 1 < 5 && maze[x + 1][y] == 0) {
			recursion(maze, count + 1, x + 1, y);
		}

		if (y + 1 < 5 && maze[x][y + 1] == 0) {
			recursion(maze, count + 1, x, y + 1);
		}
	}
}
