package io.adamalam.springbootstarter.course;

import io.adamalam.springbootstarter.topic.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
//    getAllCourses()
//    getAllCourses(String id)
//    updateCourse(Topic t)
//    deleteCourse(Topic t)
    public List<Course> findAllByTopicId(String topicId);
}
