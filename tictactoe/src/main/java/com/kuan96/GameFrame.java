package com.kuan96;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameFrame implements ActionListener,KeyListener{

    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];

    public GameFrame() {
        frame.setTitle("Tic Tac Toe");
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.addKeyListener(this);

        textfield.setBackground(Color.darkGray);
        textfield.setForeground(Color.white);
        textfield.setFont(new Font("Comic Sans", Font.ITALIC, 50));
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setText("Single Mode");
        textfield.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setPreferredSize(new Dimension(600, 120)); 
        title.add(textfield);

        button.setLayout(new GridLayout(3, 3));
        button.setBackground(Color.gray);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        frame.add(title, BorderLayout.NORTH);
        frame.add(button, BorderLayout.CENTER);
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
