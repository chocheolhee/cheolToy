package com.cheol.toy.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PostCreate {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
