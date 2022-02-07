package io.adamalam.springbootstarter.course;

import io.adamalam.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CourseController {

    @Autowired private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
        course.setTopic(new Topic(topicId, "",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }
}
