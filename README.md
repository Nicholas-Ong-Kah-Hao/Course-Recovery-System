# Course Recovery System (CRS)

Course Recovery System (CRS) is a Java-based GUI application developed for educational institutions to manage students who need to recover failed or incomplete courses. The system helps academic officers and course administrators monitor student performance, manage course recovery plans, check progression eligibility, and support academic decision-making.

## Project Overview

The purpose of this system is to help institutions streamline the course recovery process so that students can stay on track academically without unnecessary graduation delays. The application is designed using Object-Oriented Programming (OOP) principles and follows the assignment requirements for a GUI-driven Java system. :contentReference[oaicite:1]{index=1}

## Target Users

- Academic Officer
- Course Administrator

## Main Features

### 1. User Management
- Add, update, and deactivate user accounts
- Login and logout functionality
- Authentication and authorization
- Role-based access control
- Password reset and recovery
- Log login and logout timestamps in binary form

### 2. Course Recovery Plan
- View failed course components for a student
- Add, update, and remove recovery recommendations
- Add, update, and remove milestones and action plans
- Monitor and track recovery progress
- Record grading updates for recovery activities

### 3. Eligibility Check and Enrolment
- Identify students who are not eligible to progress
- Check progression based on:
  - Minimum CGPA of 2.0
  - No more than three failed courses
- Allow registration when eligibility is confirmed

### 4. Academic Performance Reporting
- Generate academic performance reports by semester and year of study
- Export reports to PDF
- Summarize student grades, CGPA, and academic progress

### 5. Email Notifications
- Send automated email notifications for:
  - User account management
  - Password recovery
  - Recovery milestones and action plans
  - Academic performance reports

## Course Recovery Policy
- Each course allows up to three attempts to pass
- The second attempt only requires passing the failed component through resubmission or resit
- If the student fails the first and second attempts, the third attempt requires all assessment components to be referred again :contentReference[oaicite:2]{index=2}

## Technologies Used

- Java
- Java GUI
- Object-Oriented Programming concepts
- Text or binary files for data storage
- Java Mail API for email notifications
- iText PDF for report generation :contentReference[oaicite:3]{index=3}

## Object-Oriented Concepts Applied

This project applies key OOP concepts, including:
- Classes and objects
- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Modularity
- Package organization :contentReference[oaicite:4]{index=4}

## Data Storage

The system uses text files or binary files for data access and manipulation, as required by the assignment specification. :contentReference[oaicite:5]{index=5}

## General Requirements
- GUI-driven application
- Input validation for user entries
- Compiles and runs without errors
- Highlights the use of Object-Oriented Programming concepts
- Uses Java only for implementation :contentReference[oaicite:6]{index=6}

## Project Structure
Example structure:

```text
Course-Recovery-System/
├── src/
├── target/
├── data/
