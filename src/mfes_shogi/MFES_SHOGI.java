/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfes_shogi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import myutils.R;
import jp.vdmtools.VDM.CGException;
import jp.vdmtools.VDM.UTIL;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author vitor_000
 */
public class MFES_SHOGI {

    private static final String INSERT_Y = "Insira o y da peca que deseja mover:";
    private static final String INSERT_X = "Insira o x da peca que deseja mover:";
    private static final String INSERT_X_FINAL = "Insira o x da celula para onde deseja mover a peca:";
    private static final String INSERT_Y_FINAL = "Insira o y da celula para onde deseja mover a peca:";

    public static final String PLAYER = "PLAYER ";

    private static Board inst;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            Board b = Board.getInstance();
            inst = b;
            printBoard();

            while (UTIL.equals(b.getGameState(), new quotes.Playing())) {

                while (!makeMove(s)) {
                    System.out.println();

                }

                //printBoard();
            }

        } catch (CGException e1) {
            e1.printStackTrace();
        } finally {
            s.close();
        }

    }

    private static boolean makeMove(Scanner s) {
        System.out.println();

        //Make move 
        System.out.println(PLAYER + getBelongTo(inst.turn) + ":");
        try {

            parsePlayerInput(s);
            printBoard();
            //*********************OLD********************
//            int xi = inputInt(s, INSERT_X);
//            int yi = inputInt(s, INSERT_Y);
//            int xf = inputInt(s, INSERT_X_FINAL);
//            int yf = inputInt(s, INSERT_Y_FINAL);
//            Board.getInstance().move(Board.getInstance().getCell(xi, yi), Board.getInstance().getCell(xf, yf));
            //********************************************
            return true;
        } catch (CGException e) {
            if (e.getMessage() != null) {
                System.out.println(e.getMessage());
            }
            return false;
        }
    }

    private static int inputInt(Scanner s, String message) {
        System.out.println(message);
        String str = s.nextLine();
        while (!validInt(str)) {
            System.out.println("Input invalido! Tente novamente:");
            str = s.nextLine();
        }
        return Integer.parseInt(str);
    }

    private static boolean validInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void printBoard() {
        try {
            Board b = Board.getInstance();

            System.out.print("   ");
            for (int x = 1; x <= 9; x++) {
                System.out.print(" " + x + "  ");
            }
            System.out.println();
            System.out.print("  ");
            for (int x = 1; x <= 9; x++) {
                System.out.print("----");
            }
            System.out.println();

            for (int y = 9; y > 0; y--) {
                System.out.print(y + "| ");
                for (int x = 1; x <= 9; x++) {
                    Cell c = b.getCell(x, y);

                    if (c.piece != null) {
                        prettyPrint(c.piece.getClass().getName(), c.piece.belongTo);
                        System.out.print(" ");
                    } else {
                        System.out.print("    ");
                    }
                }
                System.out.println();
            }
        } catch (CGException e) {
            e.printStackTrace();
        }
    }

    private static void prettyPrint(String className, Object belongTo) {
        switch (className) {
            case R.BISHOP:
                System.out.print("Bi");
                printBelongTo(belongTo);
                break;
            case R.GOLDGENERAL:
                System.out.print("Go");
                printBelongTo(belongTo);
                break;
            case R.KING:
                System.out.print("Ki");
                printBelongTo(belongTo);
                break;
            case R.KNIGHT:
                System.out.print("Kn");
                printBelongTo(belongTo);
                break;
            case R.LANCE:
                System.out.print("La");
                printBelongTo(belongTo);
                break;
            case R.PAWN:
                System.out.print("Pa");
                printBelongTo(belongTo);
                break;
            case R.ROOK:
                System.out.print("Ro");
                printBelongTo(belongTo);
                break;
            case R.SILVERGENERAL:
                System.out.print("Si");
                printBelongTo(belongTo);
                break;
            default:
                System.out.print("Un");
                printBelongTo(belongTo);
                break;
        }
    }

    private static void printBelongTo(Object belongTo) {
        if (UTIL.equals(belongTo, new quotes.White())) {
            System.out.print("W");
        } else {
            System.out.print("B");
        }
    }

    private static String getBelongTo(Object turn) {
        if (UTIL.equals(turn, new quotes.White())) {
            return "White";
        } else {
            return "Black";
        }
    }

    private static void parsePlayerInput(Scanner read) throws CGException {
        String input = read.nextLine();
        String action = input.split(" ")[0];
        if (action.equalsIgnoreCase("L")) {
            //list pieces
            Map m;
            m = inst.getCapturedPieces();
            List arr = (ArrayList) m.get(inst.turn);
            printArray(arr);
            throw new CGException();
        } else if (action.equalsIgnoreCase("B")) {
            //do none means print board
        } else if (action.equalsIgnoreCase("D")) {
            //drop piece
            List pieces = (ArrayList) inst.getCapturedPieces().get(inst.turn);
            if (pieces.isEmpty()) {
                //no pieces to drop
                throw new CGException("No pieces to drop.");
            }
            //list possible pieces
            printArray(pieces);
            //select one to drop and where to drop it
            System.out.print("Choose piece to drop\n->");
            int index = -1, x, y;
            String coords;
            do {
                try {
                    index = read.nextInt();
                    read.nextLine();
                    System.out.print("\nNow enter coordinates(x y)\n->");
                    coords = read.nextLine();
                    x = Integer.parseInt(coords.split(" ")[0]);
                    y = Integer.parseInt(coords.split(" ")[1]);
                    break;
                } catch (InputMismatchException ex) {
                    //invalid input
                }
            } while (true);
            inst.dropPiece(inst.getCell(x, y), (Piece) pieces.get(index));
        } else if (action.equalsIgnoreCase("M")) {
            //move piece
            int fromX, fromY, toX, toY;
            try {
                fromX = Integer.parseInt(input.split(" ")[1]);
                fromY = Integer.parseInt(input.split(" ")[2]);
                toX = Integer.parseInt(input.split(" ")[3]);
                toY = Integer.parseInt(input.split(" ")[4]);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please try again...");
                throw new CGException();
            }
            //actual move
            inst.move(inst.getCell(fromX, fromY), inst.getCell(toX, toY));
            //if reached and meets condition, ask user to promote piece
            //if (inst.getCell(toX, toY).promotionZone(inst.getCell(toX, toY).piece) || inst.getCell(fromX, fromY).promotionZone(inst.getCell(toX, toY).piece)) {
            if (inst.getPossibleToPromote()) {
                //where the piece landed it can be promoted || where the piece was it can be promoted
                do {
                    System.out.println("Promote moved piece?(Y/N): ");
                    char answer = read.nextLine().toCharArray()[0];
                    if (answer == 'Y' || answer == 'y') {
                        //promote
                        inst.promote();
                        break;
                    } else if (answer == 'N' || answer == 'n') {
                        //move on
                        break;
                    } else {
                        //not valid answer
                    }
                } while (true);
            }
            inst.endRound();
        } else if (action.equalsIgnoreCase(
                "H")) {
            //help command
            printHelp();
            throw new CGException();
        } else if (action.equalsIgnoreCase(
                "!")) {
            //exit command
            System.exit(0);
        } else {
            //no valid action
            System.out.println("Bad input action, try 'h' for help.");
            throw new CGException();
        }

    }

    private static void printArray(List arr) {
        int i = 0;
        for (Object p : arr) {
            Piece piece = (Piece) p;
            System.out.print(i++ + " - ");
            System.out.println(piece.toString());
        }
    }

    private static void printHelp() {
        System.out.println("------>Help: \n");
        System.out.println("Move -> m x1 y1 x2 y2");
        System.out.println("List captured pieces -> l");
        System.out.println("Drop piece -> d");
        System.out.println("Print Board -> b");
        System.out.println("Help -> h");
        System.out.println("Exit -> !");
        System.out.println("------>End help");
    }

}
