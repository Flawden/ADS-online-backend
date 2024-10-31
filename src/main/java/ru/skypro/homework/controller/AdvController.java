package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.advertisement.AdDTO;
import ru.skypro.homework.dto.advertisement.AdInfoDTO;
import ru.skypro.homework.dto.advertisement.CreateOrUpdateAd;
import ru.skypro.homework.dto.advertisement.Ads;
import ru.skypro.homework.dto.comments.CommentDTO;
import ru.skypro.homework.dto.comments.CommentsDTO;
import ru.skypro.homework.dto.comments.CreateOrUpdateComment;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdvController {

    @GetMapping
    public Ads getAllAdvertisements() {
        List<AdDTO> advertisements = new ArrayList<>();
        advertisements.add(new AdDTO(0L, new byte[]{1, 2, 3}, "PK", 10000, "TestTitle"));
        return new Ads(advertisements.size(), advertisements);
    }

    @PostMapping
    public ResponseEntity<String> addAdvertisements(@RequestParam MultipartFile image) {

        return ResponseEntity.ok("Реклама успешно добавлена");
    }

    @GetMapping("/{id}")
    public AdInfoDTO getAdvertisementById(@PathVariable Long id) {

        return new AdInfoDTO(1, "Иван", "Иванов", "Продам гараж", "ivan.ivanov@example.com", new byte[]{1,2,3}, "+79999999999", 15000.0d, "Новый гараж");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdvertisementById(@PathVariable Long id) {

        return ResponseEntity.ok("Реклама успешно удалена");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateAdvertisementById(@RequestBody CreateOrUpdateAd advertisementsDTO) {

        return ResponseEntity.ok("Реклама успешно обновлена");
    }

    @GetMapping("/me")
    public Ads getAllAdvertisementsOfAuthUser() {
        List<AdDTO> advertisements = new ArrayList<>();
        advertisements.add(new AdDTO(0L, new byte[]{1, 2, 3}, "PK", 10000, "TestTitle"));
        return new Ads(advertisements.size(), advertisements);
    }

    @PatchMapping("/{id}/image")
    public ResponseEntity<String> updateAdvertisementImage(@PathVariable Long id, @RequestParam MultipartFile image) {

        return ResponseEntity.ok("Аватарка рекламы успешно обновлена");
    }

    @GetMapping("/{id}/comments")
    public CommentsDTO getCommentsOfAdvertisement(@PathVariable Long id) {
        List<CommentDTO> commentDTOs = new ArrayList<>();
        commentDTOs.add(new CommentDTO(0L, "https://photo.com", "Валера", System.currentTimeMillis(), 101, "Текст комментария"));
        return new CommentsDTO(commentDTOs.size(), commentDTOs);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<String> addCommentToAdvertisement(@PathVariable Long id, @RequestBody String text) {

        return ResponseEntity.ok("Комментарий к рекламе успешно добавлен");
    }

    @DeleteMapping("/{addId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long addId, @PathVariable Long commentId) {

        return ResponseEntity.ok("Комментарий к рекламе успешно удалён");
    }

    @PatchMapping("/{addId}/comments/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long addId, @PathVariable Long commentId, @RequestBody CreateOrUpdateComment text) {

        return ResponseEntity.ok("Комментарий к рекламе успешно обновлен");
    }

}
