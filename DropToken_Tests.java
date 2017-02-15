/**
 * A series of tests for our Drop Token game that primarily test the different private methods,
 * as those are the main components of the game that take up the majority of work.
 * 
 * NOTE: TO GET THESE TESTS TO WORK, YOU MUST CHANGE ALL PRIVATE METHODS TO PUBLIC IN
 * 	     DROPTOKEN.java.
 * 
 * @author JustinJohnson
 *
 */
public class DropToken_Tests {
	public static void main(String[] args) {
		isBoardFullTests();
		checkVerticalTests();
		checkHorizontalTests();
		checkDiagonalsTests();
		getAvailableRowTests();
	}
	
	public static void isBoardFullTests() {
		boolean testFull = false;
		int[][] board1 = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				board1[i][j] = 1;
			}
		}
		testFull = DropToken.isBoardFull(board1);
		int[][] board2 = new int[4][4];
		boolean testEmpty = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; i < 2; i++) {
				board2[i][j] = 1;
			}
		}
		testEmpty = !DropToken.isBoardFull(board2);
		
		if (testFull && testEmpty) {
			System.out.println("Passed isBoardFull tests.");
		} else {
			System.out.println("Failed isBoardFull tests.");
		}
	}
	
	public static void checkVerticalTests() {
		int[][] board = new int[4][4];
 		for (int i = 0; i < 4; i++) {
 			for (int j = 0; j < 4; j++) {
 				board[i][j] = 1;
 			}
		}
 		boolean testOne = DropToken.checkVertical(board, 1, 1);
 		boolean testTwo = DropToken.checkVertical(board, 2, 1);
 		boolean testThree = DropToken.checkVertical(board, 3, 1);
 		boolean testFour = DropToken.checkVertical(board, 4, 1);
 		
 		if (testOne && testTwo && testThree && testFour) {
 			System.out.println("Passed checkVertical tests.");
 		} else {
 			System.out.println("Failed checkVertical tests.");
 		}
	}
	
	public static void checkHorizontalTests() {
		int[][] board = new int[4][4];
 		for (int i = 0; i < 4; i++) {
 			for (int j = 0; j < 4; j++) {
 				board[i][j] = 1;
 			}
		}
 		boolean testOne = DropToken.checkHorizontal(board, 0, 1);
 		boolean testTwo = DropToken.checkHorizontal(board, 1, 1);
 		boolean testThree = DropToken.checkHorizontal(board, 2, 1);
 		boolean testFour = DropToken.checkHorizontal(board, 3, 1);
 		
 		if (testOne && testTwo && testThree && testFour) {
 			System.out.println("Passed checkHorizontal tests.");
 		} else {
 			System.out.println("Failed checkHorizontal tests.");
 		}
	}
	
	public static void checkDiagonalsTests() {
		int[][] board = new int[4][4];
 		for (int i = 0; i < 4; i++) {
 			for (int j = 0; j < 4; j++) {
 				board[i][j] = 1;
 			}
		}
 		
 		if (DropToken.checkDiagonals(board, 1)) {
 			System.out.println("Passed checkDiagonals tests.");
 		} else {
 			System.out.println("Failed checkDiagonals tests.");
 		}
	}
	
	public static void getAvailableRowTests() {
		int[][] board = new int[4][4];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				board[i][j] = 1;
			}
		}
		
		boolean result = true;
		for(int i = 1; i <= 4; i++) {
			if (DropToken.getAvailableRow(board, i) != 3) {
				result = false;
			}
		}
		
		if (result) {
 			System.out.println("Passed getAvailableRow tests.");
 		} else {
 			System.out.println("Failed getAvailableRow tests.");
 		}
	}
}
