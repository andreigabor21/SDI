package ro.ubb.sensors;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int PORT = 2000;
    public static final String HOST = "localhost";

    private static String makeMessage(String name, Integer sensorId, Integer randomMeasurement) {
        return name + ";" + sensorId + ";" + randomMeasurement;
    }

    public static void main(String[] args) {
        String name;
        Integer sensorId, lowerBound, upperBound;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Read name:");
        name = scanner.nextLine();
        System.out.println("sensor id:");
        sensorId = scanner.nextInt();
        System.out.println("lowerBound:");
        lowerBound = scanner.nextInt();
        System.out.println("upperBound:");
        upperBound = scanner.nextInt();

        Random random = new Random();
        while (true) {
            Integer randomMeasurement = random.nextInt(upperBound - lowerBound) + lowerBound;
            String message = makeMessage(name, sensorId, randomMeasurement);

            try (var socket = new Socket(HOST, PORT);
                 OutputStream outputStream = socket.getOutputStream();
                 DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {

                System.out.println("sending message: " + message);
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush(); // send the message

                System.out.println("message sent");
                Thread.sleep(1000 + random.nextInt(2000)); //delay
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
