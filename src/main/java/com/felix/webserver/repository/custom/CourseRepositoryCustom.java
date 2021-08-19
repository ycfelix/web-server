package com.felix.webserver.repository.custom;

import com.felix.webserver.repository.model.vo.CourseVoEntity;

import java.util.List;

public interface CourseRepositoryCustom {

    List<CourseVoEntity> customRetrieve(Long bookId);
}
