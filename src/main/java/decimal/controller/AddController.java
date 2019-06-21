package decimal.controller;

import decimal.enity.Draw;
import decimal.enity.Project;
import decimal.repos.DrawRepo;
import decimal.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AddController {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private DrawRepo drawRepo;

    @RequestMapping("/add")
    public String add(Map<String, Object> model) {
        Iterable<Project> projects = projectRepo.findAll();
        model.put("projects", projects);
        return "add";
    }

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

}
