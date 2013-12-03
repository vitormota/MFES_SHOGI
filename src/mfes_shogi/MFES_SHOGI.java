/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mfes_shogi;

import java.util.Scanner;

import myutils.R;
import jp.vdmtools.VDM.CGException;
import jp.vdmtools.VDM.UTIL;

/**
 *
 * @author vitor_000
 */
public class MFES_SHOGI {

    private static final String INSERT_Y = "Insira o y da peca que deseja mover:";
	private static final String INSERT_X = "Insira o x da peca que deseja mover:";
	private static final String INSERT_X_FINAL = "Insira o x da celula para onde deseja mover a peca:";
	private static final String INSERT_Y_FINAL = "Insira o y da celula para onde deseja mover a peca:";

	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	try {
			Board b = Board.getInstance();
			printBoard();
	        
			while(UTIL.equals(b.getGameState(), new quotes.Playing())){
				
				while(!makeMove(s)){
					System.out.println();
					System.out.println("Movimento inalido! Tente outra vez.");
					System.out.println();
				}
		        
		        printBoard();
			}
	        
		} catch (CGException e1) {
			e1.printStackTrace();
		}
    	finally{
    		s.close();
    	}
   
        
        
    }

	private static boolean makeMove(Scanner s) {
		System.out.println();
		
		int xi = inputInt(s,INSERT_X);
		int yi = inputInt(s,INSERT_Y);
		int xf = inputInt(s, INSERT_X_FINAL);
		int yf = inputInt(s, INSERT_Y_FINAL);
		
		
		try {
			Board.getInstance().move(Board.getInstance().getCell(xi, yi), Board.getInstance().getCell(xf, yf));
			return true;
		} catch (CGException e) {
			return false;
		}
	}

	private static int inputInt(Scanner s, String message) {
		System.out.println(message);
		String str = s.nextLine();
		while(!validInt(str)){
			System.out.println("Input invalido! Tente novamente:");
			str = s.nextLine();
		}
		return Integer.parseInt(str);
	}
	
	private static boolean validInt(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	private static void printBoard() {
		try {
			Board b = Board.getInstance();
			
			System.out.print("   ");
			for(int x=1; x <=9; x++){
				System.out.print(" " + x + "  ");
			}
			System.out.println();
			System.out.print("  ");
			for(int x=1; x <=9; x++){
				System.out.print("----");
			}
			System.out.println();
			
			for(int y=9; y> 0; y-- )
			{
				System.out.print(y + "| ");
				for(int x=1; x<=9; x++)
				{
					Cell c = b.getCell(x, y);
					
					if( c.piece != null ){
						prettyPrint(c.piece.getClass().getName(), c.piece.belongTo);
						System.out.print(" ");
					}
					else
						System.out.print("    ");
				}
				System.out.println();
			}
		} catch (CGException e) {
			e.printStackTrace();
		}
	}
    
    private static void prettyPrint(String className, Object belongTo){
    	switch(className){
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
		if (UTIL.equals(belongTo, new quotes.White()))
			System.out.print("W");
		else
			System.out.print("B");
	}
    
}
