package decimal.controller;

import decimal.enity.Project;
import decimal.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    private ProjectRepo projectRepo;

    @PostMapping
    public String add(@RequestParam String projectName, Map<String, Object> model) {

        Project project = new Project(projectName);
        projectRepo.save(project);

        return "index";
    }

    @GetMapping
    public String main() {
        return "index";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter1, @RequestParam String filter2, Map<String, Object> model) {
        Iterable<Project> projects;

        if (filter1 != null && !filter1.isEmpty()) {
            projects = projectRepo.findByProjectName(filter1);
        } else {
            projects = projectRepo.findAll();
        }
        model.put("projects", projects);

        return "index";
    }

}