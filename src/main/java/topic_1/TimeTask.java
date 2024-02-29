package topic_1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTask {
    //    Вывести фамилию разработчика, дату и время получения задания, а также
//дату и время сдачи задания.
    public static void main(String[] args) throws InterruptedException {

            String devName = "Eva Aiwass";
            LocalDateTime startDate = LocalDateTime.now();

            Thread.sleep(10000);

            LocalDateTime endDate = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh.mm.ss");

            System.out.println(devName + ". Дата получения задания: " + startDate.format(dateTimeFormatter) +
                    ". Дата сдачи задания: " + endDate.format(dateTimeFormatter));


    }
}
