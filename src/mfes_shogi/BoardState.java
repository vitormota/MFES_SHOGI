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

// This file was genereted from "D:\\FEUP\\4o ano\\1o Semestre\\MFES\\MFES_SHOGI\\MFES_SHOGI\\classes/BoardState.vdmpp".

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import jp.vdmtools.VDM.UTIL;
import jp.vdmtools.VDM.Record;
import jp.vdmtools.VDM.Sentinel;
import jp.vdmtools.VDM.EvaluatePP;
import jp.vdmtools.VDM.CGException;
// ***** VDMTOOLS END Name=imports



public class BoardState implements EvaluatePP {

// ***** VDMTOOLS START Name=capturedPieces KEEP=NO
  private volatile Map capturedPieces = new HashMap();
// ***** VDMTOOLS END Name=capturedPieces

// ***** VDMTOOLS START Name=lines KEEP=NO
  public volatile Map lines = new HashMap();
// ***** VDMTOOLS END Name=lines

// ***** VDMTOOLS START Name=turn KEEP=NO
  public volatile Object turn = null;
// ***** VDMTOOLS END Name=turn

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=BoardStateSentinel KEEP=NO
  class BoardStateSentinel extends Sentinel {

    public final int vdm_equals = 0;

    public final int BoardState = 1;

    public final int linesEquals = 2;

    public final int playerEquals = 3;

    public final int capturedEquals = 4;

    public final int nr_functions = 5;


    public BoardStateSentinel () throws CGException {}


