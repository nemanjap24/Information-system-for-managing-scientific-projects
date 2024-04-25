package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class University implements OrganizationInterface{
    private String name;
    private int publicFunds;
    private Map<PersonInterface, Integer> employees;
    private Set<ProjectInterface> projects;



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void addEmployee(PersonInterface p, int employment) {
        employees.put(p, employment);
    }

    @Override
    public Set<PersonInterface> getEmployees() {
        return employees.keySet();
    }

    @Override
    public int getEmploymentForEmployee(PersonInterface p) {
        return 0;
    }

    @Override
    public Set<ProjectInterface> getAllProjects() {
        return projects;
    }

    @Override
    public Set<ProjectInterface> getRunningProjects(int year) {
        Set<ProjectInterface> runningProjects = new HashSet<>();
        for(ProjectInterface project : projects){
            if(project.getStartingYear() <= year && project.getEndingYear() >= year){
                runningProjects.add(project);
            }
        }
        return projects;
    }

    @Override
    public void registerProjectInOrganization(ProjectInterface project) {
        projects.add(project);
    }

    @Override
    public int getProjectBudget(ProjectInterface pi) {
        return 0;
    }

    @Override
    public int getBudgetForAllProjects() {
        return 0;
    }

    @Override
    public void projectBudgetUpdateNotification(ProjectInterface pi, int year, int budgetForYear) {

    }
}
