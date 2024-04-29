package sk.stuba.fei.uim.oop.entity.grant;

import sk.stuba.fei.uim.oop.entity.people.PersonInterface;
import sk.stuba.fei.uim.oop.utility.Constants;

import java.util.*;

public class Grant implements GrantInterface{

    private String identifier;
    private int year;
    private AgencyInterface agency;
    private int budget;
    private int remainingBudget;
    private Queue<ProjectInterface> registeredProjects;
    private GrantState state;
    private Map<ProjectInterface, Integer> projectBudgets;



    public Grant(){
        projectBudgets = new HashMap<>();
        registeredProjects = new LinkedList<>();
    }

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
        this.remainingBudget = budget;
    }

    @Override
    public int getRemainingBudget() {
        return remainingBudget;
    }

    @Override
    public int getBudgetForProject(ProjectInterface project) {
        if(!(projectBudgets.get(project) == null))
            return projectBudgets.get(project);
        else return 0;
    }

    private boolean controlEmployment(ProjectInterface project) {
        for (PersonInterface participant : project.getAllParticipants()) {
            for (int year = project.getStartingYear(); year <= project.getEndingYear(); year++) {
                int totalEmployment = 0;
                for (GrantInterface grant : agency.getAllGrants()) {
                    if (grant.getState() == GrantState.CLOSED) {
                        for (ProjectInterface registeredProject : grant.getRegisteredProjects()) {
                            if (registeredProject.getAllParticipants().contains(participant) &&
                                    year >= registeredProject.getStartingYear() && year <= registeredProject.getEndingYear()) {
                                totalEmployment += registeredProject.getApplicant().getEmploymentForEmployee(participant);
                            }
                        }
                    }
                }
                totalEmployment += project.getApplicant().getEmploymentForEmployee(participant);
                if (totalEmployment > Constants.MAX_EMPLOYMENT_PER_AGENCY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean registerProject(ProjectInterface project) {
        if(getState() != GrantState.STARTED || project.getStartingYear() != getYear()) {
            return false;
        }
        if(project.getApplicant() == null || project.getAllParticipants().isEmpty()){
            return false;
        }
        registeredProjects.add(project);
        return true;
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
    }

    @Override
    public void evaluateProjects() {
        state = GrantState.EVALUATING;

        List<ProjectInterface> eligibleProjects = new ArrayList<>();

        for (ProjectInterface project : registeredProjects) {
            if (controlEmployment(project)) {
                eligibleProjects.add(project);
            }
        }

        int numberOfEligibleProjects = eligibleProjects.size();

        if(numberOfEligibleProjects > 1){
            numberOfEligibleProjects/=2;
        }
        if(numberOfEligibleProjects >= 1){
            int budgetPerProject = budget / numberOfEligibleProjects;
            for (int i = 0; i < numberOfEligibleProjects; i++) {
                ProjectInterface project = eligibleProjects.get(i);
                for(int j = 0; j < Constants.PROJECT_DURATION_IN_YEARS; j++){
                    int budgetPerProjectPerYear = budgetPerProject / Constants.PROJECT_DURATION_IN_YEARS;
                    project.setBudgetForYear(project.getStartingYear() + j, budgetPerProjectPerYear);
                    project.getApplicant().projectBudgetUpdateNotification(project, year, budgetPerProjectPerYear);
                    remainingBudget -= budgetPerProjectPerYear;
                }
                projectBudgets.put(project, budgetPerProject);
            }
        }
    }
    @Override
    public void closeGrant() {
        state = GrantState.CLOSED;
    }

}
