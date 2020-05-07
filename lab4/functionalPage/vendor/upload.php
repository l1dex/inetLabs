<?php

session_start();
require_once 'connect.php';

if(empty($_FILES['image']['name'])){
    header('Location: ../content/content.php');
}
if($_FILES['image']['size']>=2048 or strpos($_FILES['image']['name'],'script')
    or strpos($_FILES['image']['name'],'http')
    or strpos($_FILES['image']['name'],'SELECT')
    or strpos($_FILES['image']['name'],'UNION')
    or strpos($_FILES['image']['name'],'UPDATE')
    or strpos($_FILES['image']['name'],'exe')
    or strpos($_FILES['image']['name'],'exec')
    or strpos($_FILES['image']['name'],'INSERT')
    or strpos($_FILES['image']['name'],'tmp')){
    header('Location: ../content/content.php');
}

    $path = 'imag/' . time() .$_FILES['image']['name'];
    move_uploaded_file($_FILES['image']['tmp_name'],'../content/' . $path);

    $date = date("Y-m-d H:i:s");
    mysqli_query($connect,"INSERT INTO `image` (`id`, `path`, `date`) VALUES (NULL, '$path', '$date')");
    header('Location: ../content/content.php');
    ?>