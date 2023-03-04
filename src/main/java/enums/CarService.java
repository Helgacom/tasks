package enums;

public class CarService {
    public static void main(String[] args) {
        /*создание переменных из перечисления*/
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Status Toyota: " + toyota);
        System.out.println("Status Volvo: " + volvo);

        Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);
        System.out.println("Заказ-наряд №" + order.getId() + " на автомобиль " + order.getModel()
                + ", статус ремонта: " + order.getStatus().getInfo());
        System.out.println(order);
        /*Методы enum.
Далее представлены некоторые полезные методы класса Enum.
- name() - возвращает имя константы (значения) в том же виде, в каком оно объявлено.
- ordinal() - возвращает порядковый номер константы (значения), по которому её экземпляр находится в перечислении
 (нумерация с нуля).
- values() - возвращает массив всех элементов перечисления.
Добавим вывод работы этих методов в метод main() класса CarService:
java
Status[] statuses = Status.values();
        for (Status s : statuses) {
            System.out.println("Название статуса: " + s.name()
            + ", Порядковый номер статуса: "
            + s.ordinal());
        }
        В следующей строке метод values() получает массив, содержащий список значений из класса Status:
        Status[] statuses = Status.values();
        - valueOf() - получает объект типа класса перечисления по его строковому представлению.
String accepted = "ACCEPTED";
Status status = Status.valueOf(accepted);
System.out.println(status);
В данном коде мы получаем объект типа Status из одноимённой строки.
Switch.
Также, так как значения enum не меняются, то при работе с ними можно использовать оператор switch.
Добавим в метод main():

        switch (status) {
            case ACCEPTED:
                System.out.println("Статус: Автомобиль принят на СТО");
                break;
            case IN_WORK:
                System.out.println("Статус: Автомобиль в работе");
                break;
            case WAITING:
                System.out.println("Статус: Автомобиль ожидает запчасти");
                break;
            case FINISHED:
                System.out.println("Статус: Все работы завершены");
                break;
            default:
*/
    }
}
