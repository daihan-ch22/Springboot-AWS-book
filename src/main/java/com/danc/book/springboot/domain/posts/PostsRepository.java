package com.danc.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{}

// Repository (인터페이스 형식)  = ibatis나 MyBatis에서 Dao라고 불리는 DB Layer 접근자

// JpaRepository<Entity클래스, PK타입>을 상속함으로써 기본적인 CRUD 메서드 자동 생성