package com.perfatech.quickquote.control;

import com.perfatech.quickquote.QuickQuoteFx;
import com.perfatech.quickquote.domain.QqModel;
import com.perfatech.quickquote.domain.Unit;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.LocalDate.now;


@Component
@FxmlView
public class TabPane
{
    private Stage stage;

    private QqModel model;
    private static final Logger log = LoggerFactory.getLogger(TabPane.class);

    @Autowired
    public TabPane(QqModel model)
    {
        this.model = model;
        model.initialize();
    }

    @FXML
    public void initialize()
    {
        this.stage = new Stage();
        stage.setScene(new Scene(tabAreaAnchorPane));

        unitComboBox.getItems().addAll(model.getUnits());
        unitComboBox.getSelectionModel().selectFirst();

        // rental unit combo box selection listener, lambda style
        unitComboBox.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    log.trace("--> unitComboBox change({})", newValue.getId());
                    model.setSelectedUnit(newValue);
//                cleaningFeeField.setText(formatAsCurrency(newValue.getCleaningFee()));
//                rentalUnitTable.getSelectionModel().select(newValue);
//                updatePropertyDetails(newValue);
//                refreshRateTable();
//                handleRateChange();
                }
            });

    }

    public void show()
    {
        stage.show();
    }

    @FXML
    private AnchorPane tabAreaAnchorPane;

    @FXML
    private ComboBox<Unit> unitComboBox = new ComboBox<>();



//    @FXML
//    private TabPane mainTabPane;
//    @FXML
//    private AnchorPane tabAreaAnchorPane;
//    @FXML
//    private VBox rentalUnitPickerArea;
//    @FXML
//    private VBox quoteVBox;

//    // property tab -----------------------------------------
//    @FXML
//    private Tab rentalUnitTab;
//    // unit details table
//    @FXML
//    private TableView<Unit> rentalUnitTable;
//    @FXML
//    private TableColumn<Unit, String> unitNameColumn;
//    @FXML
//    private TableColumn<Unit, BigDecimal> taxRateColumn;
//    @FXML
//    private TableColumn<Unit, BigDecimal> cleaningFeeColumn;
    
//    // unit details
//    @FXML
//    private Label unitNameLabel;
//    @FXML
//    private Label taxRateLabel;
//    @FXML
//    private Label cleaningFeeLabel;
//    @FXML
//    private Label vrboIdLabel;

//    @FXML
//    private Button newUnitButton;
//    @FXML
//    private Button editUnitButton;
//    @FXML
//    private Button deleteUnitButton;

//    // rate  setup tab -----------------------------------------
//    @FXML
//    private Tab rateTab;
//    @FXML
//    private TableView<Rate> rateTable;
//    @FXML
//    private TableColumn<Rate, String> rateNameColumn;
//    @FXML
//    private TableColumn<Rate, LocalDate> beginDateColumn;
//    @FXML
//    private TableColumn<Rate, LocalDate> endDateColumn;
//    @FXML
//    private TableColumn<Rate, Integer> minStayColumn;
//    @FXML
//    private TableColumn<Rate, BigDecimal> priceColumn;

//    @FXML
//    private Button newRateButton;
//    @FXML
//    private Button editRateButton;
//    @FXML
//    private Button deleteRateButton;

//    // quote tab -----------------------------------------
//    @FXML
//    private DatePicker checkInDateField;
//    @FXML
//    private DatePicker checkOutDateField;
//    @FXML
//    private CheckBox freeNightCb;
//    @FXML
//    private CheckBox discountCb;
//    @FXML
//    private BigDecimalField discountPercentField;
//    @FXML
//    private CheckBox enforceMinCb;
//    @FXML
//    private CheckBox cleaningFeeCb;
//    @FXML
//    private BigDecimalField cleaningFeeField;
//    @FXML
//    private TextArea quoteDetailsText;
    
    // status line ---------------------------------------    
    @FXML
    private Label statusMessageLabel;

    // ---------------------------------------------------
    private QuickQuoteFx mainApp;  // ref to main app
    //private static QqModel model;

	private boolean isOriginalCheckInDate = true;
	private boolean isOriginalCheckOutDate = true;
	private boolean cleaningFeeInitalSetup = true;

