package ds.practice.arrays;


public class NumberOfClusters {

    final static int[] offsets = {-1, 0 ,1};

    // ineffective because of O(n^2) complexity and lot of if else conditions
    public int getClustersCount(int[][] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (i == 0) {
                    if (j ==0) {
                        if (input[i][j] == 1)
                            count ++;
                    } else {
                        if (input[i][j] == 1 && input[i][j-1] != 1)
                            count ++;
                    }
                } else if (j ==0) {
                    if (input[i][j] == 1 && input[i-1][j] == 0 && input[i-1][j+1] == 0)
                        count++;

                } else {
                    if( j <= input[0].length -2) {
                        if( input[i][j] == 1 && input[i][j-1] == 0 && input[i-1][j-1] == 0 && input[i-1][j] == 0 )
                            count++;
                    }
                    else if( input[i][j] == 1 && input[i][j-1] == 0 && input[i-1][j-1] == 0 && input[i-1][j] == 0 && input[i-1][j+1] == 0)
                        count++;

                }
            }
        }
        return count;
    }

    //DFS helper
    public boolean unVisitedNeighbor(int[][] matrix, int i, int j) {
       if(i>=0 && j >=0 && i<matrix.length && j <matrix[0].length && matrix[i][j] == 1)
           return true;

       return false;
    }

    private void dfsOfVisited(int[][] matrix, int i, int j, boolean[][] visited) {

        if(visited[i][j])
            return;

        visited[i][j] = true;
        int xOffset, yOffset;

        for(int l= 0; l < offsets.length; l ++) {
            xOffset = offsets[l];

            for(int m=0;m<offsets.length; m ++) {
                yOffset = offsets[m];
                if (xOffset==0 && yOffset == 0)
                    continue;

                if(unVisitedNeighbor(matrix, i + xOffset, j + yOffset)) {
                    dfsOfVisited(matrix, i+xOffset, j+yOffset, visited);
                }

            }
        }

    }

    // using graph technique
    public int getClustersCountOpt(int[][] input) {
        int count = 0;
        boolean[][] visited = new boolean[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j] == 1 && visited[i][j] == false) {
                    count++;
                    dfsOfVisited(input, i, j, visited);
                }



            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] input = {{1,0,1,0,1}, {1,1,0,0,0}, {0,1,0,1,1}};


        System.out.println("final count: " + new NumberOfClusters().getClustersCount(input));
        System.out.println("final count with DFS: " + new NumberOfClusters().getClustersCountOpt(input));
    }
}
