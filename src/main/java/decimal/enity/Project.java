package decimal.enity;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "projects", schema = "test")
public class Project {

    public Project() {
    }

    private Long id;
    private String projectName;
    private List<Draw> draws;
    private String comments;
    private String projectLeader;
    private String department;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "project_name", unique = true)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    public List<Draw> getDraws() {
        return draws;
    }

    public void setDraws(List<Draw> products) {
        this.draws = products;
    }

    public void addDraw(Draw draw) {
        draws.add(draw);
    }


    //TODO  как починить ленивую реализацию загрузки списка чертежей ?
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
//                ", draws=" + draws +
                '}';
    }

    @Column(name = "project_description")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "project_leader")
    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectName.equals(project.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName);
    }
}
