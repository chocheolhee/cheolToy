package com.cheol.toy.controller;

import com.cheol.toy.exception.InvalidRequest;
import com.cheol.toy.request.PostCreate;
import com.cheol.toy.request.PostEdit;
import com.cheol.toy.response.PostResponse;
import com.cheol.toy.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //    @GetMapping("/posts")
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
        request.validate();
        postService.write(request);
    }

    /**
     * /posts -> 글 전체 조회 ( 검색 + 페이징 )
     * /posts/{postId} -> 글 한 개만 조회
     * Request Class 분리
     * Response Class 분리
     */
    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable(name = "postId") Long postId) {
        return postService.get(postId);
    }

    /**
     * 여러개의 글을 조회 API
     * /posts
     */
    @GetMapping("/posts")
    public List<PostResponse> getList(Pageable pageable) {
        return postService.getList(pageable);
    }

    @PatchMapping("/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEdit request) {
        postService.edit(postId, request);
    }

    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.delete(postId);
    }
}
