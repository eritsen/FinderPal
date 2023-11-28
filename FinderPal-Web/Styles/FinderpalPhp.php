<?php include('server.php'); ?>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" href="loginDesign.css">

</head>
<body>

<div class = "container">
    <h1><b>Welcome to Finder Pal</b></h1>
    <br />



      <div class="centered-form">
        <div class="login-form">
            <form method="POST" action="server.php">
                <div class="input-container">
                    <label for="username"><b>Username:</b></label>
                    <input type="text" id="username" name="username" placeholder="Enter your username">
                </div>
                <div class="input-container">
                    <label for="password"><b>Password:</b></label>
                    <input type="password" id="password" name="password" placeholder="Enter your password">
                </div>
                <button type="submit" class="login-button" name="login_user"><b>Login</b></button>
                <br>
                <br>
                <?php
                session_start();
                if (isset($_SESSION['login_status'])) {
                    echo '<div class="error-message">' . $_SESSION['login_status'] . '</div>';
                    unset($_SESSION['login_status']); // Clear the session variable
                }
                ?>
            </form>
        </div>
    </div> 
</div>


</body>
</html>

<!-- <div class="centered-form">
        <div class="login-form">
            <form method="POST" action="server.php">
                <div class="input-container">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" placeholder="Enter your username">
                </div>
                <div class="input-container">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password">
                </div>
                <button type="submit" class="login-button" name="login_user">Login</button>
            </form>
            
        </div>
    </div> -->
