package com.javainuse.controller;
import com.javainuse.repository.UserDao;
import com.javainuse.model.DAOUser;
import com.javainuse.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.javainuse.service.JwtUserDetailsService;
import com.javainuse.config.JwtTokenUtil;
import com.javainuse.model.JwtRequest;
import com.javainuse.model.JwtResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public List<?> createAuthenticationToken2(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		ResponseEntity.ok(new JwtResponse(token));

		DAOUser user = userDao.findByUsername(authenticationRequest.getUsername());

		HashMap<String, Object> mapa = new HashMap<>();
		mapa.put("user", user);
		mapa.put("token", token);
		List lista = new ArrayList();
		lista.add(mapa);

		return lista;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	//Return Expired Date Token
	@GetMapping("/tokenTimeLeft/{token}")
	public Date tokenExpire(@PathVariable String token){

		Date tokenExpireDate = jwtTokenUtil.getExpirationDateFromToken(token);

		return (tokenExpireDate);
	}

}