package com.company.users;

import com.company.Main;
import com.company.Util.UserPassStorage;

import javax.swing.*;
import java.util.ArrayList;

public class Base {

    protected int clearance = 0;
    private Main main;

    public Base(Main main) {
        this.main = main;
    }

    public void switchFile(String user, int index, JPanel panel) {
        ArrayList<String> list = UserPassStorage.loadArray(user);

        String s = list.get(index);
        if (!s.equals("Swarsheni") && !s.equals("Aktiwni")) {
            list.remove(index);

            if (index > list.indexOf("Swarsheni"))
                list.add(1, s);
            else list.add(list.indexOf("Swarsheni") + 1, s);


            UserPassStorage.storeFile(user, list);
            main.getDisplay().rabotnik(user, list, panel);
        }
    }

    protected ArrayList<String> getFile(String user) {
        return UserPassStorage.loadArray(user);
    }
}
