package com.katapios.DAO;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;

@Transactional
@Repository("courseDao")
public class HibernateCourseDAO implements CourseDAO {
    private static final Log LOG = LogFactory.getLog(HibernateCourseDAO.class);

    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory () {
        return sessionFactory;
    }

    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Course findById(int id) {
        return (Course) getSessionFactory().getCurrentSession().
                byId(Course.class).load(id);
    }

    @Transactional(readOnly=true)
    public List<Course> findAll() {
        return getSessionFactory().getCurrentSession().
                createQuery("from Course с").list(); 	 // HQL
    }

    @Override
    public void insert(Course course) {
        getSessionFactory().getCurrentSession().save(course); // saveOrUpdate()
        LOG.info("Course saved with id: "+ course.getId());
    }

    @Override
    public void update(Course course) {
        getSessionFactory().getCurrentSession().update(course);
        LOG.info("Course updated with id: "+ course.getId());

    }

    @Override
    public void delete(int id) {
        Course c = new Course();
        c.setId(id);
        getSessionFactory().getCurrentSession().delete(c);
        LOG.info("Course deleted with id: "+ c.getId());

    }

    @Override
    public List<Course> findByTitle(String title) {
        return getSessionFactory().getCurrentSession().
                createQuery("from Course с where title LIKE :title").
                setString("title", "%"+title+"%").list(); 	 // HQL
    }


}