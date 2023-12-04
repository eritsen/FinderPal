// DOM elements
var button1 = document.getElementById("robotButton");
var button2 = document.getElementById("aboutUs");
var activityLogButton = document.getElementById("activityLogButton");
var inventoryButton = document.getElementById("inventory");
var activityLog = document.getElementById("activityLog");
var existingLog = JSON.parse(localStorage.getItem('activityLog')) || [];

// Add event listeners to buttons
if (button1) {
    button1.addEventListener("click", function () {
        window.location.href = "Robot.php";
    });
}

if (button2) {
    button2.addEventListener("click", function () {
        window.location.href = "AboutUs.php";
    });
}

if (activityLogButton) {
    activityLogButton.addEventListener("click", function () {
        window.location.href = "activityLogs.php";
        console.log("activity button clicked");
    });
}

if (inventoryButton) {
    inventoryButton.addEventListener("click", function () {
        window.location.href = "Inventory.php";
    });
}

// Log command function
function logCommand(command) {
    var existingLog = JSON.parse(localStorage.getItem('activityLog')) || [];
    existingLog.push('Pressed: ' + command);
    localStorage.setItem('activityLog', JSON.stringify(existingLog));

    // Send the command to the server
    fetch('robot.php', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: 'command=' + encodeURIComponent(command),
    })
        .then(response => response.text())
        .then(output => {
            console.log('Command executed:', output);
            // Handle the response if needed
        })
        .catch(error => {
            console.error('Error executing command:', error);
            // Handle errors if needed
        });
}

// Display existing log entries
existingLog.forEach(function (entry) {
    var logEntry = document.createElement('p');
    logEntry.textContent = entry;
    activityLog.appendChild(logEntry);
});

// Clear logs button
document.getElementById('clearLogs').addEventListener('click', function () {
    localStorage.removeItem('activityLog');
    activityLog.innerHTML = ''; // Remove all child elements
});

// Keyboard event listener
document.addEventListener('keydown', handleKeyPress);

// Go back function
function goBack() {
    window.history.back();
}

