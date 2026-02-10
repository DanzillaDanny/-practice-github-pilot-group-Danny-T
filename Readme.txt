AI Fundamentals Lesson 2
Group Practice: Collaborate on a
SpringBoot ClassManager project
using GitHub Copilot
Instructions
This group project will give you the opportunity to work together to develop a
simple SpringBoot application using Git and GitHub to collaborate and GitHub
Copilot to help you write the code. This activity will reinforce your ability to
collaborate using Git and GitHub and your ability to use AI tools to help you write
code.
The team should work together to develop a simple class manager application
making heavy use of GitHub Copilot to generate the code. This application should
provide a simple REST API for managing teachers and students stored in a
PostgreSQL database. The application should have the following endpoints:
● GET /teachers - Get a list of all teachers
● GET /teachers/{id} - Get a specific teacher by ID
● POST /teachers - Create a new teacher
● PUT /teachers/{id} - Update an existing teacher
● DELETE /teachers/{id} - Delete a teacher by ID
● GET /students - Get a list of all students
● GET /students/{id} - Get a specific student by ID
● POST /students - Create a new student
● PUT /students/{id} - Update an existing student
● DELETE /students/{id} - Delete a student by ID
1
Steps
Step 1: Choose a Captain
Choose a team captain who will host and do the initial setup of the project. This
member should share screen until later steps.
Step 2: Create a New SpringBoot Project
Use Spring Initializr to create a new SpringBoot project with the following
dependencies:
● Spring Web
● Spring Data JPA
● PostgreSQL Driver
Note: For the sake of simplicity, we will not be implementing
authentication in this project.
Step 3: Create the GitHub Repository
The team captain should create a new GitHub repository for the project on their
account and push the initial project code to the repository with IntelliJ IDEA.
Step 4: Add Other Group Members as GitHub Collaborators
The team captain should add the other group members as collaborators on the
GitHub repository. You can do this by going to the repository settings and selecting
the "Collaborators" tab.
Have each member clone the repository to their local machine so that each of you
have a copy.
Step 5: Develop the Project Using GitHub Copilot Driving
To get used to using AI in a collaborative environment, the team should take turns
"driving." The driver is the person who is currently sharing their screen and writing
code. When you need to switch drivers, the current driver should commit and push
their changes to the repository, and then the next driver should load their copy into
2
IntelliJ IDEA, pull the changes using the "Source Control" tab, and then share their
screen and continue coding.
Step 6: Forking
Once you are all done with the project, each member should fork the repository to
their own GitHub account so that they have their own separate copy for review and
portfolio purposes.
Setup
For this activity, you will create a group repository with your code:
1. Create a new repository.
2. Name it: practice-github-pilot-group[Your First Name]-[Your Last Initial]
3. Make sure the repository is public.
4. Clone the repository to your local machine.
5. Start working on the code.
6. When you are finished, commit your changes and push them to your
repository.
Submission
Submit the url for your GitHub repo in the field below.
