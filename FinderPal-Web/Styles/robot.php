<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" href="robot.css">

</head>
<body>

<div class = "container">
    
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
            <img src="download2.png" alt="Back Arrow" class = "backImage">
    </div>

</div>

          <script src="script.js"></script>  


</body>
</html>


