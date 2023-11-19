package com.diplomado.tarea.services.mapper;

public interface CustomMapper<DTO, Entity> {
    DTO toDto(Entity entity);
    Entity toEntity(DTO dto);
}
