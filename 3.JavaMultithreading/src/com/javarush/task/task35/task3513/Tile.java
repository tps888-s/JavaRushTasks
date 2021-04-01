package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {
    int value;

    public Tile() {
        this.value = 0;
    }

    public Tile(int value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public Color getFontColor() {

        if (value < 16) return new Color(0x77, 0x6e, 0x65);
        else return new Color(0xf9, 0xf6, 0xf2);
    }

    public Color getTileColor() {
        switch (value) {

            case 0:
                return new Color (0xcd,0xc1,0xb4);
            case 2:
                return new Color(0xee, 0xe4, 0xda);
            case 4:
                return new Color(0xed, 0xe0, 0xc8);
            case 8:
                return new Color(0xf2, 0xb1, 0x79);
            case 16:
                return new Color(0xf5, 0x95, 0x63);
            case 32:
                return new Color(0xf6, 0x7c, 0x5f);
            case 64:
                return new Color(0xf6, 0x5e, 0x3b);
            case 128:
                return new Color(0xed, 0xcf, 0x72);
            case 256:
                return new Color(0xed, 0xcc, 0x61);
            case 512:
                return new Color(0xed, 0xc8, 0x50);
            case 1024:
                return new Color(0xed, 0xc5, 0x3f);
            case 2048:
                return new Color(0xed, 0xc2, 0x2e);
        }
        return new Color(0xff, 0x00, 0x00);
    }
}
