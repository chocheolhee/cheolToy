package com.cheol.toy.controller;

import com.cheol.toy.domain.Post;
import com.cheol.toy.request.PostCreate;
import com.cheol.toy.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public String get() {
        return "Hello World";
    }

    //    @PostMapping("/posts")
    public String post(@RequestBody @Valid PostCreate params, BindingResult result) {

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
        }
        return "Hello World";
    }

    /**
     * Case 1. 저장한 데이터 Entity -> response로 응답하기.
     * Case 2. 저장한 데이터의 primary_id -> response로 응답하기.
     */
    @PostMapping("/posts")
    public void postV2(@RequestBody @Valid PostCreate request) {
        postService.write(request);
    }
}
