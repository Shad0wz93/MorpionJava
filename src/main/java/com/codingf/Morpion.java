package com.codingf;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Morpion {

    static String[] board;
    static String turn;
    private static Player player1;
    private static Player player2;

    private static Player takePlayerInput(int num) {
        Scanner s = new Scanner(System.in);
        System.out.println("Entrez le nom du joueur " + num + " :");
        String name = s.nextLine();
        Player p = new Player(name);
        return p;
    }



    static String checkWinner(){


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



        return null;
    }

    static void printBoard(){

        System.out.println("╔═══╦═══╦═══╗");
        System.out.println("║ " + board[0] + " ║ " + board[1] + " ║ " + board[2] + " ║");
        System.out.println("║═══╬═══╬═══║");
        System.out.println("║ " + board[3] + " ║ " + board[4] + " ║ " + board[5] + " ║");
        System.out.println("║═══╬═══╬═══║");
        System.out.println("║ " + board[6] + " ║ " + board[7] + " ║ " + board[8] + " ║");
        System.out.println("╚═══╩═══╩═══╝");
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        player1 = takePlayerInput(1);
        player2 = takePlayerInput(2);





        boolean tryagain = true ;
        while (tryagain) {
            board = new String[9];
            turn = "X";
            String winner = null;

            for (int a = 0; a < 9; a++) {
                board[a] = String.valueOf(a + 1);
            }
            System.out.println("Bienvenue !");
            System.out.println("Voici les règles du jeu : ");
            System.out.println("Se joue à 2 joueurs: X pour joueur 1 et O pour joueur 2.");
            System.out.println("Pour gagner : réaliser le premier alignement horizontal, vertical ou diagonale.");
            System.out.println("Si égalité, la partie s'arrête.");


            System.out.println(player1.getName() + " possède les pions X. Choisis une case :");
            printBoard();

            System.out.println("Joueur 1 possede les pions X. Choisis une case :");
            while (winner == null) {

                int numInput;

                try{
                    numInput = in.nextInt();

                    if(!(numInput>0 && numInput <= 9)){
                        System.out.println("Invalide. Réessayez :");
                        continue;
                    }
                }
                //si lettre selectionnée ressayer
                catch(InputMismatchException e){
                    System.out.println("Invalide. Réessayez :");
                    break;

                }


                //décide du tour entre X et O
                if (board[numInput - 1].equals(String.valueOf(numInput))) {
                    board[numInput - 1] = turn;
                    printBoard();
                    winner = checkWinner();


                    if(turn.equals("X") && winner == null){
                        turn = "O";
                        System.out.println(
                                "Au tour de " + player2.getName() + ". Entrer un nombre pour placer " + turn + " :"
                        );
                    } else if (turn.equals("O") && winner == null){
                        turn = "X";
                        System.out.println(
                                "Au tour de " + player1.getName() + ". Entrer un nombre pour placer " + turn + " :"
                        );
                    }

                } else {
                    System.out.println("Case déjà remplie. Sélectionnez une autre case :");
                }

            }

            //si personne ne gagne
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("Egalité ! Merci d'avoir joué ( vous etes tout les deux des crackes)");
            }

            //message pour le gagnant
            else {
                System.out.println("Félicitations ! " + winner + " gagne la partie. Merci d'avoir jouez !");
            }

            System.out.println("voulez-vous continuer ? :");
            Scanner scanner = new Scanner(System.in);
            String lettre = scanner.nextLine();
            if (Objects.equals(lettre, "non")) {
                tryagain = false;
            } else if (Objects.equals(lettre, "yes")) {
                tryagain = true;
                winner = null;
            } else {
                tryagain = false;
            }
        }

    }
}
