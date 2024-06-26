package sk.stuba.fei.uim.oop.entity.organization;

import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;
import sk.stuba.fei.uim.oop.utility.Constants;

import java.util.*;

public class Company implements OrganizationInterface {
    private String name;
    private Map<PersonInterface, Integer> employees;
    private Set<ProjectInterface> projects;
    private int companyBudget;

    public Company() {
        this.projects = new LinkedHashSet<>();
        this.employees = new HashMap<>();
        this.companyBudget = Constants.COMPANY_INIT_OWN_RESOURCES;
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
        return new HashSet<>(employees.keySet());
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
        for (ProjectInterface project : projects) {
            if (project.getStartingYear() <= year && project.getEndingYear() >= year) {
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
        for (ProjectInterface project : projects) {
            totalBudget += project.getTotalBudget();
        }
        return totalBudget;
    }

    @Override
    public void projectBudgetUpdateNotification(ProjectInterface pi, int year, int budgetForYear) {
        int grantBudget = pi.getBudgetForYear(year);
        if(companyBudget >= budgetForYear){
            companyBudget -= grantBudget;
            pi.setBudgetForYear(year, budgetForYear + grantBudget);
        } else{
            pi.setBudgetForYear(year, budgetForYear + companyBudget);
            companyBudget = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}











