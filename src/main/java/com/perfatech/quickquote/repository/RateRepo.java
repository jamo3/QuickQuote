package com.perfatech.quickquote.repository;

import com.perfatech.quickquote.domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RateRepo extends JpaRepository<Rate, Long> {

    List<Rate> findByUnitIdOrderByBeginDate(Long unitId);

    Optional<Rate> findByBeginDateBeforeAndEndDateAfterAndUnitId(
        LocalDate date1, LocalDate date2, Long unitId);
}
