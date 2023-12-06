<?php
include('Net/SSH2.php');

$ssh = new Net_SSH2('172.20.10.4');
if (!$ssh->login('desktop', 'admin')) {
    exit('Login Failed');
}

function executeOnTargetServer($command) {
    global $ssh;

    $output = $ssh->exec($command);
    return $output;
}

$imageFilePath = 'image.jpg';
if (file_exists($imageFilePath)) {
    unlink($imageFilePath);
}

// Function to execute commands based on the clicked button
function executeCommand($buttonName) {
    global $ssh; // Access the global $ssh variable

    switch ($buttonName) {
        case 'Navigate':
            return executeOnTargetServer('python navigate.py');
        case 'Return to base':
            return executeOnTargetServer('python return_to_base.py');
        case 'Display item':
            // Assuming the image file is named 'item_image.jpg' on the Raspberry Pi
            $imageData = $ssh->exec('cat /home/desktop/TargetImages/Object1.jpg');
            file_put_contents('image.jpg', $imageData); // Save the image data to a file
            return 'Item image displayed';
        case 'Search for item':
            return executeOnTargetServer('python search_for_item.py');
        case 'Kill operation':
            return executeOnTargetServer('python kill.py');
        default:
            return 'Invalid button clicked';
    }
}

// Check if a command is received through POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['command'])) {
        $command = $_POST['command'];
        $output = executeCommand($command);
        echo $output;

 if (in_array($command, ['Navigate', 'Return to base', 'Search for item', 'Kill operation'])) {
            // Fetch the updated image from the Raspberry Pi
            $imageData = $ssh->exec('cat /path/to/your/image.jpg');
            file_put_contents('image.jpg', $imageData); // Save the image data to a file
        }


        exit; // Stop further execution after handling the command
    }
}

?>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" href="robot.css">
</head>

<body>
    <div class="container">
        <br />
        <h1><b>Robot</b></h1>
        <button class="arrow-button-up" onclick="logCommand('Move Forward')">↑</button>
        <div>
            <button class="arrow-button-middle" onclick="logCommand('Move Left')">←</button>
            <button class="arrow-button-middle" onclick="logCommand('Move Right')">→</button>
        </div>
        <button class="arrow-button-down" onclick="logCommand('Move Backwards')">↓</button>

        <div class="button-container">
            <button class="commands" onclick="logCommand('Navigate')">Navigate</button>
            <button class="commands" onclick="logCommand('Return to base')">Return to base</button>
            <button class="commands" onclick="logCommand('Display item')">Display item</button>
            <button class="commands" onclick="logCommand('Kill operation')">Kill operation</button>
        </div>

      <div class="image-box">
        <img src="image.jpg" alt="Image Description" class="image">
    </div>

        <div class="back-button" onclick="goBack()">
            <img src="download2.png" alt="Back Arrow" class="backImage">
        </div>
    </div>

    <script defer src="script.js"></script>
</body>

</html>