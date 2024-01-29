package com.alvonellos.interview.stackoverflow.Answer77901934;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/staff")
@RequiredArgsConstructor
//Could use @AllArgsConstructor(onConstructor = @__({@Autowired})) here instead.
public class StaffController {

    private final StaffService staffService; // Will automatically wire this in.
    @GetMapping
    public List<Staff> getStaff(){
        return staffService.getStaffs();
    }

}