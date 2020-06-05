package com.blitzquiz.springbootneo4jexample1.model;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Comment {
    @GraphId
    private Long commentId;
    private String commentData;
    private String userId;
    @Relationship(type = "REPLY", direction = Relationship.INCOMING)
    private List<Reply> replies;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentData() {
        return commentData;
    }

    public void setCommentData(String commentData) {
        this.commentData = commentData;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentData='" + commentData + '\'' +
                ", userId='" + userId + '\'' +
                ", replies=" + replies +
                '}';
    }
}
