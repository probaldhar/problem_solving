package projects;

//Copyright 2016-2018 Karat, Inc.  Please do not distribute or republish.

import java.io.*;
import java.util.*;

//Write a function that takes in the image and returns the coordinates of the rectangle of 0's -- either top-left and bottom-right; or top-left, width, and height.

//Sample output:
//x: 3, y: 2, width: 3, height: 2
//2,3 3,5 -- row,column of the top-left and bottom-right corners
//3,2 5,3 -- x,y of the top-left and bottom-right corners (as long as you stay consistent, either format is fine)


class findRectangle {


// Your function here:
public int[][] findReact( int[][] image ) {
 
 int[][] returnArray = new int[2][2];
 Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();
 
 // DS to store the first index of the different rectangle
 Map<Integer,Integer> firstIndex = new HashMap<Integer,Integer>();
 
 int start = 0, end = 0, lastX = -1, lastY = -1, firstX = -1, firstY = -1;
 
 for ( int i = 0; i < image.length; i++ ) {
   for ( int j = 0; j < image[i].length; j++ ) {
     // System.out.print(image[i][j]);
     
     if ( image[i][j] == 0 && start == 0 ) {
       // returnArray[0][0] = i;
       // returnArray[0][1] = j;
       // System.out.println(i + " " + j);
       firstX = i;
       firstY = j;
       
       // first index
       myMap.put(i, j);
       
       // start = 1;
       // lastX = i;
       // lastY = j;
     } else if ( image[i][j] == 0 ) {
       
       if (j >= myMap.get(firstX)){
         // System.out.println("same rectangle");
         
         // value of the first index
         // myMap.get(firstX);
         
         // store the last index
         myMap.put(i, j);
         
       } else {
         
         // how to keep track of the different first index
         
         // store the first index of the different reactangle
         myMap.put(i, j);
         
         // System.out.println("Different rectangle");
         // store the co-ordinate for the start of the reactangle
       }
        // lastX = i;
        // lastY = j;
     }
     
   }
 }
 // System.out.println(lastX + " " + lastY);
 
 returnArray[1][0] = lastX;
 returnArray[1][1] = lastY;
 
 
 return returnArray;
 
}



//Sample output (using top-left and bottom-right):
//[[[2,3],[3,5]],
//[[3,1],[5,1]],
//[[5,3],[6,4]]]


public int numIslands(char[][] grid) {
    int count = 0;
    for ( int i = 0; i < grid.length; i++ )
        for ( int j = 0 ; j < grid[0].length; j++) {
            if ( grid[i][j] == '0' ) {
                dfsFill(grid,i,j);
                count++;
            }
        }
    return count;
}
private void dfsFill(char[][] grid,int i, int j) {
    if ( i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '0' ) {
        grid[i][j] = '1';
        dfsFill(grid, i + 1, j);
        dfsFill(grid, i - 1, j);
        dfsFill(grid, i, j + 1);
        dfsFill(grid, i, j - 1);
    }
}



public static void main(String[] args) {
 
 // Sample input:
 int[][] image = {  
   {1, 1, 1, 1, 1, 1, 1},
   {1, 1, 1, 1, 1, 1, 1},
   {1, 1, 1, 0, 0, 0, 1},
   {1, 0, 1, 0, 0, 0, 1},
   {1, 0, 1, 1, 1, 1, 1},
   {1, 0, 1, 0, 0, 1, 1},
   {1, 1, 1, 0, 0, 1, 1},
   {1, 1, 1, 1, 1, 1, 1},
 };

 
 findRectangle solve = new findRectangle();
 
 int[][] retArray = solve.findReact(image);
 
 for ( int i = 0; i < retArray.length; i++ ) {
   for ( int j = 0; j < retArray[i].length; j++ ) {
       System.out.print(retArray[i][j] + " ");
   }
   System.out.println();
 }
}
}


