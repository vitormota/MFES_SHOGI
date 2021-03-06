package mfes_shogi;

// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2013-12-08 by the VDM++ to JAVA Code Generator
// (v9.0.2 - Thu 14-Mar-2013 12:36:47 +0900)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// This file was genereted from "D:\\FEUP\\4o ano\\1o Semestre\\MFES\\MFES_SHOGI\\MFES_SHOGI\\classes/SilverGeneral.rtf".

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO
import jp.vdmtools.VDM.UTIL;
import jp.vdmtools.VDM.Record;
import jp.vdmtools.VDM.Sentinel;
import jp.vdmtools.VDM.EvaluatePP;
import jp.vdmtools.VDM.CGException;
// ***** VDMTOOLS END Name=imports



public class SilverGeneral extends Piece {


// ***** VDMTOOLS START Name=SilverGeneralSentinel KEEP=NO
  class SilverGeneralSentinel extends PieceSentinel {

    public final int SilverGeneral = 10;

    public final int validMovement = 11;

    public final int nr_functions = 12;


    public SilverGeneralSentinel () throws CGException {}


    public SilverGeneralSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=SilverGeneralSentinel
;

// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new SilverGeneralSentinel(this);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=vdm_init_SilverGeneral KEEP=NO
  private void vdm_init_SilverGeneral () {}
// ***** VDMTOOLS END Name=vdm_init_SilverGeneral


// ***** VDMTOOLS START Name=SilverGeneral KEEP=NO
  public SilverGeneral () throws CGException {
    vdm_init_SilverGeneral();
  }
// ***** VDMTOOLS END Name=SilverGeneral


// ***** VDMTOOLS START Name=SilverGeneral#1|Object KEEP=NO
  public SilverGeneral (final Object p) throws CGException {
    super(p);
    vdm_init_SilverGeneral();
  }
// ***** VDMTOOLS END Name=SilverGeneral#1|Object


// ***** VDMTOOLS START Name=validMovement#2|Cell|Cell KEEP=NO
  public Boolean validMovement (final Cell c1, final Cell c2) throws CGException {
    sentinel.entering(((SilverGeneralSentinel)sentinel).validMovement);
    try {
      if (promoted.booleanValue()) 
        return validGoldGeneralMove(c1, c2);
      else {
        Boolean rexpr_4 = null;
        Boolean var1_5 = null;
        if ((var1_5 = Boolean.valueOf((c1.x).intValue() == (c2.x).intValue())).booleanValue()) 
          var1_5 = Boolean.valueOf((c1.y).intValue() == ((c2.y).intValue() + direction().intValue()));
        if (!(rexpr_4 = var1_5).booleanValue()) {
          Boolean var2_18 = null;
          Boolean var1_19 = null;
          Boolean var1_20 = null;
          if ((var1_20 = Boolean.valueOf(Math.abs(((c1.x).intValue() - (c2.x).intValue())) == Math.abs(((c1.y).intValue() - (c2.y).intValue())))).booleanValue()) 
            var1_20 = Boolean.valueOf(Math.abs(((c1.x).intValue() - (c2.x).intValue())) == 1);
          if ((var1_19 = var1_20).booleanValue()) 
            var1_19 = notFriend(c1, c2);
          if ((var2_18 = var1_19).booleanValue()) 
            var2_18 = Boolean.valueOf(!protectingKing(c1, c2).booleanValue());
          rexpr_4 = var2_18;
        }
        return rexpr_4;
      }
    }
    finally {
      sentinel.leaving(((SilverGeneralSentinel)sentinel).validMovement);
    }
  }
// ***** VDMTOOLS END Name=validMovement#2|Cell|Cell

}
;
