package com.stackroute.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class has various methods to do stream operations on person collection
 */
public class PersonStreamOperations {

    /**
     * sorts the person list alphabetically in uppercase
     * Returns Empty Optional if the given list is null or empty
     *
     * @param personList
     * @return
     */
    public Optional<List<String>> getPersonListSortedByNameInUpperCase(List<String> personList) {
        Optional<List<String>> optional = Optional.empty();

        if( personList ==null || personList.isEmpty()) {
            return optional;
        }

        optional = Optional.of(personList.stream()
                .sorted()
                .filter(x -> (!x.isBlank()))
                .map(person -> person.toUpperCase())
                .collect(Collectors.toList()));
        return optional;
    }

    /**
     * Sorts the distinct person names in descending order
     * Returns empty set if the given list is empty or null
     *
     * @param personList
     * @return
     */

    public Set<String> getDistinctPersonNamesSortedInDescendingOrder(List<String> personList) {
        Set<String> set = new LinkedHashSet<String>();

        if( personList ==null || personList.isEmpty()) {
            return set;
        }

        List<String> list = personList.stream()
                .distinct()
                .filter(x -> (!x.isBlank()))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        list.forEach(x -> set.add(x));

        return set;
    }

    /**
     * Returns "Person found" if the person searched is available in the list or else returns "Person not found"
     * Returns "Give proper input not null" if the given list or name to search is null
     *
     * @param personList
     * @return
     */
    public String searchPerson(List<String> personList, String nameToSearch) {
        if(personList == null || nameToSearch == null) {
            return "Give proper input not null";
        }

        boolean check = personList.stream()
                .anyMatch( x -> x.equalsIgnoreCase(nameToSearch));

        if (check == true) {
            return "Person found";
        }else {
            return "Person not found";
        }
    }

    /**
     * Filters the list whose name length is greater than five and sorts by name length
     * Returns empty list if the given list is empty or null
     *
     * @param personList
     * @return
     */

    public List<String> getPersonListSortedByLengthWithNameLengthGreaterThanFive(List<String> personList) {
        List<String> list = new ArrayList<String>();
        if(personList == null || personList.isEmpty()) {
            return list;
        }

        list = personList.stream()
                .filter(person -> person.length() > 5)
                .sorted((q1,q2) -> q1.length() - q2.length())
                .collect(Collectors.toList());
        return list;
    }

    /**
     * Returns the person name having maximum age from the given Map<String,Integer> having name as key and age as value
     * Returns "Give proper input not null" if the given map is empty or null
     *
     * @param personMap
     * @return
     */

    public String getPersonByMaxAge(Map<String, Integer> personMap) {
        if (personMap == null || personMap.isEmpty()) {
            return "Give proper input not null";
        }

        return personMap.entrySet()
                .stream()
                .max( (q1,q2) -> q1.getValue() > q2.getValue() ? 1 : -1 )
                .get()
                .getKey();
    }

}
