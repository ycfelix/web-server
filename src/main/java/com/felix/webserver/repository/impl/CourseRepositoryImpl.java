package com.felix.webserver.repository.impl;

import com.felix.webserver.model.Book;
import com.felix.webserver.model.Student;
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

        var sqSum = cq.subquery(Integer.class);
        var sqBook = sqSum.from(Book.class);
        var sqStudent = sqBook.join("student", JoinType.LEFT);
        sqSum.where(cb.equal(sqStudent.get("id"),students.get("id")));
        sqSum.select(cb.sum(sqBook.get("price")));

        cq.where(
                cb.equal(books.get("id"),bookId)
        );
        cq.groupBy(courseRoot.get("id"));
//        var sum = cb.sum(books.<Long>get("price"));

        cq.multiselect(courseRoot.get("id"), sqSum.getSelection());

        var query = entityManager.createQuery(cq);
        var results = query.getResultList();

       return results;
    }
}
