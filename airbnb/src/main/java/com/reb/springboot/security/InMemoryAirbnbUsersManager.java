package com.reb.springboot.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.util.Assert;

/**
 * My own implementation of {@code UserDetailsManager} which is backed by an
 * in-memory map.
 * <p>
 * Mainly intended for testing and demonstration purposes, where a full blown persistent
 * system isn't required.
 *
 * @author Rémi BELIN
 */
public class InMemoryAirbnbUsersManager implements UserDetailsManager
		 {
	protected final Log logger = LogFactory.getLog(getClass());

	private final Map<String, UserDetails> users = new HashMap<>();

	private AuthenticationManager authenticationManager;

	public InMemoryAirbnbUsersManager() {
	}

	public InMemoryAirbnbUsersManager(Collection<UserDetails> users) {
		for (UserDetails user : users) {
			createUser(user);
		}
	}

	public InMemoryAirbnbUsersManager(UserDetails... users) {
		for (UserDetails user : users) {
			createUser(user);
		}
	}

	public void createUser(UserDetails user) {
		Assert.isTrue(!userExists(user.getUsername()), "user should not exist");

		users.put(user.getUsername().toLowerCase(), user);
	}

	public void deleteUser(String username) {
		users.remove(username.toLowerCase());
	}

	public void updateUser(UserDetails user) {
		Assert.isTrue(userExists(user.getUsername()), "user should exist");

		users.put(user.getUsername().toLowerCase(), user);
	}

	public boolean userExists(String username) {
		return users.containsKey(username.toLowerCase());
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails user = users.get(username.toLowerCase());

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return user;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

    public UserDetails updatePassword(UserDetails user, String newPassword) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // TODO Auto-generated method stub

    }
}
