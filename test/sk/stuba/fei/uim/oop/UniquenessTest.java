package sk.stuba.fei.uim.oop;

import org.junit.jupiter.api.Test;
import sk.stuba.fei.uim.oop.entity.grant.Grant;
import sk.stuba.fei.uim.oop.entity.grant.GrantInterface;
import sk.stuba.fei.uim.oop.entity.grant.Project;
import sk.stuba.fei.uim.oop.entity.grant.ProjectInterface;
import sk.stuba.fei.uim.oop.entity.organization.Company;
import sk.stuba.fei.uim.oop.entity.organization.OrganizationInterface;
import sk.stuba.fei.uim.oop.entity.organization.University;
import sk.stuba.fei.uim.oop.entity.people.Person;
import sk.stuba.fei.uim.oop.entity.people.PersonInterface;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquenessTest {
    @Test
    public void testUniquenessProject() {
        Set<ProjectInterface> projects = new HashSet<>();
        ProjectInterface project1 = new Project();
        ProjectInterface project2 = new Project();
        project1.setProjectName("1");
        project2.setProjectName("1");

        projects.add(project1);
        projects.add(project2);

        assertEquals(1, projects.size());
    }

    @Test
    public void testUniquenessOrganization() {
        Set<OrganizationInterface> organizations = new HashSet<>();
        OrganizationInterface company = new Company();
        OrganizationInterface university = new University();
        company.setName("1");
        university.setName("1");

        organizations.add(company);
        organizations.add(university);

        assertEquals(1, organizations.size());
    }

    @Test
    public void testUniquenessUniversity() {
        Set<OrganizationInterface> univerities = new HashSet<>();
        OrganizationInterface university1 = new University();
        OrganizationInterface university2 = new University();
        university1.setName("1");
        university2.setName("1");

        univerities.add(university1);
        univerities.add(university2);

        assertEquals(1, univerities.size());
    }

    @Test
    public void testUniquenessAgency() {
        Set<ProjectInterface> agencies = new HashSet<>();
        ProjectInterface agency1 = new Project();
        ProjectInterface agency2 = new Project();
        agency1.setProjectName("1");
        agency2.setProjectName("1");

        agencies.add(agency1);
        agencies.add(agency2);

        assertEquals(1, agencies.size());
    }

    @Test
    public void testUniquenessPerson() {
        Set<PersonInterface> persons = new HashSet<>();
        PersonInterface person1 = new Person();
        PersonInterface person2 = new Person();
        person1.setName("1");
        person2.setName("1");

        persons.add(person1);
        persons.add(person2);

        assertEquals(1, persons.size());
    }

    @Test
    public void testUniquenessGrant() {
        Set<GrantInterface> grants = new HashSet<>();
        GrantInterface grant1 = new Grant();
        GrantInterface grant2 = new Grant();
        grant1.setIdentifier("1");
        grant2.setIdentifier("1");

        grants.add(grant1);
        grants.add(grant2);

        assertEquals(1, grants.size());
    }
}
