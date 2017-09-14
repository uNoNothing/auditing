package com.spring.user;

import java.util.ArrayList;
import java.util.List;

public class Marshall {

    public static UserDto userToUserDto(User user) {
	return new UserDto(user.getId(), user.getFirstName(), user.getSecondName(), user.getEmail());
    }

    public static User userDtoToUser(UserDto userDto) {
	if (userDto.getId() == null) {
	    userDto.setId(0);
	}
	return new User(userDto.getId(), userDto.getFirstName(), userDto.getSecondName(), userDto.getEmail());
    }

    public static List<UserDto> userToUserDto(Iterable<User> userList) {
	List<UserDto> userDtoList = new ArrayList<>();
	for (User user : userList) {
	    userDtoList.add(userToUserDto(user));
	}
	return userDtoList;
    }

}
