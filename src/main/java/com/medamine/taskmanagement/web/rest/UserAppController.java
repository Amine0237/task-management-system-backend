package com.medamine.taskmanagement.web.rest;

import com.medamine.taskmanagement.domain.UserApp;
import com.medamine.taskmanagement.service.UserAppService;
import com.medamine.taskmanagement.service.dto.UserAppDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app-users")
public class UserAppController {

    @Autowired
    private UserAppService userAppService;

    @GetMapping
    public List<UserApp> getAllUsers() {
        return userAppService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserApp> getUserById(@PathVariable Long id) {
        return userAppService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserApp createUser(@RequestBody UserAppDTO userAppDTO) {
        return userAppService.save(userAppDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserApp> updateUser(@PathVariable Long id, @RequestBody UserAppDTO userAppDTO) {
        if (!userAppService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userAppDTO.setId(id);
        return ResponseEntity.ok(userAppService.save(userAppDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userAppService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
