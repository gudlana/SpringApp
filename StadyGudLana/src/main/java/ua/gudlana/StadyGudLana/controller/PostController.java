package ua.gudlana.StadyGudLana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.gudlana.StadyGudLana.data.domain.User;
import ua.gudlana.StadyGudLana.model.PostRequestDto;
import ua.gudlana.StadyGudLana.model.PostResponseDto;
import ua.gudlana.StadyGudLana.service.PostService;

import javax.websocket.server.PathParam;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("api/post/create")
    public PostResponseDto create(@RequestBody PostRequestDto request){

       return postService.createPost(request);
    }

    @PostMapping("api/user/create/{username}")
    public User create(@PathVariable String username){

        return postService.createUser(username);
    }
}
