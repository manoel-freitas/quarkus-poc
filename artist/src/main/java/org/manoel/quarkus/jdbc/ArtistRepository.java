package org.manoel.quarkus.jdbc;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Random;

@ApplicationScoped
public class ArtistRepository {

    @Inject
    private DataSource dataSource;

    @Inject
    private Logger logger;

    public  void persist(Artist artist) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "INSERT INTO t_artists (id, name, bio, created_date)" +
                " VALUES (?, ?, ?, ?)";

        artist.setId(Math.abs(new Random().nextLong()));
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setString(3, artist.getBio());
            ps.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            this.logger.error("Erro ao executar query: ",sqlException);
        }
        connection.close();
    }

    public Artist findById(Long id) throws  SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "SELECT id, name, bio, created_date FROM t_artists" +
                " WHERE id = ?";
        Artist artist = new Artist();

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                artist.setId(rs.getLong(1));
                artist.setName(rs.getString(2));
                artist.setBio(rs.getString(3));
                artist.setCreatedDate(rs.getTimestamp(4).toInstant());
            }
        } catch (SQLException sqlException) {
            this.logger.error("Erro ao executar query: ",sqlException);
        }
        connection.close();
        return artist;
    }
}
