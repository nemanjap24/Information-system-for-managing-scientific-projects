package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;
import sk.stuba.fei.uim.oop.utility.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Project implements ProjectInterface {

    private String projectName;
    private int startingYear;
    private Map<Integer, Integer> budgetPerYear;



    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public void setProjectName(String name) {
        this.projectName = name;
    }

    @Override
    public int getStartingYear() {
        return startingYear;
    }

    @Override
    public void setStartingYear(int year) {
        this.startingYear = year;
    }

    @Override
    public int getEndingYear() {
        return startingYear + Constants.PROJECT_DURATION_IN_YEARS - 1;
    }

    @Override
    public int getBudgetForYear(int year) {
        return budgetPerYear.get(year);
    }

    @Override
    public void setBudgetForYear(int year, int budget) {
        budgetPerYear.put(year, budget);
    }

    @Override
    public int getTotalBudget() {
        int totalBudget = 0;
        for (int i = 0; i < Constants.PROJECT_DURATION_IN_YEARS; i++) {
            totalBudget += budgetPerYear.get(startingYear + i);
        }
        return totalBudget;
    }

    @Override
    public void addParticipant(PersonInterface participant) {

    }

    @Override
    public Set<PersonInterface> getAllParticipants() {
        return null;
    }

    @Override
    public OrganizationInterface getApplicant() {
        return null;
    }

    @Override
    public void setApplicant(OrganizationInterface applicant) {

    }
}
