package com.perfatech.quickquote.domain;

import com.perfatech.quickquote.service.RateService;
import com.perfatech.quickquote.service.UnitService;
import com.perfatech.quickquote.util.QuoteFxException;
import javafx.collections.ObservableList;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static javafx.collections.FXCollections.observableArrayList;

@Service
public class QqModel
{
    private ObservableList<Unit> units;
    private Unit selectedUnit;
    private ObservableList<Rate> rates;
    private Map<LocalDate,Availability> availMap = null;
    private final Queue<QuoteFxException> exceptions = new LinkedList<>();
    private Window mainWindow;
    private static final Logger log = LoggerFactory.getLogger(QqModel.class);
    private UnitService unitService;
    private RateService rateService;

    @Autowired
    public QqModel(UnitService unitService, RateService rateService)
    {
        this.unitService = unitService;
        this.rateService = rateService;
    }


    public void initialize()
    {
        units = observableArrayList(unitService.findAllUnits());

        if (!units.isEmpty())
        {
            selectedUnit = units.get(0);
            // todo
            //rates = observableArrayList(findRatesForUnit(selectedRentalUnit);

            //todo rework availability cal?
//            availMap = HtmlUtil.getHomeAwayAvailability(selectedRentalUnit.getVrboPropId());
//            if (availMap.isEmpty()) {
//                availMap = null;
//            }
        }
        else
        {
            selectedUnit = null;
            rates = observableArrayList();
        }
    }

    public ObservableList<Unit> getUnits() {
        return units;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit)
    {
        if (log.isTraceEnabled()) log.trace("--> setSelectedRentalUnit(" + selectedUnit.getId() + ")");
        if (selectedUnit != this.selectedUnit)
        {
            this.selectedUnit = selectedUnit;
//            rates.clear();
//            if (selectedUnit != null) {
//                try {
//                    rates.addAll(rateDAO.findRatesForUnit(selectedRentalUnit));
//                }
//                catch (DAOException ex) {
//                    addException(ex);
//                }
//            }
        }
        else if (selectedUnit != null)
        {
//            availMap = HtmlUtil.getHomeAwayAvailability(selectedRentalUnit.getVrboPropId());
        }
    }


    public Window getMainWindow() {
        return mainWindow;
    }
    public void setMainWindow(Window mainWindow) {
        this.mainWindow = mainWindow;
    }
}
