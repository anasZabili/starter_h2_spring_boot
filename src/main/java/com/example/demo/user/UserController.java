package com.example.demo.user;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
@RequestMapping("user")
public class UserController {

  private final UserService userService; 

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getUser() {
    return this.userService.getUser();
  }

  @PostMapping
  public User addUser(@RequestBody User user) {
    return this.userService.addUser(user);
  }

  @PutMapping(path = "{userId}")
  public User updateUser(@RequestBody User updatedUser, @PathVariable String userId) throws NotFoundException {
    Long id = Long.parseLong(userId);
    return this.userService.updateUser(id, updatedUser);
  }

  @DeleteMapping(path = "{userId}")
  public void deleteUser(@PathVariable String userId) throws NotFoundException {
    Long id = Long.parseLong(userId);
      this.userService.deleteUser(id);      
  }
}
