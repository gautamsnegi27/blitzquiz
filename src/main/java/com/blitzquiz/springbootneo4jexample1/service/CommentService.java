package com.blitzquiz.springbootneo4jexample1.service;

import com.blitzquiz.springbootneo4jexample1.model.Comment;
import com.blitzquiz.springbootneo4jexample1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Comment getComment(Long commentId)
    {
        return commentRepository.findOne(commentId);
    }
    public Comment insertComment(Comment comment)
    {
        return commentRepository.save(comment);
    }

    public void deleteComment(Comment comment)
    {
        commentRepository.delete(comment);
    }
}
