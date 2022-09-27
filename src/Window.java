import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    private SortPanel sortpanel;
    private Menu menu;

    private int cols;
    public Window(int cols){
        this.cols = cols;
        this.menu = new Menu(this);
        this.setTitle("Bubble Sort Visualizer");
        this.getContentPane().setPreferredSize(new Dimension(1200, 600));
        this.getContentPane().add(menu);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setBubble(){
        this.getContentPane().remove(menu);

        this.sortpanel = new SortPanel(this.cols, 0);
        this.getContentPane().add(sortpanel);
        this.pack();
    }

    public void setInsert(){
        this.getContentPane().remove(menu);

        this.sortpanel = new SortPanel(this.cols, 1);
        this.getContentPane().add(sortpanel);
        this.pack();
    }
}
