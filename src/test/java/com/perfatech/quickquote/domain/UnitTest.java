package com.perfatech.quickquote.domain;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class UnitTest
{
    @Test
    public void testConstructorAndGetters() {

        BigDecimal taxRate = new BigDecimal(123.456);
        BigDecimal cleaningFee = new BigDecimal(0.123);

        Unit unit = new Unit("testUnitName",taxRate, cleaningFee, "65432");
        assertThat(unit.getName(), is("testUnitName"));
        assertThat(unit.getTaxRate(), Matchers.comparesEqualTo(taxRate));
        assertThat(unit.getCleaningFee(), Matchers.comparesEqualTo(cleaningFee));
        assertThat(unit.getCalendarId(), is("65432"));
    }

}