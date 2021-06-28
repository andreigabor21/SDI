package ro.ubb.backend.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "userWithFollowers",
                attributeNodes = @NamedAttributeNode(value = "followers")),

        @NamedEntityGraph(
                name = "userWithFollowersWithPostsWithComments",
                attributeNodes = {
                        @NamedAttributeNode(value = "followers"),
                        @NamedAttributeNode(value = "posts", subgraph = "postWithComments")
                },
                subgraphs = @NamedSubgraph(name = "postWithComments",
                attributeNodes = @NamedAttributeNode(value = "comments"))
        )})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser extends BaseEntity<Long>{
    private String name;

    private String birthday;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Follower> followers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;
}
