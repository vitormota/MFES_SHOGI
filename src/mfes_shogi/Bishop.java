package mfes_shogi;

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

// This file was genereted from "D:\\FEUP\\4o ano\\1o Semestre\\MFES\\MFES_SHOGI\\MFES_SHOGI\\classes/Bishop.vdmpp".

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import jp.vdmtools.VDM.UTIL;
import jp.vdmtools.VDM.Record;
import jp.vdmtools.VDM.Sentinel;
import jp.vdmtools.VDM.EvaluatePP;
import jp.vdmtools.VDM.CGException;
// ***** VDMTOOLS END Name=imports



public class Bishop extends Piece {


// ***** VDMTOOLS START Name=BishopSentinel KEEP=NO
  class BishopSentinel extends PieceSentinel {

    public final int Bishop = 9;

    public final int validMovement = 10;

    public final int nr_functions = 11;


    public BishopSentinel () throws CGException {}


    public BishopSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=BishopSentinel
;

// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new BishopSentinel(this);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=vdm_init_Bishop KEEP=NO
  private void vdm_init_Bishop () {}
// ***** VDMTOOLS END Name=vdm_init_Bishop


// ***** VDMTOOLS START Name=Bishop KEEP=NO
  public Bishop () throws CGException {
    vdm_init_Bishop();
  }
// ***** VDMTOOLS END Name=Bishop


// ***** VDMTOOLS START Name=Bishop#1|Object KEEP=NO
  public Bishop (final Object p) throws CGException {
    super(p);
    vdm_init_Bishop();
  }
// ***** VDMTOOLS END Name=Bishop#1|Object


// ***** VDMTOOLS START Name=validMovement#2|Cell|Cell KEEP=NO
  public Boolean validMovement (final Cell c1, final Cell c2) throws CGException {
    sentinel.entering(((BishopSentinel)sentinel).validMovement);
    try {
      Boolean rexpr_3 = null;
      Boolean var1_4 = null;
      Boolean var1_5 = null;
      if ((var1_5 = Boolean.valueOf(Math.abs(((c1.x).intValue() - (c2.x).intValue())) == Math.abs(((c1.y).intValue() - (c2.y).intValue())))).booleanValue()) {
        boolean tmpQuant_20 = true;
        {
          Set e1_set_26 = intermediateVals((c1.x), (c2.x));
          Set e1_set_32 = intermediateVals((c1.y), (c2.y));
          Number xi = null;
          Number yi = null;
          Set tmpSet_85 = new HashSet(e1_set_32);
          for (Iterator enm_84 = tmpSet_85.iterator(); enm_84.hasNext() && tmpQuant_20; ) {
            Number elem_83 = UTIL.NumberToInt(enm_84.next());
            /* yi */
            yi = elem_83;
            Set tmpSet_82 = new HashSet(e1_set_26);
            for (Iterator enm_81 = tmpSet_82.iterator(); enm_81.hasNext() && tmpQuant_20; ) {
              Number elem_80 = UTIL.NumberToInt(enm_81.next());
              /* xi */
              xi = elem_80;
              Boolean pred_33 = null;
              Boolean var1_34 = null;
              Boolean var1_35 = null;
              Boolean var1_36 = null;
              Boolean var1_37 = null;
              Boolean var1_38 = null;
              if ((var1_38 = Boolean.valueOf(Math.abs(((c1.x).intValue() - xi.intValue())) == Math.abs(((c1.y).intValue() - yi.intValue())))).booleanValue()) {
                Board obj_54 = Board.getInstance();
                var1_38 = Boolean.valueOf(UTIL.equals((obj_54.getCell(xi, yi).piece), null));
              }
              if (!(var1_37 = var1_38).booleanValue()) 
                var1_37 = Boolean.valueOf(xi.intValue() == (c1.x).intValue());
              if (!(var1_36 = var1_37).booleanValue()) 
                var1_36 = Boolean.valueOf(xi.intValue() == (c2.x).intValue());
              if (!(var1_35 = var1_36).booleanValue()) 
                var1_35 = Boolean.valueOf(yi.intValue() == (c1.y).intValue());
              if (!(var1_34 = var1_35).booleanValue()) 
                var1_34 = Boolean.valueOf(yi.intValue() == (c2.y).intValue());
              if (!(pred_33 = var1_34).booleanValue()) {
                Boolean var2_74 = null;
                if ((var2_74 = promoted).booleanValue()) 
                  var2_74 = validKingMove(c1, c2);
                pred_33 = var2_74;
              }
              if (!pred_33.booleanValue()) 
                tmpQuant_20 = false;
            }
          }
        }
        var1_5 = Boolean.valueOf(tmpQuant_20);
      }
      if ((var1_4 = var1_5).booleanValue()) {
        Boolean var2_86 = null;
        if (!(var2_86 = Boolean.valueOf(UTIL.equals((c2.piece), null))).booleanValue()) {
          Boolean var2_91 = null;
          if ((var2_91 = Boolean.valueOf(!UTIL.equals((c2.piece), null))).booleanValue()) 
            var2_91 = Boolean.valueOf(!UTIL.equals(((c2.piece).belongTo), ((c1.piece).belongTo)));
          var2_86 = var2_91;
        }
        var1_4 = var2_86;
      }
      if ((rexpr_3 = var1_4).booleanValue()) 
        rexpr_3 = Boolean.valueOf(!protectingKing(c1).booleanValue());
      return rexpr_3;
    }
    finally {
      sentinel.leaving(((BishopSentinel)sentinel).validMovement);
    }
  }
// ***** VDMTOOLS END Name=validMovement#2|Cell|Cell

}
;