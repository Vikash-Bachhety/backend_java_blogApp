package com.practiceproject.blogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practiceproject.blogapp.entity.Blog;
import com.practiceproject.blogapp.services.BlogService;

@RestController
@CrossOrigin(origins = "https://frontend-java-blog-app.vercel.app")
@RequestMapping("/blogs")

public class BlogController {

	@Autowired
	private BlogService blogService;

	@GetMapping("/")
	public List<Blog> allBlogs() {
		return blogService.allBlogs();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Blog> getSingleBlog(@PathVariable long id) {
		Blog blog = blogService.getSingleBlog(id);
		if (blog != null) {
			return new ResponseEntity<>(blog, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addBlog")
	public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
		Blog addedBlog = blogService.addBlog(blog);
		return new ResponseEntity<>(addedBlog, HttpStatus.CREATED);
	}

	@PutMapping("/updateBlog/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable long id, @RequestBody Blog blogDetails) {
		Blog updatedBlog = blogService.updateBlog(id, blogDetails);
		if (updatedBlog != null) {
			return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteBlog/{id}")
	public ResponseEntity<Void> deleteBlog(@PathVariable long id) {
		blogService.deleteBlog(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
