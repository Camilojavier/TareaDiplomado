package com.diplomado.tarea.web.rest;

import com.diplomado.tarea.domain.entities.User;
import com.diplomado.tarea.domain.services.UserService;
import com.diplomado.tarea.web.UserAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(UserAPI.userRoute)
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody final User user) throws URISyntaxException {
        if (user.getId() != null)
            throw new IllegalArgumentException("A new user can't have an id " + user.getId() );
        final User newUser = userService.saveUser(user);
        return ResponseEntity.created(new URI(UserAPI.userRoute + newUser.getId())).body(newUser);

    }
}
