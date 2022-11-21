package com.stackroute.streams;

import java.text.Format;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class DateTimeUtility {
    public List<String> getNextMonthWorkingDays(LocalDate today) {
        if(today.getDayOfMonth()!=1)
            today=today.minusDays(today.getDayOfMonth()-1);

        LocalDate notToday=today.plusMonths(1);
        List<String> workday=new ArrayList<>();
        while (notToday.getMonth().compareTo(today.plusMonths(1).getMonth())==0){
            if((notToday.getDayOfWeek().compareTo(DayOfWeek.SATURDAY)<0))
                workday.add(notToday.toString());
            notToday=notToday.plusDays(1);
        }
        return workday;
    }

    public List<String> getScheduledBusDepartureTimings(String startTime, Duration frequency) {
        List<String> busDeparture = new ArrayList<>();
        LocalTime localTime = LocalTime.parse(startTime);
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        if(frequency.toHours()>=24)
            return busDeparture;

        while(localTime.isBefore(LocalTime.MAX)&&!localTime.isBefore(LocalTime.parse(startTime))){
            if(today.compareTo(tomorrow)>=0){
                break;
            }
            busDeparture.add(localTime.format(format2));
            localTime=localTime.plus(frequency);
        }
        System.out.println(busDeparture);
        return busDeparture;
    }
}