package val.udp;

import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(PORT);
            System.out.println("Сервер запущен...");
            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Получено сообщение: " + message);

                String[] params = message.split(",");
                double x = Double.parseDouble(params[0]);
                double y = Double.parseDouble(params[1]);
                double result = calculateFunction(x, y);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String response = String.valueOf(result);
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);

                saveToFile(x, y, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    private static double calculateFunction(double x, double y) {
        return 2 * x * Math.pow(1 + Math.pow(x, 2), 2) * (Math.sqrt(x)) / (x + Math.pow(Math.abs(1 + Math.pow(x, 5)), 1.0 / 3.0)) / (2 * y + 10);
    }

    private static void saveToFile(double x, double y, double result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true))) {
            writer.write("x: " + x + ", y: " + y + ", result: " + result);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}