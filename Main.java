package com.company1;

import java.util.Scanner;

public class TicTacToePvP {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ' , ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        //printBoard(board);
        printBoardWithNum();
        while (true) {
            playerTurn1(board, scanner);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);

            playerTurn2(board, scanner);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
        }
        scanner.close();
    }


    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("game status: Player 1 wins!");
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("game status: Player 2 wins!");
            return true;
        }

        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("game status: Draw!");
        return true;
    }


    private static boolean hasContestantWon(char[][] board, char symbol) {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private static void playerTurn2(char[][] board, Scanner scanner) {
        String Player2move;
        while (true) {
            System.out.println("Enter Your Move p2:");
            Player2move = scanner.nextLine();
            if (isValidMove(board, Player2move)){
                break;
            } else {
                System.out.println(Player2move + " is not a valid move.");
            }
        }
        PlaceYourMove(board, Player2move, 'O');
    }


    private static boolean isValidMove (char[][] board, String position) {
        return switch (position) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false;
        };
    }

    private static void playerTurn1(char[][] board, Scanner scanner) {
        String Player1move;
        while (true) {
            System.out.println("Enter Your Move p1:");
            Player1move = scanner.nextLine();
            if (isValidMove(board, Player1move)){
                break;
            } else {
                System.out.println(Player1move + " is not a valid move.");
            }
        }
        PlaceYourMove(board, Player1move, 'X');
    }


    private static void PlaceYourMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
            default -> System.out.println(":(");
        }
    }




    private static void printBoard(char[][] board) {
        System.out.print((board[0][0]));
        System.out.print("|");
        System.out.print((board[0][1]));
        System.out.print("|");
        System.out.println((board[0][2]));
        System.out.print((board[1][0]));
        System.out.print("|");
        System.out.print((board[1][1]));
        System.out.print("|");
        System.out.println((board[1][2]));
        System.out.print((board[2][0]));
        System.out.print("|");
        System.out.print((board[2][1]));
        System.out.print("|");
        System.out.println((board[2][2]));

    }
    private static void printBoardWithNum() {

        System.out.print("1|");
        System.out.println("2|3");
        System.out.print("4|");
        System.out.println("5|6");
        System.out.print("7|");
        System.out.println("8|9");

    }

}
