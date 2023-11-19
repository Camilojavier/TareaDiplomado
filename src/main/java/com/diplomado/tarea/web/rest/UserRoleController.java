package com.diplomado.tarea.web.rest;

import com.diplomado.tarea.dto.UserDTO;
import com.diplomado.tarea.dto.UserRoleDTO;
import com.diplomado.tarea.services.UserRoleService;
import com.diplomado.tarea.web.API;
import com.diplomado.tarea.web.UserRoleAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserRoleAPI.userRoleRoute)
public final class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public ResponseEntity<List<UserRoleDTO>>getUserRoles() {
        return ResponseEntity.ok().body(userRoleService.getUserRoles());
    }
    @GetMapping(path = UserRoleAPI.roleRoute + API.rolePath)
    public ResponseEntity<List<UserRoleDTO>>getUsersByRole(@PathVariable Integer roleId) {
        return ResponseEntity.ok().body(userRoleService.getUsersByRole(roleId));
    }
    @GetMapping(path = UserRoleAPI.userRoute + API.userPath)
    public ResponseEntity<List<UserRoleDTO>>getRolesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userRoleService.getRolesByUser(userId));
    }
    @PostMapping
    public ResponseEntity<List<UserRoleDTO>> createUserRole(@RequestBody UserRoleDTO... userRoles) throws URISyntaxException {
        List<UserRoleDTO> newUserRoles = userRoleService.createUserRoles(userRoles);

        if (!newUserRoles.isEmpty()) {
            return ResponseEntity.created(new URI(UserRoleAPI.userRoleRoute)).body(newUserRoles);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(UserRoleAPI.userRolePath)
    public ResponseEntity<Void> deleteUserRole(@PathVariable Integer userRoleId) {
        if (userRoleService.getUserRole(userRoleId).isPresent()) {
            userRoleService.deleteUserRole(userRoleId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = UserRoleAPI.userRolePath, method = RequestMethod.PATCH)
    public ResponseEntity<UserRoleDTO> setInactive(@PathVariable Integer userRoleId) {
        Optional<UserRoleDTO> optionalUserRole = userRoleService.getUserRole(userRoleId);

        if (optionalUserRole.isPresent()) {
            UserRoleDTO userRole = userRoleService.setInactive(userRoleId);
            return ResponseEntity.ok(userRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
