import java.util.Scanner;

package com.codingf;

public class Morpion {

    static String[] board;

    static String turn;

    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for(int a = 0; a < 9; a++){
            board[a] = String.valueOf( a + 1 );
        }

        System.out.println("Bienvenue");
        printBoard();

        System.out.println("Joueur 1 possede les pions X. Choisis une case :");
    }

}

