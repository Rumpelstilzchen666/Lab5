package Recursions;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exercises implements Exercise02, Exercise03, Exercise04,
        Exercise05, Exercise06, Exercise07, Exercise08, Exercise09, Exercise10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Практическая работа №5");
        frame.setVisible(true);

        ArrayList<String> exNames = new ArrayList<>();
        try {
            File exFile = new File("Exercises.txt");
            BufferedReader reader =
                    new BufferedReader(new FileReader(exFile));
            String line = reader.readLine();
            while(line != null) {
                exNames.add(line);
                do {
                    line = reader.readLine();
                } while(line != null && line.length() != 0);
                line = reader.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        int nEx = exNames.size();
        frame.setSize(300, 39 + (nEx + 1) * (26 + 5));
        frame.setLayout(new GridLayout(nEx + 1, 1));
        JPanel[] pnl = new JPanel[nEx + 1];
        pnl[0] = new JPanel();
        pnl[0].setLayout(new BorderLayout());
        pnl[0].add(new JLabel("Выбирете упражнение:", JLabel.CENTER),
                BorderLayout.CENTER);
        frame.add(pnl[0]);

        JButton[] exBottons = new JButton[nEx];
        for(int i = 0; i < nEx; i++) {
            exBottons[i] = new JButton(exNames.get(i));
            exBottons[i].addActionListener(e -> {
                String str = e.toString();
                int n = str.charAt(48) - 48;
                if(str.charAt(49) != '.')
                    n = n * 10 + (int) str.charAt(49) - 48;
                n--;

                JFrame ex = new JFrame(exNames.get(n));
                ex.setVisible(true);
                ex.setSize(500, 300);
                ex.setLayout(new BorderLayout());

                str = "";
                try {
                    File exFile = new File("Exercises.txt");
                    BufferedReader reader =
                            new BufferedReader(new FileReader(exFile));
                    String line = reader.readLine();
                    while(line != null) {
                        if(line.equals(exNames.get(n))) {
                            line = reader.readLine();
                            do {
                                str += line + '\n' + '\n';
                                line = reader.readLine();
                            } while(line != null && line.length() != 0);
                            break;
                        }
                        line = reader.readLine();
                    }
                } catch(IOException t) {
                    t.printStackTrace();
                }
                char[] c = str.toCharArray();
                for(int i1 = 1, l = 0; l + i1 < str.length(); i1++) {
                    if(i1 % 75 == 0) {
                        for(; i1 > 0; i1--) {
                            if(c[l + i1] == ' ') {
                                c[l + i1] = '\n';
                                break;
                            }
                        }
                    }
                    if(c[l + i1] == '\n') {
                        l += i1 + 1;
                        i1 = 1;
                    }
                }

                TextArea exTxt = new TextArea(String.copyValueOf(c));
                exTxt.setEditable(false);
                ex.add(exTxt, BorderLayout.NORTH);
            });
            pnl[i + 1] = new JPanel();
            pnl[i + 1].setLayout(new BorderLayout());
            pnl[i + 1].add(exBottons[i], BorderLayout.NORTH);
            frame.add(pnl[i + 1]);
        }
    }
}