package ro.ubb.catalog.core.repository;

import ro.ubb.catalog.core.model.GunProvider;

import java.util.List;

public interface GunProviderCustomRepository {

    List<GunProvider> findByGivenSpeciality(String speciality);

    List<GunProvider> findByReputationInRange(int lowerBound, int upperBound);
}
