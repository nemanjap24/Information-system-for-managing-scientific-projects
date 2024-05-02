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
        if (!grants.containsKey(year)) {
            grants.put(year, new ArrayList<>());
        }
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return Objects.equals(name, agency.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
