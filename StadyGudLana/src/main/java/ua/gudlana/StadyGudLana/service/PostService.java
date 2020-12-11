package ua.gudlana.StadyGudLana.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gudlana.StadyGudLana.data.domain.Comment;
import ua.gudlana.StadyGudLana.data.domain.Post;
import ua.gudlana.StadyGudLana.data.domain.User;
import ua.gudlana.StadyGudLana.data.repository.PostRepository;
import ua.gudlana.StadyGudLana.data.repository.UserRepository;
import ua.gudlana.StadyGudLana.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    public List<PostResponseDto> getPostsList(){
        List<Post> posts = postRepository.findAll();
        return mappingToPostResponseDto(posts);
    }

    public List<PostResponseDto> getPostsListByAuthorId(String authorId) {
         List<Post> posts = postRepository.findAllByAuthorId(authorId);
         return mappingToPostResponseDto(posts);
    }

    private List<PostResponseDto> mappingToPostResponseDto(List<Post> posts) {
        List<PostResponseDto> postsDto = new ArrayList<>();
        for(Post p : posts){
           PostResponseDto postDto = mappingToPostResponseDto(p);
           postsDto.add(postDto);
        }
        return postsDto;
    }

    private PostResponseDto mappingToPostResponseDto(Post entity) {

        PostResponseDto postDto = new PostResponseDto();
        postDto.title = entity.title;
        postDto.description = entity.description;
        postDto.tag = entity.tag;
        postDto.author = getUserDto(entity.authorId);
        postDto.comments = getCommentDto(entity.comments);
        return  postDto;
    }

    public PostResponseDto createPost(PostRequestDto request) {

        Post post = new Post();
        post.title = request.title;
        post.tag = request.tag;
        post.description = request.description;
        post.authorId = request.authorId;
        post.dateCreate = new Date();

        postRepository.save(post);

        return mappingToPostResponseDto(post);
    }

    public PostResponseDto addCommentToPost(CommentRequestDto request) {

        Post post = postRepository.findById(request.postId).orElse(null);
        if(post == null) {return null;}

        Comment com = new Comment();
        com.text = request.text;
        com.userId = request.userId;
        com.dateCreate = new Date();

        post.comments.add(com);

        postRepository.save(post);

        return mappingToPostResponseDto(post);
    }

    private UserDto getUserDto(String authorId) {

        UserDto userDto = new UserDto();
        User author = userRepository.findById(authorId).orElse(null);
        if (author != null) {
            userDto.id = author.getId();
            userDto.username = author.getUsername();
            return userDto;
        } else {
            return null;
        }
    }

    private List<CommentResponseDto> getCommentDto(List<Comment> comments) {

        if(comments == null) {
            return null;
        }

        List<CommentResponseDto> commentsDto = new ArrayList<>();
        for (Comment com : comments) {
            CommentResponseDto dto = new CommentResponseDto();
            dto.text = com.text;
            dto.user = getUserDto(com.userId);
            dto.dateCreate = com.dateCreate;
            commentsDto.add(dto);
        }
        return commentsDto;
    }


}
