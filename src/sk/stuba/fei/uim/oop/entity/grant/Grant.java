package sk.stuba.fei.uim.oop.entity.grant;

import java.util.*;

public class Grant implements GrantInterface{

    private String identifier;
    private int year;
    private AgencyInterface agency;
    private int budget;
    private int remainingBudget;
    private Queue<ProjectInterface> registeredProjects;
    private GrantState state;


    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public AgencyInterface getAgency() {
        return agency;
    }

    @Override
    public void setAgency(AgencyInterface agency) {
        this.agency = agency;
    }

    @Override
    public int getBudget() {
        return budget;
    }

    @Override
    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public int getRemainingBudget() {

        //TODO: implement this method
        return 0;
    }

    @Override
    public int getBudgetForProject(ProjectInterface project) {
        //TODO: implement this method
        return 0;
    }

    @Override
    public boolean registerProject(ProjectInterface project) {
        if(getState() == GrantState.STARTED && project.getStartingYear() == getYear()) {
            registeredProjects.add(project);
            return true;
        }
        //TODO: implement this method, maybe its already implemented
        return false;
    }


    @Override
    public Set<ProjectInterface> getRegisteredProjects() {
        return new LinkedHashSet<>(registeredProjects);
    }

    @Override
    public GrantState getState() {
        return state;
    }

    @Override
    public void callForProjects() {
        state = GrantState.STARTED;
        //TODO: implement this method, maybe it's already implemented
    }

    @Override
    public void evaluateProjects() {
        //TODO: implement this method
        state = GrantState.EVALUATING;

//        for( ProjectInterface project : registeredProjects){
//            project.getAllParticipants().forEach(participant ->{
//                if(participant.getEmployers().forEach(employerOrganization ->{
//                    employerOrganization.getEmploymentForEmployee(participant)
//                    //TODO skontati sta i kako, ali preko agenture treba valjda
//                    // da se dobije uvazok za projekat
//                })
//            });)
//        })
    }

    @Override
    public void closeGrant() {

    }

}
