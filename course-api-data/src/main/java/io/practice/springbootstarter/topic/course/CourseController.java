package io.practice.springbootstarter.topic.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.practice.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	//set the return type of the method to what the response should be
			//springmvc converts the arrayList calls into a json request
	@Autowired // needs dependency injection, create a new instance and looks at registry and takes instance and injects it through
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses") //GET request to get all topics	
	public List <Course> getAllCourses(@PathVariable String id) { 
		return courseService.getAllCourses(id); //encapsulated method call to access topics from Business Service
					
				
	}
	@RequestMapping("/topics/{topicId}/courses/{id}") // Tells spring this is a variable portion
	 public Optional<Course> getCourse(@PathVariable String id) {// GET request for a single topic -course id // tells spring that this is a variable id
		return courseService.getCourse(id);
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	//I have used postMan to check each method call
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}") //go to a specific page and delete the list.
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteTopic(id);
	}
}
