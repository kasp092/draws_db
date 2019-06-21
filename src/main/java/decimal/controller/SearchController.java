package decimal.controller;

import decimal.enity.Project;
import decimal.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    private ProjectRepo projectRepo;

//    @PostMapping
////    public String add(@RequestParam String projectName, Map<String, Object> model) {
////
////        Project project = new Project(projectName);
////        projectRepo.save(project);
////
////        model.put("add", "this?");
////
////        return "search";
////    }

    @RequestMapping("/search")
    public String search(Map<String, Object> model) {

        Iterable<Project> projects = projectRepo.findAll();
        model.put("projects", projects);

        return "search";
    }

//    @PostMapping("/search")
//    public String filter(@RequestParam String filter1, @RequestParam String filter2, Map<String, Object> model) {
//        Iterable<Project> projects;
//
//        if (filter1 != null && !filter1.isEmpty() && filter2 != null && !filter2.isEmpty()) {
//            projects = projectRepo.findByProjectNameContains(filter1);
//        } else {
//            projects = projectRepo.findAll();
//        }
//        model.put("projects", projects);
//
//        return "search";
//    }

}