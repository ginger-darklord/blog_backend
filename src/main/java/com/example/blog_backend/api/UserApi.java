package com.example.blog_backend.api;

import com.example.blog_backend.service.UserService;
import com.example.blog_backend.service.dtos.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*")
public class UserApi {
    private UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
    }

    @PutMapping("/update")
    void updateUser(@PathVariable Long id, @RequestBody UserDto user){
        userService.updateUser(id, user);
    }

    @DeleteMapping("/delete")
    void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PostMapping("/logIn")
    boolean logIn(@RequestBody UserDto userDto) {
        return userService.logIn(userDto);
    }
}
