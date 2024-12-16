package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvisorService {

    @Autowired
    private AdvisorRepository advisorRepository;

    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    public Advisor getAdvisorById(Long id) {
        return advisorRepository.findById(id).orElse(null);
    }

    public Advisor createAdvisor(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    public Advisor updateAdvisor(Long id, Advisor updatedAdvisor) {
        return advisorRepository.findById(id)
                .map(existingAdvisor -> {
                    existingAdvisor.setFirstName(updatedAdvisor.getFirstName());
                    existingAdvisor.setLastName(updatedAdvisor.getLastName());
                    existingAdvisor.setAddress(updatedAdvisor.getAddress());
                    existingAdvisor.setPhone(updatedAdvisor.getPhone());
                    existingAdvisor.setEmail(updatedAdvisor.getEmail());
                    return advisorRepository.save(existingAdvisor);
                }).orElse(null);
    }

    public void deleteAdvisor(Long id) {
        advisorRepository.deleteById(id);
    }
}
