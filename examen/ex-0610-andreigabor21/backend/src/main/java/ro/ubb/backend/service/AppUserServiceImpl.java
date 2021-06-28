package ro.ubb.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.backend.model.AppUser;
import ro.ubb.backend.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser find(Long id) {
        return appUserRepository.findById(id).orElseThrow();
    }

    @Override
    public AppUser findWithFollowers(Long id) {
        return appUserRepository.findWithFollowers(id);
    }

    @Override
    public AppUser findWithPostsAndFollowers(Long id) {
        return appUserRepository.findWithPostsAndFollowers(id);
    }
}
