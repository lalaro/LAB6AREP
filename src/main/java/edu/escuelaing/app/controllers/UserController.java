package edu.escuelaing.app.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

	private final PasswordEncoder passwordEncoder;
	private Map<String, String> users = new HashMap<>();

	public UserController(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		users.put("admin", passwordEncoder.encode("1234")); // Usuario de prueba
	}

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> credentials) {
		String username = credentials.get("username");
		String password = credentials.get("password");

		if (users.containsKey(username) && passwordEncoder.matches(password, users.get(username))) {
			return Map.of("message", "Login exitoso");
		} else {
			throw new RuntimeException("Credenciales incorrectas");
		}
	}
}

