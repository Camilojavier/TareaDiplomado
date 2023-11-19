package com.diplomado.tarea.web.rest;

import com.diplomado.tarea.dto.UserDTO;
import com.diplomado.tarea.dto.UserDetailDTO;
import com.diplomado.tarea.services.UserDetailService;
import com.diplomado.tarea.web.UserDetailAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserDetailAPI.userDetailRoute)
public final class UserDetailController {
    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> readUserDetails() {
        return ResponseEntity.ok().body(userDetailService.getUserDetails());
    }
    @GetMapping(UserDetailAPI.userPath)
    public ResponseEntity<UserDetailDTO> getDetailByUser(@PathVariable Long userId) {
        return userDetailService.getUserDetail(userId)
                .map(userDetail -> ResponseEntity.ok().body(userDetail))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDetailDTO> saveUserDetail(@RequestBody UserDetailDTO userDetail) throws URISyntaxException {
        final UserDTO user = userDetail.getUser();
        if (userDetailService.getUserDetail(user.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        final UserDetailDTO newUserDetail = userDetailService.createUserDetail(userDetail);

        return ResponseEntity.created(new URI(UserDetailAPI.userDetailRoute + newUserDetail.getId())).body(newUserDetail);
    }
    @DeleteMapping(UserDetailAPI.userPath)
    public ResponseEntity<Void> deleteUserDetail(@PathVariable Long userId) {
        if (userDetailService.getUserDetail(userId).isPresent()) {
            userDetailService.deleteUserDetail(userId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(UserDetailAPI.userPath)
    public ResponseEntity<UserDetailDTO> updateUserDetail(@PathVariable Long userId, @RequestBody UserDetailDTO userDetail) {
        validateUserIdAndUserDetail(userId, userDetail);

        Optional<UserDetailDTO> existingUserDetail = userDetailService.getUserDetail(userId);
        if (existingUserDetail.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        validateUserDetailIdMatching(existingUserDetail.get(), userDetail);

        return ResponseEntity.ok().body(userDetailService.createUserDetail(userDetail));
    }

    private void validateUserIdAndUserDetail(Long userId, UserDetailDTO userDetail) {
        if (userId == null || userDetail.getId() == null ||
                userDetail.getUser().getId() == null ||
                !userId.equals(userDetail.getUser().getId())) {
            throw new IllegalArgumentException("Path variable id and user id in the request body must match");
        }
    }

    private void validateUserDetailIdMatching(UserDetailDTO existingUserDetail, UserDetailDTO userDetail) {
        if (!userDetail.getId().equals(existingUserDetail.getId())) {
            throw new IllegalArgumentException("Path variable id and user id in the request body must match");
        }
    }

}
