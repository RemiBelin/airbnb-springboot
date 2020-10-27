package com.reb.springboot;

import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.lang.reflect.Member;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.reb.springboot.dto.PhotoDTO;
import com.reb.springboot.services.PhotoService;
import com.reb.springboot.dto.AirbnbUserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@RestController
public class AppRestController {

	Logger logger = LoggerFactory.getLogger(AppRestController.class);

	@Autowired
	private File monFichier;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PhotoService photoService;

	/*@GetMapping("/")
	public String index() {
		String retour = "nom fichier=" + monFichier.getName();
		
		return retour;
	}*/

	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/photos")
	public List<PhotoDTO> getPhotos() throws InterruptedException {
		
		logger.info("Starting getPhotos2");
	
		/*TimeUnit.SECONDS.sleep(3);
		
		PhotoDTO photo1 = new PhotoDTO("chambre.webp","You room1 / Votre chambre");
		PhotoDTO photo2 = new PhotoDTO("chambre_2.webp","You room1 / Votre chambre");
		PhotoDTO photo3 = new PhotoDTO("cuisine.webp","The kitchen1 / La cuisine");
		PhotoDTO photo4 = new PhotoDTO("cuisine.webp","The kitchen1 / La cuisine");
		PhotoDTO photo5 = new PhotoDTO("salle_de_bain.webp","The bathroom1 / La salle de bain");
		PhotoDTO photo6 = new PhotoDTO("salon.webp","Living room1- we share this space with you");
		
		List<PhotoDTO> photos = new ArrayList<PhotoDTO>();
		
		photos.add(photo1);
		photos.add(photo2);
		photos.add(photo3);
		photos.add(photo4);
		photos.add(photo5);
		photos.add(photo6);
		System.out.println("Ending getPhotos");*/
			
		return photoService.getAll();
	}

	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/api/post")
	public String testlogin()
	{
		System.out.println("Starting login");

		return "ok";
	}

	@GetMapping("/me")
	public AirbnbUserDTO getMe(UsernamePasswordAuthenticationToken token) {
		
		logger.info("token.getName()=" + token.getName());
		logger.info("token.toString()=" + token.toString());
	
		AirbnbUser user = (AirbnbUser)token.getPrincipal();

		AirbnbUserDTO dtoUser = new AirbnbUserDTO();
		dtoUser.setPassword(user.getPassword());
		dtoUser.setAge(user.getAge());
		dtoUser.setAdresse(user.getAdresse());
		
		return dtoUser;

	}

}
