package org.manoel.course.quarkus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_cd")
public class CD extends Item{

    @Column(name = "music_company")
    public  String musicCompany;
    @Column(length = 100)
    public  String genre;

    @OneToMany(mappedBy = "cd", cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE
    })
    public List<Track> tracks = new ArrayList<>();
}
