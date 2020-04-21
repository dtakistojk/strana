package com.news.bumer.service;

import com.news.bumer.model.Post;
import com.news.bumer.model.vm.Page;
import com.news.bumer.repository.PostRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return this.postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    public List<Integer> getLastNewsByCategory(){
        return postRepository.getLastNewsByCategory();
    }

    public Page<Post> getAllPostsPerPage(int page, int size) {
        return this.postRepository.getAllPostsPerPage(page, size);
    }

    public Optional<Post> findById(long id) {
        return this.postRepository.findById(id);
    }

    public List<Post> getAllPostsByCategoryId(Long id){
        return postRepository.getAllPostsByCategoryId(id);
    };

//    public Post updatePost(long id, String name, double rating) {
//
//        Bookmark bookmark = this.bookmarkRepository.findById(id).orElseThrow(InvalidBookmarkException::new);
//
//        bookmark.setName(name);
//        bookmark.setRating(rating);
//        return this.bookmarkRepository.save(bookmark);
//    }

    public void deletePost(long id) {
        this.postRepository.deleteById(id);
    }

}
