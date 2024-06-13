# Machine Application Problem Description

## Overview
Develop a machine application with three distinct user roles: Admin, Trainer, and Student. Each role will have specific functionalities designed to manage and interact with the system efficiently.

## User Roles and Functionalities

### Admin
The Admin has the following capabilities:
- **Add Questions**: Ability to add new questions. Each question should have:
    - Unique ID
    - Question text
    - Multiple options
    - Correct option
    - Difficulty level (easy, medium, hard)
- **Delete Questions**: Ability to delete existing questions by their unique ID.
- **View Questions**: Ability to view all questions along with their details.

### Trainer
The Trainer has the following capabilities:
- **Assign Test**: Create and assign tests to students. The test creation should include:
    - Number of questions
    - Distribution of difficulty levels (easy, medium, hard)
- **View Scores**: Ability to view the scores of all students who have taken the test.
- **Identifiers**:
    - Trainer ID to specify the trainer.
    - Test ID to specify the test.

### Student
The Student has the following capabilities:
- **Take Test**: Ability to take tests assigned by trainers. Each student should:
    - Have a unique ID for identification.
    - Be able to attend the test and answer the questions.
- **View Scores**: Ability to view the marks scored at the end of the test.



### Directory Structure
```
src
├── controller
│   ├── AdminController.java
│   ├── StudentController.java
│   └── TrainerController.java
├── model
│   ├── Question.java
│   ├── Test.java
│   └── Score.java
├── repository
│   ├── QuestionRepository.java
│   │   └── InMemoryQuestionRepository.java
│   └── TestRepository.java
│       └── InMemoryTestRepository.java
├── service
│   ├── AdminService.java
│   ├── StudentService.java
│   └── TrainerService.java
└── Main.java
```
