package com.medamine.taskmanagement.service;

import com.medamine.taskmanagement.domain.User;
import com.medamine.taskmanagement.domain.UserApp;
import com.medamine.taskmanagement.repository.AuthorityRepository;
import com.medamine.taskmanagement.repository.UserAppRepository;
import com.medamine.taskmanagement.repository.UserRepository;
import com.medamine.taskmanagement.security.AuthoritiesConstants;
import com.medamine.taskmanagement.service.dto.UserAppDTO;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAppService {

    private final UserAppRepository userAppRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    public UserAppService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        UserAppRepository userAppRepository,
        AuthorityRepository authorityRepository
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userAppRepository = userAppRepository;
        this.authorityRepository = authorityRepository;
    }

    public List<UserApp> findAll() {
        return userAppRepository.findAll();
    }

    public Optional<UserApp> findById(Long id) {
        return userAppRepository.findById(id);
    }

    public UserApp save(UserAppDTO userAppDTO) {
        User user = new User();
        user.setLogin(userAppDTO.getUsername()); // Assuming username in UserApp maps to login in User
        user.setPassword(passwordEncoder.encode(userAppDTO.getPassword())); // Encode the password
        user.setFirstName(userAppDTO.getFirstName());
        user.setLastName(userAppDTO.getLastName());
        user.setEmail(userAppDTO.getEmail());
        user.setActivated(true); // Assuming the user is activated by default
        user.setLangKey("en"); // Default language key
        user.setAuthorities(Collections.singleton(authorityRepository.findById(AuthoritiesConstants.USER).orElseThrow())); // Set default role

        userRepository.save(user);

        return userAppRepository.save(this.convertToEntity(userAppDTO));
    }

    private UserApp convertToEntity(UserAppDTO userAppDTO) {
        UserApp userApp = new UserApp();
        userApp.setUsername(userAppDTO.getUsername());
        userApp.setFirstName(userAppDTO.getFirstName());
        userApp.setLastName(userAppDTO.getLastName());
        userApp.setEmail(userAppDTO.getEmail());
        return userApp;
    }

    public void deleteById(Long id) {
        userAppRepository.deleteById(id);
    }
}
