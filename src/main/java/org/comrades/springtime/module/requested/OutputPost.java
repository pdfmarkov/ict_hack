package org.comrades.springtime.module.requested;


import lombok.Data;
import org.comrades.springtime.module.Post;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;

@Data
public class OutputPost implements Comparable<OutputPost> {
    private String title;
    private String text;
    private LocalDateTime time;
    private String firstname;
    private String secondname;
    private String teamname;
    private Integer numberOfMembers;

    @Override
    public int compareTo(OutputPost o) {
        return this.getTime().compareTo(o.getTime());
    }
}

