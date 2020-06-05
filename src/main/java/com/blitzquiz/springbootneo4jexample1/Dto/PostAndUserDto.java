package com.blitzquiz.springbootneo4jexample1.Dto;

public class PostAndUserDto {
    private Long postId;
    private String userId;
    private Long commentId;
    private String userName;
    private String userAvatar;
    private String commentUserId;
    private String commentData;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

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

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentData() {
        return commentData;
    }

    public void setCommentData(String commentData) {
        this.commentData = commentData;
    }

    @Override
    public String toString() {
        return "PostAndUserDto{" +
                "postId=" + postId +
                ", userId='" + userId + '\'' +
                ", commentId=" + commentId +
                ", userName='" + userName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", commentUserId='" + commentUserId + '\'' +
                ", commentData='" + commentData + '\'' +
                '}';
    }
}
