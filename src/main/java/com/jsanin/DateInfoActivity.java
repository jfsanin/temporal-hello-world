package com.jsanin;

import java.time.LocalDate;

public class DateInfoActivity implements DateInfoActivityI {

    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }
}
