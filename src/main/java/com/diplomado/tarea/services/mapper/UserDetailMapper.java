package com.diplomado.tarea.services.mapper;

import com.diplomado.tarea.domain.entities.UserDetail;
import com.diplomado.tarea.dto.UserDetailDTO;
import org.springframework.stereotype.Component;

@Component
public final class UserDetailMapper implements CustomMapper<UserDetailDTO, UserDetail> {
    private final UserMapper userMapper;

    public UserDetailMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetailDTO toDto(UserDetail userDetail) {
        final UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setId(userDetail.getId());
        userDetailDTO.setFirstName(userDetail.getFirstName());
        userDetailDTO.setLastName(userDetail.getLastName());
        userDetailDTO.setAge(userDetail.getAge());
        userDetailDTO.setBirthday(userDetail.getBirthday());
        if (userDetail.getUsers() != null) {
            userDetailDTO.setUser(userMapper.toDto(userDetail.getUsers()));
        }
        return userDetailDTO;
    }

    @Override
    public UserDetail toEntity(UserDetailDTO userDetailDTO) {
        final UserDetail userDetail = new UserDetail();
        userDetail.setId(userDetailDTO.getId());
        userDetail.setFirstName(userDetailDTO.getFirstName());
        userDetail.setLastName(userDetailDTO.getLastName());
        userDetail.setAge(userDetailDTO.getAge());
        userDetail.setBirthday(userDetailDTO.getBirthday());
        userDetail.setUsers(userMapper.toEntity(userDetailDTO.getUser()));
        return userDetail;
    }
}
