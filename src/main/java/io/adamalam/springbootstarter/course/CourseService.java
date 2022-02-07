package io.adamalam.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAllByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course topic) {
        courseRepository.save(topic);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        Course topic = courseRepository.findById(id).orElse(null);
        if (topic != null) {
            courseRepository.delete(topic);
        }
    }
}
