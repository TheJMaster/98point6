import java.util.*;

/**
 * DropToken is a command line program that allows two individuals to play a 
 * game of 98point6 drop token. 
 * @author Justin Johnson
 * @since Winter Quarter 2017
 */
public class DropToken {
	public static void main(String[] args) {
		/*
		 * Setup Variables
		 */
		int[][] gameBoard = new int[4][4];
		ArrayList<Integer> moves = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		String command = input.nextLine();
		boolean hasWon = false;
		/*
		 * Main Gameplay
		 */
		while(!command.equals("EXIT")) {
			String[] strs = command.split("\\s+");
			if (strs[0].equals("PUT") && !hasWon) {
				int column = -1;
				while (column == -1) { // Handles error when non-integer follows "PUT"
					try { 
						column = Integer.parseInt(strs[1]);
					} catch(Exception e) {
						break;
					}
				}
				if (column > 4 || column < 0) { // Handles column out of bounds
					System.out.println("ERROR");
				} else {
					int row = getAvailableRow(gameBoard, column);
					if (row == -1) {
						System.out.println("ERROR"); // Handles full column
					} else {
						moves.add(Integer.parseInt(strs[1]));
						// Note: (moves.size() - 1) % 2 + 1 is used to keep track of each players turn
						gameBoard[row][column - 1] = (moves.size() - 1) % 2 + 1;
						if(isGameWon(gameBoard, row, column, (moves.size() - 1) % 2 + 1)) {
							System.out.println("WIN");
							hasWon = true;
						} else if (isBoardFull(gameBoard)) {
							System.out.println("DRAW");
						} else {
							System.out.println("OK");
						}
					}
				}
				
			} else if (strs[0].equals("GET")) {
				for (int i : moves) {
					System.out.println(i);
				}
			} else if (strs[0].equals("BOARD")) {
				printGameBoard(gameBoard);
			} else {
				System.out.println("ERROR"); // Handles invalid command
			}
			command = input.nextLine();
		}
		input.close();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	
	// A private method that accepts an integer matrix representing our game board,
	// and returns true if every element is non-zero(full), false otherwise.
	private static boolean isBoardFull(int[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// A private method that accepts an integer matrix representing our game board,
	// an row of the current added value, the column of the current added value, and 
	// the current player. Returns true if the current player has won the current game, false otherwise.
	private static boolean isGameWon(int[][] gameBoard, int row, int column, int player) {
		return checkVertical(gameBoard, column, player) || checkHorizontal(gameBoard, row, player) 
				|| checkDiagonals(gameBoard, player);
	}
	
	// A private method that accepts an integer matrix representing our game board, 
	// our most recently inserted value's column, and the current player. Returns true
	// if every value in our column is equal to our player, false otherwise.
	private static boolean checkVertical(int[][] gameBoard, int column, int player) {
		for (int i = gameBoard.length - 1; i >= 0; i--) {
			if (gameBoard[i][column - 1] != player) {
				return false;
			}
		}
		
		return true;
	}
	
	// A private method that accepts an integer matrix, representing our game board,
	// our most recently inserted value's row, and the current player. Returns true
	// if every value in our current row is equal to our player, false otherwise.
	private static boolean checkHorizontal(int[][]gameBoard, int row, int player) {
		for (int i = 0; i < gameBoard.length; i++) { 
			if (gameBoard[row][i] != player) {
				return false;
			}
		}
		
		return true;
	}
	
	// A private method that accepts an integer matrix, representing our game board
	// and an integer for the current player. Returns true if either diagonal
	// is matching in our array - false otherwise.
	private static boolean checkDiagonals(int[][] gameBoard, int player) {
		boolean result1 = true;
		for(int i = 0; i < gameBoard.length; i++) {
			if (gameBoard[i][i] != player) {
				result1 = false;
			}
		}
		
		boolean result2 = true;
		for (int i = 0; i < gameBoard.length; i++) {
			if(gameBoard[i][gameBoard.length - 1 - i] != player) {
				return false;
			}
		}
		
		return result1 || result2;
	}
	
	// A private method that accepts an integer matrix, representing our game board
	// and and integer for the desired column. Returns the next available row,
	// from top to bottom, in the matrix in our desired column, returns -1
	// if column is full.
	private static int getAvailableRow(int[][] gameBoard, int column) {
		int i = gameBoard.length - 1;
		while (i >= 0) {
			if (gameBoard[i][column - 1] == 0) {
				return i;
			}
			i--;
		}
		
		return -1;
	}
	
	// A private method that accepts a provided gameBoard, as stored in
	// a matrix, and prints its contents to console, in specified format.
	private static void printGameBoard(int[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("+--------");
		System.out.println("  1 2 3 4");
	}
}
