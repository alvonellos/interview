package com.alvonellos.interview.Interviews.Walmart;

import static com.alvonellos.interview.util.java.AddressUtil.addrString;

public class Solution {

    /**
     * >> postalCode/zipCode --> input                     -> Controller Layer
     * >> department --> Input
     *
     * Step1). Build get in controller layer with prototype
     *
     *
     * @GetMapping("/intistutions")
     * public ResponseEntity<List<Intitution>> getInstitutions(@PathParam(name = "zipCode") String zipCode
     *                                                                         @PathParam(name = "dept")    String dept
     * >> Op: Department {computer, social...}
     * Step2). Build Entity JPA Interfaces
     * Institution
     * Department (many to one mapping) code table
     *
     * Step 2a). Build service layer component to talk back and forth between database and controller
     *  a). Reach out and query based on zip code
     *  b). Filter list of institutions by department
     *  c). Return List<Institutions>
     *
     * Step 3). Build client layer
     *  a). Build configuration in application.properties / yml
     *  b). Build a wrapper around rest template that calls external API to get list of institutions
     *  c). Build appropriate dto objects to deserialize api reponse into pojo
     *
     *  Step 4). Build component tests
     *      a). I like to start here (BDD / TDD), but not always possible.
     *
     *  Step 5). Fill in details.
     *      b). Fill in implementatition details and confirm with business.
     *
     *
     * Outpu
     * {
     *     [ list of Insti with basic dtaails ]
     * }
     *
     * threshold: 20 miles{...}
     * --------
     * Interface -> API
     *
     * Implpl : {
     *
     * }
     * ----------
     * @param args
     */


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(addrString(s));
    }
}
