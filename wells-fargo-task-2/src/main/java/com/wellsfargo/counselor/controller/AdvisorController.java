package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advisors")
public class AdvisorController {

    @Autowired
    private AdvisorService advisorService;

    @GetMapping
    public List<Advisor> getAllAdvisors() {
        return advisorService.getAllAdvisors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advisor> getAdvisorById(@PathVariable Long id) {
        Advisor advisor = advisorService.getAdvisorById(id);
        return advisor != null ? ResponseEntity.ok(advisor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Advisor createAdvisor(@RequestBody Advisor advisor) {
        return advisorService.createAdvisor(advisor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advisor> updateAdvisor(@PathVariable Long id, @RequestBody Advisor advisor) {
        Advisor updatedAdvisor = advisorService.updateAdvisor(id, advisor);
        return updatedAdvisor != null ? ResponseEntity.ok(updatedAdvisor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvisor(@PathVariable Long id) {
        advisorService.deleteAdvisor(id);
        return ResponseEntity.noContent().build();
    }
}
