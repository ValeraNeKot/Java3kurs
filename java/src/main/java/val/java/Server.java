package val.java;

import java.io.*;
import java.net.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        List<Socket> currentSockets = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен и ожидает подключения...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                currentSockets.add(clientSocket);
                System.out.println("Клиент подключен.");
                new Thread(new ClientHandler(clientSocket)).start();
                System.out.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    }


