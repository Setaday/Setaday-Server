package com.meet.command.utils;

import java.io.Serializable;
import lombok.Data;

@Data
public class DateData implements Serializable {
    private String month;
    private String date;
    private String day;
}
