package com.connectfivetest;

//Test to check that has winner cover all outcomes
//Printing out all winning combinations to check for loops
public class HasWinnerTest {
 public static void main(String[] args) {
     //create board
     String [][] board = new String [6][9];
     //current player
     char player = 'x';
     
     String bracket = "x";
     
     //HorizontalWinner1(board, bracket);  // uncomment to check
     //HorizontalWinner2(board, bracket);  // uncomment to check
     //HorizontalWinner3(board, bracket);  // uncomment to check
     //HorizontalWinner4(board, bracket);  // uncomment to check
     //HorizontalWinner5(board, bracket);  // uncomment to check
     VerticalWinner1(board, bracket);   // uncomment to check
     //VerticalWinner2(board, bracket);   // uncomment to check
     //DiagonalLeft1(board, bracket);      // uncomment to check
     //DiagonalLeft2(board, bracket);      // uncomment to check
     //DiagonalRight1(board, bracket);   // uncomment to check
     //DiagonalRight2(board, bracket);   // uncomment to check
 
 } 
 
public static void HorizontalWinner1(String [][] board, String bracket){
 for(int i = 0; i < 6; i++){       
         board[i][0] = bracket;
         board[i][1] = bracket;
         board[i][2] = bracket;
         board[i][3] = bracket;
         board[i][4] = bracket;
      printBoard(board);   
      System.out.println(); 
     }     
}
public static void HorizontalWinner2(String [][] board, String bracket){
 for(int i = 0; i < 6; i++){       
         board[i][1] = bracket;
         board[i][2] = bracket;
         board[i][3] = bracket;
         board[i][4] = bracket;
         board[i][5] = bracket;
      printBoard(board);   
      System.out.println(); 
     }     
}

public static void HorizontalWinner3(String [][] board, String bracket){
 for(int i = 0; i < 6; i++){       
         board[i][2] = bracket;
         board[i][3] = bracket;
         board[i][4] = bracket;
         board[i][5] = bracket;
         board[i][6] = bracket;
      printBoard(board);   
      System.out.println(); 
     }     
}

public static void HorizontalWinner4(String [][] board, String bracket){
 for(int i = 0; i < 6; i++){       
         board[i][3] = bracket;
         board[i][4] = bracket;
         board[i][5] = bracket;
         board[i][6] = bracket;
         board[i][7] = bracket;
      printBoard(board);   
      System.out.println(); 
     }     
}

public static void HorizontalWinner5(String [][] board, String bracket){
 for(int i = 0; i < 6; i++){       
         board[i][4] = bracket;
         board[i][5] = bracket;
         board[i][6] = bracket;
         board[i][7] = bracket;
         board[i][8] = bracket;
      printBoard(board);   
      System.out.println(); 
     }     
}

public static void VerticalWinner1(String [][] board, String bracket){
 for(int i = 0; i < 9; i++){       
         board[0][i] = bracket;
         board[1][i] = bracket;
         board[2][i] = bracket;
         board[3][i] = bracket;
         board[4][i] = bracket;
      printBoard(board);   
      System.out.println(); 
     }     
}

public static void VerticalWinner2(String [][] board, String bracket){
 for(int i = 0; i < 9; i++){       
         board[1][i] = bracket;
         board[2][i] = bracket;
         board[3][i] = bracket;
         board[4][i] = bracket;
         board[5][i] = bracket;
      printBoard(board);   
      System.out.println(); 
     }     
}

public static void DiagonalLeft1(String [][] board, String bracket){
 for(int i = 0; i < 5; i++){       
         board[0][8 - i] = bracket;
         board[1][7 - i] = bracket;
         board[2][6 - i] = bracket;
         board[3][5 - i] = bracket;
         board[4][4 - i] = bracket;
      printBoard(board);   
      System.out.println(); 
     }     
}
public static void DiagonalLeft2(String [][] board, String bracket){
 for(int i = 0; i < 5; i++){         
         board[1][8 - i] = bracket;
         board[2][7 - i] = bracket;
         board[3][6 - i] = bracket;
         board[4][5 - i] = bracket;
         board[5][4 - i] = bracket;
      printBoard(board);   
      System.out.println(); 
     }        
}

public static void DiagonalRight1(String [][] board, String bracket){
 for(int i = 0; i < 5; i++){         
         board[0][1 + i] = bracket;
         board[1][2 + i] = bracket;
         board[2][3 + i] = bracket;
         board[3][4 + i] = bracket;
         board[4][5 + i] = bracket;
      printBoard(board);   
      System.out.println(); 
     }        
}

public static void DiagonalRight2(String [][] board, String bracket){
 for(int i = 0; i < 5; i++){         
         board[1][1 + i] = bracket;
         board[2][2 + i] = bracket;
         board[3][3 + i] = bracket;
         board[4][4 + i] = bracket;
         board[5][5 + i] = bracket;
      printBoard(board);   
      System.out.println(); 
     }        
}


//prints board out
public static void printBoard(String [][] board){
 for(int i = 0; i < board.length; i++){
     for(int j = 0; j < board[i].length; j++){
         System.out.print(board[i][j] + " ");
 }
 System.out.println();
 }
}
 

 
}
