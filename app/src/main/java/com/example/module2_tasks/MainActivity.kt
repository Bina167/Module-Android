package com.example.module2_tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2_tasks.ui.theme.Module2_TasksTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2_TasksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // ВЫЗОВ ФУНКЦИИ: передаем конкретное имя "Студент"
                    Hello(
                        name = "Студент",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// 1. Наша новая функция Hello
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    // Проверяем, равно ли имя null
    val greetingText = if (name == null) {
        "Имя не задано"
    } else {
        "Привет, $name!"
    }

    // Выводим текст на экран
    Text(
        text = greetingText,
        modifier = modifier
    )
}

// Превью для просмотра в Android Studio (необязательно, но полезно)
@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Module2_TasksTheme {
        Hello(name = "Студент")
    }
}
// 1. Портретная ориентация (по умолчанию)
@Preview(name = "Portrait", showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
fun HelloPreviewPortrait() {
    Module2_TasksTheme {
        Hello(name = "Портрет")
    }
}

// 2. Альбомная ориентация (landscape)
@Preview(name = "Landscape", showSystemUi = true, device = "spec:width=891dp,height=411dp,orientation=landscape")
@Composable
fun HelloPreviewLandscape() {
    Module2_TasksTheme {
        Hello(name = "Ландшафт")
    }
}

// 3. Круглый дисплей 200x200dp с желтым фоном
@Preview(name = "Round", showSystemUi = true, device = "spec:width=200dp,height=200dp,isRound=true")
@Composable
fun HelloPreviewRound() {
    // Обернули в Surface с желтым цветом, чтобы выполнить условие задания
    androidx.compose.material3.Surface(
        color = androidx.compose.ui.graphics.Color.Yellow,
        modifier = Modifier.fillMaxSize()
    ) {
        Hello(name = "Круг")
    }
}
@Composable
fun Task3Text() {
    androidx.compose.foundation.layout.Column(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
        // 1. Стилизованный текст (зеленый, курсив, по центру, одна строка с многоточием)
        androidx.compose.material3.Text(
            text = androidx.compose.ui.res.stringResource(id = com.example.module2_tasks.R.string.compose_desc),
            color = androidx.compose.ui.graphics.Color.Green,
            fontSize = androidx.compose.ui.unit.TextUnit(16f, androidx.compose.ui.unit.TextUnitType.Sp),
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            maxLines = 1,
            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(horizontal = androidx.compose.ui.unit.Dp(16f))
        )

        // 2. Текст с отступом сверху, размером 24sp, черным цветом на зеленом фоне и подчеркнутый
        androidx.compose.material3.Text(
            text = "Дополнительный текст",
            fontSize = androidx.compose.ui.unit.TextUnit(24f, androidx.compose.ui.unit.TextUnitType.Sp),
            color = androidx.compose.ui.graphics.Color.Black,
            textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline,
            modifier = androidx.compose.ui.Modifier
                .padding(top = androidx.compose.ui.unit.Dp(48f))
                .background(androidx.compose.ui.graphics.Color.Green)
                .padding(androidx.compose.ui.unit.Dp(8f))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task3Preview() {
    Module2_TasksTheme {
        Task3Text()
    }
}
@Composable
fun Task4Button() {
    androidx.compose.material3.Button(
        onClick = { /* Действие при нажатии */ },
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth() // 1. Растягиваем по ширине
            .padding(16.dp), // Небольшой отступ от краев экрана, чтобы кнопка не прилипала
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), // 2. Скругленные углы
        border = androidx.compose.foundation.BorderStroke(2.dp, androidx.compose.ui.graphics.Color.Gray), // 3. Серая рамка
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = androidx.compose.ui.graphics.Color.LightGray, // 5. Светло-серый фон
            contentColor = androidx.compose.ui.graphics.Color.Black // 5. Черный текст
        ),
        elevation = androidx.compose.material3.ButtonDefaults.buttonElevation(defaultElevation = 4.dp) // 4. Тень 4.dp
    ) {
        androidx.compose.material3.Text(text = "Нажми на меня")
    }
}

// Превью для Задания 4
@Preview(showBackground = true)
@Composable
fun Task4Preview() {
    Module2_TasksTheme {
        // Оборачиваем в Box, чтобы кнопка не прилипала к верхнему краю
        androidx.compose.foundation.layout.Box(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
            Task4Button()
        }
    }
}
@Composable
fun Task5Initials() {
    // 1. Серый контейнер на всю ширину, высотой 100.dp
    androidx.compose.foundation.layout.Row(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(androidx.compose.ui.graphics.Color.Gray)
            .padding(vertical = 16.dp, horizontal = 16.dp), // 2. Вертикальные отступы 16.dp
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        // 3. Круг, занимающий всю доступную высоту (100.dp минус отступы = 68.dp)
        androidx.compose.foundation.layout.Box(
            modifier = androidx.compose.ui.Modifier
                .fillMaxHeight() // Занимает всю доступную высоту
                .aspectRatio(1f) // Делает фигуру идеально круглой
                .background(androidx.compose.ui.graphics.Color.White, shape = androidx.compose.foundation.shape.CircleShape),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            androidx.compose.material3.Text(
                text = "АБ", // Инициалы
                color = androidx.compose.ui.graphics.Color.Black,
                fontSize = androidx.compose.ui.unit.TextUnit(24f, androidx.compose.ui.unit.TextUnitType.Sp)
            )
        }
    }
}

// Превью для Задания 5
@Preview(showBackground = true)
@Composable
fun Task5Preview() {
    Module2_TasksTheme {
        androidx.compose.foundation.layout.Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize()
        ) {
            Task5Initials()
        }
    }
}
@Composable
fun Task6CircleTopRight() {
    androidx.compose.foundation.layout.Box(
        modifier = androidx.compose.ui.Modifier
            .size(240.dp, 120.dp) // Размер компонента
            .background(androidx.compose.ui.graphics.Color.Black), // Черный фон
        contentAlignment = androidx.compose.ui.Alignment.TopEnd // Круг в правом верхнем углу
    ) {
        androidx.compose.foundation.Image(
            painter = androidx.compose.ui.res.painterResource(id = com.example.module2_tasks.R.drawable.circle),
            contentDescription = "Круг"
        )
    }
}

@Composable
fun Task6CircleCenterBlue() {
    androidx.compose.foundation.layout.Box(
        modifier = androidx.compose.ui.Modifier
            .size(240.dp, 120.dp)
            .background(androidx.compose.ui.graphics.Color.Blue), // Синий фон
        contentAlignment = androidx.compose.ui.Alignment.Center // Круг по центру
    ) {
        androidx.compose.foundation.Image(
            painter = androidx.compose.ui.res.painterResource(id = com.example.module2_tasks.R.drawable.circle),
            contentDescription = "Круг",
            // Растягиваем круг на размеры контейнера с обрезкой
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            // Меняем цвет на фиолетовый
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(androidx.compose.ui.graphics.Color.Magenta)
        )
    }
}

// Превью для первого круга (черный фон, оранжевый круг справа вверху)
@Preview(showBackground = true)
@Composable
fun Task6PreviewTopRight() {
    Module2_TasksTheme {
        Task6CircleTopRight()
    }
}

// Превью для второго круга (синий фон, фиолетовый овал по центру)
@Preview(showBackground = true)
@Composable
fun Task6PreviewCenterBlue() {
    Module2_TasksTheme {
        Task6CircleCenterBlue()
    }
}

// --- TASK 7 ---

@Composable
fun ContactColumnItem(name: String, phone: String) {
    androidx.compose.foundation.layout.Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(androidx.compose.ui.graphics.Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        androidx.compose.material3.Text(text = "Name: $name", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        androidx.compose.material3.Text(text = "Middle name: Andreevich")
        androidx.compose.material3.Text(text = "Surname: Lukashin")
        androidx.compose.material3.Text(text = "Mobile phone: $phone")
        androidx.compose.material3.Text(text = "Address: Moscow, 3rd Stroiteley St., 25, apt. 12")
    }
}

@Composable
fun Task7ColumnLayout() {
    androidx.compose.foundation.layout.Column(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
        ContactColumnItem(name = "Evgeny", phone = "+7 495 495 95 95")
        ContactColumnItem(name = "Name 2", phone = "+7 495 495 95 96")
        ContactColumnItem(name = "Name 3", phone = "+7 495 495 95 97")
    }
}

@Composable
fun Task7RowLayout() {
    androidx.compose.foundation.layout.Row(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(androidx.compose.ui.graphics.Color.LightGray)
            .padding(8.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        // Текст слева
        androidx.compose.foundation.layout.Column(modifier = androidx.compose.ui.Modifier.weight(1f)) {
            androidx.compose.material3.Text(text = "Name: Evgeny", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            androidx.compose.material3.Text(text = "Middle name: Andreevich")
            androidx.compose.material3.Text(text = "Surname: Lukashin")
            androidx.compose.material3.Text(text = "Mobile phone: +7 495 495 95 95")
            androidx.compose.material3.Text(text = "Address: Moscow, 3rd Stroiteley St., 25, apt. 12")
        }

        // Звездочка справа (заменена на текст)
        androidx.compose.material3.Text(
            text = "★",
            color = androidx.compose.ui.graphics.Color.Yellow,
            fontSize = androidx.compose.ui.unit.TextUnit(24f, androidx.compose.ui.unit.TextUnitType.Sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task7ColumnPreview() {
    Module2_TasksTheme {
        Task7ColumnLayout()
    }
}

@Preview(showBackground = true)
@Composable
fun Task7RowPreview() {
    Module2_TasksTheme {
        Task7RowLayout()
    }
}
@Composable
fun WaterTracker() {
    // Состояния
    var waterCount by remember { mutableIntStateOf(0) }
    var daysInARow by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Заголовок
        Text(
            text = "Water Tracker",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF415f91)
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Счетчик воды
        Text(
            text = "$waterCount ml",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF565f71)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Кнопка добавления
        Button(
            onClick = { waterCount += 250 },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF415f91))
        ) {
            Text(text = "+250 ml", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка завершения дня
        Button(
            onClick = {
                if (waterCount >= 1500) {
                    daysInARow += 1
                } else {
                    daysInARow = 0
                }
                waterCount = 0
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF415f91))
        ) {
            Text(text = "Finish Day", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Счетчик дней
        Text(
            text = "Days in a row (1500+ ml): $daysInARow",
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Task8Preview() {
    Module2_TasksTheme {
        WaterTracker()
    }
}
@Composable
fun Task10ShoppingCart() {
    // Создаем состояние для списка товаров (название и цена). Изначально добавляем 3 товара.
    var products by androidx.compose.runtime.remember {
        androidx.compose.runtime.mutableStateOf(
            listOf(
                "Product #1" to 100,
                "Product #2" to 150,
                "Product #3" to 56
            )
        )
    }

    // Получаем контекст приложения (нужен для вызова Toast)
    val context = androidx.compose.ui.platform.LocalContext.current

    // Вычисляем общую сумму всех товаров в списке (price = второй элемент пары)
    val totalSum = products.sumOf { it.second }
    // Вычисляем текущее количество товаров в списке
    val productSize = products.size

    // Основной контейнер для расположения элементов вертикально
    androidx.compose.foundation.layout.Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {

        // Цикл для вывода каждого товара из списка
        for (product in products) {
            androidx.compose.material3.Text(text = "${product.first} - ${product.second} rubles")
        }

        // Добавляем пустое пространство между списком и суммой
        androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))

        // Выводим текст с общей суммой товаров
        androidx.compose.material3.Text(text = "Total sum: $totalSum rubles")

        // Добавляем пустое пространство перед кнопками
        androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

        // Кнопка для добавления нового товара в корзину
        androidx.compose.material3.Button(
            onClick = {
                // Генерируем название для нового товара (по порядковому номеру)
                val newProductName = "Product #${products.size + 1}"
                // Генерируем случайную цену от 0 до 100
                val newProductPrice = (0..100).random()
                // Создаем пару (название, цена)
                val newProduct = newProductName to newProductPrice

                // Обновляем состояние списка, добавляя новый товар в конец
                products = products + newProduct

                // Проверяем условие: если сумма всех товаров больше 500, показываем Toast
                if (products.sumOf { it.second } > 500) {
                    android.widget.Toast.makeText(context, "Free delivery!", android.widget.Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            androidx.compose.material3.Text("Add product")
        }

        // Добавляем пустое пространство между кнопками
        androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))

        // Условие: показываем кнопку удаления только если в корзине есть товары
        if (productSize > 0) {
            androidx.compose.material3.Button(
                onClick = {
                    // Удаляем последний товар из списка
                    products = products.dropLast(1)
                }
            ) {
                androidx.compose.material3.Text("Remove product")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task10Preview() {
    Module2_TasksTheme {
        Task10ShoppingCart()
    }
}