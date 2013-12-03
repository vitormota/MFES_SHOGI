//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2013-12-02 by the VDM++ to JAVA Code Generator
// (v9.0.2 - Thu 14-Mar-2013 12:36:47 +0900)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// This file was genereted from "D:\\FEUP\\4o ano\\1o Semestre\\MFES\\MFES_SHOGI\\MFES_SHOGI\\classes/King.vdmpp".

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO
import jp.vdmtools.VDM.UTIL;
import jp.vdmtools.VDM.Record;
import jp.vdmtools.VDM.Sentinel;
import jp.vdmtools.VDM.EvaluatePP;
import jp.vdmtools.VDM.CGException;
// ***** VDMTOOLS END Name=imports



public class King extends Piece {


// ***** VDMTOOLS START Name=KingSentinel KEEP=NO
  class KingSentinel extends PieceSentinel {

    public final int King = 9;

    public final int validMovement = 10;

    public final int nr_functions = 11;


    public KingSentinel () throws CGException {}


    public KingSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=KingSentinel
;

// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new KingSentinel(this);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=vdm_init_King KEEP=NO
  private void vdm_init_King () {}
// ***** VDMTOOLS END Name=vdm_init_King


// ***** VDMTOOLS START Name=King KEEP=NO
  public King () throws CGException {
    vdm_init_King();
  }
// ***** VDMTOOLS END Name=King


// ***** VDMTOOLS START Name=King#1|Object KEEP=NO
  public King (final Object p) throws CGException {
    super(p);
    vdm_init_King();
  }
// ***** VDMTOOLS END Name=King#1|Object


// ***** VDMTOOLS START Name=validMovement#2|Cell|Cell KEEP=NO
  public Boolean validMovement (final Cell c1, final Cell c2) throws CGException {
    sentinel.entering(((KingSentinel)sentinel).validMovement);
    try {
      Boolean rexpr_3 = null;
      if ((rexpr_3 = validKingMove(c1, c2)).booleanValue()) {
        Board obj_10 = Board.getInstance();
        rexpr_3 = Boolean.valueOf(!obj_10.check(belongTo, c2).booleanValue());
      }
      return rexpr_3;
    }
    finally {
      sentinel.leaving(((KingSentinel)sentinel).validMovement);
    }
  }
// ***** VDMTOOLS END Name=validMovement#2|Cell|Cell

}
;
