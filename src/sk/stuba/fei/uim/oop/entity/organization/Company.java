package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Company implements OrganizationInterface{
    private String name;
    private Map<PersonInterface, Integer> employees;
    private Set<ProjectInterface> projects;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void addEmployee(PersonInterface p, int employment) {
        employees.put(p, employment);

    }

    @Override
    public Set<PersonInterface> getEmployees() {
        return new HashSet<>(employees.keySet());
    }

    @Override
    public int getEmploymentForEmployee(PersonInterface p) {
        //todo
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
        //todo
        return 0;
    }

    @Override
    public int getBudgetForAllProjects() {
        //todo
        return 0;
    }

    @Override
    public void projectBudgetUpdateNotification(ProjectInterface pi, int year, int budgetForYear) {
        //todo
    }
}
