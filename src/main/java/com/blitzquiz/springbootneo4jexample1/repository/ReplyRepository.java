package com.blitzquiz.springbootneo4jexample1.repository;

import com.blitzquiz.springbootneo4jexample1.model.Reply;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ReplyRepository extends Neo4jRepository<Reply,Long> {
}
