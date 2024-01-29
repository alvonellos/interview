package com.alvonellos.interview.Interviews.Walmart;

//Spring boot crud restcontroller titled DistributionGroupController

import java.util.List;

import lombok.AllArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/distribution-groups")
public class DistributionGroupController {

    private final DistributionGroupService distributionGroupService;

    @GetMapping
    public ResponseEntity<List<DistributionGroup>> getAllDistributionGroups() {
        return new ResponseEntity<>(distributionGroupService.getAllDistributionGroups(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistributionGroup> getDistributionGroupById(@PathVariable UUID distributionGroupId) {
        return new ResponseEntity<>(distributionGroupService.getDistributionGroupById(distributionGroupId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DistributionGroup> createDistributionGroup(@RequestBody DistributionGroup distributionGroup) {
        return new ResponseEntity<>(distributionGroupService.createDistributionGroup(distributionGroup), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistributionGroup> updateDistributionGroup(@PathVariable UUID distributionGroupId, @RequestBody DistributionGroup distributionGroup) {
        return new ResponseEntity<>(distributionGroupService.updateDistributionGroup(distributionGroupId, distributionGroup), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DistributionGroup> deleteDistributionGroup(@PathVariable UUID distributionGroupId) {
        return new ResponseEntity<>(distributionGroupService.deleteDistributionGroup(distributionGroupId), HttpStatus.OK);
    }
}