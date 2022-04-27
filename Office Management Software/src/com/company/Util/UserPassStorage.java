package com.company.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserPassStorage {

    private static final String path = new File("").getAbsolutePath();

    public static int load(String user, String pass) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + "res/userPass.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] chicks = line.split("\\s");

                if (chicks[0].equals(user) && chicks[1].equals(pass)) {
                    return Integer.parseInt(chicks[2]);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String[][] load(String user) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + "res/usersWork/" + user + "Work.txt"))) {

            String line;
            boolean type = false;
            List<String> list = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.equals("Aktiwni")) {
                    continue;
                }
                if (line.equals("Swarsheni")) {
                    type = true;
                    continue;
                }

                if (!type) list.add(line);
                else list1.add(line);
            }

            String[][] data;
            data = new String[(Math.max(list.size(), list1.size()))][(Math.max(list.size(), list1.size()))];
            for (int j = 0; j < Math.max(list.size(), list1.size()); j++) {
                data[j][0] = list.get(j);
            }
            for (int j = 0; j < Math.max(list.size(), list1.size()); j++) {
                data[j][1] = list1.get(j);
            }
            reader.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> loadArray(String user) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + "res/usersWork/" + user + "Work.txt"))) {
            String line;
            ArrayList<String> data = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            reader.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void storeFile(String user, ArrayList<String> arrayList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path + File.separator + "res/usersWork/" + user + "Work.txt"))) {
            for (String s : arrayList) {
                writer.println(s);
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getEmployeesList(String manager) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + "res/Managers/" + manager + "Employees.txt"))) {
            String line;
            ArrayList<String> data = new ArrayList<String>();
            int i = 0;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            reader.close();
            return data;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
