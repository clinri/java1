package ru.progwards.clinri.T161;

import ru.progwards.clinri.T103.test103;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

public class Date161 {

    //Напишите метод, с сигнатурой ZonedDateTime parseZDT(String str),
    // который возвращает ZonedDateTime, парся строку вида "01.01.2020 16:27:14.444 +0300 Moscow Standard Time"
    ZonedDateTime parseZDT(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS Z zzzz",Locale.US);
        TemporalAccessor tc = formatter.parse(str);
        ZoneId zoneId = ZoneId.from(tc);
        ZonedDateTime zdt = Instant.from(tc).atZone(zoneId);
        return zdt;
    }


    public static void main(String[] args) {
        System.out.println(new Date(0));
        System.out.println(Long.MAX_VALUE);
        System.out.println(new Date(Long.MAX_VALUE));
        System.out.println(Long.MIN_VALUE);
        System.out.println(new Date(Long.MIN_VALUE));
        System.out.println(new Date().getTime());
        System.out.println(new Date());
        ZoneId zid = ZoneId.of("Europe/Moscow");
        System.out.println(zid.getDisplayName(TextStyle.FULL, Locale.getDefault()));
        System.out.println(zid.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        System.out.println(zid.getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(zid.getDisplayName(TextStyle.FULL, Locale.CHINA));

        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz y", Locale.US);

        System.out.println(format.format(new Date()));
        //Укажите формат для правильного вывода java.util.Date в виде "04.01.2020 15:58:37.346".
        // Формат укажите в двойных кавычках, как строка в Java - "aa bb"
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.y HH:mm:ss.S");
        //"dd.MM.yyyy HH:mm:ss.S"
        System.out.println(format1.format(new Date()));
        //Укажите формат для правильного вывода java.util.Date в виде "От'езд - суббота 04 января в 4PM".
        // Формат укажите в двойных кавычках, как строка в Java - "aa bb"
        SimpleDateFormat format2 = new SimpleDateFormat("'От''езд - 'EEEE dd MMMM' в 'Ha", new Locale("ru","RU"));
        //"'От''езд' - EEEE dd MMMM 'в' ha"
        System.out.println(format2.format(new Date()));

        //Укажите формат для правильного вывода java.time.Instant стандартного вида "2020-01-04T13:21:42.173042400Z".
        // Формат укажите в двойных кавычках, как строка в Java - "aa bb"
        ZonedDateTime  zdt = Instant.now().atZone(ZoneId.of("Europe/Moscow"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.n'Z' SSS Z zzzz", Locale.US);
        //"yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'"
        System.out.println(formatter.format(zdt));

        System.out.println("==");
        System.out.println(new Date161().parseZDT("01.01.2020 16:27:14.444 +0300 Moscow Standard Time"));
    }
}
