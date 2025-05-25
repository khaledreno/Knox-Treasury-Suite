package com.khaled.tms.HolidayComponent;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
@Service
public class HolidaysService {
//    private static final Logger log = LoggerFactory.getLogger(HolidaysService.class);

    @Autowired
    private HolidaysRepo holidaysRepo;

    public boolean checkHoliday(LocalDate localDate) {
        if (!holidaysRepo.existsByDate(localDate)) {
            log.info("No holiday in that day");
            return false;
        }
        log.info("There is holiday in that day");
        return true;
    }

}
