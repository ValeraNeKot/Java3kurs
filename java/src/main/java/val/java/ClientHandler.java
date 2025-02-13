package val.java;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

            double[][] matrix = (double[][]) in.readObject();
            double result = calculateRatio(matrix);

            out.writeDouble(result);
            out.flush();

            saveToDatabase(matrix, result);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void saveToDatabase(double[][] matrix, double result) {
        DatabaseHandler dbHandler = new DatabaseHandler();

        StringBuilder matrixRepresentation = new StringBuilder();
        for (double[] row : matrix) {
            for (double value : row) {
                matrixRepresentation.append(value).append(",");
            }
            matrixRepresentation.append(";");
        }

        int size = matrix.length;
        double mainDiagonalSum = 0;
        double secondaryDiagonalSum = 0;

        for (int i = 0; i < size; i++) {
            mainDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][size - i - 1];
        }

        double mainDiagonalAvg = mainDiagonalSum / size;
        double secondaryDiagonalAvg = secondaryDiagonalSum / size;

        dbHandler.saveCalculation(size, matrixRepresentation.toString(), mainDiagonalAvg, secondaryDiagonalAvg, result);
    }
    
    private static double calculateRatio(double[][] matrix) {
        int size = matrix.length;
        double mainDiagonalSum = 0;
        double secondaryDiagonalSum = 0;

        for (int i = 0; i < size; i++) {
            mainDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][size - 1 - i];
        }

        double mainDiagonalAverage = mainDiagonalSum / size;
        double secondaryDiagonalAverage = secondaryDiagonalSum / size;

        return secondaryDiagonalAverage == 0 ? 0 : mainDiagonalAverage / secondaryDiagonalAverage;
    }
}
