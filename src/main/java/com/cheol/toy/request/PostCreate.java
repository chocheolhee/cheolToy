package com.cheol.toy.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PostCreate {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @Builder
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * 빌더의 장점
     *  - 가독성이 좋다. (값 생성에 대한 유연함)
     *  - 필요한 값만 받을 수 있다. (오버로딩 가능한 조건 찾아보기)
     *  - 객체의 불변성!!
     */
}
