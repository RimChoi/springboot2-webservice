package com.metamong.book.springboot.service.posts;

import com.metamong.book.springboot.domain.posts.Posts;
import com.metamong.book.springboot.domain.posts.PostsRepository;
import com.metamong.book.springboot.web.dto.PostsListResponseDTO;
import com.metamong.book.springboot.web.dto.PostsResponseDTO;
import com.metamong.book.springboot.web.dto.PostsSaveRequestDTO;
import com.metamong.book.springboot.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO) {

        return postsRepository.save(requestDTO.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDTO requestDTO) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. ID=" + id)
        );
        posts.update(requestDTO.getTitle(), requestDTO.getContent());

        return id;
    }

    public PostsResponseDTO findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. ID=" + id)
        );

        return new PostsResponseDTO(entity);
    }

    @Transactional
    public List<PostsListResponseDTO> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이없습니다. ID="+id )
        );
        postsRepository.delete(posts);
    }
}
