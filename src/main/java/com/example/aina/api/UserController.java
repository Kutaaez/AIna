package com.example.aina.api;

import com.example.aina.dto.UserDto;
import com.example.aina.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // poluchit vse polzovatelej
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    // poluchit polzovatelya po id
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // dobavit novogo polzovatelya
    @PostMapping
    public UserDto addUser(@RequestBody UserDto dto) {
        return userService.saveUser(dto);
    }

    // obnovit polzovatelya po id
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
        return userService.updateUser(id, dto);
    }

    // udalit polzovatelya po id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
