package ro.ubb.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.movieapp.converter.ActorConverter;
import ro.ubb.movieapp.dto.ActorDto;
import ro.ubb.movieapp.model.Actor;
import ro.ubb.movieapp.service.ActorService;

import java.util.List;

@RestController
@RequestMapping(path = "/movieapp")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private ActorConverter actorConverter;

    @GetMapping("/actors")
    public ResponseEntity<List<ActorDto>> getAllActors() {
        List<Actor> allActors = actorService.getAllActors();
        return new ResponseEntity<>(actorConverter.convertModelsToDtos(allActors), HttpStatus.OK);
    }

    @GetMapping("/actors/available")
    public ResponseEntity<List<ActorDto>> getAllAvailableActors() {
        List<Actor> allActors = actorService.getAllAvailableActors();
        return new ResponseEntity<>(actorConverter.convertModelsToDtos(allActors), HttpStatus.OK);
    }


}
