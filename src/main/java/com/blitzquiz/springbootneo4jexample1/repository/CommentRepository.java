package com.blitzquiz.springbootneo4jexample1.repository;

import com.blitzquiz.springbootneo4jexample1.model.Comment;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommentRepository extends Neo4jRepository<Comment,Long> {
}
