package com.khaled.tms.HolidayComponent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;

public interface HolidaysRepo extends JpaRepository<PublicHolidaysEntity,Integer> {
    public boolean existsByDate(LocalDate localDate);}
