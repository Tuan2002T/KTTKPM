package com.kttkpm.Course.service;

import com.kttkpm.Course.entity.Course;
import com.kttkpm.Course.repository.CoursseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursseRepository coursseRepository;

    @Override
    @Cacheable(value = "coursesCache", key = "#root.methodName")
    public List<Course> getAll() {
        return coursseRepository.findAll();
    }

    @Override
    @Cacheable(value = "coursesCache", key = "#id")
    public Course getDetail(Long id) {
        return coursseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course is not exist!"));
    }

    @Override
    @CacheEvict(value = "coursesCache", allEntries = true)
    public Course create(Course course) {
        return coursseRepository.save(course);
    }

    @Override
    @CacheEvict(value = "coursesCache", key = "#id")
    public void update(Long id, Course courseUpdate) {
        Course course = coursseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course is not exist!"));

        // Update course properties

        coursseRepository.save(course);
    }

    @Override
    @CacheEvict(value = "coursesCache", key = "#id")
    public void delete(Long id) {
        coursseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course is not exist!"));
        coursseRepository.deleteById(id);
    }
}
