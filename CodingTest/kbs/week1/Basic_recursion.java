package week1;

/*
* 21.03.28
* 문제 : 함수를 사용해 1 ~ 100까지 숫자 중 홀수의 합을 구해라
*/
public class Basic_recursion {
	public static void main(String args[]) {
		System.out.println(recursionSum(1));
	}

	public static int recursionSum(int startNum) {

		// 마지막 정의
		if (startNum == 100) {
			return 0;

			// 홀수일때만 합산
		} else if (startNum % 2 == 1) {
			return startNum + recursionSum(++startNum);
		}
		// 짝수일때는 합산하지 않음
		return recursionSum(++startNum);
	}
}