//    @FXML
//    private void initialize() {
        // rental unit table
//        unitNameColumn.setCellValueFactory(
//            new PropertyValueFactory<>("name"));
        // format tax rate to percent
//        taxRateColumn.setCellValueFactory(
//            new PropertyValueFactory<>("taxRate"));
//        taxRateColumn.setCellFactory(
//            (TableColumn<AbstractEntity, BigDecimal> param) -> new UiUtil.FormatPercentCell());
        // format cleaning fee as currency
//        cleaningFeeColumn.setCellValueFactory(
//            new PropertyValueFactory<>("cleaningFee"));
//        cleaningFeeColumn.setCellFactory(
//            (TableColumn<AbstractEntity, BigDecimal> param) -> new UiUtil.FormatPriceCell());
        // clear property details
//        clearUnitDetails();
        // rental unit table selection listener
//        rentalUnitTable.getSelectionModel().selectedItemProperty().addListener(
//            (observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                    if (log.isTraceEnabled()) log.trace("--> rentalUnitTable change(" + newValue.getId() + ")");
//                    rentalUnitComboBox.getSelectionModel().select(newValue);
//            }
//        });

        // rental unit combo box selection listener, lambda style
//        rentalUnitComboBox.getSelectionModel().selectedItemProperty().addListener(
//            (observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                log.trace("--> uUnitComboBox change({})", newValue.getId());
//                model.setSelectedUnit(newValue);
//                cleaningFeeField.setText(formatAsCurrency(newValue.getCleaningFee()));
//                rentalUnitTable.getSelectionModel().select(newValue);
//                updatePropertyDetails(newValue);
//                refreshRateTable();
//                handleRateChange();
//            }
//        });
        
        // rates table
//        rateNameColumn.setCellValueFactory(
//            new PropertyValueFactory<>("name"));
//
//        beginDateColumn.setCellValueFactory(
//            new PropertyValueFactory<>("beginDate"));
//        beginDateColumn.setCellFactory(
//            (TableColumn<AbstractEntity, LocalDate> param) -> new UiUtil.FormatLocalDateCell());
//
//        endDateColumn.setCellValueFactory(
//            new PropertyValueFactory<>("endDate"));
//        endDateColumn.setCellFactory(
//            (TableColumn<AbstractEntity, LocalDate> param) -> new UiUtil.FormatLocalDateCell());
//
//        minStayColumn.setCellValueFactory(
//            new PropertyValueFactory<>("minimumStay"));
//        minStayColumn.setCellFactory(
//        	(TableColumn<AbstractEntity, Integer> param) -> new UiUtil.FormatIntegerCell());
        
        // format the price column currency
//        priceColumn.setCellValueFactory(
//            new PropertyValueFactory<>("price"));
//        priceColumn.setCellFactory(
//            (TableColumn<AbstractEntity, BigDecimal> param) -> new UiUtil.FormatPriceCell());
        
        // rate table selection listener
//        rateTable.getSelectionModel().selectedItemProperty().addListener(
//        	(observable, oldValue, newValue) -> updateRateButtons(newValue));
    	
        LocalDate now = now();
        LocalDate checkInLd = now.plus(30, ChronoUnit.DAYS);
//        checkInDateField.setValue(checkInLd);
//        checkInDateField.setOnAction(event -> {
//			if (log.isTraceEnabled()) log.trace("checkInDateField change");
//            if (isOriginalCheckInDate && isOriginalCheckOutDate) {
//                log.trace("updating checkOut date");
//                LocalDate ciDate = checkInDateField.getValue();
//                LocalDate coDate = ciDate.plus(5, ChronoUnit.DAYS);
//                checkOutDateField.setValue(coDate);
//                isOriginalCheckInDate = false;
//            }
//			handleRateChange();
//        });
        
        LocalDate checkOutLd = now.plus(35, ChronoUnit.DAYS);
//        checkOutDateField.setValue(checkOutLd);
//        checkOutDateField.setOnAction(event -> {
//			if (log.isTraceEnabled()) log.trace("checkOutDateField change");
//			isOriginalCheckOutDate = false;
//			handleRateChange();
//        });
        
