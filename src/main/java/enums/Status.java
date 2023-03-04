package enums;

public enum Status {
    /*создадим перечисление статусов автомобиля в автосервисе, далее создадим в пакете
    классы CarService и Order */
    ACCEPTED("Принят"),
    IN_WORK("В работе"),
    WAITING("Ожидание"),
    FINISHED("Работы завершены");

    private String info;

    Status(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
    /*Перечисление может содержать поля, методы и конструкторы. Добавим в перечисление поле status,
    создадим конструктор, принимающий это поле, и геттер, чтобы получать значение поля status
    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }*/

/*Перечисление может объявляться отдельно, а может быть объявлено в другом классе
в виде внутреннего класса. Например, объявление перечисления Status в классе CarService выглядело бы так:
public class CarService {

    private enum Status {
        ACCEPTED,
        INWORK,
        WAITING,
        FINISHED
    }

    public static void main(String[] args) {
        System.out.println(Status.FINISHED);
    }
}
модификатор enum здесь private. Если enum вложен в другой класс, он может быть как public, так и private.
Если же enum не является внутренним классом, то он может иметь только модификатор public.
Перечисление (enum) наследуется от java.lang.Enum, поэтому он не может наследовать другие классы.
Перечисление может реализовывать интерфейсы
Каждое значение (константа) нашего перечисления - это объект анонимного класса.
Создав конструктор с полем info, мы сразу должны передать этот параметр в каждое значение нашего перечисления,
то есть ранее у нас был просто ACCEPTED, а стал
ACCEPTED("Принят")
Данная строка "под капотом" выглядит как:
public static final Status ACCEPTED = new Status("Принят") { };
Отсюда следует, что перечисление - это список неизменяемых готовых объектов, которыми можно пользоваться.
Так как каждое значение перечисления - это объект анонимного класса, то в нём можно объявлять свои методы:

public enum Status {
    ACCEPTED("Принят") {
        private String message = "Автомобиль принят на СТО";

        @Override
        public String getMessage() {
            return message;
        }

    },
    IN_WORK("В работе") {
        private String message = "Автомобиль в работе";

        @Override
        public String getMessage() {
            return message;
        }
    },
    WAITING("Ожидание") {
        private String message = "Автомобиль ожидает запчасти";

        @Override
        public String getMessage() {
            return message;
        }
    },
    FINISHED("Работы завершены") {
        private String message = "Все работы завершены";

        @Override
        public String getMessage() {
            return message;
        }
    };*/