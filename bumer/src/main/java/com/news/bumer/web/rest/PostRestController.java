package com.news.bumer.web.rest;

import com.news.bumer.model.Post;
import com.news.bumer.model.vm.Page;
import com.news.bumer.service.MapValidationErrorService;
import com.news.bumer.service.PostService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/posts", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class PostRestController {

    private final PostService postService;
    private final MapValidationErrorService mapValidationErrorService;

    public PostRestController(PostService postService, MapValidationErrorService mapValidationErrorService) {
        this.postService = postService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getLastNewsByCategory(){

        List<Post> listPost = new ArrayList<>();
        for (int i=0; i<5; i++) {
            listPost.add(postService.findById(postService.getLastNewsByCategory().get(i)).get());
        }
        return listPost;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<Post> getAllPosts(@RequestHeader(name = "page", defaultValue = "0", required = false) int page,
                                  @RequestHeader(name = "page-size", defaultValue = "10", required = false) int size) {
        return postService.getAllPostsPerPage(page, size);
    }

    @GetMapping("/category/{id}")
    public List<Post> getAllPostsByCategoryId(@PathVariable Long id,
                                              @RequestParam Long limit){

        List<Post> listPost = new ArrayList<>();
        for (int i = 0; i <limit ; i++) {
            listPost.add(postService.getAllPostsByCategoryId(id).get(i));
        }
        return listPost;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Object createPost(@Valid @RequestBody Post post, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        return this.postService.save(post);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Post> getPost(@PathVariable long id){
        return this.postService.findById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post updatePost(@PathVariable long id,
                           @RequestBody Post post){
        post.setId(id);
        return this.postService.save(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable long id){
        this.postService.deletePost(id);
    }
}
