package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.dto.UpdateUser;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    @PostMapping("/set_password")
    public ResponseEntity<HttpStatus> reNewPassword(@RequestBody NewPassword newPassword) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<User> getAuthUser() {

        return new ResponseEntity<>(new User(0, "test@mail.ru", "firstname", "lastname", "89000000000", "USER", "https://static-cse.canva.com/blob/847132/paulskorupskas7KLaxLbSXAunsplash2.jpg"), HttpStatus.OK);
    }


    @PatchMapping("/me")
    public ResponseEntity<UpdateUser> updateAuthUser(@RequestBody UpdateUser updateUser) {

        return new ResponseEntity<>(new UpdateUser("firsname", "lastname", "88005353535"), HttpStatus.OK);
    }

    @PatchMapping("/me/image")
    public ResponseEntity<String> updateAvatarOfAuthUser(@RequestParam MultipartFile image) {

        return ResponseEntity.ok("Аватар пользователя был успешно обновлен");
    }

}
