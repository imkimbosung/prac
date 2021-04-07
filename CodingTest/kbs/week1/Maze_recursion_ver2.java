package week1;

import java.util.*;
/*
문제
미로에서 입력한 좌표까지의 길이를 구하여ㅁ
*/
public class Maze_recursion_ver2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// case1
		int[][] maze = { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 1, 1, 1 }, { 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0 } };

		// case2
		// int[][] maze = {{0,0,0,0,0},{1,1,0,1,0},{0,0,1,1,0},{1,0,0,0,0},{0,0,1,1,0}};

		int inputX = input.nextInt();
		int inputY = input.nextInt();

		recursion(maze, 0, 0, 0, inputX, inputY);
	}

	public static void recursion(int[][] maze, int count, int x, int y, int inputX, int inputY) {

		// BaseCase
		if (x == inputX && y == inputY) {
			System.out.println(count);
			return;
		}

		if (x + 1 < 5 && maze[x + 1][y] == 0) {
			recursion(maze, count + 1, x + 1, y, inputX, inputY);
		}

		if (y + 1 < 5 && maze[x][y + 1] == 0) {
			recursion(maze, count + 1, x, y + 1, inputX, inputY);
		}
	}
}
