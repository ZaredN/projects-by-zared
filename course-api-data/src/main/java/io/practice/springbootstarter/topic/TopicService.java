package io.practice.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //A stereotype annotation (class-path scan/ singleton )
public class TopicService {
	@Autowired //allows a member variable to have access to service class, injects an instance to springframkework
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList( // static initialization block
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Java Core Description"),
			new Topic("javascript", "Javascript", "Javaacript Description")
			 //one instance of topics and different methods may access it
			));
	
	public List <Topic> getAllTopics(){ //method which returns list of topics.
		//return topics;
		List <Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	//given a topic compare the topic to the id which is passed in lambda expression
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id,Topic topic) {
		for(int i =0; i < topics.size(); i++) { 
			Topic t = topics.get(i);
			if(t.getId().equals(id)) { //loop through topic and for each topic in that list will compare the input id and if matches will send the updated service
				topics.set(i, topic);
				return;
				
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}
	
}
 	