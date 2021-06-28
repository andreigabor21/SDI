package ro.ubb.backend.converter;

import org.springframework.stereotype.Component;
import ro.ubb.backend.dto.FollowerDto;
import ro.ubb.backend.dto.UserDto;
import ro.ubb.backend.model.Follower;

@Component
public class FollowerConverter implements Converter<Follower, FollowerDto> {
    @Override
    public Follower toModel(FollowerDto followerDto) {
        return null;
    }

    @Override
    public FollowerDto toDTO(Follower follower) {
        FollowerDto followerDto = new FollowerDto();
        followerDto.setId(follower.getId());
        followerDto.setName(follower.getName());
        return followerDto;
    }
}
