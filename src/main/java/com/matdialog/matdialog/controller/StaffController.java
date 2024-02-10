package com.matdialog.matdialog.controller;

import com.matdialog.matdialog.entity.Staff;
import com.matdialog.matdialog.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/staff")
@CrossOrigin("*")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService service;

    @PostMapping
    public Staff add(@RequestBody Staff staff){
        return service.add(staff);
    }
    @GetMapping
    public List<Staff> all(){
        return service.all();
    }
    @GetMapping("{id}")
    public Optional<Staff> getOne(@PathVariable Integer id){
        return service.one(id);
    }
    @DeleteMapping("{id}")
    public void deleteMe(@PathVariable Integer id){
        service.deleteMe(id);
    }
    @PutMapping("{id}")
    public Staff update(@RequestBody Staff staff,@PathVariable Integer id){
        staff.setId(id);
        return service.add(staff);
    }
}
