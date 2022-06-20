package com.danc.book.springboot.web;

import com.danc.book.springboot.service.posts.PostsService;
import com.danc.book.springboot.web.dto.PostsResponseDto;
import com.danc.book.springboot.web.dto.PostsSaveRequestDto;
import com.danc.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }


    //게시글 수정 API
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto)
    {
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id)
    {
        return postsService.findById(id);
    }


}
