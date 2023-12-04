<?php
include('Net/SSH2.php');

$ssh = new Net_SSH2('172.20.10.4');
if (!$ssh->login('desktop', 'admin')) {
    exit('Login Failed');
}

// Function to execute commands based on the clicked button
function executeCommand($buttonName) {
    global $ssh; // Access the global $ssh variable

    switch ($buttonName) {
        case 'Navigate':
            return $ssh->exec('python navigate.py');
        case 'Return to base':
            return $ssh->exec('python return_to_base.py');
        case 'Search for item':
            return $ssh->exec('python search_for_item.py');
        case 'Kill operation':
            return $ssh->exec('python kill.py');
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
        <button class="arrow-button-up">↑</button>
        <div>
            <button class="arrow-button-middle">←</button>
            <button class="arrow-button-middle">→</button>
        </div>
        <button class="arrow-button-down">↓</button>

        <div class="button-container">
            <button class="commands" onclick="logCommand('Navigate')">Navigate</button>
            <button class="commands" onclick="logCommand('Return to base')">Return to base</button>
            <button class="commands" onclick="logCommand('Search for item')">Search for item</button>
            <button class="commands" onclick="logCommand('Kill operation')">Kill operation</button>
        </div>

        <div class="back-button" onclick="goBack()">
            <img src="download2.png" alt="Back Arrow" class="backImage">
        </div>
    </div>

    <script src="script.js"></script>
</body>

</html>