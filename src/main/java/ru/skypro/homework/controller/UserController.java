package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.dto.UpdateUser;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/set_password")
    public ResponseEntity<String> reNewPassword(@RequestBody NewPassword newPassword) {

        return ResponseEntity.ok("Пароль успешно обновлен");
    }

    @GetMapping("/me")
    public UserDTO getAuthUser() {

        return new UserDTO(0L, "test@mail.ru", "firstname", "lastname", "89000000000", "USER", "https://photo.com");
    }


    @PatchMapping("/me")
    public ResponseEntity<String> updateAuthUser(@RequestBody UpdateUser updateUser) {

        return ResponseEntity.ok("Данные были успешно обновлены");
    }

    @PatchMapping("/me/image")
    public ResponseEntity<String> updateAvatarOfAuthUser(@RequestParam MultipartFile image) {

        return ResponseEntity.ok("Аватар пользователя был успешно обновлен");
    }

}
