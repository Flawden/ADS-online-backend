package ru.skypro.homework.dto.advertisement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ad {

    private Integer author;
    private String image;
    private Integer pk;
    private Integer price;
    private String title;

}
