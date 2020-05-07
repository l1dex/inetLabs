<?php

    $connect = mysqli_connect('localhost','mysql','mysql','test');
    if(!$connect){
        die('Error db connection');
    }