package com.luxsoft.client;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("localhost", 3000);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Hello! Enter 'BYE' or 'q' to exit.");

            boolean done = false;
            while (!done) {
                String message = scanner.nextLine();
                if (message.trim().equals("BYE") || message.trim().equals("q")){
                    done  = true;
                }
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                String responseMessage = bufferedReader.readLine();
                System.out.println(responseMessage);
            }
        }
    }
}






