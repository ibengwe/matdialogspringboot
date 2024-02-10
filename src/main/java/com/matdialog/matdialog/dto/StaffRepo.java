package com.matdialog.matdialog.dto;

import com.matdialog.matdialog.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff,Integer> {
}
