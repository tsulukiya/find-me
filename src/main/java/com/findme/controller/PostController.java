package com.findme.controller;

import com.findme.models.Post;
import com.findme.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "savePost", produces = "application/json")
    public @ResponseBody
    Post save(@RequestBody Post post) {
        return postService.save(post);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePost", produces = "application/json")
    public @ResponseBody
    Post update(@RequestBody Post post) {
        return postService.update(post);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePost", produces = "application/json")
    public @ResponseBody Post delete(Long id) {
        return postService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "findFlight", produces = "application/json")
    public @ResponseBody
    Post findById(Long id) {
        return postService.findById(id);
    }
}
