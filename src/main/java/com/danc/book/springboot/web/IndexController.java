package com.danc.book.springboot.web;

import com.danc.book.springboot.config.auth.LoginUser;
import com.danc.book.springboot.config.auth.dto.SessionUser;
import com.danc.book.springboot.service.posts.PostsService;
import com.danc.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    //private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findAllDesc());

        /*SessionUser user = (SessionUser) httpSession
                .getAttribute("user");*/

        if(user != null)
        {
            model.addAttribute("SocialuserName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }

    //수정 화면을 연결할 Controller 코드
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


}

/*
@GetMapping("/")
    public String index()
    {
        return "index";
    }



 */