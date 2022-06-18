package com.danc.book.springboot.web.domain.posts;

import com.danc.book.springboot.domain.posts.Posts;
import com.danc.book.springboot.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup()
    {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기()
    {
        //given
        String title = "테스트 게시글";
        String content = "게시글 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("daehan.dan.choi@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void ADD_BaseTimeEntity()
    {
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();


        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>> createDate=" + posts.getCreatedDate()+
                ", modifiedDate=" +posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
