package val.java_cl;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client {

    private JTextField sizeField;
    private JPanel matrixPanel;
    private JButton sendButton;
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Client::new);
    }

    public Client() {
        frame = new JFrame("Matrix Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel sizeLabel = new JLabel("Размер матрицы:");
        sizeField = new JTextField(10);
        JButton generateButton = new JButton("Создать матрицу");
        topPanel.add(sizeLabel);
        topPanel.add(sizeField);
        topPanel.add(generateButton);

        matrixPanel = new JPanel();
        matrixPanel.setLayout(new GridLayout(0, 1, 5, 5));

        sendButton = new JButton("Отправить матрицу");
        sendButton.setEnabled(false);

        generateButton.addActionListener(e -> generateMatrixInput());
        sendButton.addActionListener(e -> sendMatrix());

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(matrixPanel), BorderLayout.CENTER);
        frame.add(sendButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void generateMatrixInput() {
        matrixPanel.removeAll();
        try {
            int size = Integer.parseInt(sizeField.getText().trim());
            if (size <= 0) throw new NumberFormatException();

            matrixPanel.setLayout(new GridLayout(size, size, 5, 5));

            for (int i = 0; i < size * size; i++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                matrixPanel.add(cell);
            }

            sendButton.setEnabled(true);
            frame.revalidate();
        } catch (NumberFormatException e) {
            showErrorDialog("Введите корректный размер матрицы (положительное целое число).");
        }
    }

    private void sendMatrix() {
        try {
            double[][] matrix = getMatrixFromInput();

            String serverAddress = "localhost";
            int port = 12345;
            try (Socket socket = new Socket(serverAddress, port);
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                out.writeObject(matrix);
                out.flush();

                double result = in.readDouble();
                showInfoDialog("Отношение среднего значения главной диагонали к побочной: " + result);
            }

        } catch (NumberFormatException e) {
            showErrorDialog("Убедитесь, что все элементы матрицы заполнены корректными числами.");
        } catch (IOException e) {
            showErrorDialog("Не удалось подключиться к серверу.");
        }
    }

    private double[][] getMatrixFromInput() throws NumberFormatException {
        int size = Integer.parseInt(sizeField.getText().trim());
        double[][] matrix = new double[size][size];

        Component[] components = matrixPanel.getComponents();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JTextField cell = (JTextField) components[i * size + j];
                if (cell.getText().trim().isEmpty()) {
                    throw new NumberFormatException("Пустая ячейка");
                }
                matrix[i][j] = Double.parseDouble(cell.getText().trim());
            }
        }

        return matrix;
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfoDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Информация", JOptionPane.INFORMATION_MESSAGE);
    }
}
