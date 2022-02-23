package com.jsanin;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.time.LocalDate;

@ActivityInterface
public interface DateInfoActivityI {
    @ActivityMethod
    LocalDate getDate();
}
