package org.example.util_date;

import java.time.Instant;
import java.time.LocalDate;

public class Utils {
    public static java.sql.Date getSqlDate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }
}