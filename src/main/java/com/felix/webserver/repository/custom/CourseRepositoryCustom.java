package com.felix.webserver.repository.custom;

import com.felix.webserver.model.vo.CourseVo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseRepositoryCustom {

    List<CourseVo> customRetrieve(Long bookId);
}
