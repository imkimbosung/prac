package week1;

public class Recursion {
	static int rslt=0;
	public static void main(String[] args) {
		// 재귀 알고리즘의 기초
	      /*
	       * 특정 함수 내에서 자기 자신을 다시 호출하여 문제를 해결해나가는 함수.
	       * 원래 범위의 문제에서 더 작은 범위의 하위 문제를 먼저 해결함으로써 원래 문제를 해결해 나가는 방식.
	       * 일반 반복문을 통해 구현 가능한 기능은 재귀함수를 통해 구현이 가능하며 반대로 재귀함수로 구현한 기능을 반복문으로 구현이 가능합니다.
	       * 
	       * 재귀 함수는 함수 내에서 자기 자신을 계속 호출하는 방식이기 때문에 함수 안에 반드시 종료 구간이 되는 Base Case를 생각하며 코드를 구현해야함.
	       * 
	       * # 알고리즘 영상강의 안보고 작성한 코드
	       * 
	       * Question .1` 함수 recursion을 사용하여 100까지의 숫자 중 홀수의 합을 구하세요.
	       * 
	       * */
	       Recursion(100);

	}
	
	public static void Recursion(int num){
        if(num == 0){
            System.out.println("odd number sum = " + rslt);
            return;
        }else{
            if(num % 2 == 1){
                rslt += num;
            }else{
                
            }
        }
        Recursion(--num);
    }

}
