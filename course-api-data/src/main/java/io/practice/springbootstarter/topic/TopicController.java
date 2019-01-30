package io.practice.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	//set the return type of the method to what the response should be
			//springmvc converts the arrayList calls into a json request
	@Autowired // needs depency injection, create a new instance and looks at registery and takes instance and injects it through
	private TopicService topicService;
	
	@RequestMapping("/topics") //GET request to get all topics	
	public List <Topic> getAllTopics() { 
		return topicService.getAllTopics(); //encapsulated method call to access topics from Business Service
					
				
	}
	@RequestMapping("/topics/{id}") // Tells spring this is a variable portion
	 public Topic getTopic(@PathVariable String id) {// GET request for a single topic // tells spring that this is a variable id
		return topicService.getTopic(id);
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	//I have used postMan to check each method call
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}") //go to a specific page and delete the list.
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
