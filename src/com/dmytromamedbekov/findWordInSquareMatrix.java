package com.dmytromamedbekov;
import java.io.*;

class findWordInSquareMatrix {

    public static void main(String args[])
    {
        char[][] matrix = stringTo2DCharArray(getStringSquareMatrixFromConsole());
        String searchedWord = getStringWordFromConsole();
        startSearch(matrix,searchedWord);
    }


    //arrays of vectors to reach 4 adjacent matrix spots
    static final int[] xSearchDirectionMatrix = {-1, 0, 0,  1};
    static final int[] ySearchDirectionMatrix = { 0, -1, 1, 0};


    static void startSearch(char[][] matrix, String word)
    {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                StringBuilder orderOfLetterPositions=new StringBuilder();
                if (recursiveSubSearch(matrix, row, col, word, orderOfLetterPositions))
                    System.out.println(orderOfLetterPositions);
            }
        }
    }


    static private String getStringSquareMatrixFromConsole()
    {
        String stringArray;

        do
        {
            System.out.printf("Enter the array of symbols to form a square matrix:");
            stringArray=getStringInput();
            if (!isPerfectSquare(stringArray.length()))
            {
                System.out.println("Matrix is not square. Check its size it and try again.");
            }
        }
        while (!isPerfectSquare(stringArray.length()));

        return stringArray;
    }

    static private String getStringInput()
    {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static boolean isPerfectSquare(double x)
    {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }


    public static boolean recursiveSubSearch(char[][] matrix, int row,
                                          int col, String word, StringBuilder orderOfLetters) {

        if (matrix[row][col] != word.charAt(0))
            return false;

        int len = word.length();
        if (len==1)
            {
                orderOfLetters.append("["+col+", "+row+"]"); //row and column had to be switched to have the same order of coordinates, as in task's example
                return true;
            }

        orderOfLetters.append("["+col+", "+row+"]->");

        for (int dir = 0; dir < 4; dir++)
        {
            int rd = row + xSearchDirectionMatrix[dir], cd = col + ySearchDirectionMatrix[dir];

            if (!(rd >= matrix.length || rd < 0 || cd >= matrix.length || cd < 0) ){
                if (recursiveSubSearch(matrix, rd, cd, word.substring(1),orderOfLetters))
                        return true;
            }
        }

        return false;
    }


    private static char[][] stringTo2DCharArray(String stringMatrixFromConsole) {

        char[] stringToCharMatrix=stringMatrixFromConsole.toCharArray();

        int matrixSize =(int)(Math.sqrt(stringToCharMatrix.length));

        char[][] dimensionalMatrix=new char[matrixSize][matrixSize];

        for (int i= 0;i<matrixSize;i++)
            for (int j=0;j<matrixSize;j++)
                dimensionalMatrix[i][j]=stringToCharMatrix[j*matrixSize+i];

        return dimensionalMatrix;
    }


    static private String getStringWordFromConsole()
    {
        System.out.printf("Enter the word to be found:");
        return getStringInput();
    }
}

