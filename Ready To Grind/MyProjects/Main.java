import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String [] args){
        JFrame myFrame = new JFrame("Resizable Square");
        myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);

       JSlider slide = new JSlider();
        slide.setMajorTickSpacing(20);
        slide.setMinorTickSpacing(10);
        slide.setPaintLabels(true);
        slide.setPaintTicks(true);
        slide.setBorder(BorderFactory.createTitledBorder("Size of the square"));


       JComponent mySquare = new JComponent() {
       };
       MyPanel freddy = new MyPanel(slide,mySquare);
       myFrame.add(freddy, BorderLayout.CENTER);
       myFrame.add(slide,BorderLayout.SOUTH);
       myFrame.pack();
       myFrame.setLocationRelativeTo(null);
       myFrame.setVisible(true);





    }
}
