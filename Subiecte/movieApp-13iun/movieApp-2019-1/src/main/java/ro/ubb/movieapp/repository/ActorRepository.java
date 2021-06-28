package ro.ubb.movieapp.repository;

import org.springframework.stereotype.Repository;
import ro.ubb.movieapp.model.Actor;

@Repository
public interface ActorRepository extends MovieAppRepository<Actor, Long> {
}
