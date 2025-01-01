package com.kuan96;

public class Main {
    public static void main(String[] args)
    {
        playerData player = new playerData();
        InputHandler input = new InputHandler(player);
        input.handler();

        ChooseMode mode = new ChooseMode();
    }
}
