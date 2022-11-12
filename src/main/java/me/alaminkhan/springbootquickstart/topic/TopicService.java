package me.alaminkhan.springbootquickstart.topic;

import me.alaminkhan.springbootquickstart.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spring Framework", "Spring Framwork Description"),
//            new Topic("java", "Core Java", "Core Java Description"),
//            new Topic("javascript", "JavaScript", "JavaScript Description")
//    ));

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){
//        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }


    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        //topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();

//        for (int i = 0; i < topics.size(); i++){
//            Topic t = topics.get(i);
//            System.out.println(t);
//
//            if (t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }

        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
