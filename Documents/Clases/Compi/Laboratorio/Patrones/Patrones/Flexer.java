/* The following code was generated by JFlex 1.6.1 */

/********************************************************************************
**  Proyecto 2: Analizador léxico para p--, subconjunto de Python.                               **
**  @author Diana Montes                                                                       **
*********************************************************************************/
import java.util.Stack;
import java.util.Arrays;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>Flexer.flex</tt>
 */
public class Flexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int INDENT = 2;
  public static final int CADENA = 4;
  public static final int DEDENT = 6;
  public static final int NORMAL = 8;
  public static final int EOF = 10;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5, 5
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\36\1\4\1\25\1\25\1\25\22\0\1\7\1\21\1\37"+
    "\1\10\1\6\1\15\1\43\1\0\1\22\1\23\1\13\1\11\1\0"+
    "\1\12\1\40\1\14\1\2\1\3\10\1\1\24\1\41\1\16\1\20"+
    "\1\17\2\0\5\5\1\32\15\5\1\26\6\5\3\0\1\42\1\5"+
    "\1\0\1\33\2\5\1\46\1\31\1\47\1\5\1\54\1\55\2\5"+
    "\1\34\1\51\1\45\1\50\1\56\1\5\1\27\1\35\1\52\1\30"+
    "\1\5\1\53\3\5\1\0\1\44\10\0\1\25\44\0\1\5\12\0"+
    "\1\5\4\0\1\5\5\0\27\5\1\0\37\5\1\0\u01ca\5\4\0"+
    "\14\5\16\0\5\5\7\0\1\5\1\0\1\5\201\0\5\5\1\0"+
    "\2\5\2\0\4\5\1\0\1\5\6\0\1\5\1\0\3\5\1\0"+
    "\1\5\1\0\24\5\1\0\123\5\1\0\213\5\10\0\246\5\1\0"+
    "\46\5\2\0\1\5\7\0\47\5\110\0\33\5\5\0\3\5\55\0"+
    "\53\5\25\0\12\6\4\0\2\5\1\0\143\5\1\0\1\5\17\0"+
    "\2\5\7\0\2\5\12\6\3\5\2\0\1\5\20\0\1\5\1\0"+
    "\36\5\35\0\131\5\13\0\1\5\16\0\12\6\41\5\11\0\2\5"+
    "\4\0\1\5\5\0\26\5\4\0\1\5\11\0\1\5\3\0\1\5"+
    "\27\0\31\5\107\0\23\5\121\0\66\5\3\0\1\5\22\0\1\5"+
    "\7\0\12\5\4\0\12\6\1\0\20\5\4\0\10\5\2\0\2\5"+
    "\2\0\26\5\1\0\7\5\1\0\1\5\3\0\4\5\3\0\1\5"+
    "\20\0\1\5\15\0\2\5\1\0\3\5\4\0\12\6\2\5\23\0"+
    "\6\5\4\0\2\5\2\0\26\5\1\0\7\5\1\0\2\5\1\0"+
    "\2\5\1\0\2\5\37\0\4\5\1\0\1\5\7\0\12\6\2\0"+
    "\3\5\20\0\11\5\1\0\3\5\1\0\26\5\1\0\7\5\1\0"+
    "\2\5\1\0\5\5\3\0\1\5\22\0\1\5\17\0\2\5\4\0"+
    "\12\6\25\0\10\5\2\0\2\5\2\0\26\5\1\0\7\5\1\0"+
    "\2\5\1\0\5\5\3\0\1\5\36\0\2\5\1\0\3\5\4\0"+
    "\12\6\1\0\1\5\21\0\1\5\1\0\6\5\3\0\3\5\1\0"+
    "\4\5\3\0\2\5\1\0\1\5\1\0\2\5\3\0\2\5\3\0"+
    "\3\5\3\0\14\5\26\0\1\5\25\0\12\6\25\0\10\5\1\0"+
    "\3\5\1\0\27\5\1\0\20\5\3\0\1\5\32\0\2\5\6\0"+
    "\2\5\4\0\12\6\25\0\10\5\1\0\3\5\1\0\27\5\1\0"+
    "\12\5\1\0\5\5\3\0\1\5\40\0\1\5\1\0\2\5\4\0"+
    "\12\6\1\0\2\5\22\0\10\5\1\0\3\5\1\0\51\5\2\0"+
    "\1\5\20\0\1\5\21\0\2\5\4\0\12\6\12\0\6\5\5\0"+
    "\22\5\3\0\30\5\1\0\11\5\1\0\1\5\2\0\7\5\37\0"+
    "\12\6\21\0\60\5\1\0\2\5\14\0\7\5\11\0\12\6\47\0"+
    "\2\5\1\0\1\5\2\0\2\5\1\0\1\5\2\0\1\5\6\0"+
    "\4\5\1\0\7\5\1\0\3\5\1\0\1\5\1\0\1\5\2\0"+
    "\2\5\1\0\4\5\1\0\2\5\11\0\1\5\2\0\5\5\1\0"+
    "\1\5\11\0\12\6\2\0\4\5\40\0\1\5\37\0\12\6\26\0"+
    "\10\5\1\0\44\5\33\0\5\5\163\0\53\5\24\0\1\5\12\6"+
    "\6\0\6\5\4\0\4\5\3\0\1\5\3\0\2\5\7\0\3\5"+
    "\4\0\15\5\14\0\1\5\1\0\12\6\6\0\46\5\1\0\1\5"+
    "\5\0\1\5\2\0\53\5\1\0\u014d\5\1\0\4\5\2\0\7\5"+
    "\1\0\1\5\1\0\4\5\2\0\51\5\1\0\4\5\2\0\41\5"+
    "\1\0\4\5\2\0\7\5\1\0\1\5\1\0\4\5\2\0\17\5"+
    "\1\0\71\5\1\0\4\5\2\0\103\5\45\0\20\5\20\0\125\5"+
    "\14\0\u026c\5\2\0\21\5\1\0\32\5\5\0\113\5\6\0\10\5"+
    "\7\0\15\5\1\0\4\5\16\0\22\5\16\0\22\5\16\0\15\5"+
    "\1\0\3\5\17\0\64\5\43\0\1\5\4\0\1\5\3\0\12\6"+
    "\46\0\12\6\6\0\130\5\10\0\51\5\1\0\1\5\5\0\106\5"+
    "\12\0\37\5\47\0\12\6\36\5\2\0\5\5\13\0\54\5\25\0"+
    "\7\5\10\0\12\6\46\0\27\5\11\0\65\5\53\0\12\6\6\0"+
    "\12\6\15\0\1\5\135\0\57\5\21\0\7\5\4\0\12\6\51\0"+
    "\36\5\15\0\2\5\12\6\54\5\32\0\44\5\34\0\12\6\3\0"+
    "\3\5\12\6\44\5\153\0\4\5\1\0\4\5\3\0\2\5\11\0"+
    "\300\5\100\0\u0116\5\2\0\6\5\2\0\46\5\2\0\6\5\2\0"+
    "\10\5\1\0\1\5\1\0\1\5\1\0\1\5\1\0\37\5\2\0"+
    "\65\5\1\0\7\5\1\0\1\5\3\0\3\5\1\0\7\5\3\0"+
    "\4\5\2\0\6\5\4\0\15\5\5\0\3\5\1\0\7\5\53\0"+
    "\1\25\1\25\107\0\1\5\15\0\1\5\20\0\15\5\145\0\1\5"+
    "\4\0\1\5\2\0\12\5\1\0\1\5\3\0\5\5\6\0\1\5"+
    "\1\0\1\5\1\0\1\5\1\0\4\5\1\0\13\5\2\0\4\5"+
    "\5\0\5\5\4\0\1\5\64\0\2\5\u0a7b\0\57\5\1\0\57\5"+
    "\1\0\205\5\6\0\4\5\3\0\2\5\14\0\46\5\1\0\1\5"+
    "\5\0\1\5\2\0\70\5\7\0\1\5\20\0\27\5\11\0\7\5"+
    "\1\0\7\5\1\0\7\5\1\0\7\5\1\0\7\5\1\0\7\5"+
    "\1\0\7\5\1\0\7\5\120\0\1\5\u01d5\0\2\5\52\0\5\5"+
    "\5\0\2\5\4\0\126\5\6\0\3\5\1\0\132\5\1\0\4\5"+
    "\5\0\51\5\3\0\136\5\21\0\33\5\65\0\20\5\u0200\0\u19b6\5"+
    "\112\0\u51cd\5\63\0\u048d\5\103\0\56\5\2\0\u010d\5\3\0\20\5"+
    "\12\6\2\5\24\0\57\5\20\0\37\5\2\0\106\5\61\0\11\5"+
    "\2\0\147\5\2\0\4\5\1\0\36\5\2\0\2\5\105\0\13\5"+
    "\1\0\3\5\1\0\4\5\1\0\27\5\35\0\64\5\16\0\62\5"+
    "\34\0\12\6\30\0\6\5\3\0\1\5\4\0\12\6\34\5\12\0"+
    "\27\5\31\0\35\5\7\0\57\5\34\0\1\5\12\6\6\0\5\5"+
    "\1\0\12\5\12\6\5\5\1\0\51\5\27\0\3\5\1\0\10\5"+
    "\4\0\12\6\6\0\27\5\3\0\1\5\3\0\62\5\1\0\1\5"+
    "\3\0\2\5\2\0\5\5\2\0\1\5\1\0\1\5\30\0\3\5"+
    "\2\0\13\5\7\0\3\5\14\0\6\5\2\0\6\5\2\0\6\5"+
    "\11\0\7\5\1\0\7\5\1\0\53\5\1\0\4\5\4\0\2\5"+
    "\132\0\43\5\15\0\12\6\6\0\u2ba4\5\14\0\27\5\4\0\61\5"+
    "\u2104\0\u016e\5\2\0\152\5\46\0\7\5\14\0\5\5\5\0\1\5"+
    "\1\0\12\5\1\0\15\5\1\0\5\5\1\0\1\5\1\0\2\5"+
    "\1\0\2\5\1\0\154\5\41\0\u016b\5\22\0\100\5\2\0\66\5"+
    "\50\0\14\5\164\0\5\5\1\0\207\5\23\0\12\6\7\0\32\5"+
    "\6\0\32\5\13\0\131\5\3\0\6\5\2\0\6\5\2\0\6\5"+
    "\2\0\3\5\43\0\14\5\1\0\32\5\1\0\23\5\1\0\2\5"+
    "\1\0\17\5\2\0\16\5\42\0\173\5\u0185\0\35\5\3\0\61\5"+
    "\57\0\40\5\20\0\21\5\1\0\10\5\6\0\46\5\12\0\36\5"+
    "\2\0\44\5\4\0\10\5\60\0\236\5\2\0\12\6\126\0\50\5"+
    "\10\0\64\5\234\0\u0137\5\11\0\26\5\12\0\10\5\230\0\6\5"+
    "\2\0\1\5\1\0\54\5\1\0\2\5\3\0\1\5\2\0\27\5"+
    "\12\0\27\5\11\0\37\5\141\0\26\5\12\0\32\5\106\0\70\5"+
    "\6\0\2\5\100\0\1\5\17\0\4\5\1\0\3\5\1\0\33\5"+
    "\54\0\35\5\3\0\35\5\43\0\10\5\1\0\34\5\33\0\66\5"+
    "\12\0\26\5\12\0\23\5\15\0\22\5\156\0\111\5\u03ba\0\65\5"+
    "\56\0\12\6\23\0\55\5\40\0\31\5\7\0\12\6\11\0\44\5"+
    "\17\0\12\6\20\0\43\5\3\0\1\5\14\0\60\5\16\0\4\5"+
    "\13\0\12\6\1\5\45\0\22\5\1\0\31\5\204\0\57\5\21\0"+
    "\12\6\13\0\10\5\2\0\2\5\2\0\26\5\1\0\7\5\1\0"+
    "\2\5\1\0\5\5\3\0\1\5\37\0\5\5\u011e\0\60\5\24\0"+
    "\2\5\1\0\1\5\10\0\12\6\246\0\57\5\121\0\60\5\24\0"+
    "\1\5\13\0\12\6\46\0\53\5\25\0\12\6\u01d6\0\100\5\12\6"+
    "\25\0\1\5\u01c0\0\71\5\u0507\0\u0399\5\u0c67\0\u042f\5\u33d1\0\u0239\5"+
    "\7\0\37\5\1\0\12\6\146\0\36\5\22\0\60\5\20\0\4\5"+
    "\14\0\12\6\11\0\25\5\5\0\23\5\u0370\0\105\5\13\0\1\5"+
    "\102\0\15\5\u4060\0\2\5\u0bfe\0\153\5\5\0\15\5\3\0\11\5"+
    "\7\0\12\5\u1766\0\125\5\1\0\107\5\1\0\2\5\2\0\1\5"+
    "\2\0\2\5\2\0\4\5\1\0\14\5\1\0\1\5\1\0\7\5"+
    "\1\0\101\5\1\0\4\5\2\0\10\5\1\0\7\5\1\0\34\5"+
    "\1\0\4\5\1\0\5\5\1\0\1\5\3\0\7\5\1\0\u0154\5"+
    "\2\0\31\5\1\0\31\5\1\0\37\5\1\0\31\5\1\0\37\5"+
    "\1\0\31\5\1\0\37\5\1\0\31\5\1\0\37\5\1\0\31\5"+
    "\1\0\10\5\2\0\62\6\u1000\0\305\5\u053b\0\4\5\1\0\33\5"+
    "\1\0\2\5\1\0\1\5\2\0\1\5\1\0\12\5\1\0\4\5"+
    "\1\0\1\5\1\0\1\5\6\0\1\5\4\0\1\5\1\0\1\5"+
    "\1\0\1\5\1\0\3\5\1\0\2\5\1\0\1\5\2\0\1\5"+
    "\1\0\1\5\1\0\1\5\1\0\1\5\1\0\1\5\1\0\2\5"+
    "\1\0\1\5\2\0\4\5\1\0\7\5\1\0\4\5\1\0\4\5"+
    "\1\0\1\5\1\0\12\5\1\0\21\5\5\0\3\5\1\0\5\5"+
    "\1\0\21\5\u1144\0\ua6d7\5\51\0\u1035\5\13\0\336\5\u3fe2\0\u021e\5"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u05f0\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\6\0\1\1\2\2\1\1\1\3\1\4\1\5\1\2"+
    "\1\6\1\7\1\10\1\2\1\11\1\12\2\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\2\1\26\1\27\1\30\5\15\1\31\1\32"+
    "\1\33\1\34\1\35\7\15\1\36\3\0\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\4\15\1\45\5\15\1\46"+
    "\1\15\1\47\1\50\1\15\1\51\5\15\1\52\1\53"+
    "\1\54\1\15\1\55\2\15\1\56\1\15\1\57\1\60"+
    "\1\61\3\15\1\62\1\63\1\64";

  private static int [] zzUnpackAction() {
    int [] result = new int[102];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\353\0\u011a\0\u011a"+
    "\0\u0149\0\u0178\0\u011a\0\u011a\0\u011a\0\u0178\0\u011a\0\u01a7"+
    "\0\u011a\0\u01d6\0\u011a\0\u011a\0\u0205\0\u0234\0\u011a\0\u0263"+
    "\0\u011a\0\u011a\0\u0292\0\u02c1\0\u011a\0\u02f0\0\u031f\0\u034e"+
    "\0\u037d\0\u011a\0\u011a\0\u011a\0\u03ac\0\u03db\0\u040a\0\u0439"+
    "\0\u0468\0\u011a\0\u011a\0\u011a\0\u011a\0\u011a\0\u0497\0\u04c6"+
    "\0\u04f5\0\u0524\0\u0553\0\u0582\0\u05b1\0\u011a\0\u0149\0\u01d6"+
    "\0\u05e0\0\u011a\0\u011a\0\u011a\0\u011a\0\u011a\0\u011a\0\u060f"+
    "\0\u063e\0\u066d\0\u069c\0\u0263\0\u06cb\0\u06fa\0\u0729\0\u0758"+
    "\0\u0787\0\u0263\0\u07b6\0\u0263\0\u0263\0\u07e5\0\u05e0\0\u0814"+
    "\0\u0843\0\u0872\0\u08a1\0\u08d0\0\u0263\0\u0263\0\u0263\0\u08ff"+
    "\0\u0263\0\u092e\0\u095d\0\u0263\0\u098c\0\u0263\0\u0263\0\u0263"+
    "\0\u09bb\0\u09ea\0\u0a19\0\u0263\0\u0263\0\u0263";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[102];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\4\7\1\10\2\7\1\11\1\12\25\7\1\11\20\7"+
    "\4\13\1\14\2\13\1\15\1\16\14\13\1\10\10\13"+
    "\1\17\20\13\1\10\3\20\1\21\3\20\1\16\10\20"+
    "\1\22\3\20\1\10\10\20\1\10\1\23\5\10\12\20"+
    "\4\24\1\10\3\24\1\16\14\24\1\10\31\24\1\10"+
    "\1\25\1\26\1\25\1\27\1\30\2\10\1\16\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\10\1\45\1\46\1\30\1\47"+
    "\1\50\1\51\2\30\1\10\1\52\1\10\1\53\1\54"+
    "\1\55\1\56\1\57\1\60\1\61\1\62\2\30\1\63"+
    "\1\30\1\64\1\65\10\10\1\16\46\10\57\0\4\66"+
    "\1\0\2\66\1\67\1\0\25\66\1\67\20\66\4\16"+
    "\1\0\20\16\1\0\31\16\1\0\3\20\1\0\14\20"+
    "\1\70\3\20\1\0\10\20\7\0\12\20\20\0\1\20"+
    "\37\0\1\25\1\0\1\25\34\0\1\71\56\0\1\71"+
    "\17\0\3\30\1\0\1\30\20\0\10\30\7\0\12\30"+
    "\13\0\1\72\57\0\1\73\62\0\1\74\56\0\1\75"+
    "\56\0\1\76\56\0\1\77\37\0\3\30\1\0\1\30"+
    "\20\0\1\30\1\100\6\30\7\0\12\30\1\0\3\30"+
    "\1\0\1\30\20\0\3\30\1\101\4\30\7\0\12\30"+
    "\1\0\3\30\1\0\1\30\20\0\6\30\1\102\1\30"+
    "\7\0\12\30\1\0\3\30\1\0\1\30\20\0\5\30"+
    "\1\103\2\30\7\0\12\30\1\0\3\30\1\0\1\30"+
    "\20\0\7\30\1\104\7\0\1\105\11\30\1\0\3\30"+
    "\1\0\1\30\20\0\10\30\7\0\3\30\1\106\6\30"+
    "\1\0\3\30\1\0\1\30\20\0\3\30\1\107\4\30"+
    "\7\0\12\30\1\0\3\30\1\0\1\30\20\0\1\30"+
    "\1\110\6\30\7\0\3\30\1\111\6\30\1\0\3\30"+
    "\1\0\1\30\20\0\1\30\1\112\6\30\7\0\12\30"+
    "\1\0\3\30\1\0\1\30\20\0\10\30\7\0\7\30"+
    "\1\113\2\30\1\0\3\30\1\0\1\30\20\0\10\30"+
    "\7\0\1\114\1\30\1\115\7\30\1\0\3\30\1\0"+
    "\1\30\20\0\1\30\1\116\6\30\7\0\12\30\2\0"+
    "\2\117\54\0\3\30\1\0\1\30\20\0\2\30\1\120"+
    "\5\30\7\0\12\30\1\0\3\30\1\0\1\30\20\0"+
    "\10\30\7\0\5\30\1\121\4\30\1\0\3\30\1\0"+
    "\1\30\20\0\7\30\1\122\7\0\10\30\1\123\1\30"+
    "\1\0\3\30\1\0\1\30\20\0\6\30\1\124\1\30"+
    "\7\0\12\30\1\0\3\30\1\0\1\30\20\0\10\30"+
    "\7\0\1\30\1\125\10\30\1\0\3\30\1\0\1\30"+
    "\20\0\10\30\7\0\5\30\1\126\4\30\1\0\3\30"+
    "\1\0\1\30\20\0\10\30\7\0\2\30\1\127\7\30"+
    "\1\0\3\30\1\0\1\30\20\0\10\30\7\0\3\30"+
    "\1\130\6\30\1\0\3\30\1\0\1\30\20\0\1\30"+
    "\1\131\6\30\7\0\12\30\1\0\3\30\1\0\1\30"+
    "\20\0\10\30\7\0\10\30\1\132\1\30\1\0\3\30"+
    "\1\0\1\30\20\0\10\30\7\0\10\30\1\133\1\30"+
    "\1\0\3\30\1\0\1\30\20\0\3\30\1\134\4\30"+
    "\7\0\12\30\1\0\3\30\1\0\1\30\20\0\2\30"+
    "\1\135\5\30\7\0\12\30\1\0\3\30\1\0\1\30"+
    "\20\0\3\30\1\136\4\30\7\0\12\30\1\0\3\30"+
    "\1\0\1\30\20\0\10\30\7\0\2\30\1\137\7\30"+
    "\1\0\3\30\1\0\1\30\20\0\7\30\1\120\7\0"+
    "\12\30\1\0\3\30\1\0\1\30\20\0\10\30\7\0"+
    "\4\30\1\140\5\30\1\0\3\30\1\0\1\30\20\0"+
    "\6\30\1\141\1\30\7\0\12\30\1\0\3\30\1\0"+
    "\1\30\20\0\10\30\7\0\1\142\11\30\1\0\3\30"+
    "\1\0\1\30\20\0\1\30\1\143\6\30\7\0\12\30"+
    "\1\0\3\30\1\0\1\30\20\0\3\30\1\144\4\30"+
    "\7\0\12\30\1\0\3\30\1\0\1\30\20\0\10\30"+
    "\7\0\5\30\1\145\4\30\1\0\3\30\1\0\1\30"+
    "\20\0\10\30\7\0\1\146\11\30";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2632];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\6\0\2\11\2\1\3\11\1\1\1\11\1\1\1\11"+
    "\1\1\2\11\2\1\1\11\1\1\2\11\2\1\1\11"+
    "\4\1\3\11\5\1\5\11\7\1\1\11\3\0\6\11"+
    "\47\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[102];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    /** Variables auxiliares para 
    * manejar la indentación.*/
    static Stack<Integer> pila = new Stack<Integer>();
    static Integer actual = 0;
    static String cadena = "";
    static int dedents = 0;
    static int indents = 0;

    private Parser yyparser;

    /** Nuevo constructor
    * @param FileReader r
    * @param Parser parser - parser
    */
    public Flexer(java.io.Reader r, Parser parser){
    	   this(r);
    	   this.yyparser = parser;
    }

    /** Función que maneja los niveles de indetación e imprime
    * átomos INDENT y DEDENT.
    * @param int espacios - nivel de indetación actual.
    * @return void
    */
    public void indentacion(int espacios){
        if(pila.empty()){ //ponerle un cero a la pila si esta vacia
             pila.push(new Integer(0));             
        }
	
        Integer tope = pila.peek();
        
        if(tope != espacios){
	    //Se debe emitir un DEDENT por cada nivel mayor al actual
            if(tope > espacios){
                while(pila.peek() > espacios &&  pila.peek()!=0 ){
                    pila.pop();             
                    dedents += 1;                                 
                }
                if(pila.peek() == espacios){
		    yybegin(DEDENT);	       
                }else{
		    System.out.println("IndentationError: line "+(yyline+1));
		    System.exit(1);		    
		}
			return;
            }
   	    //El nivel actual de indentación es mayor a los anteriores.
            pila.push(espacios);
	    yybegin(NORMAL);
            indents = 1;
        }
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Flexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2470) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                this.indentacion(0);
					if(dedents > 0){
					    dedents--;
					    return Parser.DEDENT;
					}else{
					    return 0;
					}
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yypushback(1); yybegin(NORMAL);
            }
          case 53: break;
          case 2: 
            { 
            }
          case 54: break;
          case 3: 
            { yypushback(1); 
                                         this.indentacion(actual);
					 yybegin(NORMAL);
					 if(indents == 1){
					    indents = 0;
					    return Parser.INDENT;
					 }
            }
          case 55: break;
          case 4: 
            { actual = 0;
            }
          case 56: break;
          case 5: 
            { actual++;
            }
          case 57: break;
          case 6: 
            { actual += 4;
            }
          case 58: break;
          case 7: 
            { cadena = yytext();
            }
          case 59: break;
          case 8: 
            { System.out.println("Unexpected newline. Line "+(yyline+1));
                                         System.exit(1);
            }
          case 60: break;
          case 9: 
            { yybegin(NORMAL);
  					 yyparser.yylval = new StringLeaf(cadena);
					 cadena = "";
					 return Parser.CADENA;
            }
          case 61: break;
          case 10: 
            { yypushback(1);
  					  if(dedents > 0){
						dedents--;
						return Parser.DEDENT;
  					  }
					  yybegin(NORMAL);
            }
          case 62: break;
          case 11: 
            { yyparser.yylval = new IntLeaf(Integer.parseInt(yytext()));
  	   				return Parser.ENTERO;
            }
          case 63: break;
          case 12: 
            { yybegin(INDENT); actual=0;
  					  return Parser.NEWLINE;
            }
          case 64: break;
          case 13: 
            { return Parser.IDENTIFIER;
            }
          case 65: break;
          case 14: 
            { return Parser.MAS;
            }
          case 66: break;
          case 15: 
            { return Parser.MENOS;
            }
          case 67: break;
          case 16: 
            { return Parser.POR;
            }
          case 68: break;
          case 17: 
            { return Parser.DIV;
            }
          case 69: break;
          case 18: 
            { return Parser.MODULO;
            }
          case 70: break;
          case 19: 
            { return Parser.LE;
            }
          case 71: break;
          case 20: 
            { return Parser.GR;
            }
          case 72: break;
          case 21: 
            { return Parser.EQ;
            }
          case 73: break;
          case 22: 
            { return Parser.PA;
            }
          case 74: break;
          case 23: 
            { return Parser.PC;
            }
          case 75: break;
          case 24: 
            { return Parser.DOBLEPUNTO;
            }
          case 76: break;
          case 25: 
            { yybegin(CADENA);
            }
          case 77: break;
          case 26: 
            { return Parser.PUNTOCOMA;
            }
          case 78: break;
          case 27: 
            { return Parser.XOR;
            }
          case 79: break;
          case 28: 
            { return Parser.ANDB;
            }
          case 80: break;
          case 29: 
            { return Parser.ORB;
            }
          case 81: break;
          case 30: 
            { System.out.println("IndentationError: unexpected indent. Line "+(yyline+1));
					  System.exit(1);
            }
          case 82: break;
          case 31: 
            { return Parser.POTENCIA;
            }
          case 83: break;
          case 32: 
            { return Parser.DIVENTERA;
            }
          case 84: break;
          case 33: 
            { return Parser.LEQ;
            }
          case 85: break;
          case 34: 
            { return Parser.GRQ;
            }
          case 86: break;
          case 35: 
            { return Parser.EQUALS;
            }
          case 87: break;
          case 36: 
            { return Parser.DIFF;
            }
          case 88: break;
          case 37: 
            { return Parser.AS;
            }
          case 89: break;
          case 38: 
            { return Parser.OR;
            }
          case 90: break;
          case 39: 
            { return Parser.IN;
            }
          case 91: break;
          case 40: 
            { return Parser.IF;
            }
          case 92: break;
          case 41: 
            { yyparser.yylval = new FloatLeaf(Double.parseDouble(yytext()));
  	      				return Parser.REAL;
            }
          case 93: break;
          case 42: 
            { return Parser.AND;
            }
          case 94: break;
          case 43: 
            { return Parser.NOT;
            }
          case 95: break;
          case 44: 
            { return Parser.DEF;
            }
          case 96: break;
          case 45: 
            { return Parser.FOR;
            }
          case 97: break;
          case 46: 
            { return Parser.BOOLEAN;
            }
          case 98: break;
          case 47: 
            { return Parser.ELSE;
            }
          case 99: break;
          case 48: 
            { return Parser.ELIF;
            }
          case 100: break;
          case 49: 
            { return Parser.FROM;
            }
          case 101: break;
          case 50: 
            { return Parser.WHILE;
            }
          case 102: break;
          case 51: 
            { return Parser.PRINT;
            }
          case 103: break;
          case 52: 
            { return Parser.RETURN;
            }
          case 104: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
