package com.example.demo.user;

import static org.mockito.Mockito.when;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock
  UserRepository userRepositoryMock;

  @InjectMocks
  private UserService userService;

  @Test
  void testGetUser() {
    // Given
    User userPayload = new User();
    userPayload.setAge(78);
    userPayload.setName("angular");
    List<User> users =  new ArrayList<User>();
    users.add(userPayload);  
    when(userRepositoryMock.findAll()).thenReturn(users);
    // When
    List<User> returnedUsers = this.userService.getUser();
    // Then
    Mockito.verify(userRepositoryMock, Mockito.times(1)).findAll();
    assertThat(returnedUsers.size()).isEqualTo(users.size());  
      
  }

  @Test
  void testDeleteUser() {

  }

  @Test
  void testAddUser() {
    // Given
    User userPayload = new User();
    userPayload.setAge(78);
    userPayload.setName("angular");
    when(userRepositoryMock.save(userPayload)).thenReturn(userPayload);

    // When 
    this.userService.addUser(userPayload);
    // Then
    Mockito.verify(userRepositoryMock, Mockito.times(1)).save(userPayload);
  }

  @Test
  void testUpdateUser() {

  }
}
