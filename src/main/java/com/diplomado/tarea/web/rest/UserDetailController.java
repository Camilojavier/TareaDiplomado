package com.diplomado.tarea.web.rest;

import com.diplomado.tarea.domain.entities.UserDetail;
import com.diplomado.tarea.domain.services.UserDetailService;
import com.diplomado.tarea.web.API;
import com.diplomado.tarea.web.UserDetailAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(UserDetailAPI.userDetailRoute)
public class UserDetailController {
    private final UserDetailService userDetailService;

    public UserDetailController(final UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping(API.userPath)
    public ResponseEntity<UserDetail> getDetailByUser(@PathVariable final Long userId) {
        return ResponseEntity.ok().body(userDetailService.getDetailByUser(userId));
    }

    @PostMapping
    public ResponseEntity<UserDetail> saveUserDetail( @RequestBody final UserDetail userDetail) throws URISyntaxException {
        if (userDetail.getUser() == null)
            throw new IllegalArgumentException("user can't be null");
        if (userDetail.getUser().getId() == null)
            throw new IllegalArgumentException("userId can't be null");
        final UserDetail newUserDetail = userDetailService.saveUserDetail(userDetail.getUser().getId(), userDetail);
        return ResponseEntity.created(new URI(UserDetailAPI.userDetailRoute + newUserDetail.getId())).body(newUserDetail);
    }
}
