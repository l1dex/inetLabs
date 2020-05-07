<?php
session_start();
if($_SESSION['user']){
    header('Location: ../content/content.php');
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Authorization</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <form action="vendor/signin.php" method="post">
        <label>Login</label>
        <input type="text" name="login" placeholder="Enter login">
        <label>Password</label>
        <input type="password" name="password" placeholder="Enter password">
        <button>Login in</button>
        <p>If you haven't an account - <a href="registration/index.php">Registration</a></p>
        <?php
        if($_SESSION['message']){
            echo '<p class="msg"> ' . $_SESSION['message'] . ' </p>';
        }
        unset($_SESSION['message']);
        ?>
    </form>
</body>
</html>