package ro.ubb.catalog.core.repository;

import ro.ubb.catalog.core.model.GunType;

import java.util.List;

public interface GunTypeCustomRepository {

    List<GunType> findByGivenName(String name);

    List<GunType> findByNameStartsWith(Character character);
}
