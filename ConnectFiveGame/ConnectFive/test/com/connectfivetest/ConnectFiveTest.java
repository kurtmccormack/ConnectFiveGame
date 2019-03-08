package com.connectfivetest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.connectfive.ConnectFive;


public class ConnectFiveTest {
	ConnectFive confive;
	
	@Before
	public void setUp() throws Exception {
		confive = new ConnectFive();       
	}

	@Test
	public void testChangePlayerO() {
		String player = "[o]";
		assertEquals(confive.changePlayer(player), "[x]");
	}
	@Test
	public void testChangePlayerX() {
		String player = "[x]";
		assertEquals(confive.changePlayer(player), "[o]");
	}
	
	@Test
	public void testChangePlayerName1() { // change name from player 1 to player 2
		String player1 = "John";
		String player2 = "Mary";
		String playerName = "John";
		assertEquals(confive.changePlayerName(player1, player2, playerName), "Mary");
	}
	
	@Test
	public void testChangePlayerName2() {
		String player1 = "John";
		String player2 = "Mary";
		String playerName = "Mary";
		assertEquals(confive.changePlayerName(player1, player2, playerName), "John");
	}
	
	@Test
	public void testValidMoveColumnOutOfBoundsHigh() { // Value for column out of bounds high
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{0, 9};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), false);
	}
	
	@Test
	public void testValidMoveColumnOutOfBoundsLow() { // Value for column out of bounds low
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{0, -1};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), false);
	}
	
	@Test
	public void testValidMoveRowOutOfBoundsHigh() { // Value for row out of bounds High
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{6, 5};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), false);
	}
	
	@Test
	public void testValidMoveRowOutOfBoundsLow() { // Value for row out of bounds Low
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{-1, 5};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), false);
	}
	
	@Test
	public void testValidMoveInBounds() { // Value in bounds for both row and column
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{2, 6};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveXInRow1() { // Column select already has x in it
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[x]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 0};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveXInRow1PlaceO() { // Column select already has x in it
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[x]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 0};
		String player = "[o]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveOInRow1PlaceO() { // Column select already has o in it
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[x]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 0};
		String player = "[o]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveOInRow1() { // Column select already has O in it
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[o]"} };
		int [] playerMove = new int[]{5, 8};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveXInRow2() { // Column already has x in it in row 2
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[x]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[o]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 1};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveOInRow2() { // Column already has o in it in row 2
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[o]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[x]","[ ]"} };
		int [] playerMove = new int[]{5, 7};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveXInRow3() { // Column already has x in it in row 3
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 2};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveOInRow3() { // Column already has o in it in row 3
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[o]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[x]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[o]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 6};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	@Test
	public void testValidMoveXInRow4() { // Column already has x in it in row 4
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[x]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[o]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[x]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[o]","[ ]","[ ]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 3};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	@Test
	public void testValidMoveOInRow4() { // Column already has o in it in row 4
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[ ]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[ ]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[ ]","[ ]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[ ]","[o]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 5};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveXInRow5() { // Column already has x in it in row 5
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[o]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 4};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveOInRow5() { // Column already has o in it in row 5
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[o]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 4};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), true);
	}
	
	@Test
	public void testValidMoveXInRow6() { // Column already has x in it in row 6 COLUMN FULL
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[o]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 4};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), false);
	}
	
	@Test
	public void testValidMoveOInRow6() { // Column already has x in it in row 6 COLUMN FULL
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[o]","[ ]","[ ]","[ ]"} };
		int [] playerMove = new int[]{5, 4};
		String player = "[x]";
		String bracket = "[ ]";
		assertEquals(confive.validMove(board, playerMove, player, bracket), false);
	}
	
	@Test
	public void testHasWinnerHorizontalWinX() { // Column already has x in it in row 6 COLUMN FULL
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[x]", "[x]","[x]","[x]","[x]","[ ]","[ ]","[ ]"} };
		String player = "[x]";
		assertEquals(confive.hasWinner(board, player), true);
	}
	
	@Test
	public void testHasWinnerHorizontalWinO() { // Horizontal win for O
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[o]","[o]","[o]","[o]"} ,
							{"[ ]", "[ ]", "[x]","[x]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[o]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[x]","[x]","[o]","[ ]","[ ]","[ ]"} };
		String player = "[o]";
		assertEquals(confive.hasWinner(board, player), true);
	}
	
	@Test
	public void testHasWinnerNoWin() { // No win should return false
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[o]", "[o]","[ ]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[ ]","[x]","[o]","[ ]","[ ]","[ ]"} };
		String player = "[x]";
		assertEquals(confive.hasWinner(board, player), false);
	}
	
	@Test
	public void testHasWinnerWinForOtherPlayerX() { // A win for other player will return false
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[o]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[o]", "[o]","[o]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[o]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[o]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[o]","[x]","[o]","[ ]","[ ]","[ ]"} };
		String player = "[x]";
		assertEquals(confive.hasWinner(board, player), false);
	}
	
	@Test
	public void testHasWinnerWinForOtherPlayerO() { // A win for other player will return false
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[x]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[o]", "[o]","[x]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[x]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[o]","[x]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[x]","[x]","[x]","[o]","[ ]","[ ]","[ ]"} };
		String player = "[o]";
		assertEquals(confive.hasWinner(board, player), false);
	}
	
	@Test
	public void testHasWinnerVericalX() { // Vertical win for X
		String board[][] = { {"[x]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[x]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[x]", "[o]", "[o]","[ ]","[o]","[o]","[ ]","[ ]","[ ]"} ,
							{"[x]", "[ ]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[ ]"} ,
							{"[x]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[ ]"} ,
							{"[o]", "[ ]", "[x]","[ ]","[x]","[o]","[ ]","[ ]","[ ]"} };
		String player = "[x]";
		assertEquals(confive.hasWinner(board, player), true);
	}
	
	@Test
	public void testHasWinnerVericalO() { // Vertical win for O
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[o]"} ,
							{"[x]", "[o]", "[o]","[ ]","[o]","[o]","[ ]","[ ]","[o]"} ,
							{"[x]", "[ ]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[o]"} ,
							{"[x]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[o]"} ,
							{"[o]", "[ ]", "[x]","[ ]","[x]","[o]","[ ]","[ ]","[o]"} };
		String player = "[o]";
		assertEquals(confive.hasWinner(board, player), true);
	}
	
	@Test
	public void testHasWinnerDiagonalLeftX() { // Diagonal left win for X
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[o]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[o]"} ,
							{"[x]", "[ ]", "[o]","[ ]","[o]","[x]","[ ]","[ ]","[x]"} ,
							{"[x]", "[ ]", "[ ]","[ ]","[x]","[x]","[x]","[ ]","[o]"} ,
							{"[x]", "[ ]", "[o]","[ ]","[ ]","[o]","[ ]","[x]","[o]"} ,
							{"[o]", "[ ]", "[x]","[ ]","[o]","[x]","[ ]","[ ]","[x]"} };
		String player = "[x]";
		assertEquals(confive.hasWinner(board, player), true);
	}
	
	@Test
	public void testHasWinnerDiagonalLeftO() { // Diagonal left win for O
		String board[][] = { {"[o]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[o]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[o]"} ,
							{"[x]", "[o]", "[o]","[ ]","[o]","[o]","[ ]","[ ]","[x]"} ,
							{"[x]", "[ ]", "[x]","[o]","[x]","[x]","[ ]","[ ]","[o]"} ,
							{"[x]", "[ ]", "[o]","[ ]","[o]","[o]","[ ]","[ ]","[o]"} ,
							{"[o]", "[ ]", "[x]","[ ]","[o]","[x]","[ ]","[ ]","[o]"} };
		String player = "[o]";
		assertEquals(confive.hasWinner(board, player), true);
	}
	
	
	@Test
	public void testHasWinnerDiagonalRightX() { // Diagonal right win for X
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[x]","[o]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[x]", "[o]", "[x]","[ ]","[o]","[o]","[ ]","[o]","[x]"} ,
							{"[x]", "[x]", "[x]","[ ]","[x]","[x]","[ ]","[ ]","[o]"} ,
							{"[x]", "[ ]", "[o]","[ ]","[o]","[o]","[ ]","[ ]","[o]"} ,
							{"[o]", "[ ]", "[x]","[ ]","[o]","[o]","[ ]","[ ]","[o]"} };
		String player = "[x]";
		assertEquals(confive.hasWinner(board, player), true);
	}
	
	@Test
	public void testHasWinnerDiagonalRightO() { // Diagonal right win for O
		String board[][] = { {"[ ]", "[ ]", "[ ]","[ ]","[x]","[ ]","[ ]","[ ]","[ ]"} ,
							{"[ ]", "[ ]", "[ ]","[ ]","[o]","[ ]","[ ]","[ ]","[o]"} ,
							{"[x]", "[o]", "[o]","[ ]","[o]","[o]","[ ]","[o]","[x]"} ,
							{"[x]", "[ ]", "[x]","[ ]","[x]","[x]","[o]","[ ]","[o]"} ,
							{"[x]", "[ ]", "[o]","[ ]","[o]","[o]","[ ]","[ ]","[o]"} ,
							{"[o]", "[ ]", "[x]","[ ]","[o]","[o]","[ ]","[ ]","[o]"} };
		String player = "[o]";
		assertEquals(confive.hasWinner(board, player), true);
	}
	

}
