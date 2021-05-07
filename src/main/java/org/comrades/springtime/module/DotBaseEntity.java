package org.comrades.springtime.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class DotBaseEntity {

    @Column(name = "deal")
    private String deal;
    @Column(name = "time")
    private LocalDateTime time = LocalDateTime.now();
}
