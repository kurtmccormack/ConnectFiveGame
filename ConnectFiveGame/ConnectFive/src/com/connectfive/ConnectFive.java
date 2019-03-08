package com.connectfive;

import java.util.Scanner;
/**
 *
 * @author kurts laptop
 */
public class ConnectFive {
    
    public static void main(String[] args) {
        //Get user input
        Scanner userInput = new Scanner(System.in);
        //create board
        String [][] board = new String [6][9];
        //current player
        String player = "[x]";
        String player1;
        String player2;
        String bracket = "[ ]";
        //number of moves
        int movesLeft = 54;
        //holds the row and the col of move
        int [] playerMove = new int[2];
        playerMove[0] = 5;
        boolean isValid = false;
        initializeArray(board, bracket);
        String playerName;
        System.out.println("Player1 Please enter name");
        player1 = userInput.next();
        System.out.println("Player2 Please enter name");
        player2 = userInput.next();
        playerName = player1;
        
        while(true){
            while(isValid == false){
                System.out.println("Player " + playerName + " turn, Please enter Column number");
                playerMove[1] = userInput.nextInt();
                isValid = validMove(board,playerMove,player, bracket);
                if(isValid == false)
                    System.out.println("Invalid Input Please try again");      
            }
        //decrement amount of moves left
        movesLeft--;
        //display board
        printBoard(board);
        
        // if we have a winner break out of loop
        if(hasWinner(board, player)){
            userInput.close();
            break;
        }
        
        //reset flag
        isValid = false;
        //toggle between players
        player = changePlayer(player);
        playerName = changePlayerName(player1, player2, playerName);
        //reset the game if no moves remaining
        if(movesLeft == 0){
            movesLeft = 54;
            initializeArray(board, bracket);
            //player = 'x';
            System.out.println("Restarting game no winner");
        }
    }
    System.out.println("Winner is Player " + playerName);
    
}

//toggle player to switch turns
public static String changePlayer(String player){
    if(player == "[x]"){
        return "[o]";
    }
   return "[x]";
}
public static String changePlayerName(String player1, String player2, String playerName){
    if(playerName.equals(player1)){
        return player2;
    }
   return player1;
}


public static boolean validMove(String [][] board, int [] playerMove, String player, String bracket) {
    if(playerMove[0] >= 0 && playerMove[0] <= 5 &&
       playerMove[1] >= 0 && playerMove[1] <= 8){
            if(board[playerMove[0]][playerMove[1]].equals(bracket)){
                board[playerMove[0]][playerMove[1]] = player;
                return true;
            }else if(board[playerMove[0]][playerMove[1]].equals("[x]") || board[playerMove[0]][playerMove[1]].equals("[o]") ){ //row 1
                playerMove[0] -= 1;
                if(board[playerMove[0]][playerMove[1]].equals(bracket)){
                board[playerMove[0]][playerMove[1]] = player;
                playerMove[0] = 5;
                return true;
                }else if(board[playerMove[0]][playerMove[1]].equals("[x]") || board[playerMove[0]][playerMove[1]].equals("[o]") ){ //row 2
                    playerMove[0] -= 1;
                    if(board[playerMove[0]][playerMove[1]].equals(bracket)){
                    board[playerMove[0]][playerMove[1]] = player;
                    playerMove[0] = 5;
                    return true;
                    }else if(board[playerMove[0]][playerMove[1]].equals("[x]") || board[playerMove[0]][playerMove[1]].equals("[o]") ){ //row 3
						playerMove[0] -= 1;
						if(board[playerMove[0]][playerMove[1]].equals(bracket)){
						board[playerMove[0]][playerMove[1]] = player;
						playerMove[0] = 5;
						return true;
						}else if(board[playerMove[0]][playerMove[1]].equals("[x]") || board[playerMove[0]][playerMove[1]].equals("[o]") ){ // row 4
							playerMove[0] -= 1;
							if(board[playerMove[0]][playerMove[1]].equals(bracket)){
							board[playerMove[0]][playerMove[1]] = player;
							playerMove[0] = 5;
							return true;
							}else if(board[playerMove[0]][playerMove[1]].equals("[x]") || board[playerMove[0]][playerMove[1]].equals("[o]") ){ // row 5
								playerMove[0] -= 1;
								if(board[playerMove[0]][playerMove[1]].equals(bracket)){
								board[playerMove[0]][playerMove[1]] = player;
								playerMove[0] = 5;
								return true;
								}else if(board[playerMove[0]][playerMove[1]].equals("[x]") || board[playerMove[0]][playerMove[1]].equals("[o]") ){ // row 6
									playerMove[0] = 5;
                                                                        return false;
									} // end of row 6
							} // end of row 5
						} // end of row 4
					} // end of row 3
                } // end of row2
            }  //end of row1
    } // end of if between 0 and 6, 0 and 9
    return false;
} // end of Valid move

//initialize board to brackets
public static void initializeArray(String [][] board, String bracket){
    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++){
            board[i][j] = bracket;
        }
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

//Checks to see if there is a winner
public static boolean hasWinner(String [][] board, String player){
    for(int i = 0; i < 6; i++){ // all horizontal five in a row
        if (board[i][0].equals(player)
            && board[i][1].equals(player)
            && board[i][2].equals(player)
            && board[i][3].equals(player)    
            && board[i][4].equals(player)) {
                return true;
            }
        else if(board[i][1].equals(player)
            && board[i][2].equals(player)
            && board[i][3].equals(player)
            && board[i][4].equals(player)    
            && board[i][5].equals(player)) {
                return true;  
        }
        else if(board[i][2].equals(player)
            && board[i][3].equals(player)
            && board[i][4].equals(player)
            && board[i][5].equals(player)    
            && board[i][6].equals(player)) {
                return true;  
        }
        else if(board[i][3].equals(player)
                && board[i][4].equals(player)
                && board[i][5].equals(player)
                && board[i][6].equals(player)    
                && board[i][7].equals(player)) {
                    return true;  
            }
            else if(board[i][4].equals(player)
                && board[i][5].equals(player)
                && board[i][6].equals(player)
                && board[i][7].equals(player)    
                && board[i][8].equals(player)) {
                    return true;  
            }
            
    }

    for(int i = 0; i < 9; i++){ // all vertical five in a row
        if (board[0][i].equals(player)
            && board[1][i].equals(player)
            && board[2][i].equals(player)
            && board[3][i].equals(player)    
            && board[4][i].equals(player)) {
                return true;
            }
        else if(board[1][i].equals(player)
            && board[2][i].equals(player)
            && board[3][i].equals(player)
            && board[4][i].equals(player)    
            && board[5][i].equals(player)) {
                return true;
            }
        }
     
    // all left diagonal five in a row
    for(int i = 0; i < 5; i++){ 
        if (board[0][0 + i].equals(player)
            && board[1][1 + i].equals(player)
            && board[2][2 + i].equals(player)
            && board[3][3 + i].equals(player)    
            && board[4][4 + i].equals(player)) {
                return true;
            }
        else if(board[1][0 + i].equals(player)
            && board[2][1 + i].equals(player)
            && board[3][2 + i].equals(player)
            && board[4][3 + i].equals(player)    
            && board[5][4 + i].equals(player)) {
                return true;
            }
        }
    // all right diagonal five in a row
    for(int i = 0; i < 5; i++){ 
        if (board[0][8 - i].equals(player)
            && board[1][7 - i].equals(player)
            && board[2][6 - i].equals(player)
            && board[3][5 - i].equals(player)    
            && board[4][4 - i].equals(player)) {
                return true;
            }
        else if(board[1][8 - i].equals(player)
            && board[2][7 - i].equals(player)
            && board[3][6 - i].equals(player)
            && board[4][5 - i].equals(player)    
            && board[5][4 - i].equals(player)) {
                return true;
            }
        }
    return false;
    }

}

