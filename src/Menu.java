import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private Window parent;
    private JButton bubble = new JButton("Bubble Sort Algorithm");
    private JButton insert = new JButton("Insert Algorithm");
    public Menu(Window parent) {
        this.parent = parent;

        this.bubble.setBackground(Color.WHITE);
        this.insert.setBackground(Color.WHITE);
        this.bubble.setFocusPainted(false);
        this.insert.setFocusPainted(false);

        bubble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setBubble();
            }
        });

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setInsert();
            }
        });

        this.setBackground(new Color(0, 128, 43));

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        add(new JLabel("<html><h1>Sorting Visualizer</h1></html>"), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());

        buttons.add(bubble, gbc);
        buttons.add(insert, gbc);

        gbc.weighty = 1;
        this.add(buttons, gbc);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        }

}
