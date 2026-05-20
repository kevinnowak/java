package com.github.kevinnowak.java.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    static void main() {
        try (
                ServerSocket server = new ServerSocket(9000);
                Socket client = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {
            IO.println("Connected...");
            String line = "";

            while ((line = in.readLine()) != null) {
                out.println("You said: " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
