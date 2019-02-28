package io.practice.springbootstarter.topic.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.practice.springbootstarter.topic.Topic;

@Entity //JPA creates a table with Topic instance of Topic.
public class Course{
	@Id //marks the primary key in the db
	private String id;
	private String name;
	private String description;
	
	@ManyToOne // maps to the table via many to one ORM persistence
	private Topic topic;
	
	public Course() {
		
	}
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	
	
}

