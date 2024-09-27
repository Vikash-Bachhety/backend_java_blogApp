package com.practiceproject.blogapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiceproject.blogapp.entity.Blog;
import com.practiceproject.blogapp.repository.BlogDao;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;

	@Override
	public List<Blog> allBlogs() {
		return blogDao.findAll();
	}

	@Override
	public Blog getSingleBlog(long id) {
		// Using Optional to handle if the blog is not found
		return blogDao.findById(id).orElse(null);
	}

	@Override
	public Blog addBlog(Blog blog) {
		return blogDao.save(blog);
	}

	@Override
	public Blog updateBlog(long id, Blog blogDetails) {
		Optional<Blog> optionalBlog = blogDao.findById(id);
		if (optionalBlog.isPresent()) {
			Blog blog = optionalBlog.get();
			blog.setTitle(blogDetails.getTitle());
			blog.setDescription(blogDetails.getDescription());
			blog.setViews(blogDetails.getViews());
			return blogDao.save(blog);
		}
		return null; // Or handle with exception
	}

	@Override
	public void deleteBlog(long id) {
		blogDao.deleteById(id);
	}
}
