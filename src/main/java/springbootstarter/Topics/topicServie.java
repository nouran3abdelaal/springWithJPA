package springbootstarter.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class topicServie {
    private List<topic> topicList = new ArrayList<>(  Arrays.asList(
            new topic("t1","t1","t1"),
            new topic("t2","t2","t2")

    ));
    @Autowired
    private topicRepository topicRepository;
    public List<topic> getAllTopics(){

//        return topicList;
        List<topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }
    public Optional<topic> getTopicByID(String Id){
//        return topicList.stream().filter(t->t.getId().equals(Id)).findFirst().get();
      return  topicRepository.findById(Id);
    }

    public List<topic> addTopic(topic t) {
//        topicList.add(t);
//        return topicList;
        List<topic> topics = new ArrayList<>();
        topicRepository.save(t);
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public void updateTopic(String id, topic newTopic) {
//        topicList = topicList.stream()
//                .map(existingTopic -> {
//                    if (existingTopic.getId().equals(id)) {
//                        return newTopic;
//                    } else {
//                        return existingTopic;
//                    }
//                })
//                .collect(Collectors.toList());
//
//        return topicList;
        topicRepository.save(newTopic);
    }

    public void deleteTopic(String id) {
//        topicList.removeIf(t->t.getId().equals(id));
//        return topicList;
        topicRepository.deleteById(id);
    }
}
