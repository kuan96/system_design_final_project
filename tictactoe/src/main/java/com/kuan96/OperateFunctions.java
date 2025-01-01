package com.kuan96;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class OperateFunctions {

    private RecordFrame record;

    public OperateFunctions()
    {
        this.record = new RecordFrame();
    }

    public void win(int player, JButton[] buttons)
	{
		this.record.setScore(player);
        if(player == 0)
        {
            JOptionPane.showMessageDialog(null, "Player1 wins !!!\nPress q to quit\nPress r to restart");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Player2 wins !!!\nPress q to quit\nPress r to restart");
        }

        for(int i=0; i<9; ++i)
        {
            buttons[i].setEnabled(false);
        }
	}

    public void tie(JButton[] buttons)
    {
        JOptionPane.showMessageDialog(null, "Tie !\nPress q to quit\nPress r to restart");
        for(int i=0; i<9; ++i)
        {
            buttons[i].setEnabled(false);
        }
    }

    public void restart(JButton[] buttons)
    {
        for(int i=0; i<9; ++i)
        {
            buttons[i].setText("");
        }

        for(int i=0; i<9; ++i)
        {
            buttons[i].setEnabled(true);
        }
    }

    public Boolean check_win(JButton[] buttons, String symbol)
    {
        Boolean horizontal = compare_horizontal(buttons, symbol);
        Boolean vertical = compare_vertical(buttons, symbol);
        Boolean slash = compare_slash(buttons, symbol);

        return horizontal || vertical || slash;
    }

    public Boolean check_tie(JButton[] buttons)
    {
        for(int i=0; i<9; ++i)
        {
            if(buttons[i].getText() == "")
                return false;
        }

        return true;
    }

    public Boolean compare_horizontal(JButton[] buttons, String symbol)
    {
        if(buttons[0].getText() == symbol && buttons[1].getText() == symbol && buttons[2].getText() == symbol)
        {
            return true;
        }
        if(buttons[3].getText() == symbol && buttons[4].getText() == symbol && buttons[5].getText() == symbol)
        {
            return true;
        }
        if(buttons[6].getText() == symbol && buttons[7].getText() == symbol && buttons[8].getText() == symbol)
        {
            return true;
        }

        return false;
    }

    public Boolean compare_vertical(JButton[] buttons, String symbol)
    {
        if(buttons[0].getText() == symbol && buttons[3].getText() == symbol && buttons[6].getText() == symbol)
        {
            return true;
        }
        if(buttons[1].getText() == symbol && buttons[4].getText() == symbol && buttons[7].getText() == symbol)
        {
            return true;
        }
        if(buttons[2].getText() == symbol && buttons[5].getText() == symbol && buttons[8].getText() == symbol)
        {
            return true;
        }

        return false;
    }

    public Boolean compare_slash(JButton[] buttons, String symbol)
    {
        if(buttons[0].getText() == symbol && buttons[4].getText() == symbol && buttons[8].getText() == symbol)
        {
            return true;
        }
        if(buttons[2].getText() == symbol && buttons[4].getText() == symbol && buttons[6].getText() == symbol)
        {
            return true;
        }

        return false;
    }
}
