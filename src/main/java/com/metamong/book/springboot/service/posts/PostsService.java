package com.metamong.book.springboot.service.posts;

import com.metamong.book.springboot.domain.posts.PostsRepository;
import com.metamong.book.springboot.web.dto.PostsSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO) {

        return postsRepository.save(requestDTO.toEntity()).getId();
    }
}
