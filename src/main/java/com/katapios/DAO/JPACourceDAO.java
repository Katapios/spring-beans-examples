package com.katapios.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Service("jpaCourseService")
@Repository
@Transactional
class JPACourseDAO implements CourseDAO {
    private static final Log LOG = LogFactory.getLog(JPACourseDAO.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public Course findById(int id) {
        TypedQuery<Course> query = em.createQuery(
                "select c from Course c where c.id=:id", Course.class);
        query.setParameter ( "id", id) ;
        return query.getSingleResult();
    }
    @Transactional(readOnly=true)
    public List<Course> findAll() {
//        return em.createNamedQuery("Courses.findAll",
//        		Course.class).getResultList();
        return em.createQuery("select с from Course с",
                Course.class).getResultList();
    }
    @Override
    public void insert(Course course) {
        em.persist(course);
        LOG.info("Course saved with id: "+ course.getId());

    }
    @Override
    public void update(Course course) {
        if (course.getId()!=0 && em.find(Course.class, course.getId())!=null)
            em.merge(course);
        LOG.info("Course updated with id: "+ course.getId());
    }
    @Override
    public List<Course> findByTitle(String title) {
        TypedQuery<Course> query = em.createQuery(
                "select c from Course c where c.title LIKE :title", Course.class);
        query.setParameter ( "title", "%"+title+"%") ;
        return query.getResultList();
    }
    @Override
    public void delete(int id) {
        em.remove(em.find(Course.class, id));
        LOG.info("Course deleted with id: "+ id);
    }


}