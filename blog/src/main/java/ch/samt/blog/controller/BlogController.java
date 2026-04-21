package ch.samt.blog.controller;

import ch.samt.blog.data.BlogRepository;
import ch.samt.blog.model.Blog;
import ch.samt.blog.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogRepository blogRepository) {
        this.blogService = new BlogService(blogRepository);
    }

    @GetMapping("/blog")
    public String loadBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "blogsList";
    }

    @GetMapping("/blog/new")
    public String loadInsertPage(Model model) {
        model.addAttribute("blog", new Blog());
        return "insertBlog";
    }
    @PostMapping("/blog/new")
    public String insertBlog(@Valid @ModelAttribute("blog") Blog blog, Errors errors) {
        if (errors.hasErrors()) {
            return "insertInstrument";
        }
        blogService.saveBlog(blog);
        return "redirect:/blog";
    }
}

