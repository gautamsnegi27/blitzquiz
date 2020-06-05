package com.blitzquiz.springbootneo4jexample1.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Post {

    @GraphId
    private Long postId;
    private String postData;
    @Relationship(type = "COMMENTED", direction = Relationship.INCOMING)
    private List<Comment> comments;


    public Post() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }



    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postData='" + postData + '\'' +
                ", comments=" + comments +
                '}';
    }
}
