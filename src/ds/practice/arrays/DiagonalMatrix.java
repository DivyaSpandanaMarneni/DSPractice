package ds.practice.arrays;

public class DiagonalMatrix {
    public int[][] printDiagonalElements(int[][] matrix) {
        int rowIndex = matrix.length;
        int colIndex = 0;

        int[][] newMatrix = new int[matrix.length + matrix[0].length -1][matrix.length];

        while (colIndex < matrix[0].length || rowIndex >= 0) {
            for(int r = 0; r < rowIndex; r++) {
                newMatrix[r + colIndex][colIndex] = matrix[r][colIndex];
                System.out.print(matrix[r][colIndex] + "\t");
            }

            for(int c = colIndex + 1; c < matrix[0].length; c++) {
                newMatrix[rowIndex-1+c][colIndex] = matrix[rowIndex-1][c];
                System.out.print(matrix[rowIndex-1][c] + "\t");
            }
            System.out.println();
            if (colIndex <= matrix[0].length)
            colIndex ++;
            if (rowIndex >= 0)
            rowIndex --;
        }

        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] input = { {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        for(int i=0; i< input.length; i++) {
            for(int j=0; j < input[0].length; j++){
                System.out.print(input[i][j] + "\t");
            }

            System.out.println();
        }
        int[][] result = new DiagonalMatrix().printDiagonalElements(input);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] != 0)
                System.out.print(result[i][j] + "\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }
}
