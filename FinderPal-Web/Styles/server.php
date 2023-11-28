<?php
// Database connection
$host = "localhost"; 
$username = ""; 
$password = ""; 
$database = ""; 

$conn = mysqli_connect('localhost', 'root', '', 'finderpalusers');

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Handle login
if (isset($_POST['login_user'])) {
    $username = $_POST['username'];
    $password = $_POST['password'];

    // Sanitize user input (prevents SQL injection)
    $username = mysqli_real_escape_string($conn, $username);
    $password = mysqli_real_escape_string($conn, $password);

    // Query the database to check if the username and password match
    $query = "SELECT * FROM users WHERE username='$username' AND password='$password'";
    $result = mysqli_query($conn, $query);

    if (mysqli_num_rows($result) == 1) {
        // Username and password are correct
        echo "Login successful!"; // You can redirect the user to another page here
                 header('Location: main.php');
 	  

    } else {
        // Username and password do not match
        //echo "Login failed. Please check your credentials.";
     session_start();
        $_SESSION['login_status'] = "Login failed. Please check your credentials.";
        header('Location: FinderPalPhp.php'); // Redirect back to the login page
        exit();
    }
}

// Close the database connection
mysqli_close($conn);
?>
