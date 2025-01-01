package com.kuan96;

import javax.swing.JOptionPane;

public class InputHandler {
	private playerData player_ID;
	
	public InputHandler(playerData player_ID) {
		this.player_ID = player_ID;
	}
	
	public void handler()
	{
		if(player_ID.get_ID() == null)
		{
			init();
		}
		
		clarify();
	}
	
	public void init()
	{
		String input;
		
		while(true)
		{
			input = JOptionPane.showInputDialog("Create your game ID");
			if(input == null)
			{
				System.exit(0);
			}
			else if(input.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please try again");
			}
			else
			{
				break;
			}
		}
		
		player_ID.insert_ID(input);
	}
	
	public void clarify()
	{	
		while(true)
		{
			String input = JOptionPane.showInputDialog("Input your game ID");
			if(input == null)
			{
				System.exit(0);
			}
			else if(input.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please try again");
			}
			else if(!input.equals(player_ID.get_ID()))
			{
				JOptionPane.showMessageDialog(null, "your ID is wrong");
			}
			else
			{
				break;
			}
		}
	}
}
