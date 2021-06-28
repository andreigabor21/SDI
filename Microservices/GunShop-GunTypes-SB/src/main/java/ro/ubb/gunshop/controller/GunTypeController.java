package ro.ubb.gunshop.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.gunshop.converter.GunTypeConverter;
import ro.ubb.gunshop.dto.GunTypeDto;
import ro.ubb.gunshop.dto.GunTypesDto;
import ro.ubb.gunshop.model.GunType;
import ro.ubb.gunshop.service.GunTypeService;

import java.util.List;

@RestController
public class GunTypeController {

    public static final Logger logger = LoggerFactory.getLogger(GunTypeController.class);

    @Autowired
    private GunTypeService gunTypeService;

    @Autowired
    private GunTypeConverter gunTypeConverter;

    @RequestMapping(value = "/gun-types")
    GunTypesDto getAllGunTypes() {
        logger.trace("getAllGunTypes - method entered");
        List<GunType> gunTypes = gunTypeService.getAllGunTypes();
        GunTypesDto gunTypesDto = new GunTypesDto(gunTypeConverter.convertModelsToDTOs(gunTypes));
        logger.trace("getAllGunTypes: " + gunTypes);
        return gunTypesDto;
    }

    @RequestMapping(value = "/gun-types", method = RequestMethod.POST)
    void addGunType(@RequestBody GunTypeDto gunTypeDto) {
        logger.trace("addGunType - method entered - gunTypeDto: " + gunTypeDto);
        GunType gunType = gunTypeConverter.convertDtoToModel(gunTypeDto);
        gunTypeService.addGunType(gunType.getName(), gunType.getCategory());
        logger.trace("addGunType - added");
    }

}
