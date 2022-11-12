package me.alaminkhan.springbootquickstart.topic;

import me.alaminkhan.springbootquickstart.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
}
