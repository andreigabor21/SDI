package ro.ubb.razvan.county.server;

import java.io.*;
import java.net.Socket;

public class HandleVotingScan implements Runnable {
    private Socket socket;

    public HandleVotingScan(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String measurement = dataInputStream.readUTF();
            String[] split = measurement.split(";");
            String name = split[0];
            int a = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[2]);
            int c = Integer.parseInt(split[3]);
            Server.aCount += a;
            Server.bCount += b;
            Server.cCount += c;
            System.out.println(String.format("%s %d %d %d", name, a, b, c));
            Thread.sleep(4000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
