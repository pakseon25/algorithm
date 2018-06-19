/*
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
*/

class GameOfLife {
    public static final int LIVE = 1;
    public static final int DIE = 0;

    public void gameOfLife(int[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;
        
        List<int[]> changes = new LinkedList<>();

        for (int row = 0;row < board.length;row++) {
            for (int col = 0; col < board[0].length;col++) {
                int nextState = getNextState(board, row, col);
                if (board[row][col] != nextState) {
                    changes.add(new int[] {row, col, nextState});
                }
            }
        }
        
        for (int[] ch : changes) {
            board[ch[0]][ch[1]] = ch[2];
        }
    }
    
    
    public int getNextState(int[][] board, int row, int col) {
        int liveNeighbors = countLiveNeighbors(board, row, col);
        
        if (board[row][col] == LIVE) {
            if (liveNeighbors == 2 || liveNeighbors == 3) {
                return LIVE;
            }
        }
        else {
            if (liveNeighbors == 3) {
                return LIVE;
            }
        }
        
        return DIE;
    }
    
    public int[][] eightDirs = new int[][] {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}};
    
    public int countLiveNeighbors(int[][] board, int row, int col) {
        int liveNeighbors = 0;
        for (int[] xyDir : eightDirs) {
            int rowMove = row + xyDir[0];
            int colMove = col + xyDir[1];
            if (rowMove >= 0 && rowMove < board.length && colMove >= 0 && colMove < board[0].length) {
                if (board[rowMove][colMove] == LIVE) {
                    liveNeighbors++;
                }
            }
        }
        return liveNeighbors;
    }
}