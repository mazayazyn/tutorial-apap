package apap.tutorial.cineplux.security;

import apap.tutorial.cineplux.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String username);
}