    public BoardStateSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=BoardStateSentinel
;

// ***** VDMTOOLS START Name=evaluatePP#1|int KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return Boolean.TRUE;
  }
// ***** VDMTOOLS END Name=evaluatePP#1|int


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new BoardStateSentinel(this);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=vdm_init_BoardState KEEP=NO
  private void vdm_init_BoardState () {
    try {
      setSentinel();
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=vdm_init_BoardState


// ***** VDMTOOLS START Name=BoardState KEEP=NO
  public BoardState () throws CGException {
    vdm_init_BoardState();
  }
// ***** VDMTOOLS END Name=BoardState


// ***** VDMTOOLS START Name=BoardState#3|List|Map|Object KEEP=NO
  public BoardState (final List state, final Map captured, final Object t) throws CGException {
    vdm_init_BoardState();
    Map res_m_5 = new HashMap();
    {
      Set e_set_15 = new HashSet();
      e_set_15 = new HashSet();
      for (int count_18 = 1; count_18 <= 9; count_18++) 
        e_set_15.add(new Integer(count_18));
      Number y = null;
      Set tmpSet_24 = new HashSet(e_set_15);
      for (Iterator enm_23 = tmpSet_24.iterator(); enm_23.hasNext(); ) {
        Number elem_22 = UTIL.NumberToInt(enm_23.next());
        /* y */
        y = elem_22;
        List arg_8 = null;
        if ((1 > y.intValue()) || (y.intValue() > state.size())) 
          UTIL.RunTime("Illegal index");
        arg_8 = Board.mapStartSeq(UTIL.ConvertToList(state.get(y.intValue() - 1)), new Integer(1), y);
        res_m_5.put(y, new BoardLine(arg_8, y));
      }
    }
    lines = (Map)UTIL.clone(res_m_5);
    Map rhs_26 = new HashMap();
    if (!(((Object)rhs_26) instanceof Map)) 
      UTIL.RunTime("Incompatible type");
    capturedPieces = (Map)UTIL.clone(rhs_26);
    Map rhs_27 = new HashMap();
    rhs_27 = new HashMap(capturedPieces);
    rhs_27.putAll(captured);
    capturedPieces = (Map)UTIL.clone(rhs_27);
    if (UTIL.equals(t, new quotes.White())) 
      turn = new quotes.White();
    else 
      turn = new quotes.Black();
  }
// ***** VDMTOOLS END Name=BoardState#3|List|Map|Object


// ***** VDMTOOLS START Name=vdm_equals#1|Board KEEP=NO
  public Boolean vdm_equals (final Board b) throws CGException {
    sentinel.entering(((BoardStateSentinel)sentinel).vdm_equals);
    try {
      Boolean rexpr_2 = null;
      if ((rexpr_2 = linesEquals(b.getLines())).booleanValue()) 
        rexpr_2 = capturedEquals(b.getCapturedPieces());
      return rexpr_2;
    }
    finally {
      sentinel.leaving(((BoardStateSentinel)sentinel).vdm_equals);
    }
  }
// ***** VDMTOOLS END Name=vdm_equals#1|Board


// ***** VDMTOOLS START Name=linesEquals#1|Map KEEP=NO
  private Boolean linesEquals (final Map l) throws CGException {
    sentinel.entering(((BoardStateSentinel)sentinel).linesEquals);
    try {
      {
        Set iset_6 = new HashSet(l.keySet());
        Set tmpSet_114 = new HashSet(iset_6);
        for (Iterator enm_113 = tmpSet_114.iterator(); enm_113.hasNext(); ) {
          Number elem_2 = UTIL.NumberToInt(enm_113.next());
          Number y = null;
          /* y */
          y = elem_2;
          {
            Set iset_9 = new HashSet();
            iset_9 = new HashSet();
            for (int count_12 = 1; count_12 <= 9; count_12++) 
              iset_9.add(new Integer(count_12));
            Set iset_15 = iset_9;
            Set tmpSet_112 = new HashSet(iset_15);
            for (Iterator enm_111 = tmpSet_112.iterator(); enm_111.hasNext(); ) {
              Number elem_7 = UTIL.NumberToInt(enm_111.next());
              Number x = null;
              /* x */
              x = elem_7;
              Boolean cond_16 = null;
              Boolean var1_17 = null;
              BoardLine obj_24 = (BoardLine)l.get(y);
              if ((var1_17 = Boolean.valueOf(UTIL.equals((obj_24.getCell(x).piece), null))).booleanValue()) {
                BoardLine obj_33 = (BoardLine)lines.get(y);
                var1_17 = Boolean.valueOf(!UTIL.equals((obj_33.getCell(x).piece), null));
              }
              if (!(cond_16 = var1_17).booleanValue()) {
                Boolean var2_36 = null;
                BoardLine obj_43 = (BoardLine)l.get(y);
                if ((var2_36 = Boolean.valueOf(!UTIL.equals((obj_43.getCell(x).piece), null))).booleanValue()) {
                  BoardLine obj_52 = (BoardLine)lines.get(y);
                  var2_36 = Boolean.valueOf(UTIL.equals((obj_52.getCell(x).piece), null));
                }
                cond_16 = var2_36;
              }
              if (cond_16.booleanValue()) 
                return Boolean.FALSE;
              else {
                Boolean cond_55 = null;
                Boolean var1_56 = null;
                BoardLine obj_63 = (BoardLine)l.get(y);
                if ((var1_56 = Boolean.valueOf(!UTIL.equals((obj_63.getCell(x).piece), null))).booleanValue()) {
                  BoardLine obj_72 = (BoardLine)lines.get(y);
                  var1_56 = Boolean.valueOf(!UTIL.equals((obj_72.getCell(x).piece), null));
                }
                if ((cond_55 = var1_56).booleanValue()) {
                  Boolean var2_75 = null;
                  BoardLine obj_83 = (BoardLine)l.get(y);
                  BoardLine obj_90 = (BoardLine)lines.get(y);
                  if (!(var2_75 = Boolean.valueOf(!(obj_83.getCell(x).piece).getClass().equals((obj_90.getCell(x).piece).getClass()))).booleanValue()) {
                    BoardLine obj_99 = (BoardLine)l.get(y);
                    BoardLine obj_107 = (BoardLine)lines.get(y);
                    var2_75 = Boolean.valueOf(!UTIL.equals(((obj_99.getCell(x).piece).belongTo), ((obj_107.getCell(x).piece).belongTo)));
                  }
                  cond_55 = var2_75;
                }
                {
                  if (cond_55.booleanValue()) 
                    return Boolean.FALSE;
                }
              }
            }
          }
        }
      }
      return Boolean.TRUE;
    }
    finally {
      sentinel.leaving(((BoardStateSentinel)sentinel).linesEquals);
    }
  }
// ***** VDMTOOLS END Name=linesEquals#1|Map


// ***** VDMTOOLS START Name=playerEquals#1|Object KEEP=NO
  private Boolean playerEquals (final Object p) throws CGException {
    sentinel.entering(((BoardStateSentinel)sentinel).playerEquals);
    try {
      return Boolean.valueOf(UTIL.equals(p, turn));
    }
    finally {
      sentinel.leaving(((BoardStateSentinel)sentinel).playerEquals);
    }
  }
// ***** VDMTOOLS END Name=playerEquals#1|Object


// ***** VDMTOOLS START Name=capturedEquals#1|Map KEEP=NO
  private Boolean capturedEquals (final Map c) throws CGException {
    sentinel.entering(((BoardStateSentinel)sentinel).capturedEquals);
    try {
      {
        Set iset_6 = new HashSet(c.keySet());
        Set tmpSet_38 = new HashSet(iset_6);
        for (Iterator enm_37 = tmpSet_38.iterator(); enm_37.hasNext(); ) {
          Object elem_2 = enm_37.next();
          Object p = null;
          /* p */
          p = elem_2;
          if (!UTIL.Contains(new HashSet(capturedPieces.keySet()), p)) 
            return Boolean.FALSE;
          else {
            Set iset_17 = new HashSet(UTIL.ConvertToList(c.get(p)));
            Set tmpSet_35 = new HashSet(iset_17);
            for (Iterator enm_34 = tmpSet_35.iterator(); enm_34.hasNext(); ) {
              Piece elem_11 = (Piece)enm_34.next();
              Piece piece = null;
              /* piece */
              piece = elem_11;
              boolean tmpQuant_20 = false;
              {
                Set e1_set_25 = new HashSet(UTIL.ConvertToList(capturedPieces.get(p)));
                Piece pi = null;
                Set tmpSet_32 = new HashSet(e1_set_25);
                for (Iterator enm_31 = tmpSet_32.iterator(); enm_31.hasNext() && !tmpQuant_20; ) {
                  Piece elem_30 = (Piece)enm_31.next();
                  /* pi */
                  pi = elem_30;
                  if (pi.getClass().equals(piece.getClass())) 
                    tmpQuant_20 = true;
                }
              }
              if (!tmpQuant_20) 
                return Boolean.FALSE;
            }
          }
        }
      }
      return Boolean.TRUE;
    }
    finally {
      sentinel.leaving(((BoardStateSentinel)sentinel).capturedEquals);
    }
  }
// ***** VDMTOOLS END Name=capturedEquals#1|Map

}
;
