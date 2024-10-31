package ru.skypro.homework.dto.advertisement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateAd {

    private String title;
    private Double price;
    private String description;

}
