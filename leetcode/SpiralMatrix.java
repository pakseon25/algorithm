// https://leetcode.com/problems/spiral-matrix/description/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int leftRight = matrix[0].length;
        int upDown = matrix.length - 1;
        // System.out.println(leftRight + "," + upDown);
        
        int x = 0;
        int y = 0;
        while (upDown >= 0 && leftRight >= 0) {
            for (int i = 0;i < leftRight && upDown >= 0 && leftRight >= 0;i++) {
                result.add(matrix[x][y]);
                // System.out.println(matrix[x][y] + " = " + leftRight + "," + upDown);
                y++;
            }
            y--;
            x++;
            leftRight--;
            
            for (int i = 0;i < upDown && upDown >= 0 && leftRight >= 0;i++) {
                result.add(matrix[x][y]);
                // System.out.println(matrix[x][y] + " = " + leftRight + "," + upDown);
                x++;
            }
            x--;
            y--;
            upDown--;
            
            for (int i = 0;i < leftRight && upDown >= 0 && leftRight >= 0;i++) {
                result.add(matrix[x][y]);
                // System.out.println(matrix[x][y] + " = " + leftRight + "," + upDown);
                y--;
            }
            y++;
            x--;
            leftRight--;
            
            for (int i = 0;i < upDown && upDown >= 0 && leftRight >= 0;i++) {
                result.add(matrix[x][y]);
                // System.out.println(matrix[x][y] + " = " + leftRight + "," + upDown);
                x--;
            }
            x++;
            y++;
            upDown--;
        }
        
        return result;
    }
}
