package ro.ubb.backend.converter;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.backend.dto.UserDto;
import ro.ubb.backend.model.AppUser;

@Component
public class UserConverter implements Converter<AppUser, UserDto> {

    @Autowired
    private FollowerConverter followerConverter;

    @Override
    public AppUser toModel(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto toDTO(AppUser user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setId(user.getId());
        userDto.setFollowers(followerConverter.toDTOList(user.getFollowers()));
        return userDto;
    }
}
