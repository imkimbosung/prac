package day1;

// 미로를 탈출 하기 위해 지나야하는 최소의 칸 수 구하기.
// 0은 뚫린 길이고 1은 막힌 길
// [0,0]이 시작 [4,4]가 도착
public class Miro{
	
	static String [][] miro = {
			{"0","0","0","0","0"},
			{"0","1","0","1","1"},
			{"0","0","1","1","1"},
			{"1","0","0","0","0"},
			{"0","0","1","1","0"}
	};
//	static String [][] miro = {
//			{"0","1","0","0","0"},
//			{"0","1","0","1","0"},
//			{"0","0","0","1","0"},
//			{"0","1","1","1","0"},
//			{"0","0","0","0","0"}
//	};
	static String [][] fakeMiro = miro;	// 지나온 길을 표시하기 위한 쌍둥이 미로 
	static int count = 0;	// 이동한 칸 수 
	static int i = 0;		// 세로 
	static int j = 0;		// 가로 
	static String preDirection = "";	// 이전에 동작했던 행위 
	
	public static void main(String args[]) {
		getCount();
		
	}
	
	public static void getCount() {

		if(i==4&&j==4) {
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
						getCount();
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j+1]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
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
						getCount();
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						miro[i][j+1]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
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
						getCount();
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						miro[i+1][j]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
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
						getCount();
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						miro[i][j-1]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
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
						getCount();
					} else if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						miro[i-1][j]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
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