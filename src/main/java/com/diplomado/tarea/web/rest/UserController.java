package com.diplomado.tarea.web.rest;

import com.diplomado.tarea.dto.UserDTO;
import com.diplomado.tarea.services.UserService;
import com.diplomado.tarea.web.api.UserAPI;
import com.diplomado.tarea.web.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserAPI.userRoute)
public final class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> readUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) throws URISyntaxException {
        if (user.getId() != null) {
            throw new IllegalArgumentException("A new user can't have an id " + user.getId());
        }
        user.setCreatedAt(LocalDateTime.now());
        final UserDTO newUser = userService.createUser(user);
        return ResponseEntity.created(new URI(UserAPI.userRoute + newUser.getId())).body(newUser);
    }

    @GetMapping(UserAPI.userPath)
    public ResponseEntity<UserDTO> readUser(@PathVariable Long userId) {
        UserDTO user = userService.getUser(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return ResponseEntity.ok().body(user);
    }


    @DeleteMapping(UserAPI.userPath)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        if (userService.getUser(userId).isPresent()) {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(UserAPI.userPath)
    public  ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO user){
        if (userId == null || user.getId() == null || !userId.equals(user.getId())) {
            throw new IllegalArgumentException("Path variable id and user id in the request body must match");
        }
        Optional<UserDTO> existingUser = userService.getUser(userId);
        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(userService.createUser(user));
    }
}
