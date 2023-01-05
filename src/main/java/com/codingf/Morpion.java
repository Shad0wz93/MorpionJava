package com.codingf;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Morpion {

    static String[] board;
    static String turn;

    static String checkWinner() {

        for(int a=0; a<8; a++){
            String line = null;

            switch(a){
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            //for X winner
            if(line.equals("XXX")){
                return "X";
            }

            //for O winner
            if(line.equals("OOO")){
                return "O";
            }
        }

        for(int a=0; a < 9; a++){
            if(Arrays.asList(board).contains(String.valueOf(a + 1))){
                break;
            }
            else if(a == 8) {
                return "draw";
            }
        }

        System.out.println(
                turn + "'s turn. Enter a slot number to place " + turn + " in :"
        );

        return null;
    }

    static void printBoard(){

        System.out.println("+---+---+---+");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|---+---+---|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|---+---+---|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("+---+---+---+");
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for(int a = 0; a < 9; a++){
            board[a] = String.valueOf( a + 1 );
        }

        System.out.println("Bienvenue !");
        System.out.println("Voici les règles du jeu : ");
        System.out.println("Se joue à 2 joueurs: X pour joueur 1 et O pour joueur 2.");
        System.out.println("Pour gagner : réaliser le premier alignement horizontal, vertical ou diagonale.");
        System.out.println("Si égalité, la partie s'arrête.");
        printBoard();

        System.out.println("Joueur 1 possede les pions X. Choisis une case :");

        while(winner == null){
            int numInput;

            try{
                numInput = in.nextInt();

                if(!(numInput>0 && numInput <= 9)){
                    System.out.println("Invalide. Reessaye :");
                    continue;
                }
            }

            catch(InputMismatchException e){
                System.out.println("Invalide. Reessaye :");
                continue;
            }

            //dÃ©cide du tour entre X et O
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

        //message pour le gagnant
        else{
            System.out.println("Felicitations ! " + winner + " gagne la partie. Merci d'avoir joue !");
        }
    }
}
