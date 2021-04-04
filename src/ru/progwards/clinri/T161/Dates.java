package ru.progwards.clinri.T161;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SortedMap;

public class Dates {
    // 16.1 Напишите метод с сигнатурой Date createDate(),
    // который возвращает дату - 28 февраля 1986, 0 часов, 0 минут, 0 секунд, 0 миллисекунд
    Date createDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1986, 1, 28);
        return new Date(calendar.getTimeInMillis());
    }

    // 16.2 Создайте метод с сигнатурой Instant createInstant(), который возвращает Instant,
    // соответствующий 1 января 2020 года, 15 часов и одна наносекунда по Московскому времени
    Instant createInstant(){
        LocalTime localTime = LocalTime.of(15,0,0,1);
        System.out.println("время : " + localTime);
        LocalDate localDate = LocalDate.of(2020,1,1);
        System.out.println("дата : " + localDate);
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        System.out.println("дата и время : " + localDateTime);
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        System.out.println("ZoneID: " + zoneId);
        ZonedDateTime zdt1 = localDateTime.atZone(zoneId);
        System.out.println("ZonedDateTime: " + zdt1);
        System.out.println("мгновение: " + zdt1.toInstant());
        return zdt1.toInstant();
    }

    public static void main(String[] args) {
        System.out.println(new Dates().createDate());

        LocalDateTime ldt1= LocalDateTime.now();
        LocalDateTime ldt2= ldt1.plusDays(4);
        Duration duration = Duration.between(ldt1,ldt2);
        System.out.println(duration.toHours());

        LocalDateTime ldt3= LocalDateTime.of(2019, 05, 05, 22, 24);
        System.out.println(ldt3);

        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println(zid1.getRules().getOffset(Instant.now()));

        System.out.println(new Dates().createInstant());
    }

}
