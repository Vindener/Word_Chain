package org.word_chain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


class Main {

    private static ArrayList<String> cities = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        fillCities();

        System.out.println("Вітаю вас у грі \"Слова по українським містам\"!");
        System.out.println("Щоб вийти з гри напишіть \"вихід\" або \"exit\"");
        System.out.println("Введіть ваше перше слово:");

        gameLoop();
    }

    private static void gameLoop() {
        String lastComputerCity = null;
        char exception1 = 'ь';
        char exception2 = 'и';
        char exception3 = 'є';
        char exception4 = 'ц';

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("exit")||input.equals("вихід")) {
                System.out.println("Дякую за гру!");
                System.out.println("Тепер ви краще знаєте міста України!");
                System.exit(0);
            }

            // Перевіряємо, чи є місто, що ввів користувач, в списку
            boolean isCorrectCity = false;
            for(String city: cities){
                if(city.equalsIgnoreCase(input)){
                    isCorrectCity = true;
                    break;
                }
            }
            if(!isCorrectCity){
                System.out.println("Такого міста не існує в базі даних. Введіть інше місто!");
                continue;
            }

            // Перевірка, чи з потрібної букви ми вводимо слово
            if(lastComputerCity != null){
                char lastComputerCityChar = lastComputerCity.charAt(lastComputerCity.length()-1);

                if(lastComputerCityChar == exception1
                        || lastComputerCityChar == exception2
                        || lastComputerCityChar == exception3
                        || lastComputerCityChar == exception4){
                    lastComputerCityChar = lastComputerCity.charAt(lastComputerCity.length()-2);
                }
                char firstInputChar = input.charAt(0);

                if(Character.toLowerCase(lastComputerCityChar) != Character.toLowerCase(firstInputChar)){
                    System.out.println("Ви ввели місто з неправильною першою буква");
                    continue;
                }

            }

            char lastChar = input.charAt(input.length() - 1);
            lastComputerCity = getRandomCity(lastChar);
            System.out.println("Моє місто: "+lastComputerCity);
        }
    }

    private static String getRandomCity(char firstChar){
        List<String> properCities = new ArrayList<>();
        for(String city: cities){
            if(Character.toLowerCase(city.charAt(0)) == Character.toLowerCase(firstChar)){
                properCities.add(city);
            }
        }

        Random random = new Random();
        int index = random.nextInt(properCities.size());
        return properCities.get(index);
    }

    private static void fillCities() {
        // cities.add("Київ");
        // cities.add("Вінниць");
        List<String> allCities =  Arrays.asList("Авдіївка",
                "Алмазна",
                "Алупка",
                "Алушта",
                "Алчевськ",
                "Амвросіївка",
                "Ананьїв",
                "Андрушівка",
                "Антрацит",
                "Апостолове",
                "Армянськ",
                "Арциз",
                "Балаклія",
                "Балта",
                "Бар",
                "Баранівка",
                "Барвінкове",
                "Батурин",
                "Бахмач",
                "Бахмут",
                "Бахчисарай",
                "Баштанка",
                "Белз",
                "Бердичів",
                "Бердянськ",
                "Берегове",
                "Бережани",
                "Березань",
                "Березівка",
                "Березне",
                "Берестечко",
                "Берислав",
                "Бершадь",
                "Бібрка",
                "Біла Церква",
                "Білгород-Дністровський",
                "Білицьке",
                "Білогірськ",
                "Білозерське",
                "Білопілля",
                "Біляївка",
                "Благовіщенське",
                "Бобринець",
                "Бобровиця",
                "Богодухів",
                "Богуслав",
                "Боково-Хрустальне",
                "Болград",
                "Болехів",
                "Борзна",
                "Борислав",
                "Бориспіль",
                "Борщів",
                "Боярка",
                "Бровари",
                "Броди",
                "Брянка",
                "Бунге",
                "Буринь",
                "Бурштин",
                "Буськ",
                "Буча",
                "Бучач",
                "Валки",
                "Вараш",
                "Василівка",
                "Васильків",
                "Ватутіне",
                "Вашківці",
                "Великі Мости",
                "Верхівцеве",
                "Верхньодніпровськ",
                "Вижниця",
                "Вилкове",
                "Винники",
                "Виноградів",
                "Вишгород",
                "Вишневе",
                "Вільногірськ",
                "Вільнянськ",
                "Вінниця",
                "Вовчанськ",
                "Вознесенівка",
                "Вознесенськ",
                "Волноваха",
                "Володимир",
                "Волочиськ",
                "Ворожба",
                "Вуглегірськ",
                "Вугледар",
                "Гадяч",
                "Гайворон",
                "Гайсин",
                "Галич",
                "Генічеськ",
                "Герца",
                "Гірник",
                "Гірське",
                "Глиняни",
                "Глобине",
                "Глухів",
                "Гнівань",
                "Гола Пристань",
                "Голубівка",
                "Горішні Плавні",
                "Горлівка",
                "Городенка",
                "Городище",
                "Городня",
                "Городок",
                "Городок",
                "Горохів",
                "Гребінка",
                "Гуляйполе",
                "Дебальцеве",
                "Деражня",
                "Дергачі",
                "Джанкой",
                "Дніпро",
                "Дніпрорудне",
                "Добромиль",
                "Добропілля",
                "Довжанськ",
                "Докучаєвськ",
                "Долина",
                "Долинська",
                "Донецьк",
                "Дрогобич",
                "Дружба",
                "Дружківка",
                "Дубляни",
                "Дубно",
                "Дубровиця",
                "Дунаївці",
                "Енергодар",
                "Євпаторія",
                "Єнакієве",
                "Жашків",
                "Жданівка",
                "Жидачів",
                "Житомир",
                "Жмеринка",
                "Жовква",
                "Жовті Води",
                "Заводське",
                "Залізне",
                "Заліщики",
                "Запоріжжя",
                "Заставна",
                "Збараж",
                "Зборів",
                "Звенигородка",
                "Звягель",
                "Здолбунів",
                "Зеленодольськ",
                "Зимогір'я",
                "Зіньків",
                "Зміїв",
                "Знам'янка",
                "Золоте",
                "Золотоноша",
                "Золочів",
                "Зоринськ",
                "Зугрес",
                "Івано-Франківськ",
                "Ізмаїл",
                "Ізюм",
                "Ізяслав",
                "Іллінці",
                "Іловайськ",
                "Інкерман",
                "Ірміно",
                "Ірпінь",
                "Іршава",
                "Ічня",
                "Кагарлик",
                "Кадіївка",
                "Калинівка",
                "Калуш",
                "Кальміуське",
                "Камінь-Каширський",
                "Кам'янець-Подільський",
                "Кам'янка",
                "Кам'янка-Бузька",
                "Кам'янка-Дніпровська",
                "Кам'янське",
                "Канів",
                "Карлівка",
                "Каховка",
                "Керч",
                "Київ",
                "Кипуче",
                "Ківерці",
                "Кілія",
                "Кіцмань",
                "Кобеляки",
                "Ковель",
                "Кодима",
                "Козятин",
                "Коломия",
                "Комарно",
                "Конотоп",
                "Копичинці",
                "Корець",
                "Коростень",
                "Коростишів",
                "Корсунь-Шевченківський",
                "Корюківка",
                "Косів",
                "Костопіль",
                "Костянтинівка",
                "Краматорськ",
                "Красилів",
                "Красногорівка",
                "Красноград",
                "Красноперекопськ (Яни Капу)",
                "Кременець",
                "Кременчук",
                "Кремінна",
                "Кривий Ріг",
                "Кролевець",
                "Кропивницький",
                "Куп'янськ",
                "Курахове",
                "Ладижин",
                "Ланівці",
                "Лебедин",
                "Лиман",
                "Липовець",
                "Лисичанськ",
                "Лозова",
                "Лохвиця",
                "Лубни",
                "Луганськ",
                "Лутугине",
                "Луцьк",
                "Львів",
                "Любомль",
                "Люботин",
                "Макіївка",
                "Мала Виска",
                "Малин",
                "Марганець",
                "Маріуполь",
                "Мар'їнка",
                "Мелітополь",
                "Мена",
                "Мерефа",
                "Миколаїв",
                "Миколаїв",
                "Миколаївка",
                "Миргород",
                "Мирноград",
                "Миронівка",
                "Міусинськ",
                "Могилів-Подільський",
                "Молодогвардійськ",
                "Молочанськ",
                "Монастириська",
                "Монастирище",
                "Моршин",
                "Моспине",
                "Мостиська",
                "Мукачево",
                "Надвірна",
                "Немирів",
                "Нетішин",
                "Ніжин",
                "Нікополь",
                "Нова Каховка",
                "Нова Одеса",
                "Новгород-Сіверський",
                "Новий Буг",
                "Новий Калинів",
                "Новий Розділ",
                "Новоазовськ",
                "Нововолинськ",
                "Новогродівка",
                "Новодністровськ",
                "Новодружеськ",
                "Новомиргород",
                "Новомосковськ",
                "Новоселиця",
                "Новоукраїнка",
                "Новояворівськ",
                "Носівка",
                "Обухів",
                "Овруч",
                "Одеса",
                "Олевськ",
                "Олександрівськ",
                "Олександрія",
                "Олешки",
                "Оріхів",
                "Остер",
                "Острог",
                "Охтирка",
                "Очаків",
                "Павлоград",
                "Первомайськ",
                "Первомайськ",
                "Первомайський",
                "Перевальськ",
                "Перемишляни",
                "Перечин",
                "Перещепине",
                "Переяслав",
                "Першотравенськ",
                "Петрово-Красносілля",
                "Пирятин",
                "Південне",
                "Підгайці",
                "Підгородне",
                "Погребище",
                "Подільськ",
                "Покров",
                "Покровськ",
                "Пологи",
                "Полонне",
                "Полтава",
                "Помічна",
                "Попасна",
                "Почаїв",
                "Привілля",
                "Прилуки",
                "Приморськ",
                "Прип'ять",
                "Пустомити",
                "Путивль",
                "П'ятихатки",
                "Рава-Руська",
                "Радехів",
                "Радивилів",
                "Радомишль",
                "Рахів",
                "Рені",
                "Решетилівка",
                "Ржищів",
                "Рівне",
                "Ровеньки",
                "Рогатин",
                "Родинське",
                "Рожище",
                "Роздільна",
                "Ромни",
                "Рубіжне",
                "Рудки",
                "Саки",
                "Самбір",
                "Сарни",
                "Свалява",
                "Сватове",
                "Світловодськ",
                "Світлодарськ",
                "Святогірськ",
                "Севастополь",
                "Селидове",
                "Семенівка",
                "Середина-Буда",
                "Сєвєродонецьк",
                "Синельникове",
                "Сіверськ",
                "Сімферополь",
                "Скадовськ",
                "Скалат",
                "Сквира",
                "Сколе",
                "Славута",
                "Славутич",
                "Слов'янськ",
                "Сміла",
                "Снігурівка",
                "Сніжне",
                "Сновськ",
                "Снятин",
                "Сокаль",
                "Сокиряни",
                "Соледар",
                "Сорокине",
                "Соснівка",
                "Старий Крим",
                "Старий Самбір",
                "Старобільськ",
                "Старокостянтинів",
                "Стебник",
                "Сторожинець",
                "Стрий",
                "Судак",
                "Судова Вишня",
                "Суми",
                "Суходільськ",
                "Таврійськ",
                "Тальне",
                "Тараща",
                "Татарбунари",
                "Теплодар",
                "Теребовля",
                "Тернівка",
                "Тернопіль",
                "Тетіїв",
                "Тисмениця",
                "Тлумач",
                "Токмак",
                "Торецьк",
                "Тростянець",
                "Трускавець",
                "Тульчин",
                "Турка",
                "Тячів",
                "Угнів",
                "Ужгород",
                "Узин",
                "Українка",
                "Українськ",
                "Умань",
                "Устилуг",
                "Фастів",
                "Феодосія",
                "Харків",
                "Харцизьк",
                "Херсон",
                "Хирів",
                "Хмельницький",
                "Хмільник",
                "Ходорів",
                "Хорол",
                "Хоростків",
                "Хотин",
                "Хрестівка",
                "Христинівка",
                "Хрустальний",
                "Хуст",
                "Часів Яр",
                "Червоноград",
                "Черкаси",
                "Чернівці",
                "Чернігів",
                "Чигирин",
                "Чистякове",
                "Чоп",
                "Чорнобиль",
                "Чорноморськ",
                "Чортків",
                "Чугуїв",
                "Чуднів",
                "Шаргород",
                "Шахтарськ",
                "Шепетівка",
                "Шостка",
                "Шпола",
                "Шумськ",
                "Щастя",
                "Щолкіне",
                "Южне",
                "Южноукраїнськ",
                "Яворів",
                "Яготин",
                "Ялта",
                "Ямпіль",
                "Яремче",
                "Ясинувата");
        cities.addAll(allCities);
    }

}