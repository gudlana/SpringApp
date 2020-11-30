package ua.gudlana.StadyGudLana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.gudlana.StadyGudLana.data.domain.Post;
import ua.gudlana.StadyGudLana.data.domain.User;
import ua.gudlana.StadyGudLana.model.PostRequestDto;
import ua.gudlana.StadyGudLana.model.PostResponseDto;
import ua.gudlana.StadyGudLana.service.PostService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("api/posts")
    public List<PostResponseDto> getAllPosts(){
        return postService.getPostsList();
    }

    @GetMapping("api/posts/{authorId}")
    public List<PostResponseDto> getAllPostsByAuthorId(@PathVariable String authorId){
        return postService.getPostsByAuthorId(authorId);
    }

    @PostMapping("api/post/create")
    public PostResponseDto create(@RequestBody PostRequestDto request){

       return postService.createPost(request);
    }

    @PostMapping("api/user/create/{username}")
    public User create(@PathVariable String username){

        return postService.createUser(username);
    }
}
