package edu.uph.ii.springbootprj.controllers;

import edu.uph.ii.springbootprj.entities.Topic;
import edu.uph.ii.springbootprj.filters.TopicFilter;
import edu.uph.ii.springbootprj.repositories.AnswerRepository;
import edu.uph.ii.springbootprj.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TopicsController {

    private final TopicRepository topicRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public TopicsController(TopicRepository topicRepository, AnswerRepository answerRepository) {
        this.topicRepository = topicRepository;
        this.answerRepository = answerRepository;
    }

    @RequestMapping(value="/topics", method={RequestMethod.GET, RequestMethod.POST})
    public String displayAllTopics(Model model, @ModelAttribute("topicFilter") TopicFilter filter, @PageableDefault(page=0, sort = "id", size = 20) Pageable pageable) {
        //List<Topic> topics = topicRepository.findAll(new Sort(Sort.Direction.DESC, "createdDate"));
        List<Topic> topics = topicRepository.findAll();
        String header = setHeader("all");
        model.addAttribute("page",topicRepository.findTopicsByTitle(filter.getPhrase(), pageable));
        //model.addAttribute("topics",topicRepository.findTopicsByTitle(filter.getPhrase(), pageable));
        model.addAttribute("topics", topics); // wyswietlanie tematow
        model.addAttribute("header", header); //wyswietlanie ile jest tematow
        model.addAttribute("answerRepository", answerRepository);
        return "topics";
    }

//    @RequestMapping(value="/list",method = {RequestMethod.GET, RequestMethod.POST})
//    protected String showList(Model model, @ModelAttribute("vehicleFilter") VehicleFilter vehicleFilter,
//                              @PageableDefault(sort="id", size=20) Pageable pageable)//?page=x&size=y&sort=prop1,ASC&sort=prop2,DESC
//    {
//        //model.addAttribute("vehicleList", DBDump.vehicleList);
//        if(vehicleFilter.isEmpty()){
//            model.addAttribute("page", vehicleRepository.findAll(pageable));
//        }
//        else{
//            model.addAttribute("page", vehicleRepository.findVehiclesByModelIgnoreCaseContainingOrMarkaIgnoreCaseContaining(vehicleFilter.getPhrase(), vehicleFilter.getPhrase(), pageable));
//        }
//        return "vehicle/carList";
//    }

    @GetMapping("topics/{category}")
    public String displayTopicsByCategory(@PathVariable String category, Model model) {
        List<Topic> topics = topicRepository.findTopicsByCategoryOrderByCreatedDateDesc(category);
        String header = setHeader(category);
        model.addAttribute("topics", topics);
        model.addAttribute("header", header);
        model.addAttribute("answerRepository", answerRepository);
        return "topics";
    }

    @GetMapping("topics/user/{id}")
    public String displayTopicsByUser(@PathVariable String id, Model model) {
        List<Topic> topics = topicRepository.findTopicsByUser_IdOrderByCreatedDateDesc(Long.valueOf(id));
        String header = setHeader("user");
        model.addAttribute("topics", topics);
        model.addAttribute("header", header);
        model.addAttribute("answerRepository", answerRepository);
        return "topics";
    }

    private String setHeader(String category) {
        switch (category) {
            case "60":
                return "Lata 60";
            case "70":
                return "Lata 70";
            case "80":
                return "Lata 80";
            case "90":
                return "Lata 90";
            case "00":
                return "Lata 00";
            case "all":
                return "All topics";
            default:
                return "User's topics";
        }
    }

//    @GetMapping
//    public List<Topic> list(@RequestParam int size, @RequestParam int page, @RequestParam String search, Model model){
//        Page<Topic> pageableTopics = searchRepository.findAll(searchTopicSpecification(search), PageRequest.of(page, limit);
//        return pageableTopics.getContent();
//    }
}