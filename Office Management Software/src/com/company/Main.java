package com.company;

import com.company.display.Display;
import com.company.users.Base;
import com.company.users.Empl;
import com.company.users.Mana;

import java.awt.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Main {

    private Base base;
    private Empl empl;
    private Mana mana;
    private Display display;

    private Font font = new Font("Arial", Font.PLAIN, 35);

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    private void init() {
        display = new Display(this,"Program", Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        base = new Base(this);
        empl = new Empl(this);
        mana = new Mana(this);
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Empl getEmpl() {
        return empl;
    }

    public void setEmpl(Empl empl) {
        this.empl = empl;
    }

    public Mana getMana() {
        return mana;
    }

    public void setMana(Mana mana) {
        this.mana = mana;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Font getFont() {
        return font;
    }
}
