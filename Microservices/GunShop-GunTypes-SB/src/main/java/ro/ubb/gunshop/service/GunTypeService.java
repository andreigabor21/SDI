package ro.ubb.gunshop.service;


import ro.ubb.gunshop.model.GunType;

import java.util.List;

public interface GunTypeService {

    List<GunType> getAllGunTypes();

    void addGunType(String name, String category);

    /*void updateClient(Long id, String name, Integer years);

    void deleteClient(Long id);

    List<GunType> getClientsByName(String name);*/
}
