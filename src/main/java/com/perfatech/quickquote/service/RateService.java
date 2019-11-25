package com.perfatech.quickquote.service;

import com.perfatech.quickquote.domain.Rate;
import com.perfatech.quickquote.domain.Unit;
import com.perfatech.quickquote.repository.RateRepo;
import com.perfatech.quickquote.repository.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateService
{
    private final RateRepo rateRepo;

    @Autowired
    public RateService(RateRepo rateRepo)
    {
        this.rateRepo = rateRepo;
    }


    public List<Rate> findAllRates()
    {
        return rateRepo.findAll();
    }

    public Rate findRate(Long id)
    {
        Optional<Rate> optiRate = rateRepo.findById(id);
        return optiRate.orElse(null);
    }
}
