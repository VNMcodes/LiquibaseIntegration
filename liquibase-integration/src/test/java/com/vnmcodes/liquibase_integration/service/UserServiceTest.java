package com.vnmcodes.liquibase_integration.service;


import com.vnmcodes.liquibase_integration.model.User;
import com.vnmcodes.liquibase_integration.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User("john", "john@example.com");
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<User> users = userService.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("john", users.get(0).getUsername());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testSaveUser() {
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(user);

        assertEquals("john", savedUser.getUsername());
        assertEquals("john@example.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(user);
    }
}

