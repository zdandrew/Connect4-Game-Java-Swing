import java.awt.*;

public class Piece {
    
    private Color color;
    private int x;
    private int y;
    
    public Piece(Color c, int xPos, int yPos) {
        x = xPos;
        y = yPos;
        color = c;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void changeColor(char c) {
        if (c == 'r') {
            color = Color.red;
        } else if (c == 'b') {
            color = Color.blue;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x, y, 65, 65);
    }
}