//        freeNightCb.setOnAction(event -> {
//        	if (log.isTraceEnabled()) log.trace("freeNightCb change");
//        	handleRateChange();
//        });

//        discountCb.setOnAction(event -> {
//        	if (log.isTraceEnabled()) log.trace("discountCb change");
//        	handleRateChange();
//        });
       
//        discountPercentField.setNumber(BigDecimal.ZERO);
//        discountPercentField.setFormat(new DecimalFormat(BigDecimalUtil.PERCENT_FORMAT));
//        discountPercentField.setMinValue(BigDecimal.ZERO);
//        discountPercentField.setMaxValue(BigDecimal.ONE);
//        discountPercentField.setStepwidth(valueOf(0.05));
//        discountPercentField.setText(formatAsDecimalPercent(
//           	BigDecimalUtil.BIGDECIMAL_10_PERCENT));
//        discountPercentField.numberProperty().addListener((observable, oldValue, newValue) -> {
//			if (log.isTraceEnabled()) log.trace("discountPercentField change");
//			handleRateChange();
//        });

//        enforceMinCb.setSelected(true);
//        enforceMinCb.setOnAction(event -> {
//        	if (log.isTraceEnabled()) log.trace("enforceMinCb change");
//        	handleRateChange();
//        });

//        cleaningFeeCb.setOnAction(event -> {
//        	if (log.isTraceEnabled()) log.trace("cleaningFeeCb change");
//        	handleRateChange();
//        });

//        cleaningFeeField.setNumber(BigDecimal.ZERO);
//        cleaningFeeField.setFormat(getCurrencyInstance(getDefault()));
//        cleaningFeeField.setMinValue(BigDecimal.ZERO);
//        cleaningFeeField.setStepwidth(new BigDecimal(5));
//        cleaningFeeField.numberProperty().addListener((observable, oldValue, newValue) -> {
//			if (log.isTraceEnabled()) log.trace("cleaningFeeField change");
//			if (cleaningFeeInitalSetup)
//				cleaningFeeInitalSetup = false;
//			else
//				handleRateChange();
//        });
//    }	// end of initialize()
    
    
    
    public void setReferences(QuickQuoteFx qqApp, QqModel model) {
        mainApp = qqApp;    // parent reference
//        setModel(model);
        
        // add the same list to the combo box at top and select the first unit
        unitComboBox.getItems().addAll(model.getUnits());
        unitComboBox.getSelectionModel().selectFirst();

//        if (model.getUnits().size() < 2) {
//        	hidePropertyCombo();
//        }
//
//        // add the observable list of rental unit data to the table, and set the selection
//        rentalUnitTable.setItems(model.getUnits());
//        rentalUnitTable.getSelectionModel().select(model.getSelectedUnit());
//
//        rateTable.setItems(model.getRates());
//
//        cleaningFeeField.setText(formatAsCurrency(
//            model.getSelectedUnit().getCleaningFee()));
//
//        handleRateChange();
    }
   
//    public static void setModel(QqModel model) {
//        TabPaneController.model = model;
//    }

    
    // =========================================================================
    // ---------------------------- unit tab -----------------------------------
   
//    private void updatePropertyDetails(Unit unit) {
//    	if (log.isTraceEnabled()) log.trace("--> updatePropertyDetails(" + unit.getId() + ")");
//        if (null == unit) {
//            clearUnitDetails();
//            editUnitButton.setDisable(true);
//           	deleteUnitButton.setDisable(true);
//        }
//        else {
//            model.setSelectedUnit(unit);
//
//            unitNameLabel.setText(unit.getName());
//            unitNameLabel.setStyle("-fx-font-weight: bold;");
//
//            taxRateLabel.setText(formatAsDecimalPercent(unit.getTaxRate()));
//            taxRateLabel.setAlignment(Pos.CENTER_RIGHT);
//            taxRateLabel.setStyle("-fx-font-weight: bold;");
//
//            cleaningFeeLabel.setText(formatAsCurrency(unit.getCleaningFee()));
//            cleaningFeeLabel.setStyle("-fx-font-weight: bold;");
//
//            vrboIdLabel.setText(unit.getVrboPropId());
//            vrboIdLabel.setStyle("-fx-font-weight: bold;");
//
//            editUnitButton.setDisable(false);
//            if (model.getUnits().size() == 1) {
//            	deleteUnitButton.setDisable(true);
//            }
//            else {
//            	deleteUnitButton.setDisable(false);
//            }
//        }
//    }

