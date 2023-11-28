# Finder Pal - College Capstone Project

Welcome to the Finder Pal repository, a remarkable college capstone project focused on building an intelligent warehouse robot capable of automatic navigation, object recognition, and precise placement of items in predefined locations. This README provides an overview of the project, instructions for setup and usage, guidelines for contributing, and licensing information.

## Project Overview

Finder Pal is a cutting-edge warehouse robot developed as part of our capstone project for the Computer Science Program at the University of Michigan Flint. This project showcases our proficiency in robotics, computer vision, and autonomous navigation technologies. The primary objectives of Finder Pal include:

- **Automatic Navigation:** The robot can autonomously navigate within a warehouse environment to locate items and destinations.

- **Object Recognition:** Utilizing camera recognition, the robot can identify objects and categorize them for efficient handling.

- **Precise Item Placement:** Finder Pal can accurately pick up items and place them in predefined locations within the warehouse.

## Table of Contents

1. [Getting Started](#getting-started)
2. [Prerequisites](#prerequisites)
3. [Installation App](#installation-app)
4. [Installation Web](#installation-web)
5. [Configuration](#configuration)
6. [Usage](#usage)



## Getting Started

To set up Finder Pal on your local machine or hardware, follow these steps:

### Prerequisites

Before installing and using Finder Pal on your iPhone, please ensure that you meet the following prerequisites:

1. **iPhone Device:** Finder Pal is compatible with iPhone devices running iOS 15. To use the app, you need an iPhone with the required iOS version or a later one.

2. **Apple ID:** You will need an active Apple ID to access the App Store and download apps, including Finder Pal. If you don't have an Apple ID, you can create one during the app installation process.

3. **Internet Connection:** An active internet connection, either through Wi-Fi or cellular data, is necessary to download and install Finder Pal from the App Store. It is also essential for certain app features that rely on real-time data and updates.

4. **Sufficient Storage:** Ensure that your iPhone has sufficient storage space available to accommodate the app's installation. Finder Pal's size may vary based on updates and additional data.

5. **Location Services:** Some features within Finder Pal may require access to your device's location services. Please grant the necessary permissions when prompted for the best user experience.

By meeting these prerequisites, you'll be ready to install and use Finder Pal on your iPhone for efficient warehouse management and automation.


### Installation App

Finder Pal is available for installation on the Play Store for Android devices. To get started, follow these simple steps:

1. Open the App Store on your iPhone.

2. In the App Store's search bar, type "Finder Pal."

3. Find the Finder Pal app in the search results and tap on it.

4. Tap the "Install" button to download and install the app on your iPhone.

5. Once the installation is complete, you can find the Finder Pal app on your iPhone's home screen.

6. Launch the app, and you're ready to start using Finder Pal for your warehousing needs.

Please ensure that your iPhone meets the app's system requirements, and make sure you have an internet connection to download and install the app from the App Store.

For any support or technical assistance related to the installation and usage of Finder Pal, please reach out to our support team through the app.


### Installation Web

1. Download the Xampp server system

2. Download the mySQL workbench and server
    
4. Download the FinderPal-Web/styles folder and the users.sql file

5. Unzip the folder

6. Open the Xampp system and Start the Apache and MySQL modules

7. Open the Xampp explorer

8. Move the FinderPal-Web/styles folder into the xampp\htdocs folder

9. Open your local mySQL server instance

10. In the top navigation bar, go to server -> Data import

11. Check the "Import from Self-Contained File" option

12. Using the three dots on the left side, navigate to the users.sql file

13. Click the "New" button to change the schema name

14. Enter the name "finderpalusers"

15. Click the "Start Import" button

16. On the left side of the screen, refresh the "SCHEMAS" section, there should be a new "finderpalusers" Schema

17. Verify correct import by opening up the "tables" section, right-clicking the "users" table and click "Select Rows - Limit 1000" button

18. Verify there are 4 IDs currently within the table

19. Navigate to the http://localhost/dashboard/ page in your web browser, confirm the Xampp welcome page shows

20. Navigate to the http://localhost/FinderPal-Web/styles/FinderPalPhp.php page in your web browser and use one of the names from the sql table to log in


### Configuration

To make the most of Finder Pal within your warehouse environment, you may consider the following configuration options:

1. **Map and Layout:** Create a basic outline of the interior of your warehouse. You can upload a map or blueprint of your warehouse to the app, marking important landmarks, item storage areas, and docking stations. This map will help Finder Pal understand the layout and optimize its navigation.

2. **Object Database:** Populate the object recognition database with the types of objects commonly found in your warehouse. You can provide images and descriptions of items to improve the robot's object recognition accuracy. The more comprehensive the database, the more efficient Finder Pal becomes in identifying and handling items.

3. **Waypoints and Destinations:** Define waypoints and destinations within your warehouse. You can set up specific points where the robot should go for various tasks. Whether it's for picking up items, delivering items, or performing inspections, configuring these waypoints streamlines Finder Pal's operations.

4. **Safety Zones:** Implement safety zones and restricted areas within your warehouse to ensure safe and controlled robot movement. These configurations can help avoid collisions and ensure that the robot operates safely around human workers.

5. **Alerts and Notifications:** Configure alerts and notifications to keep you informed about the robot's progress and any issues that may arise during its operations. You can set up real-time alerts for tasks completion, low battery, or unexpected obstacles.

By carefully configuring Finder Pal according to your warehouse's specific requirements, you can maximize its efficiency and adapt it to your unique operational needs. Our user-friendly interface and intuitive tools make this process straightforward.


## Usage

Finder Pal can be used for various applications in the warehousing industry. Here are some key features and how to use them:

1. **Automatic Navigation:**
   
Set a route and the robot will follow it.
  
To set a route for Finder Pal, you can use our user-friendly interface or API. Define waypoints and destinations within the warehouse, and the robot will autonomously navigate the most efficient path to reach its destination. You can also monitor its progress in real- time using the control dashboard.

3. **Object Recognition:**
   
Decide what object the robot should find.
   
Finder Pal's object recognition system is highly adaptable. Specify the type or category of objects you want the robot to identify through our intuitive configuration interface. The robot's onboard cameras and AI algorithms will then scan the environment, identify the target objects, and provide real-time feedback on their locations, quantities, and conditions.

5. **Precise Item Placement:**
   
Finder Pal ensures precise and gentle item placement in predefined locations within the warehouse. Our system allows you to program item-specific placement instructions, including orientation, stacking, and safety measures. The robot's advanced gripper and sensors guarantee the secure handling and accurate positioning of items, reducing the risk of damage and optimizing warehouse efficiency.
