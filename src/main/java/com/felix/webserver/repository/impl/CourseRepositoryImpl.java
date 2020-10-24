package com.felix.webserver.repository.impl;

import com.felix.webserver.model.vo.CourseVo;
import com.felix.webserver.repository.custom.CourseRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.JoinType;
import java.util.List;
import java.util.stream.Collectors;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CourseVo> customRetrieve(Long bookId) {
        var cb = entityManager.getCriteriaBuilder();
        var cq = cb.createQuery(CourseVo.class);
        var courseRoot = cq.from(CourseVo.class);
        var students = courseRoot.joinList("students", JoinType.LEFT);
        var books = students.joinList("books", JoinType.LEFT);
        cq.where(
                cb.equal(books.get("id"),bookId)
        );

        var query = entityManager.createQuery(cq);
        var results = query.getResultList();

       return results;
    }
}
