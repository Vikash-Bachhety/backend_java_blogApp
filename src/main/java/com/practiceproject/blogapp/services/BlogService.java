package com.practiceproject.blogapp.services;

import java.util.List;

import com.practiceproject.blogapp.entity.Blog;

public interface BlogService {

	// Return all blogs
	List<Blog> allBlogs();

	// Return a single blog by its ID
	Blog getSingleBlog(long id);

	// Add a new blog and return the added blog
	Blog addBlog(Blog blog);

	// Update an existing blog and return the updated blog
	Blog updateBlog(long id, Blog blog);

	// Delete a blog and return confirmation (could return boolean or void)
	void deleteBlog(long id);
}
