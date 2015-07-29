package org.openmrs.module.emrapi.encounter;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DateMapperTest {

    @Test
    public void shouldConvertUTCformatToDate() throws Exception {
        String utcDateString = "2015-07-30T18:30:00.000Z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));

        Date actualDate = new DateMapper().convertUTCToDate(utcDateString);

        assertNotNull(actualDate);
        assertEquals("31/07/2015", simpleDateFormat.format(actualDate));

    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionForWrongUTCformat() throws Exception {
        String utcDateString = "2015-07-30T11:00:00.000";
        Date actualDate = new DateMapper().convertUTCToDate(utcDateString);
    }
}