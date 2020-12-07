import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/** 
 *  Tests the hasWinner method in Board. This method detects if there exists 4 in a row of the 
 *  specified color.
 */

public class GameTest {

    @Test
    public void testNoWinnerBlank() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "_______",
                        "_______",
                        "_______",
                        "_______"};
        bd.change(str);
        assertFalse(bd.hasWinner("red"));
        assertFalse(bd.hasWinner("blue"));
    }
    
    @Test
    public void testNoWinnerFull() {
        Board bd = new Board(0, 0);
        String[] str = {"rbrbrbr",
                        "rbrbrbr",
                        "rbrbrbr",
                        "brbrbrb",
                        "brbrbrb",
                        "rbrbrbr"};
        bd.change(str);
        assertFalse(bd.hasWinner("red"));
        assertFalse(bd.hasWinner("blue"));
    }
    
    @Test
    public void testNoWinnerNotFull() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "_______",
                        "_rbrb_b",
                        "brbrb_b",
                        "rbrbrbr"};
        bd.change(str);
        assertFalse(bd.hasWinner("red"));
        assertFalse(bd.hasWinner("blue"));
    }
    
    @Test
    public void testHasRedWinnerVertical() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "r______",
                        "r______",
                        "r______",
                        "r______"};
        bd.change(str);
        assertTrue(bd.hasWinner("red"));
        assertFalse(bd.hasWinner("blue"));
    }
    
    @Test
    public void testHasRedWinnerVerticalWithBlues() {
        Board bd = new Board(0, 0);
        String[] str = {"bb_____",
                        "bb_____",
                        "r__r___",
                        "r____b_",
                        "r__b___",
                        "r____b_"};
        bd.change(str);
        assertTrue(bd.hasWinner("red"));
        assertFalse(bd.hasWinner("blue"));
    }
    
    @Test
    public void testHasBlueWinnerVertical() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "b______",
                        "b______",
                        "b______",
                        "b______"};
        bd.change(str);
        assertFalse(bd.hasWinner("red"));
        assertTrue(bd.hasWinner("blue"));
    }
    
    @Test
    public void testHasBlueWinnerVerticalColumn2() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "_b_____",
                        "_b_____",
                        "_b_____",
                        "_b_____"};
        bd.change(str);
        assertFalse(bd.hasWinner("red"));
        assertTrue(bd.hasWinner("blue"));
    }
    
    @Test
    public void testHasBlueWinnerLastColumn() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "______b",
                        "______b",
                        "______b",
                        "______b",
                        "______r"};
        bd.change(str);
        assertFalse(bd.hasWinner("red"));
        assertTrue(bd.hasWinner("blue"));
    }
    
    @Test
    public void testHasBlueWinnerFirstRow() {
        Board bd = new Board(0, 0);
        String[] str = {"rrrbbbb",
                        "rbrbrbr",
                        "rbrbrbr",
                        "brbrbrb",
                        "brbrbrb",
                        "rbrbrbr"};
        bd.change(str);
        assertFalse(bd.hasWinner("red"));
        assertTrue(bd.hasWinner("blue"));
    }
    
    @Test
    public void testHasBlueWinnerLastRow() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "_______",
                        "_______",
                        "_______",
                        "bbbbrrr"};
        bd.change(str);
        assertFalse(bd.hasWinner("red"));
        assertTrue(bd.hasWinner("blue"));
    }
    
    @Test
    public void testHasRedWinnerMiddleRow() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "rrrr___",
                        "brbrbrb",
                        "brbrbrb",
                        "rbrbrbr"};
        bd.change(str);
        assertFalse(bd.hasWinner("blue"));
        assertTrue(bd.hasWinner("red"));
    }
    
    @Test
    public void testHasBothWinnerMiddleRow() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "rrrr___",
                        "brbbbbb",
                        "brbrbrb",
                        "rbrbrbr"};
        bd.change(str);
        assertTrue(bd.hasWinner("blue"));
        assertTrue(bd.hasWinner("red"));
    }
    
    @Test
    public void testHasBothWinnerDiagonals() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "rrb____",
                        "brbb_bb",
                        "brrrbrb",
                        "rbrrrbr"};
        bd.change(str);
        assertTrue(bd.hasWinner("blue"));
        assertTrue(bd.hasWinner("red"));
    }
    
    @Test
    public void testHasRedWinnerDiagonal() {
        Board bd = new Board(0, 0);
        String[] str = {"_______",
                        "_______",
                        "_r_____",
                        "__r____",
                        "___r___",
                        "bbbbrrr"};
        bd.change(str);
        assertTrue(bd.hasWinner("blue"));
        assertTrue(bd.hasWinner("red"));
    }
    
    @Test
    public void testHasRedWinnerDiagonalOtherDirection() {
        Board bd = new Board(0, 0);
        String[] str = {"______r",
                        "_____r_",
                        "____r__",
                        "__rr___",
                        "___r___",
                        "bb_brrr"};
        bd.change(str);
        assertFalse(bd.hasWinner("blue"));
        assertTrue(bd.hasWinner("red"));
    }

}
