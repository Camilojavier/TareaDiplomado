package com.diplomado.tarea.web;

public interface UserDetailAPI extends API{
    String userDetailRoute = API.apiVersion + "/userDetail";
    String userDetailByUser =  "/{userId}";
}
