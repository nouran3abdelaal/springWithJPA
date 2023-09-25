package springbootstarter.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class topicController {
@Autowired
    private topicServie topicServie;
    @RequestMapping("/Topics")
    public List<topic> getAllTopics(){
        return topicServie.getAllTopics();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/Topics")
    public List<topic> addTopic(@RequestBody topic t){
        return topicServie.addTopic(t);
    }
    @RequestMapping("/Topics/{Id}")
    public Optional<topic> getTopicByID(@PathVariable String Id){
        return topicServie.getTopicByID(Id);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/Topics/{id}")
    public void addTopic(@RequestBody topic t,@PathVariable String id){
         topicServie.updateTopic(id,t);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/Topics/{id}")
    public void addTopic(@PathVariable String id){
         topicServie.deleteTopic(id);
    }
}
