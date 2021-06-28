package ro.ubb.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ro.ubb.backend.model.BaseEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface BlogRepository<T extends BaseEntity<ID>, ID extends Serializable>
        extends JpaRepository<T, ID> {
}
