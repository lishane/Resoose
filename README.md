# Resoose

My submission for the 2017 Capitol One Software Engineering Summit

Resoose aims to solve the problem of choosing a place to eat. Where does the name come from? That's a good question It is actually just a combination of "Restaurant" and "Choose". When you put the two together, you get Resoose! Clever, right? I know, thanks :)

The app is deployed at https://resoose.herokuapp.com/, check it out!

Your location is based on HTML5 geoloation, if that is not available, San Francisco is used as default location.
### Design
The frontend for this app was designed to be a simple one page website. The whole point of using Resoose is so that you don't spend an insane amount of time trying to choose a place to eat, to the options are VERY limited. This is intentional. If I gave you too many options, I can only imagine the time you will spend messing with the different choices trying to get a restaurant you want to eat :)

The options provided are there because people look for different environments to eat in. Some are families, some are couples, and some are just a group of friends.

Your wallet is also a concern, I certainly don't want to force you to go bankrupt :/

### Technical Design
The choice of Java was because of my familiarty. I did not want to spend too much time on the backend since I knew I was going to have to spend time on the frontend. With balancing my midterms and schoolwork, I felt that using Java would be most time efficient even though it might not have been the most efficient method.

I used the Spring Framework to facilitate my backend, which helps a ton. May be overkill for a small project like this, but it ensures stability, security, and scalability, if I choose to do so in the future.

For the frontend, I'm using AngularJS. I followed a tutorial on google for creating a "Multi Step Form using UI-Router". Without it, I honestly would have been lost given the amount of time I had available to learn javascript.
