package com.brk.team.mates.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private EventType eventType;

    @ManyToMany
    private Set<User> owners = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //TODO LIST

    //owners done

    //location

    //participant list || ticket

    //date interval

    //event status (enum)

    //comments

}
