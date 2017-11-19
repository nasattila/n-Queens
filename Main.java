import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("What should be the length/width of the board?");
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		boolean[][] board = new boolean[n][n];
		
		System.out.println();
		
		System.out.println("On what row should a queen be placed? (Enter \"-1\" to exit.)");
		
		int qr = scanner.nextInt();
		int qc;
		
		while (qr != -1)
		{
			System.out.println("On what column should a queen be placed? (Enter \"-1\" to exit.)");
			
			qc = scanner.nextInt();
			
			if (qc == -1)
			{
				break;
			}
			
			QueensBoard.placeQueen(board, qr, qc);
			QueensBoard.print(board);
			
			System.out.println("On what row should a queen be placed? (Enter \"-1\" to exit.)");
			
			qr = scanner.nextInt();
		}
		
		scanner.close();
		
		System.out.println();
		System.out.println();
		
		System.out.println("provided board:");
		
		QueensBoard.print(board);
		
		System.out.println();
		
		System.out.println("results:");
		
		long startTime = System.nanoTime();
		
		QueensBoard.solveNQueens(board);
		
		long endTime = System.nanoTime();
		
		System.out.println();
		System.out.println();
		
		System.out.println("execution time: " + (endTime - startTime) + " nanoseconds"); 
		
		System.out.println();
		System.out.println();
	}
}
