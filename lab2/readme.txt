код корявый и некрасивый, потому что пишу в блокноте

Контрольные вопросы:
1 Что такое DOM?
DOM (от англ. Document Object Model — «объектная модель документа») — это независящий от платформы и языка программный интерфейс, позволяющий программам и скриптам получить доступ к содержимому HTML-, XHTML- и XML-документов, а также изменять содержимое, структуру и оформление таких документов.

2 Какие объекты первого уровня находятся в объекте window?
document history navigation location frames[] event screen

3 Какие объекты первого уровня находятся в объекте document?
all[] anchors[] links[] forms[] scripts[] frames[] images[] styleSheets[] body

4 Как посмотреть и изменить CSS свойства элемента в отладчике?
f-12, выделить курсором элемент, в окне Styles можно просмотреть css свойтства

5 Как посмотреть и изменить код элемента в отладчике?
f-12, выделить курсором элемент, в окне elements можно взаимодействовать с локальной копией страницы

6 Как обратиться из JS к элементам DOM?
Использовать объекты первого уровня дом с точкой, например document.body

7 Как привязать обработчик события к элементу DOM?
В теге script через знак доллара обратится к классу элемента или к конкретному элементу дальше выбрать нужный event через точку, например ( $('.clickable-elements element').html('...');)

8 Какие (виды) массивов существуют в JavaScript? (Все)

9 Какие виды циклов существуют в JavaScript? for forin while dowhile

10 Как осуществляется неявное преобразование типов в JavaScript? Всего есть три преобразования:
Строковое преобразование.
Численное преобразование.
Преобразование к логическому значению.

11 Чем отличаются сравнения == и ===?Оператор == сравнивает на равенство, а вот === — на идентичность.

12 Какие элементы форм вы знаете? Для чего они предназначены?
form
text
radio
select
checkbox
input 
