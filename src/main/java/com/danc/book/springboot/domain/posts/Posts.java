package com.danc.book.springboot.domain.posts;

import com.danc.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    //DB의 실제 테이블과 매칭 될 클래스 (Entity 클래스 라고도 한다)
    //Entity 클래스에서는 Setter를 절때 쓰지 않는다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) // 클래스 생성자
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
