package com.alvonellos.interview.helpers;

import com.alvonellos.interview.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonTestHelper {

    private static final Random random = new Random();

    public static List<Person> generatePersonList(int size) {
        List<Person> personList = new ArrayList<>();
        for (Long i = 1l; i <= size; i++) {
            String firstName = "First" + i;
            String lastName = "Last" + i;
            Long personId = i;
            Person person = new Person(personId, firstName, lastName);
            personList.add(person);
        }
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(size);
            Person person = personList.get(i);
            personList.set(i, personList.get(index));
            personList.set(index, person);
        }
        return personList;
    }
}
