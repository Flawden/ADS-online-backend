package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.advertisement.Ad;
import ru.skypro.homework.dto.advertisement.ExtendedAd;
import ru.skypro.homework.dto.advertisement.CreateOrUpdateAd;
import ru.skypro.homework.dto.advertisement.Ads;
import ru.skypro.homework.dto.comments.Comment;
import ru.skypro.homework.dto.comments.Comments;
import ru.skypro.homework.dto.comments.CreateOrUpdateComment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdvController {

    @GetMapping
    public ResponseEntity<Ads> getAllAdvertisements() {
        List<Ad> advertisements = new ArrayList<>();
        advertisements.add(new Ad(0, "https://img.freepik.com/premium-photo/baker-rolling-out-pastry-dough-baking_1280275-397011.jpg", 10, 10000, "TestTitle"));
        return new ResponseEntity<>(new Ads(advertisements.size(), advertisements), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ad> addAdvertisements(@RequestParam("image") MultipartFile image,
                                                    @RequestPart("properties") CreateOrUpdateAd properties) {

        return new ResponseEntity<>(new Ad(0, "https://img.freepik.com/premium-photo/baker-rolling-out-pastry-dough-baking_1280275-397011.jpg", 10, 10000, "TestTitle"), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAd> getAdvertisementById(@PathVariable Long id) {

        return new ResponseEntity<>(new ExtendedAd(1, "Firstname", "Lastname", "Description", "email@email.ru", "https://img.freepik.com/premium-photo/baker-rolling-out-pastry-dough-baking_1280275-397011.jpg", "88005353535", 10000, "TestTitle"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdvertisementById(@PathVariable Integer id) {

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ad> updateAdvertisementById(@PathVariable Integer id, @RequestBody CreateOrUpdateAd createOrUpdateAd) {

        return new ResponseEntity<>(new Ad(0, "https://img.freepik.com/premium-photo/baker-rolling-out-pastry-dough-baking_1280275-397011.jpg", 10, 10000, "TestTitle"), HttpStatus.CREATED);
    }

    @GetMapping("/me")
    public ResponseEntity<Ads> getAllAdvertisementsOfAuthUser() {
        List<Ad> advertisements = new ArrayList<>();
        advertisements.add(new Ad(0, "https://img.freepik.com/premium-photo/baker-rolling-out-pastry-dough-baking_1280275-397011.jpg", 10, 10000, "TestTitle"));
        return new ResponseEntity<>(new Ads(advertisements.size(), advertisements), HttpStatus.OK);
    }

    @PatchMapping("/{id}/image")
    public ResponseEntity<byte[]> updateAdvertisementImage(@PathVariable("id") Integer id,
                                                           @RequestParam("image") MultipartFile image) throws IOException {

        byte[] updatedImageContent = image.getBytes();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(updatedImageContent);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<Comments> getCommentsOfAdvertisement(@PathVariable Long id) {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(0, "https://img.freepik.com/premium-photo/baker-rolling-out-pastry-dough-baking_1280275-397011.jpg", "Валера", 10000, 101, "Текст комментария"));
        return new ResponseEntity<>(new Comments(comments.size(), comments), HttpStatus.OK);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addCommentToAdvertisement(@PathVariable Long id, @RequestBody CreateOrUpdateComment text) {

        return new ResponseEntity<>(new Comment(1, "https://img.freepik.com/premium-photo/baker-rolling-out-pastry-dough-baking_1280275-397011.jpg", "Author", 1000, 1000, "Text"), HttpStatus.OK);
    }

    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable("adId") Integer adId,
                                              @PathVariable("commentId") Integer commentId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable("adId") Integer adId,
                                                @PathVariable("commentId") Integer commentId,
                                                @RequestBody CreateOrUpdateComment updatedComment) {

        return ResponseEntity.ok().build();
    }

}
