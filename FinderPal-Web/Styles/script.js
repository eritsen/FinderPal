

var button1 = document.getElementById("robotButton");
var button2 = document.getElementById("aboutUs");
var activityLogButton = document.getElementById("activityLogButton")

var activityLog = document.getElementById("activityLog")
var existingLog = JSON.parse(localStorage.getItem('activityLog')) || [];


    // Add a click event listener to the button
if (button1) {
    button1.addEventListener("click", function () {
        // Navigate to the "Robot" page when the button is clicked
        window.location.href = "Robot.php";
    });
}

if (button2) {
    button2.addEventListener("click", function () {
        // Navigate to the "about us" page when the button is clicked
        window.location.href = "AboutUs.php";
    });
}

if (activityLogButton) {
    activityLogButton.addEventListener("click", function () {
        // Navigate to the "activity log" page when the button is clicked
        window.location.href = "activityLogs.php";
        console.log("activity button clicked");
    });
}

    function logCommand(command) {
        // Retrieve existing log from localStorage or initialize an empty array
        var existingLog = JSON.parse(localStorage.getItem('activityLog')) || [];

        // Add the new command to the log
        existingLog.push('Pressed: ' + command);

        // Save the updated log back to localStorage
        localStorage.setItem('activityLog', JSON.stringify(existingLog));
    }


    existingLog.forEach(function (entry) {
        var logEntry = document.createElement('p');
        logEntry.textContent = entry;
        activityLog.appendChild(logEntry);
    });

    document.getElementById('clearLogs').addEventListener('click', function () {
        // Clear the logs in localStorage and on the page
        localStorage.removeItem('activityLog');
        activityLog.innerHTML = ''; // Remove all child elements
    });

    function goBack() {
        window.history.back();
    }







/*document.addEventListener('DOMContentLoaded', () => {
    const video = document.getElementById('live-feed');
    const toggleCameraButton = document.getElementById('toggle-camera');

    let isCameraOn = true;

    // Function to toggle the camera on and off
    const toggleCamera = () => {
        if (isCameraOn) {
            // Stop the camera
            const tracks = video.srcObject.getTracks();
            tracks.forEach(track => track.stop());
        } else {
            // Start the camera
            navigator.mediaDevices.getUserMedia({ video: true })
                .then((stream) => {
                    video.srcObject = stream;
                })
                .catch((error) => {
                    console.error('Error accessing camera:', error);
                });
        }

        // Toggle the state
        isCameraOn = !isCameraOn;
    };

    // Attach the toggleCamera function to the button click event
    toggleCameraButton.addEventListener('click', toggleCamera);

    // Access the camera when the page loads
    navigator.mediaDevices.getUserMedia({ video: true })
        .then((stream) => {
            video.srcObject = stream;
        })
        .catch((error) => {
            console.error('Error accessing camera:', error);
        });
});*/