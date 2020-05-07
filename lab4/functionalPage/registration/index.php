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
    <title>Registration</title>
    <link rel="stylesheet" href="../css/main.css">
</head>
<body>
    <form action="../vendor/signup.php" method="post">
        <label>Login</label>
        <input type="text" name="login" placeholder="Enter login">
        <label>Password</label>
        <input type="password" name="password" placeholder="Enter password">
        <label>Confirm password</label>
        <input type="password" name="conf_password" placeholder="Confirm password">
        <button>Enter</button>
        <p>Already have an account? - <a href="../">Login in</a></p>
        <?php
            if($_SESSION['message']){
                echo '<p class="msg"> ' . $_SESSION['message'] . ' </p>';
            }
            unset($_SESSION['message']);
        ?>
    </form>
</body>
</html>