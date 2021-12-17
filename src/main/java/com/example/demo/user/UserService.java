package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUser() {
    return this.userRepository.findAll();
  }


  public User addUser(User user) {
    return this.userRepository.save(user);
  }

  public void deleteUser(Long userId) throws NotFoundException {
    boolean exists = this.userRepository.existsById(userId);
    if (!exists) {
      throw new NotFoundException("student with id " + userId + " does not exist");
    }
    userRepository.deleteById(userId);
  }

  public User updateUser(Long userId,  User updatedUser) throws NotFoundException {
    boolean exists = this.userRepository.existsById(userId);
    User user = new User();
    user.setAge(updatedUser.getAge());
    user.setName(updatedUser.getName());
    user.setId(userId);
    if (!exists) {
      throw new NotFoundException("student with id " + userId + " does not exist");
    }
    return this.userRepository.save(user);
  }
}
