package com.nouman.spring_boot_rest.service;

import java.util.ArrayList;
import java.util.List;

import com.nouman.spring_boot_rest.model.JobPost;
import com.nouman.spring_boot_rest.repo.JobRepo;
import com.nouman.spring_boot_rest.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;

    @Autowired
    public JobRepository repository;

    public List<JobPost> getAllJobs() {
//        return repo.getAllJobs();
        return repository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
//        repo.addJobPost(jobPost);
        repository.save(jobPost);
    }

    public JobPost getJobPost(int postId) {
//        return repo.getJobPost(postId);
        return repository.findById(postId).orElse(new JobPost());
    }

    public void updateJobPost(JobPost jobPost) {
//        repo.updateJobPost(jobPost);
        repository.save(jobPost);
    }

    public void deleteJobPost(int postId) {
//        repo.deleteJobPost(postId);
        repository.deleteById(postId);
    }

    public void loadJobs() {
        List<JobPost> jobs = new ArrayList<>(List.of(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),
                new JobPost(4, "Network Engineer",
                        "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App"))

        ));
        repository.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repository.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
