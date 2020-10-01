package Recursions;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Exercises {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Практическая работа №5");

        BufferedReader reader = null;
        ArrayList<String> exTitles = new ArrayList<>();
        try {
            reader =
                    new BufferedReader(
                            new FileReader(new File("Exercises.txt")));
            reader.mark(32000);
            String line1 = reader.readLine();
            while(line1 != null) {
                exTitles.add(line1);
                do {
                    line1 = reader.readLine();
                } while(line1 != null && line1.length() != 0);
                line1 = reader.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        int nEx = exTitles.size();
        frame.setSize(300, 39 + (nEx + 1) * (26 + 5));
        frame.setLayout(new GridLayout(nEx + 1, 1));
        JPanel[] exPnl = new JPanel[nEx + 1];
        exPnl[0] = new JPanel();
        exPnl[0].setLayout(new BorderLayout());
        exPnl[0].add(new JLabel("Выбирете упражнение:", JLabel.CENTER),
                BorderLayout.CENTER);
        frame.add(exPnl[0]);

        BufferedReader finalReader = reader;
        JButton[] exButtons = new JButton[nEx];
        for(int i = 0; i < nEx; i++) {
            exPnl[i + 1] = new JPanel(new BorderLayout());
            exButtons[i] = new JButton(exTitles.get(i));
            exButtons[i].addActionListener(e -> {
                //Узнаём номер упражнения
                String str = e.toString();
                int n = str.charAt(48) - 48;
                if(str.charAt(49) != '.')
                    n = n * 10 + (int) str.charAt(49) - 48;
                n--;

                JFrame ex = new JFrame(exTitles.get(n));
                ex.setSize(400, 330);
                ex.setLayout(new BorderLayout());

                //Получаем текст самого задания и список параметров
                StringBuilder exTxt = new StringBuilder();
                int nInput = 0;
                String[] inputTitles = null;
                try {
                    finalReader.reset();
                    String line2 = finalReader.readLine();
                    while(line2 != null) {
                        if(line2.equals(exTitles.get(n))) {
                            nInput = Integer.parseInt(finalReader.readLine());
                            inputTitles = new String[nInput];
                            for(int j = 0; j < nInput; j++) {
                                inputTitles[j] = finalReader.readLine();
                            }
                            line2 = finalReader.readLine();
                            do {
                                exTxt.append(line2).append("\n\n");
                                line2 = finalReader.readLine();
                            } while(line2 != null && line2.length() != 0);
                            break;
                        }
                        line2 = finalReader.readLine();
                    }
                } catch(IOException t) {
                    t.printStackTrace();
                }
                //Удаляем лишние переносы в конце
                exTxt.delete(exTxt.length() - 2, exTxt.length());

                TextArea exTextArea = new TextArea(exTxt.toString(), 0, 0,
                        TextArea.SCROLLBARS_VERTICAL_ONLY);
                exTextArea.setEditable(false);
                ex.add(exTextArea, BorderLayout.NORTH);


                JPanel mainPnl = new JPanel(true);
                JPanel[] inputPnl = new JPanel[nInput + 1];
                JLabel[] inputLabel = new JLabel[nInput];
                JTextField[] inputJtf = new JTextField[nInput];
                mainPnl.setLayout(new GridLayout(nInput + 1, 1));
                for(int j = 0; j < nInput; j++) {
                    inputPnl[j] = new JPanel(true);
                    inputLabel[j] = new JLabel("Введите " + inputTitles[j]);
                    inputPnl[j].add(inputLabel[j]);
                    inputJtf[j] = new JTextField(20);
                    inputJtf[j].setFont(new Font("MONOSPACED", Font.BOLD, 14));
                    inputPnl[j].add(inputJtf[j]);
                    mainPnl.add(inputPnl[j]);
                }

                inputPnl[nInput] = new JPanel(true);
                Label resultLabel = new Label("", Label.CENTER);
                ex.add(resultLabel, BorderLayout.SOUTH);
                JButton getResult = new JButton("Вычислить результат");
                int finalN = n, finalNInput = nInput;
                String[] finalInputTitles = inputTitles;
                getResult.addActionListener(f -> {
                    long[] inputs = {1, 1};
                    if(finalN != 7) {
                        inputs = new long[finalNInput];
                        for(int k = 0; k < finalNInput; k++) {
                            try {
                                inputs[k] =
                                        Long.parseLong(
                                                inputJtf[k].getText().trim());
                            } catch(Exception g) {
                                JOptionPane.showMessageDialog(null,
                                        "Ошибка в пункте \"" +
                                                finalInputTitles[k] + "\"!",
                                        "Ошибка",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    switch (finalN) {
                        //натуральные
                        case (0) -> {
                            StringBuilder result = new StringBuilder(
                                    Exercise01.TriangularSequence(1,
                                            inputs[0]));
                            result.delete(result.length() - 2, result.length());
                            resultLabel.setText(String.valueOf(result));
                        }
                        //натуральные
                        case (1) -> resultLabel.setText(
                                Exercise02.fromAtoB(1, inputs[0]));
                        case (2) -> resultLabel.setText(
                                Exercise03.fromAtoB(inputs[0], inputs[1]));
                        case (3) -> resultLabel.setText(String.valueOf(
                                Exercise04.nNumbersWithSum(inputs[0], inputs[1],
                                        true)));
                        //натуральные
                        case (4) -> resultLabel.setText(String.valueOf(
                                Exercise05.sumOfDigits(inputs[0])));
                        case (5) -> resultLabel.setText(
                                Exercise06.isPrime(inputs[0]) ? "YES" : "NO");
                        case (6) -> resultLabel.setText(
                                Exercise07.getDivisors(inputs[0], 2));
                        case (7) -> {
                            String input = inputJtf[0].getText();
                            resultLabel.setText(
                                    Exercise08.isPalindrome(input) ? "YES" :
                                            "NO");
                        }
                        case (8) -> resultLabel.setText(String.valueOf(
                                Exercise09.nNumbersWithN00(inputs[0],
                                        inputs[1])));
                        case (9) -> resultLabel.setText(
                                String.valueOf(Exercise10.invert(inputs[0])));
                        default -> resultLabel.setText(
                                "Я ещё не сделал это упражнение(");
                    }
                });
                inputPnl[nInput].add(getResult);
                mainPnl.add(inputPnl[nInput]);
                ex.add(mainPnl, BorderLayout.CENTER);
                ex.setVisible(true);
            });
            exPnl[i + 1].add(exButtons[i], BorderLayout.NORTH);
            frame.add(exPnl[i + 1]);
            frame.setVisible(true);
        }
    }
}