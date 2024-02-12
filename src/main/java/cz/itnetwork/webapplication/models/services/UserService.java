package cz.itnetwork.webapplication.models.services;

import cz.itnetwork.webapplication.models.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {

    void createUser(UserDTO user, boolean isAdmin);
}
