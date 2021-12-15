The Mountain is Calling
============

### A ski/snowboard trip organizing & planning app

The Mountain is Calling project is designed to make skiers and snowboarders' winter planning more convenient. The website will generate a list of mountains in the US,
along with the weather condition. 
Each user will have the ability to select their favorite mountain(s), and the website will always display their favorite mountain(s) at the top of the page.

Each user will be able to purchase hotel and flight tickets in the app, and the app will keep a record of each trip. This way the user will not need to buy tickets separately 
on a hotel or flight ticket website. 

## Features

1. User Login
2. User's favorite mountains
3. Select each mountain, the hotel and flight information will be displayed
4. Purchase flight tickets, or book a hotel
5. Keeps track of each user's plan

## Tech Stack

1. Database: MySQL
2. Server: Springboot
3. Frontend: Bootstrap Table, html

## API reference

1. Used Open Weather Map as the source of weather information: [OpenWeatherMap](https://openweathermap.org/api/one-call-api)
2. Still waiting on Booking.com's API to gather real-time flight and hotel information. Currently flight and hotel information are stored in local database


## Information Update

Weather information is updated daily (see WeatherUpdate class)

In the future when implementing real-time hotel and flight information, the hotel and flight info update will be in real-time.


## Future Work

1. Booking.com API to gather hotel and flight information
2. Host the database on AWS
