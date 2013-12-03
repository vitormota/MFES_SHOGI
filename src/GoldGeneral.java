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

// This file was genereted from "D:\\FEUP\\4o ano\\1o Semestre\\MFES\\MFES_SHOGI\\MFES_SHOGI\\classes/GoldGeneral.vdmpp".

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO
import jp.vdmtools.VDM.UTIL;
import jp.vdmtools.VDM.Record;
import jp.vdmtools.VDM.Sentinel;
import jp.vdmtools.VDM.EvaluatePP;
import jp.vdmtools.VDM.CGException;
// ***** VDMTOOLS END Name=imports



public class GoldGeneral extends Piece {


// ***** VDMTOOLS START Name=GoldGeneralSentinel KEEP=NO
  class GoldGeneralSentinel extends PieceSentinel {

    public final int GoldGeneral = 9;

    public final int validMovement = 10;

    public final int nr_functions = 11;


    public GoldGeneralSentinel () throws CGException {}


    public GoldGeneralSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=GoldGeneralSentinel
;

// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new GoldGeneralSentinel(this);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=vdm_init_GoldGeneral KEEP=NO
  private void vdm_init_GoldGeneral () {}
// ***** VDMTOOLS END Name=vdm_init_GoldGeneral


// ***** VDMTOOLS START Name=GoldGeneral KEEP=NO
  public GoldGeneral () throws CGException {
    vdm_init_GoldGeneral();
  }
// ***** VDMTOOLS END Name=GoldGeneral


// ***** VDMTOOLS START Name=GoldGeneral#1|Object KEEP=NO
  public GoldGeneral (final Object p) throws CGException {
    super(p);
    vdm_init_GoldGeneral();
  }
// ***** VDMTOOLS END Name=GoldGeneral#1|Object


// ***** VDMTOOLS START Name=validMovement#2|Cell|Cell KEEP=NO
  public Boolean validMovement (final Cell c1, final Cell c2) throws CGException {
    sentinel.entering(((GoldGeneralSentinel)sentinel).validMovement);
    try {
      Boolean rexpr_3 = null;
      if ((rexpr_3 = validGoldGeneralMove(c1, c2)).booleanValue()) 
        rexpr_3 = Boolean.valueOf(!protectingKing(c1).booleanValue());
      return rexpr_3;
    }
    finally {
      sentinel.leaving(((GoldGeneralSentinel)sentinel).validMovement);
    }
  }
// ***** VDMTOOLS END Name=validMovement#2|Cell|Cell

}
;
