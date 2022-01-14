package com.interview.amazon.oa;

/**
 * You are given an encoded string  and number of rows, Convert it to original string
 * <p>
 * Input: mnesi___ya__k____mime  N = 3
 * <p>
 * Output : my name is mike
 * <p>
 * Explanation : Read the matrix in a diagonal way starting from [0][0] index until the end of row and start from the top
 * again to decode it. _ are treated as space.
 * <p>
 * m n e s i _  _
 * <p>
 * _ y a _ _ k _
 * <p>
 * _ _ _ m i m e
 */
public class DecodeInputString {
    public static void main(String[] args) {
        String input = "mnesi___ya__k____mime";
        int numberOfRows = 3;

        //convert to 2D char array
        char[][] arr = new char[numberOfRows][input.length() / numberOfRows];
        int rowIdx = 0;
        int colIdx = 0;
        for (char c : input.toCharArray()) {
            arr[rowIdx][colIdx++] = c;
            if (colIdx == input.length() / numberOfRows) {
                rowIdx++;
                colIdx = 0;
            }
        }
        StringBuilder result = new StringBuilder();
        int row = 0;

        for (int j = 0; j < arr[0].length; j++) {
            int col = j;
            while (col < arr[0].length && row < arr.length) {
                if (arr[row][col] == '_')
                    result.append(" ");
                else
                    result.append(arr[row][col]);
                row++;
                col++;
            }
            row = 0;
        }
        System.out.println(result.toString().trim());
    }
}
