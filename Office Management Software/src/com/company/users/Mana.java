package com.company.users;

import com.company.Main;
import com.company.Util.UserPassStorage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Mana extends Empl {

    private String currentUser;

    public Mana(Main main) {
        super(main);
    }

    public void openTheWorkbox(String user) {
        currentUser = user;
        main.getDisplay().manager(user, null);
    }

    public void callingEmployeeRecords(String user) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton back = new JButton("Back");
        JButton dobawi = new JButton("Dobawi");
        JButton mahni = new JButton("Mahni");

        JTextField dobawiTekst = new JTextField();
        JTextField mahniIndeks = new JTextField();

        dobawiTekst.setFont(main.getFont());
        mahniIndeks.setFont(main.getFont());
        dobawiTekst.setPreferredSize(new Dimension(200, 60));
        mahniIndeks.setPreferredSize(new Dimension(200, 60)); // manager employee rabota da promeni aktiwnost dolu dqsno indeks 11 cakane

        JLabel tekstLabel = new JLabel("Teksta za now wapros");
        JLabel mahniLabel = new JLabel("Indeksa na waprosa za mahane");

        back.addActionListener(e -> {
            openTheWorkbox(currentUser);
        });
        dobawi.addActionListener(e -> {
            ArrayList<String> arrayList = UserPassStorage.loadArray(user);
            arrayList.add(1, dobawiTekst.getText());
            UserPassStorage.storeFile(user, arrayList);
            main.getMana().callingEmployeeRecords(user);
        });

        mahni.addActionListener(e -> {
            ArrayList<String> arrayList = UserPassStorage.loadArray(user);
            if (Integer.parseInt(mahniIndeks.getText()) != 0 && !arrayList.get(Integer.parseInt(mahniIndeks.getText())).equals("Swarsheno")) {
                arrayList.remove(Integer.parseInt(mahniIndeks.getText()));
                UserPassStorage.storeFile(user, arrayList);
                main.getMana().callingEmployeeRecords(user);
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(tekstLabel, constraints);
        constraints.gridx = 1;
        panel.add(dobawiTekst, constraints);
        constraints.gridx = 2;
        panel.add(dobawi, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(mahniLabel, constraints);
        constraints.gridx = 1;
        panel.add(mahniIndeks, constraints);
        constraints.gridx = 2;
        panel.add(mahni, constraints);

        constraints.gridx = 3;
        constraints.gridy = 3;
        panel.add(back, constraints);

        openTheWorkbox(user,panel);
    }

}
