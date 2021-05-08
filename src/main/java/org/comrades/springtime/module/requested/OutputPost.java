package org.comrades.springtime.module.requested;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OutputPost {
    private String title;
    private String text;
    private LocalDateTime time;
    private String firstname;
    private String secondname;
    private String teamname;
    private Integer numberOfMembers;
}
