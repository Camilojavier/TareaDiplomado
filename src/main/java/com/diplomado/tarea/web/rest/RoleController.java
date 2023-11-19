package com.diplomado.tarea.web.rest;

import com.diplomado.tarea.dto.RoleDTO;
import com.diplomado.tarea.services.RoleService;
import com.diplomado.tarea.web.RoleAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RoleAPI.roleRoute)
public final class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public ResponseEntity<List<RoleDTO>> readRoles() {
        return ResponseEntity.ok().body(roleService.getRoles());
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO role) throws URISyntaxException {
        if (role.getId() != null) {
            throw new IllegalArgumentException("A new role can't have an id " + role.getId());
        }
        final RoleDTO newRole = roleService.createRole(role);
        return ResponseEntity.created(new URI(RoleAPI.roleRoute + newRole.getId())).body(newRole);
    }
    @GetMapping(RoleAPI.rolePath)
    public ResponseEntity<RoleDTO> readRole(@PathVariable Integer roleId) {
        return roleService.getRole(roleId)
                .map(role -> ResponseEntity.ok().body(role))
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping(RoleAPI.rolePath)
    public ResponseEntity<Void> deleteRole(@PathVariable Integer roleId){
        if (roleService.getRole(roleId).isPresent()) {
            roleService.deleteRole(roleId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(RoleAPI.rolePath)
    public  ResponseEntity<RoleDTO> updateRole(@PathVariable Integer roleId, @RequestBody RoleDTO role){
        if (roleId == null || role.getId() == null || !roleId.equals(role.getId())) {
            throw new IllegalArgumentException("Path variable id and user id in the request body must match");
        }
        Optional<RoleDTO> existingRole = roleService.getRole(roleId);
        if (existingRole.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(roleService.createRole(role));
    }
}
