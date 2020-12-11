package ua.gudlana.StadyGudLana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.gudlana.StadyGudLana.data.domain.User;
import ua.gudlana.StadyGudLana.model.CommentRequestDto;
import ua.gudlana.StadyGudLana.model.PostRequestDto;
import ua.gudlana.StadyGudLana.model.PostResponseDto;
import ua.gudlana.StadyGudLana.service.PostService;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;



    @GetMapping("/news")
    public String getAllPosts(Model model){
        List<PostResponseDto> dtoList = postService.getPostsList();
        model.addAttribute("news", dtoList);
        return "news_list";
    }

    @GetMapping("api/posts/{authorId}")
    public List<PostResponseDto> getAllPostsListByAuthorId(@PathVariable String authorId){
        return postService.getPostsListByAuthorId(authorId);
    }

    @PostMapping("api/post/create")
    public PostResponseDto create(@RequestBody PostRequestDto request){
        return postService.createPost(request);
    }

    @PostMapping("api/post/addComment")
    public PostResponseDto create(@RequestBody CommentRequestDto request){

        return postService.addCommentToPost(request);
    }

}
