package com.alvonellos.interview.stackoverflow.Answer77901934;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;
    public List<Staff> getStaffs() {
        return staffRepository.findAll();
    }
}