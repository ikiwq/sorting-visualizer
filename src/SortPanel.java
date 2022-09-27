import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SortPanel extends JPanel {
    private Random random = new Random();
    private int cols;
    private int[] array;
    private int index1, index2;

    boolean isBubble = false;
    boolean isSelection = false;
    private boolean running = true;

    private int minpos = 0;
    boolean isSorted = false;

    JButton sort = new JButton("Sort!");
    JButton reset = new JButton("Reset");

    public SortPanel(int cols, int algo){
        this.cols = cols;

        if(algo == 0){
            isBubble = true;
        }else if(algo == 1){
            isSelection = true;
        }

        this.reset();

        sort.setBackground(Color.WHITE);
        reset.setBackground(Color.WHITE);
        sort.setFocusPainted(false);
        sort.setBorderPainted(false);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);

        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    running = true;
                    BubbleSort();
                } catch (Exception exc){
                    exc.printStackTrace();
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        this.add(sort);
        this.add(reset);

    }

    private void reset(){
        this.array = new int[this.cols];
        for(int i=0;i<this.cols;i++){
            this.array[i] = this.random.nextInt(500);
        }
        repaint();
        if(isBubble){
            index1 = 0;
            index2 = array.length-1;
        }else if(isSelection){
            index1 = 0;
            index2 = 0;
        }

        minpos = 0;
        isSorted = false;
        running = false;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        int width = 1200/this.cols;
        for(int i=0; i<this.cols; i++){
            g.setColor(Color.WHITE);
            if(i == index1){
                g.setColor(Color.BLUE);
            }
            if(i == index2){
                g.setColor(Color.PINK);
            }
            g.drawRect(i*width, 600 - this.array[i], width, this.array[i]);
            g.fillRect(i*width, 600 - this.array[i], width, this.array[i]);
        }
    }

    public void BubbleCompareItems(){
        if( index1 == array.length - 1 && index2 == -1){
            running = false;
            isSorted = true;
            return ;
        }
        if(index1 == index2) {
            index1 = 0;
            index2--;
            return;
        }
        if(array[index1] > array[index1+1]){
            int temp = array[index1];
            array[index1] = array[index1 + 1];
            array[index1 +1] = temp;
        }
        index1++;
        return;
    }

    public void SelectionCompareItems(){
        if(index1 == array.length - 1){
            running = false;
            isSorted = true;
            return ;
        }

        if(array[minpos] > array[index2]){
            minpos = index2;
        }

        if(index2 == array.length -1){
            int temp = array[index1];
            array[index1] = array[minpos];
            array[minpos] = temp;
            minpos = index2 = ++index1;
        }

        index2++;
    }

    public void BubbleSort() throws Exception{
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted){
                    running = false;
                }else if(running == true){
                    if(isBubble){
                        BubbleCompareItems();
                    }else if(isSelection){
                        SelectionCompareItems();
                    }
                    repaint();
                }
            }
        });

        timer.start();
    }
}
