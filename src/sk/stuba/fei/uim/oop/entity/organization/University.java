package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.*;

public class University implements OrganizationInterface{
    private String name;
    private Map<PersonInterface, Integer> employees;
    private Set<ProjectInterface> projects;


    public University(){
        this.projects = new HashSet<>();
        this.employees = new HashMap<>();
    }

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
        return employees.get(p);
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
        return runningProjects;
    }

    @Override
    public void registerProjectInOrganization(ProjectInterface project) {
        projects.add(project);
    }

    @Override
    public int getProjectBudget(ProjectInterface pi) {
        return pi.getTotalBudget();
    }

    @Override
    public int getBudgetForAllProjects() {
        int totalBudget = 0;
        for(ProjectInterface project : projects){
            totalBudget += project.getTotalBudget();
        }
        return totalBudget;
    }

    @Override
    public void projectBudgetUpdateNotification(ProjectInterface pi, int year, int budgetForYear) {
        pi.setBudgetForYear(year, budgetForYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
