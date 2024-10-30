package ru.skypro.homework.dto.advertisement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementInfoDTO {

    private Integer pk;
    private String authorFirstName;
    private String authorLastName;
    private String stringdescription;
    private String emailString;
    private byte[] image;
    private String phone;
    private Double price;
    private String title;

}
