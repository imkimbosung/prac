package day1;

public class Recursion_2_solution {
	private static int n=5;
	private static int [][] maze = {
			{0,0,0,0,0},
			{0,1,0,1,1},
			{0,0,1,1,1},
			{1,0,0,0,0},
			{0,0,1,1,0}
	};
//	static int [][] maze = {
//	{0,1,0,0,0},
//	{0,1,0,1,0},
//	{0,0,0,1,0},
//	{0,1,1,1,0},
//	{0,0,0,0,0}
//};
	
	private static final int PATHWAY_COLOUR = 0;	// 지나다닐수 있는 칸 
	private static final int WALL_COLOUR = 1;		// 벽 
	private static final int BLOCKED_COLOUR = 2;	// 이미 방문해보고 출구까지 이어진 길이 아님 
	private static final int PATH_COLOUR = 3;		// 내가 가봤지만 출구까지 가는 경로인지 아닌지는 모름 
	private static int count = 0;
	
	public static void main(String [] args) {

		findMazePath(0,0);	// 0,0에서 시작 
		System.out.println("최소 경로 : " + count);
	}
	
	public static boolean findMazePath(int x, int y) {
		
		// x y가 미로 밖을 의미할 때 false 리턴 
		if(x<0 || y<0 || x>=n || y>=n ) {
			System.out.println("1 x : "+x+ " y : " + y);
			return false;
		} else if( maze[x][y] != PATHWAY_COLOUR ) { // 한번이라도 지났거나 벽이면 false 리턴 
			System.out.println("2 x : "+x+ " y : " + y);
			return false;
		} else if(x==n-1 && y==n-1) {	// 출구라는 의미 
			maze[x][y] = PATH_COLOUR;
			System.out.println("3 x : "+x+ " y : " + y);
			return true;
		} else {
			maze[x][y] = PATH_COLOUR; // 위치를 방문했음 (이 위치가 확실히 아닌지는 모름)
			// 현재 위치에 인접한 4개의 좌표를 둘러봄(위쪽,오른쪽,아래쪽,왼쪽 순서로 살펴봄)
			// 최대 4번은 recursion 이 되는 부분임.
			if( findMazePath(x-1,y) || findMazePath(x,y+1) || findMazePath(x+1,y) || findMazePath(x,y-1) ) {
				count++;
				System.out.println("4 x : "+x+ " y : " + y);
				return true;
			}
			maze[x][y] = BLOCKED_COLOUR; // 이 위치에서 어떤 방향으로 가더라도 출구까지 가는 경우가 없음 (지나온길을 돌아가야함)
			System.out.println("5 x : "+x+ " y : " + y);
			return false;
		}
		
		
	}
	
}