//    private void clearUnitDetails() {
//        unitNameLabel.setText("");
//        taxRateLabel.setText("");
//        cleaningFeeLabel.setText("");
//        vrboIdLabel.setText("");
//
//    }

//    @FXML
//    private void handleNewUnit() {
//        Unit newUnit = new Unit();
//        boolean okClicked = mainApp.showUnitEditDialog(newUnit);
//        if (okClicked) {  // persist the new unit and add it to the unit list
//            model.addUnit(newUnit);
//            if (getInstance().hasException()) {
//            	UiUtil.showErrorDialog("Database Error Saving New Property!", model.getNextException());
////            	create().owner(mainApp.getPrimaryStage()).title("Error")
////                	.message("Database Error Saving New Property!")
////                	.showException(model.getNextException());
//            }
//            else {  // update combo box with new unit & select it
//                rentalUnitComboBox.getItems().add(newUnit);
//                rentalUnitComboBox.getSelectionModel().select(model.getUnits().size() - 1);
//                // update details
//                updatePropertyDetails(newUnit);
//                rentalUnitComboBox.getSelectionModel().select(newUnit);
//                cleaningFeeField.setText(formatAsCurrency(
//                	newUnit.getCleaningFee()));
//                handleRateChange();
//                if (model.getUnits().size() > 1) {
//                	showPropertyCombo();
//                }
//            }
//        }
//    }

//    @FXML
//    private void handleEditUnit() {
//        Unit selectedUnit = rentalUnitTable.getSelectionModel().getSelectedItem();
//        if (selectedUnit != null) {
//            boolean okClicked = mainApp.showUnitEditDialog(selectedUnit);
//            if (okClicked) {
//                model.updateUnit(selectedUnit);
//                refreshUnitTable();
//
//                rentalUnitComboBox.getItems().removeAll(rentalUnitComboBox.getItems());
//                rentalUnitComboBox.getItems().addAll(model.getUnits());
//                rentalUnitComboBox.getSelectionModel().select(selectedUnit);
//
//                cleaningFeeField.setText(formatAsCurrency(
//                	selectedUnit.getCleaningFee()));
//            }
//        }
//        else {   // Nothing selected
//        	UiUtil.showWarningDialog("Please select a Property from the table",
//        		"No Property Selected, please select a Property to continue");
////            create()
////            	.owner(mainApp.getPrimaryStage())
////            	.title("Please select a Property from the table")
////            	.message("No Property Selected, please select a Property to continue")
////            	.showWarning();
//        }
//    }

//    @FXML
//    private void handleDeleteUnit() {
//        int selectedIndex = rentalUnitTable.getSelectionModel().getSelectedIndex();
//        if (selectedIndex >= 0) {
//            Unit selectedUnit = rentalUnitTable.getSelectionModel().getSelectedItem();
//            model.deleteUnit(selectedUnit);
//            rentalUnitComboBox.getItems().remove(selectedUnit);
//            if (rentalUnitComboBox.getItems().size() > 0) {
//            	rentalUnitComboBox.getSelectionModel().selectFirst();
//            }
//            if (model.getUnits().size() < 2) {
//            	hidePropertyCombo();
//            }
//        }
//        else {
//        	UiUtil.showWarningDialog("Please select a Property from the table",
//           		"No Property Selected, please select a Property to continue");
//        }
//    }

//    private void refreshUnitTable() {
//    	if (log.isTraceEnabled()) log.trace("--> refreshUnitTable(" + model.getSelectedUnit().getId() + ")");
//        int selectedIndex = rentalUnitTable.getSelectionModel().getSelectedIndex();
//        rentalUnitTable.setItems(null);
//        rentalUnitTable.layout();
//        rentalUnitTable.setItems(model.getUnits());
//        // Must set the selected index again (see http://javafx-jira.kenai.com/browse/RT-26291)
//        rentalUnitTable.getSelectionModel().select(selectedIndex);
//    }

