package day1;

// 함수 recursion을 사용하여 100까지 숫자 중 홀수의 합을 구하시오.
public class Recursion_1 {
	
	public static void main(String [] args) {
		int sum = 0;		// 합계
		int num = 1;		// 시작숫자
		getOdd(num,sum);	// Recursion 함수
	}
	
	public static void getOdd(int num, int sum) {
		
		if(num>100) {
			System.out.println("홀수의 합 : " + sum);
		} else {
			// 홀수 일 때 
			if((num%2)==1) {
				sum = sum + num;
				System.out.println("num - "+ num +" / sum - " + sum);
				num++;
				getOdd(num,sum);	// Recursion 함수
			} else {	// 짝수 일 때
				num++;
				getOdd(num,sum);	// Recursion 함수
			}
		}
				
	}
}
