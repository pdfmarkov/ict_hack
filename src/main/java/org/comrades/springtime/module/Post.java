package org.comrades.springtime.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {

    public Post() {}

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "time")
    private LocalDateTime time = LocalDateTime.now();

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
