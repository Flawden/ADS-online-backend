package ru.skypro.homework.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    private String filePath;
    private Long fileSize;
    private String mediaType;
    private byte[] preview;

    @Lob
    private byte[] data;
}
