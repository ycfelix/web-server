package com.felix.webserver.controller;

import com.felix.webserver.model.Course;
import com.felix.webserver.model.Student;
import com.felix.webserver.model.vo.CourseVo;
import com.felix.webserver.repository.CourseRepository;
import com.felix.webserver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public Student create(@RequestBody Student student) {
        Student s = null;
        for(int i=0 ; i < 2; i++) {
            int finalI = i;
            new Runnable() {
                @Override
                public void run() {
                    try {
                         customCreate(student, finalI);
                    }catch (Exception e) {
                        System.out.println("caught exception");
                    }
                }
            }.run();
        }
        return s;
    }

    @Transactional
    public Student customCreate(Student student, int i) {
        var res = studentRepository.save(student);
        if(i == 0){
            throw new RuntimeException("hello world");
        }
        return res;
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentRepository.customUpdate(student);
    }

    @GetMapping
    public List<Student> retrieve() {
        return studentRepository.findAll();
    }

    @GetMapping("/file")
    public void getFile(@RequestParam Long id, HttpServletResponse response) {
        String content = "abcdevgc";
        String s = "abc/s/c/123124-23123/a.csv";
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,String.format("attachment; filename= \"%s\"",s));
        try(OutputStream outputStream = response.getOutputStream()) {
            outputStream.write(content.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
