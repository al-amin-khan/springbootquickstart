package me.alaminkhan.springbootquickstart.course;


import java.util.List;
import java.util.Optional;
import me.alaminkhan.springbootquickstart.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
  @Autowired
  private CourseService courseService;

  @RequestMapping("/topics/{id}/courses")
  public List<Course> getAllCourses(@PathVariable String id){
    return courseService.getAllCourses(id);
  }

  @RequestMapping("/topics/{topicId}/courses/{id}")
  public Optional<Course> getCourse(@PathVariable String id){
    return courseService.getCourse(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
  public void addCourse(@RequestBody Course course, @PathVariable String topicId){
    course.setTopic(new Topic(topicId, "", ""));
    courseService.addCourse(course);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
  public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
    course.setTopic(new Topic(topicId, "", ""));
    courseService.updateCourse(course);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
  public void updateTopic(@PathVariable String id){
    courseService.deleteCourse(id);
  }
}
