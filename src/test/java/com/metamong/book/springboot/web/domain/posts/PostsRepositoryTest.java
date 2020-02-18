package com.metamong.book.springboot.web.domain.posts;

import com.metamong.book.springboot.domain.posts.Posts;
import com.metamong.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void get_contents() {
        //given
        String title = "TEST TITLE";
        String contents = "TEST CONTENTS";
        String author = "RIM";

        postsRepository.save(
                Posts.builder()
                .title(title)
                .content(contents)
                .author(author)
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(contents);
    }
}
