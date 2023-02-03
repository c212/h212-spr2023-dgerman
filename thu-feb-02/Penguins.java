import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics; 
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Penguins extends JComponent implements MouseListener, MouseMotionListener {

  public void mouseMoved(MouseEvent e) { }
  public void mouseDragged(MouseEvent e) { 
    if (this.selected != null) {
      int x = e.getX(), y = e.getY(); 
      selected.moveTo(x, y); 
      this.repaint();
    }
  }

  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }

  Penguin selected; // = null; 

  public void mousePressed(MouseEvent e) { 
    int x = e.getX(), y = e.getY(); 

    if (this.a.contains(x, y)) this.selected = a; 
    else if (this.b.contains(x, y)) this.selected = b;
    else if (this.c.contains(x, y)) this.selected = c;
    else this.selected = null; 

    System.out.println(this.selected);

  }
  public void mouseReleased(MouseEvent e) { }
  public void mouseClicked(MouseEvent e) { System.out.println("Ouch."); }

  public static void main(String[] args) {
    JFrame frame = new JFrame(); 
    frame.setVisible(true); 
    int width = 500, height = 500;
    frame.setSize(width + 20, height + 40); 
    Penguins drawing = new Penguins(width, height); 
    frame.add(drawing);     
  }

  int width, height; 

  Penguin a, b, c; 

  public Penguins(int width, int height) {
    this.width = width;
    this.height = height; 
    a = new Penguin( 20,  50, 0.3);         
    b = new Penguin(220,  20, 0.5);         
    c = new Penguin( 40, 230, 0.4);         
    this.addMouseMotionListener(this);
    this.addMouseListener(this);
  }
  public void paintComponent(Graphics g) {
    a.draw(g); 
    b.draw(g); 
    c.draw(g); 
  }
}
