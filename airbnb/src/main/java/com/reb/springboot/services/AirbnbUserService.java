package com.reb.springboot.services;

import java.security.Principal;

import com.reb.springboot.dto.AirbnbUserDTO;

import org.springframework.stereotype.Service;

@Service
public class AirbnbUserService {
    
   /* 	public AirbnbUserDTO getMe(final Principal principal) {
		return new AirbnbUserDTO(me(principal));
    }
    
    public Player me(final Principal me) {
		if (me instanceof User)
			return ((User)me).getPlayer();
		else
			return playerRepo.findByName(me.getName()).get();
	}*/
}