package ru.skypro.homework.dto.advertisement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdDTO {

    private Long author;
    private byte[] image;
    private String pk;
    private Integer price;
    private String title;

}
