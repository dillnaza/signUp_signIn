# User Authentication and Password Management System

This Java application provides a user authentication and password management system. Users can sign up, sign in, and reset their passwords via email. The system ensures the security of user passwords through encryption using the PBKDF2 algorithm with HMAC-SHA1.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Features](#features)
- [Usage](#usage)
- [Code Overview](#code-overview)

## Getting Started

Follow these instructions to set up and run the User Authentication and Password Management System on your local machine.

## Prerequisites

Before you begin, make sure you have the following dependencies installed:
- Java Development Kit (JDK)
- PostgreSQL Database
- JavaMail API (for sending emails)
- Secure Sockets Layer (SSL) certificate (for Gmail SMTP)

## Features

The application includes the following features:
1. **User Registration**: Users can create accounts with the following details:
   - Login
   - Individual Identification Number (IIN)
   - Telegram username
   - Email
   - Password
2. **User Authentication**: Users can sign in with their login or IIN and password.
   - Passwords are securely stored and authenticated using the PBKDF2 algorithm.
3. **Password Reset via Email**: Users can request a password reset via email.
   - A reset code is sent to the user's registered email address.
   - Users can set a new password after entering the correct reset code.
4. **Telegram Notification**: The application can send notification messages to a Telegram chat when users sign in.

## Usage

Follow these steps to run the application:
1. **Set Up the Database**:
   - Create a PostgreSQL database.
   - Configure the database connection in the code by modifying the `jdbcUrl`, `userName`, and `MasterPassword` variables in the `Shape` class.
2. **Configure Email and Telegram**:
   - Set up a Gmail account and enable "less secure apps" to send emails via Gmail.
   - Replace `"dilnazbaidakhanova@gmail.com"` and `"GMAILCODE"` in the `PasswordReset` class with your Gmail credentials.
   - Create a Telegram bot and obtain a token.
   - Replace `"tg_token"` and `chatId` in the `TelegramNotification` class with your Telegram bot token and chat ID.
3. **Run the Application**:
   - Compile and run the `Main` class to launch the GUI.
   - Use the GUI to sign up, sign in, and reset passwords.

## Code Overview

The codebase is organized into several classes:
- `PasswordEncryptionService`: Handles password encryption and authentication.
- `PasswordReset`: Manages password reset via email.
- `Shape`: An abstract class with common properties and methods.
- `SignIn`: Manages user sign-in and authentication.
- `SignUp`: Handles user registration and input validation.
- `TelegramNotification`: Sends notifications to a Telegram chat.
- `Implementation`: The main class that manages the GUI and user interactions.
