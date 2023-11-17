package com.diplomado.tarea.web.rest;

import com.diplomado.tarea.domain.entities.Role;
import com.diplomado.tarea.domain.entities.User;
import com.diplomado.tarea.domain.entities.UserRole;
import com.diplomado.tarea.domain.services.UserRoleService;
import com.diplomado.tarea.web.API;
import com.diplomado.tarea.web.UserRoleAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(UserRoleAPI.userRoleRoute)
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(final UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public ResponseEntity<List<UserRole>>getUserRoles() {
        return ResponseEntity.ok().body(userRoleService.getUserRoles());
    }
    @GetMapping(path = API.rolePath)
    public ResponseEntity<List<UserRole>>getUsersByRole(@PathVariable final Role role) {
        return ResponseEntity.ok().body(userRoleService.getUsersByRole(role));
    }
    @GetMapping(path = API.userPath)
    public ResponseEntity<List<UserRole>>getRolesByUser(@PathVariable final User user) {
        return ResponseEntity.ok().body(userRoleService.getRolesByUser(user));
    }
    @PostMapping
    public ResponseEntity<UserRole>saveUserRole(@RequestBody final UserRole userRole) throws URISyntaxException {
        final UserRole newUserRole = userRoleService.save(userRole);
        return ResponseEntity.created(new URI(UserRoleAPI.userRoleRoute + newUserRole.getId())).body(newUserRole);
    }
}
