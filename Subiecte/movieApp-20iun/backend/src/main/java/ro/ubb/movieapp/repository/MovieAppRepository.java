package ro.ubb.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ro.ubb.movieapp.model.BaseEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface MovieAppRepository<T extends BaseEntity<ID>, ID extends Serializable>
        extends JpaRepository<T, ID> {
}
