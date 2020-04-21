package com.news.bumer;

import com.news.bumer.model.Category;
import com.news.bumer.model.Post;
import com.news.bumer.repository.CategoryRepository;
import com.news.bumer.repository.PostRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

@Component
public class DatabaseInit implements ApplicationListener<ContextRefreshedEvent> {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public DatabaseInit(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Category category = new Category();
        category.setId(1L);
        category.setName("DIY");
        categoryRepository.save(category);

        Category category1 = new Category();
        category1.setId(2L);
        category1.setName("YT");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setId(3L);
        category2.setName("Cat3");
        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setId(4L);
        category3.setName("Cat4");
        categoryRepository.save(category3);

        Category category4 = new Category();
        category4.setId(5L);
        category4.setName("Cat5");
        categoryRepository.save(category4);

        Post post = new Post();
        post.setId(1L);
        post.setCategory(category);
        post.setBody("asndkajsndkasndkjandjkandnasjkdnaksd");
        post.setClicks(0);
        post.setImage("https://i.ytimg.com/vi/xS-gJydZXuM/maxresdefault.jpg");
        post.setTitle("Test post");
        post.setPostDate(LocalDateTime.of(2020, Month.APRIL, 18,16,21,22,12));
        postRepository.save(post);

        Post post1 = new Post();
        post1.setId(2L);
        post1.setCategory(category1);
        post1.setBody("sndkjandjkandnasjkdnaksd");
        post1.setClicks(0);
        post1.setImage("https://i.ytimg.com/vi/xS-gJydZXuM/maxresdefault.jpg");
        post1.setTitle("Test post 2");
        post1.setPostDate(LocalDateTime.of(2020, Month.APRIL, 18,17,21,22,12));
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setId(3L);
        post2.setCategory(category2);
        post2.setBody("sndkjandjkandnasjkdnaksd");
        post2.setClicks(0);
        post2.setImage("https://i.ytimg.com/vi/xS-gJydZXuM/maxresdefault.jpg");
        post2.setTitle("Test post 3");
        post2.setPostDate(LocalDateTime.of(2020, Month.APRIL, 18,18,21,22,12));
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setId(4L);
        post3.setCategory(category3);
        post3.setBody("sndkjandjkandnasjkdnaksd");
        post3.setClicks(0);
        post3.setImage("https://i.ytimg.com/vi/xS-gJydZXuM/maxresdefault.jpg");
        post3.setTitle("Test post 4");
        post3.setPostDate(LocalDateTime.of(2020, Month.APRIL, 18,19,21,22,12));
        postRepository.save(post3);

        Post post4 = new Post();
        post4.setId(5L);
        post4.setCategory(category4);
        post4.setBody("sndkjandjkandnasjkdnaksd");
        post4.setClicks(0);
        post4.setImage("https://i.ytimg.com/vi/xS-gJydZXuM/maxresdefault.jpg");
        post4.setTitle("Test post 5");
        post4.setPostDate(LocalDateTime.of(2020, Month.APRIL, 18,20,21,22,12));
        postRepository.save(post4);

        Post post5 = new Post();
        post5.setId(6L);
        post5.setCategory(category);
        post5.setBody("sndkjandjkandnasjkdnaksd");
        post5.setClicks(0);
        post5.setImage("https://i.ytimg.com/vi/xS-gJydZXuM/maxresdefault.jpg");
        post5.setTitle("Test post 6");
        post5.setPostDate(LocalDateTime.of(2020, Month.APRIL, 18,21,21,22,12));
        postRepository.save(post5);

        Post post6 = new Post();
        post6.setId(7L);
        post6.setCategory(category1);
        post6.setBody("sndkjandjkandnasjkdnaksd");
        post6.setClicks(0);
        post6.setImage("https://i.ytimg.com/vi/xS-gJydZXuM/maxresdefault.jpg");
        post6.setTitle("Test post 7");
        post6.setPostDate(LocalDateTime.of(2020, Month.APRIL, 18,22,21,22,12));
        postRepository.save(post6);

        Post post7 = new Post();
        post7.setId(8L);
        post7.setCategory(category);
        post7.setBody("TEST");
        post7.setClicks(0);
        post7.setImage("https://i.ytimg.com/vi/xS-gJydZXuM/maxresdefault.jpg");
        post7.setTitle("Test post 8");
        post7.setPostDate(LocalDateTime.of(2020, Month.APRIL, 18,22,21,22,12));
        postRepository.save(post7);

    }
}