package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Insurance {
    //Задача 1. Класс Insurance
    //
    //Класс должен проверять валидность страховок, например для выезжающих за рубеж.
    // Каждая страховка имеет дату-время начала, и продолжительность.
    //
    //
    //1.1  Реализовать локальный public static enum FormatStyle {SHORT, LONG, FULL} - стиль формата даты-времени
    public static enum FormatStyle {
        SHORT, //'2011-12-03'
        LONG, //'2011-12-03T10:15:30'
        FULL //'2011-12-03T10:15:30+01:00[Europe/Paris]'
    }

    //1.2. Реализовать приватные свойства класса:
    //private ZonedDateTime start - дата-время начала действия страховки.
    //private Duration duration - продолжительность действия.
    private ZonedDateTime start;
    private Duration duration;

    //1.2 Реализовать конструкторы:
    //
    //public Insurance(ZonedDateTime start) - установить дату-время начала действия страховки.
    //
    //public Insurance(String strStart, FormatStyle style) - установить дату-время начала действия страховки
    //SHORT соответствует ISO_LOCAL_DATE
    //LONG  - ISO_LOCAL_DATE_TIME
    //FULL - ISO_ZONED_DATE_TIME
    //Для вариантов, когда не задан явно часовой пояс использовать таковой по умолчанию.

    public Insurance(ZonedDateTime start){
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style){
        DateTimeFormatter dtf;
        ZoneId zoneId;
        switch (style){
            case SHORT -> dtf = DateTimeFormatter.ISO_LOCAL_DATE;
            case LONG -> dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            case FULL -> dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
            default -> throw new IllegalStateException("Unexpected value: " + style);
        }
        TemporalAccessor ta = dtf.parse(strStart);
        if (style == FormatStyle.FULL)
            zoneId= ZoneId.from(ta);
        else
            zoneId = ZoneId.systemDefault();
        start = Instant.from(ta).atZone(zoneId);
    }

    //1.3 Реализовать методы, устанавливающие продолжительность действия страховки:
    //
    //public void setDuration(Duration duration) - установить продолжительность действия страховки.
    //
    //public void setDuration(ZonedDateTime expiration) - установить продолжительность действия страховки, задав дату-время окончания.
    //
    //public void setDuration(int months, int days, int hours) - установить продолжительность действия страховки, задав целыми числами количество месяцев, дней и часов.
    //
    //public void setDuration(String strDuration, FormatStyle style) - установить продолжительность действия страховки
    //SHORT - целое число миллисекунд (тип long)
    //LONG  - ISO_LOCAL_DATE_TIME - как период, например “0000-06-03T10:00:00” означает, что продолжительность действия страховки 0 лет, 6 месяцев, 3 дня 10 часов.
    //FULL - стандартный формат Duration, который получается через toString()

    public void setDuration(Duration duration){ // todo установить продолжительность действия страховки

    }


    //1.4 Реализовать методы возврата информации:
    //
    //public boolean checkValid(ZonedDateTime dateTime) - проверить действительна ли страховка на указанную дату-время.
    // Если продолжительность не задана считать страховку бессрочной.
    //
    //public String toString() - вернуть строку
    // формата "Insurance issued on " + start + validStr, где validStr = " is valid",
    // если страховка действительна на данный момент и " is not valid", если она недействительна.


}
