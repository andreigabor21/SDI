package ro.ubb.sensors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import ro.ubb.sensors.converter.SensorConverter;
import ro.ubb.sensors.dto.SensorDto;
import ro.ubb.sensors.model.Sensor;
import ro.ubb.sensors.service.SensorService;

@RestController
public class SensorController {
    public static final int PORT = 2000;
    public static final String HOST = "localhost";

    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorConverter sensorConverter;

    @GetMapping(value = "/all")
    public List<SensorDto> getAll() {
        List<Sensor> all = sensorService.findAll();
        return sensorConverter.toDTOList(all);
    }

    @GetMapping(value = "/names")
    public List<String> getAllNames() {
        return sensorService.findAllDistinctNames();
    }

    @GetMapping(value = "/sensors/{name}")
    public List<SensorDto> getSensorsByName(@PathVariable String name) {
        List<Sensor> topByName = sensorService.findTopByName(name);
        return sensorConverter.toDTOList(topByName);
    }

    @PostMapping(value = "/kill")
    public void kill(@RequestParam String name) {
        System.out.println("I wanna kill " + name);
        try(Socket socket = new Socket(HOST, PORT);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream()) {
         DataOutputStream dataOutputStream = new DataOutputStream(os);
         dataOutputStream.writeUTF("kill;" + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
