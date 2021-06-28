package ro.ubb.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.backend.converter.MyConverter;
import ro.ubb.backend.dto.MyDto;
import ro.ubb.backend.service.MyService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyService myService;

    @Autowired
    private MyConverter myConverter;

    @GetMapping("/all")
    public ResponseEntity<List<MyDto>> getAllObjects() {
        logger.info("getAllObjects");
        return new ResponseEntity<>(
                myConverter.toDTOList(myService.getAll()),
                HttpStatus.OK
        );
    }
}