//    private void hidePropertyCombo() {
//    	setTopAnchor(mainTabPane, 0.0);
//    	rentalUnitPickerArea.setVisible(false);
//    }
    
//    private void showPropertyCombo() {
//    	setTopAnchor(mainTabPane, 50.0);
//    	rentalUnitPickerArea.setVisible(true);
//    }
    
    // =========================================================================
    // ---------------------------- rate tab -----------------------------------
//    @FXML
//    private void handleNewRate() {
//        Rate newRate = new Rate();
//
//        LocalDate nextBeginDate = getInstance().getNextRateBeginDate();
//        newRate.setBeginDate(nextBeginDate);
//
//        LocalDate nextEndDate = nextBeginDate.plus(30, ChronoUnit.DAYS);
//        newRate.setEndDate(nextEndDate);
//
//        boolean okClicked = mainApp.showRateEditDialog(newRate);
//        if (okClicked) {  // persist the new rate and add it to the rates table
//            model.getSelectedUnit().addRate(newRate);
//            model.addRate(newRate);
//            model.updateUnit(model.getSelectedUnit());
//            if (getInstance().hasException()) {
//            	UiUtil.showErrorDialog("Database Error Saving New Rate!", model.getNextException());
////            	create()
////            		.owner(mainApp.getPrimaryStage())
////            		.title("Error")
////            		.message("Database Error Saving New Rate!")
////            		.showException(model.getNextException());
//            }
//            else {  // update buttons & table, select new item
//            	updateRateButtons(newRate);
//            	refreshRateTable();
//            	log.debug("new rate: " + newRate);
//            }
//        }
//    }
    
//    private void updateRateButtons(Rate rate) {
//        if (null == rate) {
//            editRateButton.setDisable(true);
//            deleteRateButton.setDisable(true);
//        }
//        else {
//            editRateButton.setDisable(false);
//            deleteRateButton.setDisable(false);
//        }
//    }

//    @FXML
//    private void handleEditRate() {
//        Rate selectedRate = rateTable.getSelectionModel().getSelectedItem();
//        if (selectedRate != null) {
//            boolean okClicked = mainApp.showRateEditDialog(selectedRate);
//            if (okClicked) {
//            	model.updateRate(selectedRate);
//            	refreshRateTable();
//            	handleRateChange();
//            	if (log.isDebugEnabled()) log.debug("updated rate: " + selectedRate);
//            }
//        }
//        else {   // Nothing selected
//        	UiUtil.showWarningDialog("Please select a Property from the table",
//             	"No Property Selected, please select a Property to continue");
//        }
//    }
    
//    @FXML
//    private void handleDeleteRate() {
//        int selectedIndex = rateTable.getSelectionModel().getSelectedIndex();
//        if (selectedIndex >= 0) {
//        	Rate selectedRate = rateTable.getSelectionModel().getSelectedItem();
//            model.deleteRate(selectedRate);
//            model.setSelectedUnit(model.getSelectedUnit());
//        }
//        else {
//        	UiUtil.showWarningDialog("Please select a Property from the table",
//               	"No Property Selected, please select a Property to continue");
//        }
//    }
    
//    private void refreshRateTable() {
//    	if (log.isTraceEnabled()) log.trace("--> refreshRateTable(" + model.getSelectedUnit().getId() + ")");
//
//        int selectedIndex = rateTable.getSelectionModel().getSelectedIndex();
//        rateTable.setItems(null);
//        rateTable.layout();
//        rateTable.setItems(model.getRates());
//        // Must set the selected index again (see http://javafx-jira.kenai.com/browse/RT-26291)
//        rateTable.getSelectionModel().select(selectedIndex);
//    }

    
    // ===================================================================
    // ---------------------------- quote tab -----------------------------
    
