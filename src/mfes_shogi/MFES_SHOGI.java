/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mfes_shogi;

import myutils.R;
import jp.vdmtools.VDM.CGException;
import jp.vdmtools.VDM.UTIL;

/**
 *
 * @author vitor_000
 */
public class MFES_SHOGI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
			Board b = Board.getInstance();
			
			for(int y=1; y<= 9; y++ )
			{
				for(int x=1; x<=9; x++)
				{
					Cell c = b.getCell(x, y);
					
					if( c.piece != null ){
						prettyPrint(c.piece.getClass().getName(), c.piece.belongTo);
						System.out.print(" ");
					}
					else
						System.out.print(" -  ");
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
