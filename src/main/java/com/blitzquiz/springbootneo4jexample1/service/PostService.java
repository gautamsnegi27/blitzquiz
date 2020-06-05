package com.blitzquiz.springbootneo4jexample1.service;

import com.blitzquiz.springbootneo4jexample1.model.Post;
import com.blitzquiz.springbootneo4jexample1.model.User;
import com.blitzquiz.springbootneo4jexample1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    public Post save(Post post)
    {
        return postRepository.save(post);
    }

    public Post get(Long postId)
    {
        return postRepository.findOne(postId);
    }

    public void deletePost(Post post)
    {
        postRepository.delete(post);
    }

    public Collection<Post> getPosts(User user){
        return
                postRepository.getPosts(user.getUserId());
    }



}
