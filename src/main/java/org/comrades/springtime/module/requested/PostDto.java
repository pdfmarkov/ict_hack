package org.comrades.springtime.module.requested;

import lombok.Data;

@Data
public class PostDto {
    private String login;
    private String title;
    private String text;
}
