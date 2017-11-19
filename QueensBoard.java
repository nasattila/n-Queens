public class QueensBoard
{	
	private QueensBoard()
	{
	}
	
	// prints board
    public static void print(boolean board[][])
    {    	
        for (int i = 0; i < board.length; i = i + 1)
        {
        	System.out.print("\t");
        	
            for (int j = 0; j < board[i].length; j = j + 1)
            {
            	if (board[i][j] == true)
            	{
            		System.out.print("[Q]");
            	}
            	else
            	{
            		System.out.print("[ ]");
            	}
            }
            
            System.out.println();
        }
    }
    
    // places a queen at (row, column)
    public static boolean placeQueen(boolean board[][], int row, int column)
    {
    	if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
    	{
    		return false;
    	}
    	
    	return board[row][column] = true;
    }
    
    public static boolean isBoardValid(boolean board[][])
    {
    	for (int i = 0; i < board.length; i = i + 1)
    	{
    		for (int j = 0; j < board.length; j = j + 1)
    		{
    			if (board[i][j] == true)
    			{
    				if (isAttackedAnywhere(board, i, j) == true)
    				{    					
    					return false;
    				}
    			}
    		}
    	}
    	
    	return true;
    }
    
    private static boolean isAttackedColumn(boolean board[][], int row, int column)
    {
    	for (int i = 0; i < board.length; i = i + 1)
        {
            if (board[i][column] == true && i != row)
            {
                return true;
            }
        }
    	
    	return false;
    }
    
    private static boolean isAttackedRow(boolean board[][], int row, int column)
    {
    	for (int j = 0; j < board[0].length; j = j + 1)
        {
            if (board[row][j] == true && j != column)
            {
                return true;
            }
        }
    	
    	return false;
    }
    
    private static boolean isAttackedUpperLeft(boolean board[][], int row, int column)
    {
    	for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i = i - 1, j = j - 1)
        {
            if (board[i][j] == true && j != column && i != row)
            {
            	return true;
            }
        }
    	
    	return false;
    }
    
    private static boolean isAttackedUpperRight(boolean board[][], int row, int column)
    {
    	for (int i = row, j = column; i >= 0 && j < board[0].length; i = i - 1, j = j + 1)
        {
            if (board[i][j] == true && j != column && i != row)
            {
                return true;
            }
        }
    	
    	return false;
    }
    
    private static boolean isAttackedLowerLeft(boolean board[][], int row, int column)
    {
    	for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i = i + 1, j = j - 1)
        {
            if (board[i][j] == true && j != column && i != row)
            {
                return true;
            }
        }
    	
    	return false;
    }
    
    private static boolean isAttackedLowerRight(boolean board[][], int row, int column)
    {
    	for (int i = row + 1, j = column + 1; i < board.length && j < board[0].length; i = i + 1, j = j + 1)
        {
            if (board[i][j] == true && j != column && i != row)
            {
            	return true;
            }
        }
    	
    	return false;
    }
    
    // checks if queens can be placed at provided position without being attacked from anywhere besides the current column
    private static boolean isAttackedAnywhere(boolean board[][], int row, int column)
    {    	
        return isAttackedColumn(board, row, column) ||
        		isAttackedRow(board, row, column) ||
        		isAttackedUpperLeft(board, row, column) ||
        		isAttackedUpperRight(board, row, column) ||
        		isAttackedLowerLeft(board, row, column) ||
        		isAttackedLowerRight(board, row, column);
    }
    
 // checks if queens can be placed at provided position without being attacked from anywhere
    private static boolean isAttackedAnywhereButColumn(boolean board[][], int row, int column)
    {    	
        return isAttackedRow(board, row, column) ||
        		isAttackedUpperLeft(board, row, column) ||
        		isAttackedUpperRight(board, row, column) ||
        		isAttackedLowerLeft(board, row, column) ||
        		isAttackedLowerRight(board, row, column);
    }
    
    // finds all allowed queen placements
    private static boolean solveNQueens(boolean board[][], int column)
    {
    	if (column >= board.length)
    	{
    		print(board);
    		
    		System.out.println();
     	
    		return true;
    	}

    	for (int i = 0; i < board.length; i = i + 1)
    	{
    		if (isAttackedColumn(board, i, column) == true)
    		{
    			solveNQueens(board, column + 1);
    			
    			break;
    		}
    		if (isAttackedAnywhereButColumn(board, i, column) == false)
    		{
    			board[i][column] = true;
                
    			solveNQueens(board, column + 1);

    			// backtracks:
    			board[i][column] = false;
    		}
    	}

    	return false;
    }
    
    public static void solveNQueens(boolean board[][])
    {
    	if (isBoardValid(board) == true)
    	{
    		solveNQueens(board, 0);
    	}
    }
}