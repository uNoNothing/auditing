package com.swastik.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @PostMapping("/user")
    public UserDto postUser(@RequestBody UserDto userDto) {
	logger.info("/user POST");
	return Marshall.userToUserDto(userService.createUser(Marshall.userDtoToUser(userDto)));
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
	logger.info("/users GET");
	return Marshall.userToUserDto(userService.retrieveUsers());
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable Integer id) {
	logger.info("/user/" + id + " GET");
	return Marshall.userToUserDto(userService.retrieveUser(id));
    }

    @PutMapping("/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
	logger.info("/user PUT");
	return Marshall.userToUserDto(userService.updateUser(Marshall.userDtoToUser(userDto)));
    }

}
