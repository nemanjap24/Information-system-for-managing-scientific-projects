package sk.stuba.fei.uim.oop.entity.grant;

import java.util.*;

public class Agency implements AgencyInterface{

    String name;
    Map<Integer, List<GrantInterface>> grants;

    public Agency() {
        this.grants = new HashMap<>();
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
    public void addGrant(GrantInterface gi, int year) {
        // Check if there are already grants for this year
        if (!grants.containsKey(year)) {
            // If not, create a new list
            grants.put(year, new ArrayList<>());
        }

        // Add the grant to the list for this year
        grants.get(year).add(gi);
    }

    @Override
    public Set<GrantInterface> getAllGrants() {
        Set<GrantInterface> allGrants = new HashSet<>();
        for (List<GrantInterface> grantList : grants.values()) {
            allGrants.addAll(grantList);
        }
        return allGrants;
    }

    @Override
    public Set<GrantInterface> getGrantsIssuedInYear(int year) {
        if(grants.containsKey(year)){
            return new HashSet<>(grants.get(year));
        }
        return new HashSet<>();
    }
}
