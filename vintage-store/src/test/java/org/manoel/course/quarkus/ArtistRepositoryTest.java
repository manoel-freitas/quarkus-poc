package org.manoel.course.quarkus;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.manoel.course.quarkus.repositories.ArtistRepository;
import org.manoel.quarkus.jdbc.Artist;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ArtistRepositoryTest {

    @Inject
    private ArtistRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAArtist() {
        Artist artist = new Artist("name", "bio");
        repository.persist(artist);
        assertNotNull(artist.getId());

        artist = repository.findById(artist.getId());
        assertEquals("name", artist.getName());
    }
}
