import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        String name = null;
        int id = 0, lower = 0, upper = 0;
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("name: ");
        name = scanner.next();
        System.out.print("id: ");
        id = scanner.nextInt();
        int PORT = id + 2000;
        int count = 0;

        while (true) {
            try (Socket socket = new Socket(HOST, PORT);
                 InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream();
            ) {
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                int a = Math.abs(random.nextInt()) % 2;
                int b = Math.abs(random.nextInt()) % 2;
                int c = Math.abs(random.nextInt()) % 2;
                ++count;
                System.out.println(String.format("#%d - %s - %d %d %d", count, name, a, b, c));
                dataOutputStream.writeUTF(name + ";" + a + ";" + b + ";" + c);
                Thread.sleep(3000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
