package com.brk.team.mates.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EventType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "eventType")
    private Set<Event> events = new HashSet<>();

    @ManyToMany
    private Set<Tag> tags = new HashSet<>();

    //TODO list
    //specs ???


    public Long getId() {
        return id;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
