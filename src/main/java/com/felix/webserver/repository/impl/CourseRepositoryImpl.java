package com.felix.webserver.repository.impl;

import com.felix.webserver.repository.model.vo.CourseVoEntity;
import com.felix.webserver.repository.custom.CourseRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CourseVoEntity> customRetrieve(Long id) {
        var cb = entityManager.getCriteriaBuilder();
        var cq = cb.createQuery(CourseVoEntity.class);

//
        var courseRoot = cq.from(CourseVoEntity.class);
        cq.where(cb.equal(courseRoot.get("id"),id));
        cq.select(courseRoot);
        cq.orderBy(cb.desc(courseRoot.get("books")));
//        var students = courseRoot.joinList("students", JoinType.LEFT);
//        var books = students.joinList("books", JoinType.LEFT);
//
//        var sqSum = cq.subquery(Integer.class);
//        var sqBook = sqSum.from(Book.class);
//        var sqStudent = sqBook.join("student", JoinType.LEFT);
//        sqSum.where(cb.equal(sqStudent.get("id"),students.get("id")));
//        sqSum.select(cb.sum(sqBook.get("price")));
//
//        cq.where(
//                cb.equal(books.get("id"),bookId)
//        );
//        cq.groupBy(courseRoot.get("id"));
////        var sum = cb.sum(books.<Long>get("price"));
//
//        cq.multiselect(
//                courseRoot.get("id"),
//                courseRoot.get("students").get()
//        );

        var query = entityManager.createQuery(cq);
        var results = query.getResultList();

       return results;
    }
}
