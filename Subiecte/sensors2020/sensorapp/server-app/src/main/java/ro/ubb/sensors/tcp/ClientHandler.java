package ro.ubb.sensors.tcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.sensors.Sensor;
import ro.ubb.sensors.repository.SensorRepository;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Service
public class ClientHandler implements Runnable {
    private Socket socket = null;

    public ClientHandler() {
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Autowired
    private SensorRepository sensorRepository;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    private Sensor processMessage(String message) {
        String[] splitted = message.split(";");
        String name = splitted[0];
        Long sensorId = Long.valueOf(splitted[1]);
        Integer measurement = Integer.valueOf(splitted[2]);
        Sensor sensor = Sensor
                .builder()
                .name(name)
                .sensorId(sensorId)
                .measurement(measurement)
                .time(System.currentTimeMillis())
                .build();
        return sensor;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             DataInputStream dataInputStream = new DataInputStream(inputStream)) {

            String message = dataInputStream.readUTF();
            System.out.println("received message: " + message);

            // compute response
            Sensor sensor = processMessage(message);
            System.out.println("Sensor: " + sensor);
            sensorRepository.save(sensor);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
