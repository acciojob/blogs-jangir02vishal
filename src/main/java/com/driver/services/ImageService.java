package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;

    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions) {
        Blog blog = blogRepository2.findById(blogId).orElse(null);
        if (blog != null) {
            Image image = new Image(description, dimensions, blog);
            return imageRepository2.save(image);
        }
        return null;
    }

    public void deleteImage(Integer id) {
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        Blog blog = blogRepository2.findById(id).orElse(null);
        if (blog != null) {
            List<Image> images = blog.getImages();
            int count = 0;
            for (Image image : images) {
                if (image.getDimensions().equals(screenDimensions)) {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }
}
