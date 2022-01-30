package com.katapios.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class CourseRowMapper implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course c = new Course();
        c.setId(rs.getInt("id"));
        c.setTitle(rs.getString("title"));
        c.setLength(rs.getInt("length"));
        c.setDescription(rs.getString("description"));
        return c;
    }
}

public class JdbcCourseDAO implements CourseDAO {

    private static final String SQL_SELECT_COURSE =
            "SELECT id, title, length, description FROM courses";
    private static final String SQL_SELECT_COURSE_BY_ID =
            SQL_SELECT_COURSE + " WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Course findById(int id) {
        return (Course) getJdbcTemplate().queryForObject(
                SQL_SELECT_COURSE_BY_ID, new Object[]{id},
                new CourseRowMapper());
    }

    @Override
    public List<Course> findAll() {

//        List<Course> courses = new ArrayList<>();
//        List<Map<String, Object>> maps = getJdbcTemplate().queryForList(SQL_SELECT_COURSE);
//        for (Map<String, Object> row : maps) {
//            Course c = new Course();
//            c.setId((int)(row.get("id")));
//            c.setTitle((String) (row.get("title")));
//            c.setLength((int)(row.get("length")));
//            c.setDescription((String) (row.get("description")));
//            courses.add(c);
//        }
//        return courses;
//    }
        //automatic variant if fields == rows
        List<Course> courses =
                getJdbcTemplate().query(SQL_SELECT_COURSE,
                        new BeanPropertyRowMapper<>(Course.class));
        return courses;

    }

}