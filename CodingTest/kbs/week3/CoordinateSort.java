package week3;

import java.util.*;

public class CoordinateSort {
	 public static void main(String[] args) {
	        Scanner input = new Scanner(System.in); 

	        int arrayLength = input.nextInt();
	        int[][] intArray = new int[arrayLength][2];       	
	        for(int i = 0; i < arrayLength; i++){
	            for(int j = 0; j < 2 ; j++){
	                intArray[i][j] = input.nextInt();
	            }
	        }

	        // 선택정렬
	        //selectSortArray(intArray);
	        
	        // 삽입정렬
	        insertionSortArray(intArray);
	    }

	 
	    public static void selectSortArray(int[][] intArray){
	        int minXValue = 0;
	        int minYValue = 0;
	        int tmpX = 0;
	        int tmpY = 0;

	        for(int i = 0; i < intArray.length  - 1 ; i++){
	        	minXValue = intArray[i][0];
	        	minYValue = intArray[i][1];
	            for(int j = i+1 ; j < intArray.length; j++){
	                
	                if(minYValue == intArray[j][1]){
	                	if(minXValue > intArray[j][0]) {
	                		tmpX = minXValue;
	                		tmpY = minYValue;
	                		minXValue = intArray[j][0];
	                		minYValue = intArray[j][1];
	                		intArray[j][0] = tmpX;
	                		intArray[j][1] = tmpY;
	                	}
	                }else if(minYValue > intArray[j][1]){
	                	tmpX = minXValue;
                		tmpY = minYValue;
                		minXValue = intArray[j][0];
                		minYValue = intArray[j][1];
                		intArray[j][0] = tmpX;
                		intArray[j][1] = tmpY;
	                }
	                
	            }   
	            intArray[i][0] = minXValue;
	            intArray[i][1] = minYValue;			
	        }
	        
	        printArray(intArray);
	    }
	    
	    public static void insertionSortArray(int[][] intArray) {
	    	int xValue = 0;
	        int yValue = 0;
	    	int tmpX = 0;
	        int tmpY = 0;
	        
	    	for(int i = 1 ; i < intArray.length ; i++) {
	    		xValue = intArray[i][0];
	    		yValue = intArray[i][1];
	    		for(int j = i-1 ; j >= 0 ; j--) {
	    			
	    			if(intArray[j][1] > yValue) {
	    		        intArray[j+1][0] = intArray[j][0];
	    		        intArray[j+1][1] = intArray[j][1];
	    		        
	    		        intArray[j][0] = xValue;
	    		        intArray[j][1] = yValue;
	    		        
	    			}else if(intArray[j][1] == yValue && intArray[j][0] > xValue) {
	    				intArray[j+1][0] = intArray[j][0];
	    		        intArray[j+1][1] = intArray[j][1];
	    		        
	    		        intArray[j][0] = xValue;
	    		        intArray[j][1] = yValue;
	    			}
	    		}
	    	}
	    	
	    	printArray(intArray);
	    }
	    
	    public static void printArray(int[][] resultArray) {
	    	for(int i = 0; i < resultArray.length ; i++) {
	    		System.out.println(resultArray[i][0] + " " + resultArray[i][1]);
	    	}
	    }

}
