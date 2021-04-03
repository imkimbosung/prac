package day1;

import java.util.Scanner;

public class Recursion_3 {

//	미로문제를 내가 입력한 곳으로 이동시키기(최소 칸수 구하기. 단, 이동시킬 곳은 뚫려있는 길이여야 하고 미로 크기는 5x5)
	static String [][] miro = {
			{"0","0","0","0","0"},
			{"0","1","0","1","1"},
			{"0","0","1","1","1"},
			{"1","0","0","0","0"},
			{"0","0","1","1","0"}
	};
	static String [][] fakeMiro = miro;	// 지나온 길을 표시하기 위한 쌍둥이 미로 
	static int count = 0;	// 이동한 칸 수 
	static int i = 0;		// 세로 
	static int j = 0;		// 가로 
	static String preDirection = "";	// 이전에 동작했던 행위 
	
	public static void main(String [] args) {
		
		System.out.println("2개의 숫자만 입력하세요 ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();

		getCount(a,b);
		
	}
	
	
	public static void getCount(int x, int y) {

		if(i==x&&j==y) {
			System.out.println("지나온 최소 칸수 = "+count);
		}else {
			switch(preDirection) {
				case "" : 	
					if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";	// 현재 위치를 지나온 길이라고 표시 
						j++;
						check(fakeMiro[i][j]);	// 다음으로 지나갈 길의 히스토리 체크.(지나왔던 길인지 아닌지)
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i-1!=-1 && miro[i-1][j+1]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else {
						System.out.println("이럴수가? ") ;
					}
					break;
							
				case "right" : 	
					if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						miro[i][j+1]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else {
						System.out.println("이럴수가? right") ;
					}
					break;
							
				case "down" : 	
					if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						miro[i+1][j]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else {
						System.out.println("이럴수가? down") ;
						
					}
					break;
							
				case "left" :
					if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						miro[i][j-1]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else {
						System.out.println("이럴수가? left") ;
					}
					break;
							
				case "up" : 	
					if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						miro[i-1][j]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount(x,y);
					} else {
						System.out.println("이럴수가? up") ;
					}
					break;
							
			}
			
				
		}
		
	}
	
	public static void check(String road) {
		if(road=="NoCount") {
			count--;
		}else {

			count++;

		}
	}

	
}
