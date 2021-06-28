package ro.ubb.gunshop.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.gunshop.model.GunType;
import ro.ubb.gunshop.repository.GunTypeRepository;

import java.util.List;

@Service
public class GunTypeServiceImpl implements GunTypeService {

    public static final Logger logger = LoggerFactory.getLogger(GunTypeServiceImpl.class);

    @Autowired
    private GunTypeRepository gunTypeRepository;

    @Override
    public List<GunType> getAllGunTypes() {
        logger.trace("getAllGunTypes - method entered");
        List<GunType> gunTypes = gunTypeRepository.findAll();
        logger.trace("getAllGunTypes result: " + gunTypes);
        return gunTypes;
    }

    @Override
    public void addGunType(String name, String category) {
        logger.trace("addGunType - method entered");
        GunType gunType = new GunType(name, category);
        gunTypeRepository.save(gunType);
        logger.trace("addGunType - method finished");
    }
}
