package _09_DynamicProgramming;

public class Substring {
    private static final String word1 = "fish";
    private static final String word2 = "hish";
    private static final String word3 = "vista";
    private static final String word4 = "fosh";
    private static final String word5 = "fort";
    private static final String word6 = "blue";
    private static final String word7 = "clues";

    public static void main(String[] args) {
        System.out.println("maximum length is " + getSubSequenceLength(word6, word7));
    }

    private static int getSubSequenceLength(String word1, String word2) {
        int[][] array = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        array[i][j] = array[i-1][j-1] + 1;
                    } else {
                        array[i][j] = 1;
                    }
                } else {
                    if (i == 0 && j > 0) {
                        array[i][j] = array[i][j-1];
                    } else if (i > 0 && j == 1) {
                        array[i][j] = array[i-1][j];
                    } else if (i > 0 && j > 0) {
                        array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
                    } else array[i][j] = 0;
                }
            }
        }
        return findMaxAndShow(array);
    }

    private static int findMaxAndShow(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[1].length; j++) {
                System.out.print(array[i][j] + "\t");
                if (array[i][j] > max)
                    max = array[i][j];
            }
            System.out.println();
        }
        return max;
    }
}
