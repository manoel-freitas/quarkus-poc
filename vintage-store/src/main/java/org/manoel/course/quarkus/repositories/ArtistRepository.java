package org.manoel.course.quarkus.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.manoel.quarkus.jdbc.Artist;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {
}
