import java.util.InputMismatchException;
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


        while(winner==null){

            int numInput;

            //gère les exceptions pour les inputs
            try{
                numInput = in.nextInt();

                if(!(numInput>0 && numInput <= 9)){
                    System.out.println("Invalide. Reessaye :");
                    continue;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalide. Reessaye :");
                in.nextLine();
                continue;
            }

            //décide du tour entre X et O
            if(board[numInput - 1].equals(String.valueOf(numInput))){
                board[numInput - 1] = turn;

                if(turn.equals("X")){
                    turn = "O";
                }
                else{
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }
            else{
                System.out.println("Case deja remplie. Selectionne une autre case :");
            }

        }

        //si personne ne gagne
        if(winner.equalsIgnoreCase("draw")){
            System.out.println("Egalite ! Merci d'avoir joue.");
        }
    }

}

