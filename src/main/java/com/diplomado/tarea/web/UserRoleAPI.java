package com.diplomado.tarea.web;

public interface UserRoleAPI extends API{
    String userRoleRoute = apiVersion + "/userRoles";
    String roleRoute = "/role";
    String userRoute = "/user";
    String userRolePath = "/{userRoleId}";

}
