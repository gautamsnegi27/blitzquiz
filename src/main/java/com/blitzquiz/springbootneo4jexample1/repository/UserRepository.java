package com.blitzquiz.springbootneo4jexample1.repository;

import com.blitzquiz.springbootneo4jexample1.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User)<-[r:POSTED]-(p:Post) RETURN p,r,u")
    Collection<User> getAllUsers();

    @Query("MATCH (u:User),(p:Post) WHERE u.userId={userId} AND id(p)={id} CREATE (p)-[r:POSTED]->(u) RETURN r")
    void setRelation(@Param("id") Long id, @Param("userId") String userId);

    @Query("MATCH (u:User) WHERE u.userId ={userId} RETURN u")
    User findUser(@Param("userId") String userId);

    @Query("MATCH (c:Comment),(p:Post) WHERE id(c)={commentId} AND " +
            "id(p)={postId} CREATE (c)-[r:COMMENTED]->(p) RETURN r")
    void setCommentRelation(@Param("commentId") Long commentId, @Param("postId") Long postId);


    @Query("MATCH (c:Comment),(re:Reply) WHERE id(c)={commentId} AND " +
            "id(re)={replyId} CREATE (re)-[r:REPLIED]->(c) RETURN r")
    void setReplyRelation(@Param("commentId") Long commentId, @Param("replyId") Long replyId);

    @Query("MATCH (u:User) WHERE u.userId={userId} RETURN u")
    User getUser(@Param("userId") String userId);

    @Query("MATCH (u:User),(u1:User) WHERE u.userId={userId} AND u1.userId={userId1} " +
            "CREATE (u)-[r:FOLLOWS]->(u1) RETURN r")
    void setRelation(@Param("userId") String userId,
                     @Param("userId1") String userId1);



    @Query("MATCH (u:User)<-[r:FOLLOWS]-(u1:User) where u.userId = {userId} RETURN u1")
    List<User> getFollowers(@Param("userId") String userId);

    @Query("MATCH (u:User)<-[r:FOLLOWS]-(u1:User) where u.userId = {userId} RETURN u")
    List<User> getFollowing(@Param("userId") String userId);
}
