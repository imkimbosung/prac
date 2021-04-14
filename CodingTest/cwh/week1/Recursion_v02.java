package week1;

public class Recursion_v02 {

	public static void main(String[] args) {
		/*
         * Recursion Algorithm version 02 
         *  
         * Recursion function Method Type is int.
         * main Method calling Recursion function and return int Type.
         * 
         * Finaly Parameter num is return 0 and sysout is print "Total Odd Number" 
         * 
         */
         int result = Recursion(100);
         System.out.println("Total Odd Number = " + result);

	}
	
	public static int Recursion(int num){
        if( num == 0){
            return 0;
        }else if( num%2==1){
            return num + Recursion(num-1);
        }else{
            return 0 + Recursion(num-1);
        }
    }

}
