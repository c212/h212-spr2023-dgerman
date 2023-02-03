import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

public class Penguin {
  int x, y; 
  double scale; 
  public Penguin(int x, int y, double scale) {
    this.x = x; 
    this.y = y; 
    this.scale = scale; 
  }
  public void moveTo(int x, int y) {
    this.x = x;
    this.y = y; 
  }
  public boolean contains(int x, int y) {
    return this.x <= x && x <= this.x + scale(500) && 
           this.y <= y && y <= this.y + scale(500) ; 

  } 
  private int scale(int size) {
    return (int)(this.scale * size); 
  }
  public void draw(Graphics g) {
    g.setColor(Color.WHITE); 
    g.fillRect(x +  0, y +  0, scale(500), scale(500)); 
    g.setColor(Color.BLACK); 
    g.drawRect(x +  0, y +  0, scale(500), scale(500)); 
    g.setColor(Color.BLACK); 
    g.fillPolygon( new Polygon 
                    ( new int[] { x + scale( 10), x + scale(265), x + scale(499) }, 
                      new int[] { y + scale(274), y + scale( 60), y + scale(274) }, 
                      3 
                    )
                 );
    int left = 5;
    g.fillOval(x + scale( 80-left), y + scale( 50), scale(365), scale(400)); 
    g.setColor(new Color(220, 220, 220)); 
    g.fillOval(x + scale(120-left), y + scale(190), scale(290), scale(250)); 
    g.setColor(Color.WHITE); 
    g.fillOval(x + scale(155-left), y + scale(195), scale(220), scale(240)); 
    g.setColor(new Color(240, 200, 40)); 
    g.fillOval(x + scale( 85-left), y + scale(390), scale(175), scale( 80)); 
    g.setColor(new Color(240, 200, 40)); 
    g.fillOval(x + scale(285-left), y + scale(390), scale(175), scale( 80)); 
    g.setColor(new Color(255, 255, 255)); 
    g.fillOval(x + scale(170-left), y + scale( 74), scale( 92), scale(117)); 
    g.setColor(new Color(255, 255, 255)); 
    g.fillOval(x + scale(264-left), y + scale( 94), scale(107), scale( 79)); 
    g.setColor(Color.BLACK);  
    g.fillOval(x + scale(230-left), y + scale(120), scale( 25), scale( 33)); 
    g.fillOval(x + scale(270-left), y + scale(124), scale( 17), scale( 23)); 
    g.setColor(new Color(240, 200, 40)); 
    g.fillArc (x + scale(188-left), y + scale(173), scale(150), scale(150), 55,  65); 
  }
  
}
