package cz.itnetwork.webapplication.models.services;


import cz.itnetwork.webapplication.database.entities.UserEntity;
import cz.itnetwork.webapplication.database.repositories.UserRepository;
import cz.itnetwork.webapplication.models.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserDTO user, boolean isAdmin) {

        UserEntity newUser = new UserEntity();

        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setAdmin(newUser.isAdmin());

        userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Uživatel " + username + " nebyl nalezen."));
    }
}
