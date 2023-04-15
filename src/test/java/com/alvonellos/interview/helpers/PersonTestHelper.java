package com.alvonellos.interview.helpers;

import com.alvonellos.interview.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonTestHelper {

    private static final Random random = new Random();

    @Value("classpath:random_person_data.csv")
    private Resource testData;

//    private List<PersonDto> loadTestData() throws IOException {
//        List<PersonDto> dtos = new ArrayList<>();
//        try (Reader reader = new InputStreamReader(testData.getInputStream());
//             CSVReader csvReader = new CSVReader(reader)) {
//            String[] headers = csvReader.readNext();
//            Map<String, Integer> headerMap = Arrays.stream(headers)
//                    .collect(Collectors.toMap(Function.identity(), Arrays.asList(headers)::indexOf));
//            String[] row;
//            while ((row = csvReader.readNext()) != null) {
//                PersonDto dto = new PersonDto();
//                dto.setProperty1(row[headerMap.get("property1")]);
//                dto.setProperty2(row[headerMap.get("property2")]);
//                // ...
//                dtos.add(dto);
//            }
//        }
//        return dtos;
//    }

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
