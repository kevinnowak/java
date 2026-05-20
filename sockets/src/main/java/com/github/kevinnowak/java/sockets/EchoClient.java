package com.github.kevinnowak.java.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    static void main() {
        try (
                Socket echoSocket = new Socket("localhost", 9000);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;

            while ((((userInput = stdIn.readLine())) != null) && !userInput.isEmpty()) {
                out.println(userInput);
                IO.println(in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
