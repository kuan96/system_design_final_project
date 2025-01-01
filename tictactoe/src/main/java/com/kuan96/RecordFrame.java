package com.kuan96;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecordFrame {
	JFrame frame = new JFrame();
	JPanel title = new JPanel();
	JLabel textfield = new JLabel();
	JPanel title3 = new JPanel();
	JLabel textfield3 = new JLabel();
	
	private int[] score;
	
	public RecordFrame()
	{
		this.score = new int[2];
		this.score[0] = 0;
		this.score[1] = 0;
		
		frame.setTitle("Score");
		frame.setSize(500,200);
		frame.getContentPane().setBackground(Color.darkGray);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.black);
		textfield.setForeground(Color.pink);
		textfield.setFont(new Font("Comic Sans",Font.BOLD,35));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("player1     vs.     player2");
		textfield.setOpaque(true);
		
		title.setLayout(new BorderLayout());	
		title.add(textfield);
		
		textfield3.setBackground(Color.darkGray);
		textfield3.setForeground(Color.pink);
		textfield3.setFont(new Font("Ink Free",Font.BOLD,50));
		textfield3.setHorizontalAlignment(JLabel.CENTER);
		textfield3.setText(this.score[0] + "    :    " + this.score[1]);
		textfield3.setOpaque(true);

		title3.setLayout(new BorderLayout());
		title3.add(textfield3);
		
		frame.add(title,BorderLayout.NORTH);
		frame.add(title3);
	}
	
	public void setScore(int player)
	{
		this.score[player] = this.score[player] + 1;
		this.textfield3.setText(this.score[0] + "    :    " + this.score[1]);
	}
	
}
