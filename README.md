## Embedded System Assignments

### Group : Thomas Guillaume 18929049 | Victor Hinaux 18129049

# Project
A gym club application.

## Assignment 1
For this first assignment, we only designed the user interface of the app. We started by a splash screen which show the logo and redirects to another screen. The user can choose to sign up or sign in. If he wants to sign up, he have to enter his first and last name, an email address and a password. If he wants to sign in, he have to enter his email and password. Then, he arrives on the home page, where he is supposed to see the news of the gym club in a list view. He can go to the booking page or to his account page thanks to a bottom navigation bar and a system of fragments. On the booking page, the user can choose a date and trainers in order to book a training. On his account page, he can change his password, go to the settings of the app, or log out.

## Assignment 2
We implemented the signup/login feature for this assignment. We decided to use SQLite to be easier so it is a local database. A user can signup indicating his first name and last name, email address, password and a confirmation of the password. Then, he can login using his email address and password. If the user does not complete all the information, an error is displayed. If he does not use correct inputs like the wrong password or an existing email address to signup, an error is displayed. If all is correct, the user can access the dashboard activity. When the user is on the dashboard, he can access a list of video or the personal trainers list. We used a recycler view and card views to display the personal trainers list.

## Assignment 5
We chose to enable the user to login to the gymclub app with a facebook account. To do that, we followed the different steps from the facebook developers website. The user only have to click on the facebook widget button and he will be redirected to signin with his facebook account.
