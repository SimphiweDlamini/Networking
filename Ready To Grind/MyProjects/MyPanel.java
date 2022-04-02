import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MyPanel extends JPanel {
    private JComponent mySquare;
    public int inte;

    public MyPanel(JSlider slide, JComponent mySquare) {
        this.mySquare = mySquare;
        ChangeListener change=new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mySquare.repaint();
            }
        };
        slide.addChangeListener(change);
        inte=Math.min(this.getHeight(),this.getWidth())*slide.getValue()/100;

    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(inte/2-mySquare.getWidth()/2,inte-mySquare.getHeight(),inte,inte);
        g.setColor(Color.BLUE);
    }


}


