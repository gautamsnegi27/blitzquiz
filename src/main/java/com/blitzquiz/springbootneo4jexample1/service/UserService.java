package com.blitzquiz.springbootneo4jexample1.service;

import com.blitzquiz.springbootneo4jexample1.model.User;
import com.blitzquiz.springbootneo4jexample1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public User get(String userId)
    {
        return userRepository.getUser(userId);
    }

    public void estRln(Long id, String userId){
        userRepository.setRelation(id, userId);
    }

    public void estRlncomment(Long commentId, Long postId)
    {
        userRepository.setCommentRelation(commentId,postId);
    }

    public void estRlnReply(Long commentId, Long replyId)
    {
        userRepository.setReplyRelation(commentId,replyId);
    }

    public void estfriendrln(User user1, User user){
        userRepository.setRelation(user1.getUserId(),user.getUserId());
    }

    public void deleteUser(User user)
    {
        userRepository.delete(user);
    }

//    public Collection<User> getfollowers(String userId){
//        return userRepository.getFollowers(userId);
//    }

    public Collection<User> getfollowers(User user){
        return userRepository.getFollowers(user.getUserId());
    }


}
