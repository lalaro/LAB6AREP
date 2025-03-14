package edu.escuelaing.app;

import edu.escuelaing.app.controllers.UserController;
import edu.escuelaing.app.models.User;
import edu.escuelaing.app.repositories.UserRepository;
import edu.escuelaing.app.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApplicationTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testValidateUser_Failure() {
        String username = "testuser";
        String password = "wrongpassword";

        User user = new User(username, "encodedPassword");
        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(false);

        assertFalse(userService.validateUser(username, password));
    }

    @Test
    void testValidateUserSuccess() {
        String username = "validUser";
        String rawPassword = "correctPassword";
        String encodedPassword = "encodedPassword";

        User user = new User(username, encodedPassword);

        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(rawPassword, encodedPassword)).thenReturn(true);

    }

    @Test
    void testValidateUserFailure_WrongPassword() {
        String username = "validUser";
        String rawPassword = "wrongPassword";
        String encodedPassword = "encodedPassword";

        User user = new User(username, encodedPassword);

        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(rawPassword, encodedPassword)).thenReturn(false);

        assertFalse(userService.validateUser(username, rawPassword));
    }

    @Test
    void testValidateUserFailure_UserNotFound() {
        String username = "nonExistentUser";

        when(userRepository.findByUsername(username)).thenReturn(null);

        assertFalse(userService.validateUser(username, "anyPassword"));
    }

    @Test
    void testValidateUserWithNullPassword() {
        String username = "validUser";

        when(userRepository.findByUsername(username)).thenReturn(new User(username, "encodedPassword"));

        assertFalse(userService.validateUser(username, null));
    }


    @Test
    void testValidateUserWithIncorrectPassword() {
        String username = "user";
        String correctPassword = "securePassword";
        String wrongPassword = "wrongPassword";

        User user = new User(username, correctPassword);
        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(wrongPassword, user.getPassword())).thenReturn(false);

        assertFalse(userService.validateUser(username, wrongPassword));
    }

    @Test
    void testValidateUserWithNonExistentUsername() {
        String username = "nonExistentUser";
        String password = "securePassword";

        when(userRepository.findByUsername(username)).thenReturn(null);

        assertFalse(userService.validateUser(username, password));
    }

    @Test
    void testValidateUserWithIncorrectPassword2() {
        String username = "user";
        String correctPassword = "securePassword";
        String wrongPassword = "wrongPassword";

        User user = new User(username, correctPassword);
        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(wrongPassword, user.getPassword())).thenReturn(false);

        assertFalse(userService.validateUser(username, wrongPassword));
    }

    @Test
    void testValidateUserWithNonExistentUsername2() {
        String username = "nonExistentUser";
        String password = "securePassword";

        when(userRepository.findByUsername(username)).thenReturn(null);

        assertFalse(userService.validateUser(username, password));
    }

    @Test
    void testValidateUserWithHashedPasswordMismatch() {
        String username = "user";
        String password = "securePassword";
        String wrongHashedPassword = "wrongHash";

        User user = new User(username, wrongHashedPassword);
        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(password, wrongHashedPassword)).thenReturn(false);

        assertFalse(userService.validateUser(username, password));
    }
}