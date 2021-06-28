package ro.ubb.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.backend.converter.UserConverter;
import ro.ubb.backend.dto.UserDto;
import ro.ubb.backend.model.AppUser;
import ro.ubb.backend.service.AppUserService;

@RestController
public class AppController {
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private UserConverter userConverter;

    @PostMapping("/user")
    public ResponseEntity<UserDto> getUserById(@RequestParam Long id) {
        logger.info("in getUserById");
        AppUser appUser = appUserService.find(id);
        UserDto userDto = userConverter.toDTO(appUser);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/user-followers/{id}")
    public ResponseEntity<UserDto> getUserByIdWithFollowers(@PathVariable Long id) {
        logger.info("in getUserByIdWithFollowers");
        AppUser appUser = appUserService.findWithFollowers(id);
        UserDto userDto = userConverter.toDTO(appUser);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/user-posts-followers/{id}")
    public ResponseEntity<UserDto> getUserByIdWithFollowersAndPosts(@PathVariable Long id) {
        logger.info("in getUserByIdWithFollowers");
        AppUser appUser = appUserService.findWithPostsAndFollowers(id);
        UserDto userDto = userConverter.toDTO(appUser);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
