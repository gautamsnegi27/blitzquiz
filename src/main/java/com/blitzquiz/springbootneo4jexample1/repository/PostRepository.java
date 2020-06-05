package com.blitzquiz.springbootneo4jexample1.repository;

import com.blitzquiz.springbootneo4jexample1.model.Post;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PostRepository extends Neo4jRepository<Post, Long> {
    void delete(Post post);

    @Query("MATCH (u:User)<-[r:POSTED]-(p:Post) where u.userId = {userId} RETURN p")
    Collection<Post> getPosts(@Param("userId") String userId);
}
