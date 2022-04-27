package com.company.users;

import com.company.Main;

import javax.swing.*;

public class Empl extends Base {

    Main main;
    private JButton button;
    private String currentUser;

    public Empl(Main main) {
        super(main);
        this.main = main;
    }


    public void openTheWorkbox(String user, JPanel panel) {
        currentUser = user;
        main.getDisplay().rabotnik(user, null, panel);
    }

    public void emplChangeFile(int index,String user,JPanel panel) {
        switchFile(user, index,panel);
    }


    //glawen metod w wsi4ki butoni zakontrol i metodite otdelno koito mogat da se wikat i ot sledwastite


}
