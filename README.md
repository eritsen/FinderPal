# FinderPal
CIT  485 - Capstone Project


For  the Image Recognition script you will need to download a Model available from
https://github.com/OlafenwaMoses/ImageAI/releases
This needs to be put in a folder labeled "DataSets" in the same directory as the script.
*Note the default is set to Yolov3, if you wish to use any other than you'll need to modify
the SetUpModel() function to reflect the correct model.


SaveVideo() - Saves the video with detected objects
CameraFeed() - Displays live camera feed with object detection
ImageCompare() - Compares two images for similarity and returns a percentage.
SetUpModel() - Sets up the model you want to use.
SaveObjects() - Captures recognized objects and store thems in a folder in the same directory as the script.
Requires an int value representing the amount of minutes you want the function to capture objects.