package sopraAjc.projetFinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sopraAjc.projetFinal.config.UtilisateurSpring;
import sopraAjc.projetFinal.entities.Utilisateur;
import sopraAjc.projetFinal.repositories.UtilisateurRepository;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> opt = utilisateurRepo.findByLogin(username);
		if (opt.isPresent()) {
			return new UtilisateurSpring(opt.get());
		}
		throw new UsernameNotFoundException("utilisateur introuvable");
	}

}
