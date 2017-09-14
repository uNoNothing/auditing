package com.swastik.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

//    @JaversAuditable
    @Override
    public User createUser(User user) {
	User createdUser = userRepository.save(user);
	if (createdUser == null) {
	    logger.debug("null returned");
	    return new User();
	} else {
	    return createdUser;
	}
    }

    @Override
    public User retrieveUser(Integer id) {
	User retrievedUser = userRepository.findOne(id);

	if (retrievedUser == null) {
	    logger.debug("null returned");
	    return new User();
	} else {
	    return retrievedUser;
	}
    }

    @Override
    public List<User> retrieveUsers() {
	Iterable<User> retrievedUserList = userRepository.findAll();

	return (List<User>) retrievedUserList;
    }

//    @JaversAuditable
    @Override
    public User updateUser(User user) {
	User userToBeUpdated = userRepository.findOne(user.getId());
	if (userToBeUpdated == null) {
	    logger.debug("null returned");
	    return new User();
	} else {
	    userToBeUpdated.setFirstName(user.getFirstName());
	    userToBeUpdated.setSecondName(user.getSecondName());
	    userToBeUpdated.setEmail(user.getEmail());

	    User updatedUser = userRepository.save(userToBeUpdated);
	    return updatedUser;
	}
    }

}
