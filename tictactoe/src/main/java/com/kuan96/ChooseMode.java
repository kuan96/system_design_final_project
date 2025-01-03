package com.kuan96;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseMode implements ActionListener {
    public JFrame frame = new JFrame();
    public JPanel title_panel = new JPanel();
    public JLabel title = new JLabel();
    public JLabel title2 = new JLabel();
    public JPanel image_panel = new JPanel();
    public JPanel button_panel = new JPanel();
    public JButton b1 = new JButton();
    public JButton b2 = new JButton();
    public ImageIcon image = new ImageIcon("tictactoe\\src\\main\\java\\com\\kuan96\\tictactoe.png");

    public ChooseMode() {
        frame.setIconImage(image.getImage());
        frame.setTitle("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(533, 480);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Title Panel
        title.setBackground(Color.black);
        title.setForeground(Color.green);
        title.setFont(new Font("Comic Sans", Font.ITALIC, 47));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setText("TicTacToe!");
        title.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 533, 200);
        title_panel.add(title);

        // Image Panel
        title2.setVerticalAlignment(JLabel.CENTER);
        title2.setHorizontalAlignment(JLabel.CENTER);
        image_panel.setBackground(Color.lightGray);
        image_panel.setLayout(new BorderLayout());
        image_panel.add(title2);

        // Buttons
        b1.setForeground(new Color(153, 0, 76));
        b1.setFont(new Font("Comic Sans", Font.BOLD, 42));
        b1.setFocusable(false);
        b1.setText("Single Player");
        b1.addActionListener(this);

        b2.setForeground(new Color(153, 0, 76));
        b2.setFont(new Font("Comic Sans", Font.BOLD, 42));
        b2.setFocusable(false);
        b2.setText("Two Players");
        b2.addActionListener(this);

        button_panel.setLayout(new GridLayout(1, 2, 0, 0));
        button_panel.setBackground(Color.gray);
        button_panel.add(b1);
        button_panel.add(b2);

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(image_panel, BorderLayout.CENTER);
        frame.add(button_panel, BorderLayout.SOUTH);

        // Adjust components dynamically
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = frame.getWidth();
                int height = frame.getHeight();

                // Resize ImageIcon
                Image resizedImage = image.getImage().getScaledInstance(width, height * 4/5, Image.SCALE_SMOOTH);
                title2.setIcon(new ImageIcon(resizedImage));

                // Resize button fonts
                b1.setFont(new Font("Comic Sans", Font.BOLD, width / 20));
                b2.setFont(new Font("Comic Sans", Font.BOLD, width / 20));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("Single Player mode selected!");
            SingleMode single = new SingleMode();
        } else if (e.getSource() == b2) {
            System.out.println("Two Players mode selected!");
            TwoPlayerMode two_player = new TwoPlayerMode();
        }
    }
}
