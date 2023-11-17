package com.diplomado.tarea.web.rest;

import com.diplomado.tarea.domain.entities.Role;
import com.diplomado.tarea.domain.services.RoleService;
import com.diplomado.tarea.web.RoleAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(RoleAPI.roleRoute)
public class RoleController {
    private final RoleService roleService;

    public RoleController(final RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public ResponseEntity<List<Role>>getRoles() {
        return ResponseEntity.ok().body(roleService.getRoles());
    }

    @PostMapping
    public ResponseEntity<Role>saveRole(final Role role) throws URISyntaxException {
        final Role newRole = roleService.save(role);
        return ResponseEntity.created(new URI(RoleAPI.roleRoute + newRole.getId())).body(newRole);
    }
}
