<?php

session_start();
require_once 'connect.php';

    $login = $_POST['login'];
    $password = $_POST['password'];

    $check_user = mysqli_query($connect,"SELECT * FROM `users` WHERE `login`='$login' AND `password` = '$password'");
    if(mysqli_num_rows($check_user) > 0){
        $user = mysqli_fetch_assoc($check_user);

        $_SESSION['user'] = [
            "id" => $user['id'],
            "login" => $user['login'],
        ];

        header('Location: ../content/content.php');
    }else{
        $_SESSION['message'] = 'Wrong pair login/password';
        header('Location: ../');
    }