package com.alvonellos.interview.Interviews.Walmart;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/distribution-group-members")
public class DistributionGroupMemberController {

    private final DistributionGroupMemberService DistributionGroupMemberService;
    
    @GetMapping
    public ResponseEntity<List<DistributionGroupMember>> getAllDistributionGroupMembers() {
        return new ResponseEntity<>(DistributionGroupMemberService.getAllDistributionGroupMembers(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DistributionGroupMember> getDistributionGroupMemberById(@PathVariable UUID DistributionGroupMemberId) {
        return new ResponseEntity<>(DistributionGroupMemberService.getDistributionGroupMemberById(DistributionGroupMemberId), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<DistributionGroupMember> createDistributionGroupMember(@RequestBody DistributionGroupMember DistributionGroupMember) {
        return new ResponseEntity<>(DistributionGroupMemberService.createDistributionGroupMember(DistributionGroupMember), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DistributionGroupMember> updateDistributionGroupMember(@PathVariable UUID DistributionGroupMemberId, @RequestBody DistributionGroupMember DistributionGroupMember) {
        return new ResponseEntity<>(DistributionGroupMemberService.updateDistributionGroupMember(DistributionGroupMemberId, DistributionGroupMember), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<DistributionGroupMember> deleteDistributionGroupMember(@PathVariable UUID DistributionGroupMemberId) {
        return new ResponseEntity<>(DistributionGroupMemberService.deleteDistributionGroupMember(DistributionGroupMemberId), HttpStatus.OK);
    }
}