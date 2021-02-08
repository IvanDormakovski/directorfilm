package com.library.DAO;

import com.library.models.Director;
import com.library.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class FilmDAO {
    private final JdbcTemplate jdbcTemplate;
    private final String firstDayOfTheYear = "-01-01";
    private final String lastDayOfTheYear = "-12-31";
    private final String defaultStartYearForSearch = "1000";
    private final String currentYearForSearch = String.valueOf(LocalDate.now().getYear());

    @Autowired
    public FilmDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Film> search(String lastName, String yearFrom, String yearUntil) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = null;
        Date dateUntil = null;
        String convertLastName = null;
        try {
            if (lastName == null | lastName.isEmpty()) {
                convertLastName = "";
            } else {
                convertLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
            }

            if (yearFrom == null | yearFrom.isEmpty() | yearFrom.length() != 4) {
                yearFrom = defaultStartYearForSearch;
            }
            if (yearUntil == null | yearUntil.isEmpty() | yearUntil.length() != 4) {
                yearUntil = currentYearForSearch;
            }
            dateFrom = dateFormat.parse(yearFrom + firstDayOfTheYear);
            dateUntil = dateFormat.parse(yearUntil + lastDayOfTheYear);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jdbcTemplate.query(
                "SELECT * FROM director, film WHERE director.id = film.director_id AND director.last_name LIKE ? AND film.release_date BETWEEN ? AND ?;",
                new Object[]{convertLastName + "%", dateFrom, dateUntil}, (resultSet, i) -> {
                    Film film = new Film();
                    film.setDirector(new Director(resultSet.getString("first_name"),
                            resultSet.getString("last_name"), resultSet.getDate("birth_date")));
                    film.setName(resultSet.getString("name"));
                    film.setReleaseDate(resultSet.getDate("release_date"));
                    film.setGenre(resultSet.getString("genre"));
                    return film;
                });
    }
}
