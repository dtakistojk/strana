package com.news.bumer.repository;

import com.news.bumer.model.Post;
import com.news.bumer.model.vm.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    @Query(value = "select p from Post as p where p.category.id = :id ORDER BY p.postDate desc")
    default Page<Post> getAllPostsPerPage(int page, int size){
            org.springframework.data.domain.Page<Post> result = this.findAll(PageRequest.of(page, size));
            return new Page<>(page,
                    result.getTotalPages(),
                    size,
                    result.getContent());
        }

        @Query(value = "select max(p.id) from Post as p group by p.category")
        List<Integer> getLastNewsByCategory();

        @Query(value = "select p from Post as p where p.category.id = :id ORDER BY p.postDate desc")
        List<Post> getAllPostsByCategoryId(Long id);
}
