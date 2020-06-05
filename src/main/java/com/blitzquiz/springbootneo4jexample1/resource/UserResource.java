package com.blitzquiz.springbootneo4jexample1.resource;

import com.blitzquiz.springbootneo4jexample1.Dto.FriendDto;
import com.blitzquiz.springbootneo4jexample1.Dto.PostAndUserDto;
import com.blitzquiz.springbootneo4jexample1.model.Comment;
import com.blitzquiz.springbootneo4jexample1.model.Post;
import com.blitzquiz.springbootneo4jexample1.model.Reply;
import com.blitzquiz.springbootneo4jexample1.model.User;
import com.blitzquiz.springbootneo4jexample1.repository.UserRepository;
import com.blitzquiz.springbootneo4jexample1.service.CommentService;
import com.blitzquiz.springbootneo4jexample1.service.PostService;
import com.blitzquiz.springbootneo4jexample1.service.ReplyService;
import com.blitzquiz.springbootneo4jexample1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController

public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ReplyService replyService;

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping("rest/neo4j")
    public Collection<User> getAll() {
        return userService.getAll();
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping("rest/neo4j/getuser")
    public User getUser(@RequestBody User user) {
        return userService.get(user.getUserId());
    }

    public User getUser(String userId) {
        return userService.get(userId);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping("/rest/neo4j/deleteuser")
    public void deleteuser(@RequestBody User user) {
        user = userRepository.findOne(user.getId());
        userService.deleteUser(user);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping("/rest/neo4j/getPost")
    public Post getPost(@RequestBody Post post) {
        return postService.get(post.getPostId());
    }
    public Post getPost(@RequestBody Long postId) {
        return postService.get(postId);
    }
    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping("/rest/neo4j/getComment")
    public Comment getComment(@RequestBody Comment comment) {
        return commentService.getComment(comment.getCommentId());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.POST,value = "rest/neo4j/insertuser" )
    public User insertUser(@RequestBody User user) {
        return userService.save(user);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/insertpost" )
    public Post insertPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/comment" )
    public Comment insertComment(@RequestBody Comment comment) {
        return commentService.insertComment(comment);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/reply" )
    public Reply insertReply(@RequestBody Reply reply) {
        return replyService.insertReply(reply);
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/getusers" )
    public Iterable<User> getusers() {
        return userRepository.findAll();
    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/postAndEstRln" )
    public void postAndestRln(@RequestBody PostAndUserDto postAndUserDto) {
        Post post = getPost(postAndUserDto.getPostId());
        User user = getUser(postAndUserDto.getUserId());
        userService.estRln(post.getPostId(),user.getUserId());

    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/commentAndEstRln" )
    public void commentAndEstRln(@RequestBody PostAndUserDto postAndUserDto) {
        Comment comment = new Comment();
        comment.setCommentData(postAndUserDto.getCommentData());
        comment.setUserId(postAndUserDto.getCommentUserId());
        comment = insertComment(comment);
        Post post = new Post();
        post.setPostId(postAndUserDto.getPostId());
        post = getPost(post);
        userService.estRlncomment(comment.getCommentId(),post.getPostId());

    }

    @CrossOrigin(value = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/replyAndEstRln" )
    public void replyAndEstRln(@RequestBody PostAndUserDto postAndUserDto) {
        Reply reply = new Reply();
        reply.setReplyData("This is an evolution");
        reply = insertReply(reply);
        Comment comment = new Comment();
        comment.setCommentId(postAndUserDto.getCommentId());
        comment = getComment(comment);
        userService.estRlnReply(comment.getCommentId(),reply.getReplyId());

    }

    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/deletepost" )
    public void deletepost(@RequestBody Post post) {
        postService.deletePost(post);
    }
    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/deletecomment" )
    public void deleteComment(@RequestBody Comment comment) {
        commentService.deleteComment(comment);
    }

    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/estfriendrln" )
    public void estRln(@RequestBody FriendDto friendDto) {
        User user = getUser(friendDto.getUserId());
        User user1 = getUser(friendDto.getUserId1());
        userService.estfriendrln(user,user1);
    }

    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/getcommentlist" )
    public void estRln(@RequestBody Post post) {
        System.out.println(post.getComments());
    }

    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/getpostlist" )
    public Collection<Post> getPostList(@RequestBody PostAndUserDto postAndUserDto) {
        User user=getUser(postAndUserDto.getUserId());
        return postService.getPosts(user);
    }

    @RequestMapping(method = RequestMethod.GET,value = "rest/neo4j/getfollowerlist" )
    public Collection<User> getFollowerList(@RequestBody FriendDto friendDto) {
        User user=getUser(friendDto.getUserId());
        return userService.getfollowers(user);
    }

}
