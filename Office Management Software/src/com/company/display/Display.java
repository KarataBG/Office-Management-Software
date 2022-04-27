package com.company.display;

import com.company.Main;
import com.company.Util.UserPassStorage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display {

    private Main main;

    private JFrame frame;
    private JTextField user;
    private JTextField pass;
    private JLabel label;
    private JButton button;

    private String title;
    private int width, height;

    private Font font;

    public Display(Main main, String title, double width, double height) {
        this.main = main;
        this.title = title;
        this.width = (int) width;
        this.height = (int) height;
        Frame();
    }

    private void Frame() {
        frame = new JFrame(title);
        frame.setLayout(new GridBagLayout());

        First();

        frame.setBounds(0, 0, width, height);
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.pack();
    }

    private void First() {
        font = new Font("Arial", Font.PLAIN, 35);

        user = new JTextField();
        user.setPreferredSize(new Dimension(300, 50));
        user.setFont(font);
        pass = new JTextField();
        pass.setPreferredSize(new Dimension(300, 50));
        pass.setFont(font);
        label = new JLabel("Dai username i password");
        label.setFont(font);
        button = new JButton("ENTER");
        button.setFont(font);

        button.addActionListener(e -> {
            int a = UserPassStorage.load(user.getText(), pass.getText());
            switch (a) {
                case 1:
                    main.getEmpl().openTheWorkbox(user.getText(), null);
                    break;
                case 2:
                    main.getMana().openTheWorkbox(user.getText());
                    break;
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(label, constraints);
        constraints.gridy = 1;
        frame.add(user, constraints);
        constraints.gridy = 2;
        frame.add(pass, constraints);
        constraints.gridy = 3;
        frame.add(button, constraints);
    }

    public void rabotnik(String user, ArrayList<String> arrayList, JPanel panel) {
        frame.dispose();
        frame = new JFrame(title);
        frame.setLayout(new GridBagLayout());

        frame.setBounds(0, 0, width, height);
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        font = new Font("Arial", Font.PLAIN, 25);
        JList<String> jList;
        if (arrayList != null)
            jList = new JList(arrayList.toArray());
        else
            jList = new JList(UserPassStorage.loadArray(user).toArray());
        jList.setFont(font);
        jList.setCellRenderer(new MyCellRenderer());

        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(100, 40));
        JLabel label = new JLabel("Indeks");
        label.setFont(font);
        JButton button = new JButton("Promeni");
        button.addActionListener(e -> {
            main.getEmpl().emplChangeFile(Integer.parseInt(textField.getText()), user, panel);
        });

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(jList, constraints);
        constraints.gridy = 1;
        frame.add(label, constraints);
        constraints.gridx = 1;
        frame.add(textField, constraints);
        constraints.gridx = 2;
        frame.add(button, constraints);

        if (panel != null)
            frame.add(panel);

        frame.pack();
    }

    public void manager(String manager, ArrayList arrayList) {
        frame.dispose();
        frame = new JFrame(title);
        frame.setLayout(new GridBagLayout());

        frame.setBounds(0, 0, width, height);
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        font = new Font("Arial", Font.PLAIN, 25);

        JList<String> list;
        if (arrayList != null)
            list = new JList(arrayList.toArray());
        else
            list = new JList(UserPassStorage.getEmployeesList(manager).toArray());
        list.setFont(font);

        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(100, 40));
        JLabel label = new JLabel("Koi rabotnik iskash da widish");
        label.setFont(font);
        JButton button = new JButton("Wizh");
        button.addActionListener(e -> {
            textField.getText();
            main.getMana().callingEmployeeRecords(textField.getText());
        });

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(list, constraints);
        constraints.gridy = 1;
        frame.add(label, constraints);
        constraints.gridx = 1;
        frame.add(textField, constraints);
        constraints.gridx = 2;
        frame.add(button, constraints);

        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}

class MyCellRenderer extends DefaultListCellRenderer {
    final JPanel p = new JPanel(new BorderLayout());
    final JPanel IconPanel = new JPanel(new BorderLayout());
    final JLabel lt = new JLabel();
    String pre = "<html><body style='width: 600px;'>";
    private Font font = new Font("Arial", Font.PLAIN, 25);

    MyCellRenderer() {
        lt.setFont(font);
        p.add(lt, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(final JList list, final Object value, final int index, final boolean isSelected, final boolean hasFocus) {
        final String text = (String) value;
        lt.setText(pre + text);
        return p;
    }
}