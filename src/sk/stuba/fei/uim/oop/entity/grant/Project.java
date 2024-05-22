package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;
import sk.stuba.fei.uim.oop.utility.Constants;

import java.util.*;

public class Project implements ProjectInterface {

    private String projectName;
    private int startingYear;
    private final Map<Integer, Integer> budgetPerYear;
    private final Set<PersonInterface> participants;
    private OrganizationInterface applicant;

    public Project(){
        this.budgetPerYear = new HashMap<>();
        this.participants = new HashSet<>();
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
        try{
            return budgetPerYear.get(year);
        }catch (Exception ignored){

        }
        return 0;
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
        try{
            if(applicant.getEmployees().contains(participant)){
                participants.add(participant);
            }
        }
        catch(Exception ignored){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectName, project.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName);
    }

}
