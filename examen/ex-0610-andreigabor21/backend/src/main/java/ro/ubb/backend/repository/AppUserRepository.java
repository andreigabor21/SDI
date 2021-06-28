package ro.ubb.backend.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.backend.model.AppUser;

@Repository
public interface AppUserRepository extends BlogRepository<AppUser, Long> {

    @Query("select user from AppUser user where user.id = :id")
    @EntityGraph(value = "userWithFollowers", type = EntityGraph.EntityGraphType.LOAD)
    AppUser findWithFollowers(Long id);

    @Query("select user from AppUser user where user.id = :id")
    @EntityGraph(value = "userWithFollowersWithPostsWithComments", type = EntityGraph.EntityGraphType.LOAD)
    AppUser findWithPostsAndFollowers(Long id);
}
