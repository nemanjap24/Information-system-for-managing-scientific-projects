package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.Set;

public class Company implements OrganizationInterface{
    private String name;
    private int privateFunds;
    private Set<PersonInterface> employees;
    private Set<ProjectInterface> projects;


    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void addEmployee(PersonInterface p, int employment) {
        employees.add(p);

    }

    @Override
    public Set<PersonInterface> getEmployees() {
        return null;
    }

    @Override
    public int getEmploymentForEmployee(PersonInterface p) {
        return 0;
    }

    @Override
    public Set<ProjectInterface> getAllProjects() {
        return null;
    }

    @Override
    public Set<ProjectInterface> getRunningProjects(int year) {
        return null;
    }

    @Override
    public void registerProjectInOrganization(ProjectInterface project) {

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
