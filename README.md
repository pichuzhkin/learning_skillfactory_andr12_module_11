# Что нужно было сделать
Задание по [11 модулю (Collections, Generics)](https://lms.skillfactory.ru/courses/course-v1:SkillFactory+ANDROID-NEW+2020/course/#block-v1:SkillFactory+ANDROID-NEW+2020+type@sequential+block@0050e21d69f945108d473d52bd7dc9ad)
# Что сделано
## Задача
* Разработать классы "Квартира" и "Дом".
  * Дом определяется количеством этажей, количеством подъездов и количеством квартир в подъезде на этаже (для упрощения считать этажи одинаковыми, первые этажи жилыми)
  * В Квартире может проживать неопределенное количество-жителей-строк или никто.
* Реализовать методы:
  * Первичного заселения квартиры по номеру квартиры ("квартирой" или именем единственного жителя)
  * Доселения в квартиру  
  * Получения квартиры-соседа сверху и снизу
  * toString с полной информацией о доме

## Предлагаемое решение
Разработаны классы [Дом](src/House.java) и [Квартира](src/Apartment.java), также демонстрационный класс [Main](src/Main.java)

В Main дом "заселяется", демонстрируются жители двух квартир, а также всего дома
