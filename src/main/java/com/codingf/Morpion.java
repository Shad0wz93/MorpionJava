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

            if(line.equals("XXX")){
                return "X";
            }


            if(line.equals("OOO")){
                return "O";
            }
        }
}
