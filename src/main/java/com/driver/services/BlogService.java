package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        User user = userRepository1.findById(userId).orElse(null);
        if (user != null) {
            Blog blog = new Blog(title, content, user);
            return blogRepository1.save(blog);
        }
        return null;
    }

    public void deleteBlog(int blogId) {
        Blog blog = blogRepository1.findById(blogId).orElse(null);
        if (blog != null) {
            blogRepository1.deleteById(blogId);
        }
    }
}
