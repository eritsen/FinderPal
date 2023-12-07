<?php
include('Net/SFTP.php');

$ssh = new Net_SFTP('172.20.10.7');
if (!$ssh->login('desktop', 'admin')) {
    exit('Login Failed');
}


function executeOnTargetServer($command) {
    global $ssh;

    $output = $ssh->exec($command);
    return $output;
}

$imageFilePath = 'C:\xampp\htdocs\FinderPal-Web\Styles\image.jpg';
/*if (file_exists($imageFilePath)) {
    unlink($imageFilePath);
}*/

// Function to execute commands based on the clicked button
function executeCommand($buttonName) {
    global $ssh, $imageFilePath; // Access the global $ssh variable

    switch ($buttonName) {
        case 'Control':
            return executeOnTargetServer('ssh fares@172.20.10.8');

        case 'Remove item':
            if (file_exists($imageFilePath)) {
    // Attempt to delete the file
        unlink($imageFilePath); }
        header("Refresh:0");

        return NULL;
        case 'Display item':
            // Assuming the image file is named 'item_image.jpg' on the Raspberry Pi
            return $ssh->get('/home/desktop/TargetImages/image.jpg','C:\xampp\htdocs\FinderPal-Web\Styles\image.jpg' );

        case 'Search for item':
            return executeOnTargetServer('python search_for_item.py');
        case 'Kill operation':
            return executeOnTargetServer('pkill -9 bash');
        case 'Seek1':
            return executeOnTargetServer('python MainSoftware.py object1');
        case 'Seek2':
            return executeOnTargetServer('python MainSoftware.py object2');
        case 'Seek3':
            return executeOnTargetServer('python MainSoftware.py object3');
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
        <button class="arrow-button-up" onclick="logCommand('Move Forward')">↑</button>
        <div>
            <button class="arrow-button-middle" onclick="logCommand('Move Left')">←</button>
            <button class="arrow-button-middle" onclick="logCommand('Move Right')">→</button>
        </div>
        <button class="arrow-button-down" onclick="logCommand('Move Backwards')">↓</button>

        <div class="button-container">
            <button class="commands" onclick="logCommand('Control')">Control</button>
            <button class="commands" onclick="logCommand('Seek1')">First object</button>
            <button class="commands" onclick="logCommand('Seek2')">Second object</button>
            <button class="commands" onclick="logCommand('Seek3')">Third object</button>
            <button class="commands" onclick="displayItemAndRefresh()">Display item</button>
            <button class="commands" onclick="logCommand('Remove item')">Remove item</button>
            <button class="commands" onclick="logCommand('Kill operation')">Kill operation</button>

        </div>

      <div class="image-box">
            <img src="image.jpg" class="image">
    </div>

        <div class="back-button" onclick="goBack()">
            <img src="download2.png" alt="Back Arrow" class="backImage">
        </div>
    </div>

    <script src="script.js" defer></script>
</body>

</html>