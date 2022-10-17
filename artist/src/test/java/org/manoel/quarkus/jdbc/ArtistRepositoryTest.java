package org.manoel.quarkus.jdbc;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import javax.inject.Inject;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ArtistRepositoryTest {

    @Inject
    ArtistRepository repository;

    @Test
    public void shouldCrateAndFindAnArtist() throws SQLException {
        Artist artist = new Artist("name", "bio");
        repository.persist(artist);
        assertNotNull(artist.getId());

        artist = repository.findById(artist.getId());
        assertEquals("name", artist.getName());

    }
}
