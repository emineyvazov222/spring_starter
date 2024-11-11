package org.spring.springlesson2.controller;

import org.spring.springlesson2.dao.response.RollResponse;
import org.spring.springlesson2.entities.Roll;
import org.spring.springlesson2.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class RollController {
    @Autowired
    private RollService rollService;


    @PostMapping("/save")
    public Roll saveRoll(@RequestBody Roll roll) {
        return rollService.save(roll);
    }

    @GetMapping("/list")
    public List<Roll> getAllRolls(@RequestBody Roll roll) {
        return rollService.findAll(roll);
    }

    @GetMapping("/list/{id}")
    public Roll getRollById(@PathVariable Long id) {
        return rollService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Roll updateRoll(@PathVariable Long id, @RequestBody Roll roll) {
        return rollService.update(id, roll);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoll(@PathVariable Long id) {
        rollService.delete(id);
    }

    @GetMapping("/roll-response/{id}")
    public RollResponse getRollResponse(@PathVariable Long id, @RequestBody Roll roll) {
        return rollService.getResponse(id,roll);
    }


}
