class Solution {
    public void solveSudoku(char[][] board) {
        
         sudokoSolver(board,0,0);
        printArr(board);
    }

public static void printArr(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

public static boolean sudokoSolver(char[][] arr, int row, int col) {
        if (row == arr.length) {
            row = 0;
            col = col + 1;
        }

        if (col == arr.length) {
            return true;
        }

        if (arr[row][col] != '.') {
            return sudokoSolver(arr, row + 1, col);
        }

        for (int i = 1; i <= arr.length; i++) {
            if (isSafe(arr, row, col, i)) {
                arr[row][col] = (char)('0' + i);
                if (sudokoSolver(arr, row + 1, col)) {
                    return true;
                }
                arr[row][col] = '.';
            }
        }

        return false;
    }

    public static boolean isSafe(char[][] arr, int row, int col, int digit) {

                    char ch= (char)('0' + digit);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] == ch) {
                return false;
            }

            if (arr[row][i] == ch) {
                return false;
            }
        }

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {

                if (arr[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }

}