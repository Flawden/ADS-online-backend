package ru.skypro.homework.dto.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private Long author;
    private byte[] authorImage;
    private String  authorFirstName;
    private Long createdAtALong;
    private Integer pk;
    private String text;

}
