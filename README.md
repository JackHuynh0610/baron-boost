# Game Boosting App

Welcome to the Baron Boosting WebApp! This README provides an overview of the app's features, and how to use the app effectively.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Usage](#usage)
    - [For Users](#for-users)
    - [For Boosters](#for-boosters)
4. [API Documentation](#api-documentation)
5. [App Flows](#app-flows)

## Introduction

The Game Boosting App connects gamers with professional boosters. Users can order boosting services for their favorite games, and boosters can accept these orders and complete the tasks to help users achieve their gaming goals.

## Features

- **User Account Management**: Users can create and manage their accounts, update information, and view order history.
- **Booster Account Management**: Boosters can create accounts, pick up one order of their choosing, and boost.
- **Order Placement**: Users can browse available boosting services and create orders for specific games and tasks.
- **Order Management**: Boosters can view and accept not taken orders then the order will update its status to taken.
- **Secure Payment System**: Integrated payment gateway for secure transactions between users and boosters (PayPal).
- **Rating and Review System**: Users can rate and review boosters based on their performance (TrustPilot).

## Usage

### For Users

1. **Sign Up / Log In**:
   - Navigate to the homepage.
   - Click on the "Sign Up" button to create a new account or "Log In" if you already have an account.
   - Fill in the required details and submit the form.

2. **Browse Services**:
   - Once logged in, browse the list of available boosting services.
   - Use filters to narrow down the services by game, type of boost, or booster ratings.

3. **Place an Order**:
   - Select the desired boosting service.
   - Provide necessary details such as game account information and specific instructions for the booster.
   - Confirm your order and proceed to payment.
   - Once paid, user order details can't be changed.
   - To make changes in order details, contact us or make an inquiry.

4. **Rate and Review**:
   - After the order is completed and the status changes to COMPLETED, the user can view order history.
   - Users can visit TrustPilot to provide ratings and reviews.

### For Boosters

1. **Sign Up / Log In**:
   - Navigate to the homepage.
   - Sign up with us via Google form.
   - Fill in the required details and submit the form.
   - Once we approve, you will receive an email containing login information to a booster account created by us.

2. **View Orders**:
   - Go to the orders section to view a list of available orders.
   - Use filters to find orders that match your skills and availability.

3. **Accept an Order**:
   - Once you select an available order, your booster account will be in "Boosting" state (you can't boost another account until the current one is completed).
   - Click on "Boost" to take up the task. The order status will update to "Taken".

4. **Complete the Order**:
   - Follow the instructions provided by the user to complete the boost.
   - If you fail to continue, please make an inquiry with admin via contact us. We will free the contract between your account and the boosting account so another booster can pick it up.
   - If a booster fails to boost or play a single game in 3 consecutive days, the customer can make a report, then the booster will no longer be responsible for that account and will not receive any pay-outs.

5. **Update Order Status**:
   - Once you have completed the boost, make an inquiry with us that you have completed an order with its details.
   - The order status will be changed to "Completed".
   - The booster will get paid immediately.

## API Documentation

### League Orders Endpoints

- **GET: "/api/leaguePrices/soloOrder"**: Get solo order prices.
- **GET: "/api/leaguePrices/duoOrder"**: Get duo order prices.
- **GET: "/api/leaguePrices/netWinOrder"**: Get netwin order prices.
- **GET: "/api/leaguePrices/coachorder"**: Get coach order prices.

- **GET: "/api/orders"**: Returns all league orders.
- **GET: "/api/orders/soloOrders"**: Returns all solo orders.
- **GET: "/api/orders/duoOrders"**: Returns all duo orders.
- **GET: "/api/orders/coachOrders"**: Returns all coach orders.
- **GET: "/api/orders/netWinOrders"**: Returns all net win orders.

- **GET: "/api/orders/username/{username}"**: Returns all orders associated with a specific username.
- **GET: "/api/orders/status/{status}"**: Returns all orders with a specific status.
- **GET: "/api/orders/soloOrder/{id}"**: Returns a specific solo order by its ID.
- **GET: "/api/orders/duoOrder/{id}"**: Returns a specific duo order by its ID.
- **GET: "/api/orders/coachOrder/{id}"**: Returns a specific coach order by its ID.
- **GET: "/api/orders/netWinOrder/{id}"**: Returns a specific net win order by its ID.

- **POST: "/api/orders/soloOrder"**: Creates a new solo order.
- **POST: "/api/orders/duoOrder"**: Creates a new duo order.
- **POST: "/api/orders/coachOrder"**: Creates a new coach order.
- **POST: "/api/orders/netWinOrder"**: Creates a new net win order.

- **DELETE: "/api/orders/soloOrder/{id}"**: Deletes a specific solo order by its ID.
- **DELETE: "/api/orders/duoOrder/{id}"**: Deletes a specific duo order by its ID.
- **DELETE: "/api/orders/coachOrder/{id}"**: Deletes a specific coach order by its ID.
- **DELETE: "/api/orders/netWinOrder/{id}"**: Deletes a specific net win order by its ID.

- **PATCH: "/api/orders/soloOrder/{id}/status/{soloOrderStatus}/username/{username}"**: Updates the status of a specific solo order by its ID. Username is the current user.
- **PATCH: "/api/orders/duoOrder/{id}/status/{duoOrderStatus}/username/{username}"**: Updates the status of a specific duo order by its ID. Username is the current user.
- **PATCH: "/api/orders/coachOrder/{id}/status/{coachOrderStatus}/username/{username}"**: Updates the status of a specific coach order by its ID. Username is the current user.
- **PATCH: "/api/orders/netWinOrder/{id}/status/{netWinOrderStatus}/username/{username}"**: Updates the status of a specific net win order by its ID. Username is the current user.

### Users Endpoints

- **GET: "/api/users"**: Returns all users.
- **GET: "/api/users/{id}"**: Returns a specific user by their ID.
- **GET: "/api/users/username/{username}"**: Returns a specific user by their username.

- **POST: "/api/users"**: Creates a new user.

- **DELETE: "/api/users/{id}"**: Deletes a specific user by their ID.
- **DELETE: "/api/users/username/{username}"**: Deletes a specific user by their username.

- **PUT: "/api/users/{id}"**: Updates a specific user by their ID.
- **PUT: "/api/users/username/{username}"**: Updates a specific user by their username.

- **PATCH: "/api/users/{id}/boostStatus/{status}"**: Updates the boost status of a specific user by their ID.
- **PATCH: "/api/users/username/{username}/boostStatus/{status}"**: Updates the boost status of a specific user by their username.

### Security Endpoints

- **POST: "/api/authenticate/signup"**: Registers a new user. It will also send email to verify the user provide correct email address. 
                                        If yes they can signin other wise they unauthorize.            
- **POST: "/api/authenticate/signin"**: Authenticates a user and returns a token.

### ForgetPassword Endpoints

- **POST: "/updatePassword/forgotPassword"**: Sends a password reset link to the user's email. If click user will get redirect to HTML form to reset password.


## App Flows

## Post Deployment Setup

### Create Admin Users
- Initially, create two admin users to prevent unauthorized admin account creation. (2 admin only)
- Admin users will have full control over the application, including access to all endpoints and database manipulation.

## User Workflow

### User Registration
- **Endpoint**: **POST: "/api/authenticate/signup"**
- **Description**: Registers a new user as either a CUSTOMER, BOOSTER, or ADMIN.
- **Process**:
  1. User submits the registration form.
  2. A verification email from BaronBoost is sent to the user.
  3. Upon clicking the verification link, the user is enabled to sign in and access authorized endpoints.
  4. If the user fails to verify, they cannot sign in or access any endpoints.

### Password Recovery
- **Endpoint**: **POST: "/api/authenticate/resetPassword"**
- **Description**: Resetting user password via email confirmation.
- **Process**:
  1. If a user forgets their password, they can click "Forget Password" on the frontend.
  2. An email will be sent to the user to confirm their identity and allow them to update their password.

### Order Placement
- **Endpoint**: **POST: "/api/orders/{gameOrder}"**
- **Description**: Creating orders.
- **Process**:
  1. Users can navigate the UI to place a boost order.
  2. After filling out the necessary information, the UI will prompt the user to confirm the details and proceed with payment.
  3. Once paid, the order information is locked and cannot be changed by the user.

- **Issues**:
  - If there is incorrect information, users can make inquiries through a form send message to the BaronBoost email.

- **Solution**:
  - Then admins can view issues through email and can take down incorrect orders from the database and ask users to create new ones through email. If need refunds may take up to 5 days.

### Order Fulfillment
- **Process**:
  1. Upon order creation, the order state is set to `NOT_TAKEN`.
  2. When a booster picks up the order, the state changes to `TAKEN`.
  3. An email is sent to the user and admin with booster details when the order is picked up.
  (BOOSTER is the only role can pick up orders, so when booster pick up orders, JS will extract booster details and notify the user and admin via email).

### Order Issues
- **Issues**:
   1.  If an order remains untaken for a long time.
   2. Orders being held by booster for a long time.
   3. Booster fails to complete it.

- **Solution**:
   1.  Users can report issues via email to baronboostservice@gmail.com.
   2.  Admins can resolve issues by viewing issues via email.
      -  Take appropriate action such as:
         -  Increasing payout prices (for issue 1)
         -  Resetting order state to `NOT_TAKEN` through Database, and freezing the booster’s account for a set period if necessary. (for issue 2, 3)

## Booster Workflow

### Browsing Orders
- **Process**:
  1. Boosters can browse and select `NOT_TAKEN` orders in the UI. `TAKEN` orders will still be display but can't be taken.
  2. Order cards display current rank/division, desired rank/division, game title, and payouts.
  3. Upon clicking "Boost", a confirmation popup appears. 
  4. If confirmed, an email with order/account details is sent to the booster from Baronboost's email, and an email notification is sent to the user and admin(baronboost). Nothing happend if canceled.

### Boosting Process

#### Successful Boost
- **Process**:
  1. Boosters complete the order and submit a form with account details and proof of completion.
  2. Admins verify the boost and switch the order status to `COMPLETE` in the Database, then manually payout the booster.

#### Failed Boost
- **Solution**:
  1. Boosters submit a form indicating failure, including account details.
  2. An email is sent to the user and admin notifying them of the failed boost.
  3. Admins reset the order state to `NOT_TAKEN` through Database for another booster to pick up.


## What to expect at BaronBoost and our promises
- **The Purge**
It's an event at BaronBoost where we will stop all incoming order and complete all the exisiting order before wiping the entire database to ensure all user information are gone. This help keep our database cost down while be able to provide high payouts rate for booster, lower price for customer and keeping user information safe from unwanted "visitor".

- **Policy**
1. Once order is completed, there will be no refund.
2. We recommend you change your game password frequently especially after using our service for safety measure.
3. By using our services you agree to share these following data with us:
   - game login information (username, password)
   - personal email
4. By using our services you agree not to login or vadalising current state of the account until boost is completed.(there will be no refund)
5. If you decided to contact and pay booster without going through us we will not responsible for your order. And we will not refund or taking any action for you or that booster. 

5. For Booster, by using our services you agree not to vandalising user account, in game chatting, boosting when account details is not correct. Violating this will result in no payouts for that months and your boost account will be freeze.
6. For Booster, by using our services you agree to complete the order as soon as possible. Holding the order more than 2 weeks without any progress or get report by the customer will put you on our watch list for investigation and might result in no payouts and boost account freeze.
7. For Booster, by using our services you agree to follow the guide lines we provide fail to follow will result in penalty.
8. For Booster, by using our services you agree not to save user password or login user account without a contract.

- **Promise**
1. Your account data will be safe with us and we will not save any of your information for more than a year due to the cleanse.
2. We will not share your email with anyone. Here at Baronboost we respect privacy and security. 
3. We guarantee refund in these cases.
   - Order could not be fulfilled.
   - Customer canceled order before its get pick up.
   - Booster vandalising user account.
   - Account get banned during boosting services. (We will refund the money + giving user new account with fresh MMR or with higher MMR + a free coaching session)
   - Error in order informations. (wrong game username/password ...etc).
4. Not to boost your account if the account details does not match with the account we log in.
5. To provide the most affordable price for the user and the highest possible payouts rate for the booster.
---

This README provides a comprehensive guide to the Baron Boosting WebApp, ensuring both users and boosters can navigate and utilize the platform effectively. For any additional information or support, please contact us.
