package week2;
/*
Counting Cells in a Bolb
문제
임의의 x, y의 값을 넣었을 때 색칠된 블록중 인접한 블록의 개수를 구하여라.
(단, 0 <= x,y <= 6 이고, 여기서 말하는 인접은 대각선으로 이어진 블록을 포함한다.)
*/
import java.util.*;

class CountingCellInaBolb {
    static int[][] field =  {{1,0,0,1,1,0,0}
                            ,{0,1,0,1,0,1,0}
                            ,{0,1,0,0,0,0,1}
                            ,{0,0,0,0,1,1,1}
                            ,{1,1,0,0,0,0,0}
                            ,{0,1,0,1,0,1,0}
                            ,{0,0,1,0,0,0,1}};

    
    static final int CHECKEDCELL = 2;                    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputX = input.nextInt();
        int inputY = input.nextInt();
        System.out.println("inputX: " + inputX + " inputY: "+ inputY);
        System.out.println(countingCell(inputX, inputY));
    }

    public static int countingCell(int x, int y){
        // baseCase
        if(outOfRanged(x,y) || field[x][y] == 0 || field[x][y] == CHECKEDCELL){
            return 0;
        }else {
            field[x][y] = CHECKEDCELL;
            return 1 + countingCell(x+1, y) + countingCell(x, y+1) + countingCell(x-1, y) + countingCell(x, y-1)
                  + countingCell(x+1, y+1) + countingCell(x-1, y+1) + countingCell(x-1, y-1) + countingCell(x+1, y-1);
        }
    }

    public static boolean outOfRanged(int checkX, int checkY){
        return (checkX >= 7 || checkX < 0 || checkY >= 7 || checkY < 0 )?true:false;
    }
}