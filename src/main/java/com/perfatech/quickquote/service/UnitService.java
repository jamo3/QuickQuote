package com.perfatech.quickquote.service;

import com.perfatech.quickquote.domain.Unit;
import com.perfatech.quickquote.repository.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService
{
    private final UnitRepo unitRepo;

    @Autowired
    public UnitService(UnitRepo unitRepo)
    {
        this.unitRepo = unitRepo;
    }


    public List<Unit> findAllUnits()
    {
        return unitRepo.findAll();
    }

    public Unit findUnit(long id)
    {
        Optional<Unit> optiUnit = unitRepo.findById(id);
        return optiUnit.orElse(null);
    }
}
