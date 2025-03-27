package com.nouman.spring_boot_rest;

import com.nouman.spring_boot_rest.model.JobPost;
import com.nouman.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(value = "jobPosts", produces = "application/json")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJobPost(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJobPost(jobPost);
        return service.getJobPost(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJobPost(jobPost);
        return service.getJobPost(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJobPost(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.loadJobs();
        return "success";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }
}