//    private void handleRateChange() {
//    	if (log.isTraceEnabled()) log.trace("--> handleRateChange(" + model.getSelectedUnit().getId() + ")");
//    	LocalDate inLd = checkInDateField.getValue();
//    	LocalDate outLd = checkOutDateField.getValue();
//
//    	if (outLd.isBefore(inLd) || outLd.equals(inLd)) {
//        	UiUtil.showWarningDialog("Date Range Error",
//        		"The Check-In / Check-Out date range is invalid.\n" +
//                "Please correct the Check-In and Check-Out dates");
//            return;
//    	}
//
//    	showRate(inLd, outLd);
//    }
    
    /**
     * return the rate calculation by finding the rate for the date range requested
     */
//    private void showRate(LocalDate inDate, LocalDate checkOutDate) {
//    	if (log.isTraceEnabled()) log.trace("--> showRate(" + model.getSelectedUnit().getId() + ")");
//        HashMap<BigDecimal, Integer> priceMap = new HashMap<>();
//        LocalDate forDate = inDate;
//        //LocalDate checkOutDate = outDate;
//        int minNights = 0;
//        boolean hasBookedDates = false;
//        boolean vrboCalendarNotAvailable = false;
//
//        while (forDate.isBefore(checkOutDate)) {
//        	Rate rate = model.getRate(forDate);
//
//        	Availability avail = model.getAvailability(forDate);
//        	if ( !(avail.equals(Availability.OPEN) ||
//                   avail.equals(Availability.CHECK_OUT) ||
//        		   avail.equals(Availability.CAL_NOT_AVAILABLE))) {
//        		hasBookedDates = true;
//        	}
//
//        	if (avail.equals(Availability.CAL_NOT_AVAILABLE)) {
//         		vrboCalendarNotAvailable = true;
//         	}
//
//            if (log.isTraceEnabled() && model != null && rate != null) {
//            	log.trace("unitId " + model.getSelectedUnit().getId() + " on " +
//            		forDate + " @ " + rate.getPrice() + " is " + avail);
//            }
//
//            assert model != null;
//            if (model.hasException()) {
//        		model.clearAllExceptions();
//        		String msg = "Quote Error: Check that you have Rates and "
//        			+ "that the check-in and out dates to not overlap or have gaps!\n";
//                quoteDetailsText.setText(msg);
//                statusMessageLabel.setText(msg);
//                statusMessageLabel.setStyle("-fx-text-fill: red;");
//                return;
//        	}
//
//        	if (rate != null) {
//	        	if (minNights == 0) {
//	        		minNights = rate.getMinimumStay();
//	        	}
//
//	        	BigDecimal price = rate.getPrice();
//	        	if (priceMap.containsKey(price)) {
//	        		Integer daysAtCount = priceMap.get(price);
//	        		Integer newCount = daysAtCount + 1;
//	        		priceMap.put(price, newCount);
//	        	}
//	        	else {
//	        		priceMap.put(price, 1);	// first day at this price
//	        	}
//        	}
//        	else { // no rate found for date
//                DateTimeFormatter dtf = ofPattern(DateUtil.LOCAL_DATE_FORMAT);
//                String message = "Rates were not found for the Check-In / Check-Out dates provided.\n"
//	            	+ "The first missing date was " + dtf.format(forDate)
//	            	+ ".\nPlease update the Rates Table to include this date range.";
//            	UiUtil.showWarningDialog("Rates not found for dates provided", message);
//        	}
//
//        	forDate = forDate.plusDays(1);
//        }
//
//        BigDecimal total = BigDecimal.ZERO;
//        StringBuilder quoteDetails = new StringBuilder();
//        BigDecimal lastNightsRate = null;
//
//        quoteDetails.append("Check-In: ").append(format(inDate)).append(", ");
//        quoteDetails.append("Check-Out: ").append(format(checkOutDate)).append("\n");
//
//        Currency currency = getInstance(getDefault());
//        String currencySymbol = currency.getSymbol();
//        int priceLevels = priceMap.size();
//
//        for (Map.Entry<BigDecimal, Integer> entry : priceMap.entrySet()) {
//        	BigDecimal rate = entry.getKey();
//            Integer days = priceMap.get(rate);
//            priceLevels--;
//
//            if (days == 1) {
//                quoteDetails.append(days).append(" night at ").append(currencySymbol).append(rate).append(" ");
//            }
//            else {
//                quoteDetails.append(days).append(" nights at ").append(currencySymbol).append(rate);
//            }
//
//            if (priceLevels > 0) {
//                quoteDetails.append(",\n");
//            }
//            else {
//                quoteDetails.append(" ");
//            }
//
//            BigDecimal subTotal = rate.multiply(new BigDecimal(days));
//            total = total.add(subTotal);
//            lastNightsRate = rate;
//        }
//
//        quoteDetails.append("= ").append(currencySymbol).append(total).append("\n");
//
//        boolean hasFreeNight = freeNightCb.isSelected();
//        if (hasFreeNight && lastNightsRate != null) {
//            quoteDetails.append("   - ").append(lastNightsRate).append(" FREE night\n");
//            total = total.subtract(lastNightsRate);
//        }
//
//        boolean isDiscounted = discountCb.isSelected();
//        if (isDiscounted) {
//            BigDecimal discount = discountPercentField.getNumber();
//            BigDecimal discountAmount = total.multiply(discount);
//            discountAmount = discountAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
//            quoteDetails.append("   - ").append(discountAmount).append("  ")
//            	.append(formatAsPercent(discount)).append(" discount \n");
//            total = total.subtract(discountAmount);
//        }
//
//        BigDecimal taxAmount = total.multiply(model.getSelectedUnit().getTaxRate());
//        taxAmount = taxAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
//        total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
//
//        BigDecimal taxRate = model.getSelectedUnit().getTaxRate();
//        DecimalFormat df = new DecimalFormat(BigDecimalUtil.DECIMAL_PERCENT_FORMAT);
//        quoteDetails.append("   + ").append(taxAmount).append(" tax (")
//        	.append(df.format(taxRate)).append(")\n");
//
//        boolean hasCleaningFee = cleaningFeeCb.isSelected();
//        boolean isEnforceMinStay = enforceMinCb.isSelected();
//        if (hasCleaningFee || (getLengthOfStay() < minNights && isEnforceMinStay)) {
//            BigDecimal fee = cleaningFeeField.getNumber();
//            fee = fee.setScale(2, BigDecimal.ROUND_HALF_UP);
//            quoteDetails.append("   + ").append(fee).append(" cleaning fee\n");
//            total = total.add(fee);
//        }
//
//        quoteDetails.append("Total: $").append(total.add(taxAmount)).append("\n");
//        if (vrboCalendarNotAvailable) {
//        	quoteDetails.append("\nNote: Please confirm property availability:"
//        		+ " I couldn't check the Availability Calendar").append("\n");
//        }
//
//        Clipboard clipboard = getSystemClipboard();
//        ClipboardContent content = new ClipboardContent();
//        content.putString(quoteDetails.toString());
//        clipboard.setContent(content);
//
//        // populate status panel
//        if (hasBookedDates) {
//            statusMessageLabel.setText("WARNING: The dates above overlap an already booked stay(check your calendar)!");
//            statusMessageLabel.setStyle("-fx-text-fill: red;");
//        }
//        else if (getLengthOfStay() < minNights) {
//            if (isEnforceMinStay) {
//                statusMessageLabel.setText("Stay is Below Minimum: Cleaning Fee added");
//                statusMessageLabel.setStyle("-fx-text-fill: black;");
//            }
//            else {
//                statusMessageLabel.setText("WARNING: Stay is Below Minimum Required");
//                statusMessageLabel.setStyle("-fx-text-fill: red;");
//            }
//        }
//        else {
//            statusMessageLabel.setText("The Quote details have been copied to the clipboard!");
//            statusMessageLabel.setStyle("-fx-text-fill: black;");
//        }
//
//        //log.debug(rateDetails);
//        quoteDetailsText.setText(quoteDetails.toString());
//    }
    
    /**
     * calculate the length of stay in days
     */
//    private int getLengthOfStay() {
//    	LocalDate checkInLd = checkInDateField.getValue();
//        LocalDate checkOutLd = checkOutDateField.getValue();
//        return checkInLd.until(checkOutLd).getDays();
//    }

}