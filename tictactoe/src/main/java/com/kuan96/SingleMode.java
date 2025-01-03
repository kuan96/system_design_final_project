package com.kuan96;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;

public class SingleMode extends GameFrame{
	private String[] text = new String[2];
	private Color[] color = new Color[2];
	private int turn;
	private OperateFunctions function;
	
	public SingleMode()
	{
		this.text[0] = "O";
		this.text[1] = "X";
		
		this.color[0] = new Color(255,215,0);
		this.color[1] = new Color(138,43,226);
		
		this.turn = 0;
		
		this.function = new OperateFunctions();
	}

	public String[] getText() {
        return text;
    }

    public Color[] getColor() {
        return color;
    }

    public int getTurn() {
        return turn;
    }

    public JButton[] getButtons() {
        return buttons;
    }

	public void counter()
	{
		while(true)
		{
			Random rand = new Random();
			int i = rand.nextInt(9);

			if(buttons[i].getText() == "")
			{
				buttons[i].setForeground(this.color[turn]);
				buttons[i].setText(this.text[turn]);

				if(function.check_win(buttons, this.text[turn]))
				{
					function.win(turn, buttons);
				}
				else if(function.check_tie(buttons))
				{
					function.tie(buttons);
				}

				this.turn = (this.turn + 1) % 2;
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		 for(int i=0; i<9; i++) 
		 {
				if(e.getSource() == buttons[i] && buttons[i].getText() == "") 
				{
					buttons[i].setForeground(this.color[turn]);
					buttons[i].setText(this.text[turn]);

					if(function.check_win(buttons, this.text[turn]))
					{
						function.win(turn, buttons);
						break;
					}
					else if(function.check_tie(buttons))
					{
						function.tie(buttons);
						break;
					}

					this.turn = (this.turn + 1) % 2;
					counter();
				}		
		 }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'q')
		{
			System.exit(0);
		}
		if(e.getKeyChar() == 'r')
		{
			function.restart(buttons);
		}
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
