package ro.ubb.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.backend.model.MyClass;
import ro.ubb.backend.repository.MyRepository;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private MyRepository myRepository;

    public List<MyClass> getAll() {
        return myRepository.findAll();
    }
}
