package com.luxsoft.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3000);
             Socket incoming = serverSocket.accept();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(incoming.getOutputStream()));) {

            while (true) {
                String messageFromClient = bufferedReader.readLine();
                if (!(messageFromClient.trim().equals("BYE") || messageFromClient.trim().equals("q"))) {
                    bufferedWriter.write("echo: " + messageFromClient);
                }
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
    }
}



