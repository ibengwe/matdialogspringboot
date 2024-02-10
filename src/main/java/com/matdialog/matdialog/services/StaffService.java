package com.matdialog.matdialog.services;

import com.matdialog.matdialog.dto.StaffRepo;
import com.matdialog.matdialog.entity.Staff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class StaffService {
    private final StaffRepo repo;

    public Staff add(Staff staff) {
        return repo.save(staff);
    }

    public List<Staff> all() {
        return repo.findAll();
    }

    public Optional<Staff> one(Integer id) {
        return repo.findById(id);
    }

    public void deleteMe(Integer id) {
        repo.deleteById(id);
    }
}
