package com.blitzquiz.springbootneo4jexample1.service;

import com.blitzquiz.springbootneo4jexample1.model.Reply;
import com.blitzquiz.springbootneo4jexample1.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    @Autowired
    ReplyRepository replyRepository;

    public Reply insertReply(Reply reply)
    {
        return replyRepository.save(reply);
    }
}
