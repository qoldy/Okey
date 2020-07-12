package com.example.okey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Catalog catalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catalog = new Catalog();
        createCatalog();
        ((Okey)this.getApplication()).addressList.add
                ("ул. Минская, 120 корпус 8, Краснодар, Краснодарский край, 350004");
        ((Okey)this.getApplication()).addressList.add
                ("ТРК Галактика, ул. Уральская, д.98/11, Краснодар, Краснодарский край, 350075");
        ((Okey)this.getApplication()).addressList.add
                ("ул. Мачуги, 2, Краснодар, Краснодарский край, 350061");
        ((Okey)this.getApplication()).addressList.add
                ("ТРК «Oz Mall», Крылатая ул., 2, Краснодар, Краснодарский край, 350910");

        Intent intent = new Intent(this, MapActivity.class);
        startActivityForResult(intent, 0);
    }

    private void createCatalog()
    {
        catalog.addSection(sectionMeat());
        catalog.addSection(sectionBread());
        catalog.addSection(sectionMilk());
        catalog.addSection(sectionCanned());
        catalog.addSection(sectionAlko());
        catalog.addSection(sectionOil());
        ((Okey) this.getApplication()).setCatalog(catalog);
    }

    private Section sectionMeat()
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Фарш из индейки охлажденный", 164.0, 39, 1));
        products.add(new Product("Котлета из свиной корейки охлажденная Самсон 400г", 339.5, 0, 2));
        products.add(new Product("Фарш домашний охлажденный Самсон 400г", 229.0, 35, 3));
        products.add(new Product("Колбаса вареная КампоМос Докторская", 164.4, 0, 4));
        products.add(new Product("Колбаса вареная Останкино Докторская", 261.4, 0, 5));
        products.add(new Product("Колбаса вареная Папа Может Останкино", 255.9, 0, 6));
        products.add(new Product("Филе цыпленка охлажденное кг", 319.9, 0, 7));
        products.add(new Product("Гуляш говяжий п/ф охлажденный СП кг", 496.4, 0, 8));
        products.add(new Product("Кролик тушка замороженный кг", 579.5, 0, 9));
        return new Section("Мясо, птица, колбасы", products);
    }

    private Section sectionMilk()
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Яйцо куриное С0 Экстра Роскар 10 шт", 104.4, 0, 10));
        products.get(0).setShelf_life(90);
        products.add(new Product("Яйцо куриное С1 Экстра Роскар 15 шт", 138.4, 0, 11));
        products.get(1).setShelf_life(90);
        products.add(new Product("Яйцо куриное С1 Лето 10шт", 79.99, 38, 12));
        products.get(2).setShelf_life(90);
        products.add(new Product("БЗМЖ Сыр Аланталь Традиционный 50%", 175.4,0 , 13));
        products.add(new Product("БЗМЖ Сыр плав President Мааздам 40%", 87.49, 31, 14));
        products.add(new Product("БЗМЖ Сыр ОКЕЙ сливочный нарезка", 128.4, 0, 15));
        products.add(new Product("БЗМЖ Молоко утп Простоквашино 3,2%", 97.99, 0, 16));
        products.get(6).setShelf_life(5);
        products.add(new Product("БЗМЖ Молоко пастер Простоквашино 1,5%", 72.4, 0, 17));
        products.get(6).setShelf_life(5);
        products.add(new Product("БЗМЖ Продукт твор Danone Даниссимо с хр шариками 7,3%", 53.99, 0, 18));
        products.add(new Product("БЗМЖ Биойогурт Активиа обогащенный чернослив 2%", 53.49, 25, 19));
        return new Section("Молочные продукты, сыры, яйца", products);
    }

    private Section sectionBread()
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Батон Хлебный Дом Звездный 350г", 40.4, 0, 20));
        products.get(0).setShelf_life(3);
        products.add(new Product("Хлеб Хлебный Дом Тостовый в нарезке 500г", 87.9, 0, 21));
        products.get(1).setShelf_life(3);
        products.add(new Product("Хлеб Волжский Пекарь Бородинский в нарезке 300г", 27.4, 0, 22));
        products.get(2).setShelf_life(3);
        products.add(new Product("Шок.батончик Kinder Maxi 21г", 23.9, 0, 23));
        products.add(new Product("Шок.батончик MARS 50г", 39.4, 0, 24));
        products.add(new Product("Драже M&M's crispy 220г", 170.4, 0, 25));
        products.add(new Product("Шок яйцо Kinder Surprise 20г", 70.4, 0, 26));
        return new Section("Сладости, хлеб", products);
    }

    private Section sectionCanned()
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Крупа рис Отборный Националь 900г", 92.99, 27, 27));
        products.add(new Product("Крупа Гречневая PROSTO 8х62,5г", 69.4, 0, 28));
        products.add(new Product("Крупа кус-кус Националь 450г", 114.0, 33, 29));
        products.add(new Product("Макароны De Cecco Penne rigate 041 500г", 212.9, 0, 30));
        products.add(new Product("Макароны Pasta Zara Спагетти 500г", 90.4, 0, 31));
        products.add(new Product("Макароны Байсад паутинка 450г", 57.4, 0, 32));
        products.add(new Product("Паштет из тунца Аргета 95г ж/б", 114.5, 0, 33));
        products.add(new Product("Паштет из индейки 100г Setra", 79.99, 31, 34));
        products.add(new Product("Фасоль красная Бондюэль 425мл ж/б", 94.99, 0, 35));
        return new Section("Бакалея и консервация", products);
    }

    private Section sectionAlko()
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Пиво Стелла Артуа светлое 5% 0,5л ст/б СанИнбев", 95.99, 0, 36));
        products.add(new Product("Пиво Krusovice Imperial светлое пастериз фильтр 5% 0,5л ж/б Форт", 139.5, 0, 37));
        products.add(new Product("Пиво Карлсберг 4,6% 0,45л ж/б Балтика", 56.99, 30, 38));
        products.add(new Product("Пиво Балтика №9 Светлое 8% 0,45л ж/б", 47.4, 0, 39));
        products.add(new Product("Ром Captain Morgan Черная Этикетка ямайский 40% 0,5л", 1089.0,0, 40));
        products.add(new Product("Коньяк российский Старейшина 5лет 40% 0,5л", 524.0, 0, 41));
        products.add(new Product("Водка Русский Стандарт Платинум 40% 0,5л", 549.0, 20, 42));
        products.add(new Product("Коньяк армянский Ной Араспел 5лет 40% 0,5л п/у", 1094.0, 30, 43));
        return new Section("Алкогольные напитки", products);
    }

    private Section sectionOil()
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Масло подсолнечное Золотая Семечка рафинированное дезодорированное 1л", 109.0, 40, 44));
        products.add(new Product("Масло оливковое Monini E.V лимон 250мл ст/б", 628.9, 0, 45));
        products.add(new Product("Масло подсолнечное Слобода рафинированное дезодорированное 1,8л", 174.4, 0, 46));
        products.add(new Product("Приправа универсальная Maggi Букет приправ 75г", 36.9, 0, 47));
        products.add(new Product("Приправа Knorr Ароматная Классика овощей 200г", 75.9, 0, 48));
        products.add(new Product("Приправа Kotanyi д/салата Греческая 13г", 39.9, 0, 49));
        products.add(new Product("Соус Heinz чесночный 250мл ст/б", 134.4, 0, 50));
        products.add(new Product("Соус Heinz сырный 230г", 75.99, 41, 51));
        products.add(new Product("Кетчуп Heinz острый 350г д/п", 75.99, 41, 52));
        products.add(new Product("Майонез Провансаль с лимонным соком Махеев 50,5% 770г д/п", 109.9, 0, 53));
        return new Section("Растительные масла, соусы и приправы", products);
    }
}
