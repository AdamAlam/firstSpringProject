package io.adamalam.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired private TopicRepository topicRepository;

    private List<Topic> topics =
            new ArrayList<>(
                    Arrays.asList(
                            new Topic("spring", "Spring Framework", "Spring Framework Description"),
                            new Topic("java", "Core Java", "Core Java Description"),
                            new Topic("javascript", "Javascript", "Javascript Description")));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topic -> topics.add(topic));
        return topics;
    }

    public Topic getTopic(String id) {
        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        Topic topic = topicRepository.findById(id).orElse(null);
        if (topic != null) {
            topicRepository.delete(topic);
        }
    }
}
