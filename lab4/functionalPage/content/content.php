<?php
session_start();
if(!$_SESSION['user']){
    header('Location: /');
}
require_once '../vendor/connect.php';
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gallery</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/content.css">
</head>
<body>
<form action="../vendor/upload.php" method="post" enctype="multipart/form-data">
    <input type="file" name="image">
    <button>Upload</button>
    <?php
    $dir = 'imag/'; // Папка с изображениями
    $cols = 3; // Количество столбцов в будущей таблице с картинками
    $files = scandir($dir); // Берём всё содержимое директории
    echo "<table>"; // Начинаем таблицу
    $k = 0; // Вспомогательный счётчик для перехода на новые строки
    for ($i = 0; $i < count($files); $i++) { // Перебираем все файлы
        if (($files[$i] != ".") && ($files[$i] != "..")) { // Текущий каталог и родительский пропускаем
            if ($k % $cols == 0) echo "<tr>"; // Добавляем новую строку
            echo "<td>"; // Начинаем столбец
            $path = $dir.$files[$i]; // Получаем путь к картинке
            echo "<a href='$path'>"; // Делаем ссылку на картинку
            echo "<img src='$path' alt='' width='100' />"; // Вывод превью картинки
            echo "</a>"; // Закрываем ссылку
            echo "</td>"; // Закрываем столбец
            /* Закрываем строку, если необходимое количество было выведено, либо данная итерация последняя */
            if ((($k + 1) % $cols == 0) || (($i + 1) == count($files))) echo "</tr>";
            $k++; // Увеличиваем вспомогательный счётчик
        }
    }
    echo "</table>"; // Закрываем таблицу
    ?>
</form>
</body>
</html>
