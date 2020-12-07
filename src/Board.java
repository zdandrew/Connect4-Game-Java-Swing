import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Board extends GameObj{
    public static final String IMG_FILE = "files/board2.png";
    public static final int SIZEX = 500;
    public static final int SIZEY = 400;
    public static final int INIT_POS_X = 0;
    public static final int INIT_POS_Y = 0;
    public static final int INIT_VEL_X = 0;
    public static final int INIT_VEL_Y = 0;

    private static BufferedImage img;
    private static Piece[][] arr;

    public Board(int courtWidth, int courtHeight) {
        super(INIT_VEL_X, INIT_VEL_Y, INIT_POS_X, INIT_POS_Y, SIZEX, SIZEY, courtWidth, 
                courtHeight);

        try {
            if (img == null) {
                img = ImageIO.read(new File(IMG_FILE));
            }
            arr = new Piece[6][7];
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
    }
    
    public String get(int r, int c) {
        if (arr[r][c] == null) {
            return "_";
        }
        if (arr[r][c].getColor().equals(Color.red)) {
            return "r";
        } else {
            return "b";
        }
    }
    
    public void clear(int r, int c) {
        arr[r][c] = null;
    }
    
    public void change(String[] ar) {
        for (int i = 0; i < 6; i++) {
            System.out.println(ar[i]);
            for (int j = 0; j < 7; j++) {
                char ch = ar[i].charAt(j);
                if (ch == '_') {
                    arr[i][j] = null;
                    continue;
                }
                Color col = Color.red;
                if (ch == 'b') {
                    col = Color.blue;
                }
                arr[i][j] = new Piece(col, 73 * j, 67 * i);
                
            }
           
        }
    }
    
    public boolean hasWinner(String turn) {
        Color cr = Color.red;
        if (turn.equals("red")) {
            cr = Color.red;
        } else {
            cr = Color.blue;
        }
        //check horizontals
        for (int r = 0; r < 6; r++) {
            int cnt = 0;
            for (int c = 0; c < 7; c++) {
                if (arr[r][c] != null && arr[r][c].getColor().equals(cr)) {
                    cnt++;
                    if (cnt == 4) {
                        return true;
                    }
                } else {
                    cnt = 0;
                }
                
            }
        }
        // check verticals
        for (int r = 0; r < 7; r++) {
            int cnt = 0;
            for (int c = 0; c < 6; c++) {
                if (arr[c][r] != null && arr[c][r].getColor().equals(cr)) {
                    cnt++;
                    if (cnt == 4) {
                        return true;
                    }
                } else {
                    cnt = 0;
                }
                
            }
        }
        // check diagonals
        // top left to bot right
        int ctr = 0;
        
        for (int c = 0; c < 6; c++) {
            if (arr[c][c] != null && arr[c][c].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 6; c++) {
            if (arr[c][c+1] != null && arr[c][c+1].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 5; c++) {
            if (arr[c][c+2] != null && arr[c][c+2].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 4; c++) {
            if (arr[c][c+3] != null && arr[c][c+3].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 5; c++) {
            if (arr[c+1][c] != null && arr[c+1][c].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 4; c++) {
            if (arr[c+2][c] != null && arr[c+2][c].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        //bot left to top right
        for (int c = 0; c < 6; c++) {
            if (arr[5-c][c] != null && arr[5-c][c].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 5; c++) {
            if (arr[4-c][c] != null && arr[4-c][c].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 4; c++) {
            if (arr[3-c][c] != null && arr[3-c][c].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 6; c++) {
            if (arr[5-c][c+1] != null && arr[5-c][c+1].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 5; c++) {
            if (arr[5-c][c+2] != null && arr[5-c][c+2].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        for (int c = 0; c < 4; c++) {
            if (arr[5-c][c+3] != null && arr[5-c][c+3].getColor().equals(cr)) {
                ctr++;
                if (ctr == 4) {
                    return true;
                }
            } else {
                ctr = 0;
            }
        }
        ctr = 0;
        
        
        return false;
    }
    
    public boolean add(GameCourt obj, int n, Color c) {
        for (int i = 5; i > -1; i--) {
            if (arr[i][n] == null) {
                arr[i][n] = new Piece(c, 73 * n, 67 * i);
                obj.addTurn(i, n);
                return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != null) {
                    arr[i][j].draw(g);
                }
                
            }
        }
        g.drawImage(img, this.getPx(), this.getPy(), this.getWidth(), this.getHeight(), null);
    }
}
