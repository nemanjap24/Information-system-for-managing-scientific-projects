package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;
import sk.stuba.fei.uim.oop.utility.Constants;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Project implements ProjectInterface {

    private String projectName;
    private int startingYear;
    private Map<Integer, Integer> budgetPerYear;
    private Set<PersonInterface> participants;
    private OrganizationInterface applicant;

    public Project(){
        budgetPerYear = new HashMap<>();
        participants = new HashSet<>();
    }



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
        for(int i = 0; i < Constants.PROJECT_DURATION_IN_YEARS; i++){
            budgetPerYear.put(year + i, 0);
        }
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

    //Riešiteľa, ktorý nie je zamestnancom podávajúcej organizácie, nie je možné pridať do projektu.
    @Override
    public void addParticipant(PersonInterface participant) {
        if(applicant.getEmployees().contains(participant)){
            participants.add(participant);
        }
    }

    @Override
    public Set<PersonInterface> getAllParticipants() {
        return participants;
    }

    @Override
    public OrganizationInterface getApplicant() {
        return applicant;
    }

    @Override
    public void setApplicant(OrganizationInterface applicant) {
        this.applicant = applicant;
    }
}
