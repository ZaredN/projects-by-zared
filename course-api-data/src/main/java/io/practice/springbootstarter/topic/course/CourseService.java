package io.practice.springbootstarter.topic.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //A stereotype annotation (class-path scan/ singleton )
public class CourseService {
	@Autowired //allows a member variable to have access to service class, injects an instance to spring Framework
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topicId){ //method which returns list of topics. //return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);//lambda expression Method reference get the course and add it to the courses list
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
	return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		courseRepository.save(course); //the save method in the CRUD repository can do both Add and Update, checks if the row exists, if row exists it updates if not it inserts a row.
		
		
		
	}

	public void deleteTopic(String id) {
		courseRepository.deleteById(id);
		
	}
	
}
 	