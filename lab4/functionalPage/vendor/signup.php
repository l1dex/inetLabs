<?php

session_start();
require_once 'connect.php';


    $login = $_POST['login'];
    $password = $_POST['password'];
    $confirm_password = $_POST['conf_password'];

    if($password === $confirm_password){
        $checkUser = mysqli_query($connect,"SELECT * FROM `users` WHERE `login`='$login'");
        if(mysqli_num_rows($checkUser) > 0){
            $_SESSION['message'] = 'User with this login already exist';
            header('Location: ../');
        }
        $date = date("Y-m-d H:i:s");

        mysqli_query($connect,"INSERT INTO `users` (`id`, `login`, `password`, `date`) VALUES (NULL , '$login', '$password', '$date')");

        $_SESSION['message'] = 'registration was successful';
        header('Location: /');
    }else{
        $_SESSION['message'] = 'passwords dont match';
        header('Location: ../registration/index.php');
    }