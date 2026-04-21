package ch.samt.blog.service;

import ch.samt.blog.data.BlogRepository;
import ch.samt.blog.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service public class BlogService {
    private BlogRepository blogRepository;
    @Autowired
    public BlogService(BlogRepository blogRepository) {this.blogRepository = blogRepository;}
    public Blog saveBlog(Blog blog) {return blogRepository.save(blog);}
    public List<Blog> getAllBlogs() {return blogRepository.findAll();}
    public Optional<Blog> getBlogById(long id) {return blogRepository.findById(id);}

}
