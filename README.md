# Resoose

My submission for the 2017 Capitol One Software Engineering Summit

Resoose aims to solve the problem of choosing a place to eat. Where does the name come from? That's a good question It is actually just a combination of "Restaurant" and "Choose". When you put the two together, you get Resoose! Clever, right? I know, thanks :)

The app is deployed at https://resoose.herokuapp.com/, check it out! Might be a little slow, so give it sometime to run, especially on the results page. There is a small bug where sometimes the google map function might not work correctly.

Your location is based on HTML5 geoloation, if that is not available, San Francisco is used as default location.

### Design
The frontend for this app was designed to be a simple one page website. The whole point of using Resoose is so that you don't spend an insane amount of time trying to choose a place to eat, to the options are VERY limited. This is intentional. If I gave you too many options, I can only imagine the time you will spend messing with the different choices trying to get a restaurant you want to eat :)

I have limited the options down to two. Restaurant environment and price. These are two options I believe are pretty important and should be decided before choosing a restaurant. There is also the option of using a completely random one if you are feeling adventurous.

### Technical Design
The backend for this project was written in Java. The choice of Java was because of my familiarty. I did not want to spend too much time on the backend since I knew I was going to have to spend time learning the frontend. With balancing my midterms and schoolwork, I felt that using Java would be most time efficient even though it might not have been the most efficient method.

I used the Spring Framework to facilitate my backend, which helps a ton. May be overkill for a small project like this, but it ensures stability, security, and scalability, if I choose to do so in the future.

For the frontend, I'm using javascript with the Angular framework. I followed a tutorial on google for creating a "Multi Step Form using UI-Router" as a starting point. Using javascript really allowed me to quickly develop the frontend and call my backend APIs. It makes it really easy to manipulate the data to my needs, and generate different views.
