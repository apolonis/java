package com.javainuse.controller;
import java.util.ArrayList;
import java.util.List;
import com.javainuse.dao.UserDao;
import com.javainuse.model.DAOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.javainuse.service.JwtUserDetailsService;
import com.javainuse.config.JwtTokenUtil;
import com.javainuse.model.JwtRequest;
import com.javainuse.model.JwtResponse;
import com.javainuse.model.UserDTO;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
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

	@GetMapping("/show/{uuid}")
	public DAOUser show(@PathVariable String uuid) {
		DAOUser showUser = userDao.findByUuid(uuid);
		return showUser;

	}

	@GetMapping("/getAll")
	public List<DAOUser> getAll() {

		return (List<DAOUser>) userDao.findAll();

	}

	@GetMapping("/link/{uuid}")
	public String link(@PathVariable String uuid) {
		DAOUser showUser = userDao.findByUuid(uuid);
		String link = "http://www.facebook.com";
		return link;

	}

	@GetMapping("/showByRole/{role}")
	public DAOUser showByRole(@PathVariable String role) {
		DAOUser showUser = userDao.findByRole(role);
		return showUser;

	}


	@RequestMapping(value = "/giveTokenBack", method = RequestMethod.POST)
	public String tokenBack(@RequestBody JwtRequest authenticationRequest) throws Exception {


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return (token);
	}

	@GetMapping("/showByName/{name}")
	public List<DAOUser> showByName(@PathVariable String name) {
		List<DAOUser> lista = new ArrayList<DAOUser>();

		for (DAOUser user: userDao.findAll()){
			if (user.getName().equals(name)){
				lista.add(user);
			}
		}

		return lista;

	}

}