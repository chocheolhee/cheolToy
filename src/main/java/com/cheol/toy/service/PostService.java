package com.cheol.toy.service;

import com.cheol.toy.domain.Post;
import com.cheol.toy.repository.PostRepository;
import com.cheol.toy.request.PostCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate postCreate) {

        // postCreate -> Entity
        Post post = new Post(postCreate.getTitle(), postCreate.getContent());

        postRepository.save(post);
    }
}
