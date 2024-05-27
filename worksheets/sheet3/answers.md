## 2.

1. low coupling
2. controller/expert
3. 

- How can I find the responsible class for a method? 
  - Assign a responsibility to the information expert, the
  class that has the information necessary to fulfill the responsibility
    - This leads to methods being assigned to classes that have
    the necessary information to fulfill the responsibility of the method

- How can I find the responsible class for the creation of an object? (Creator Principle)
  - "Assign class B responsibility of creating instance
    of class A if"
    - B aggregates A objects
    - B contains A objects
    - B records instances of A objects
    - B closely uses A objects
    - B has initializing data for creating A objects

  - Key idea: the class creating an object will frequently use it, so look
  for class that frequently uses that object


- What is the Controller Principle?
  - Who should be responsible for handling system input/output?
  => class representing the overall system


## 3.

CRC Cards:

#### Class: WebSession
Responsibilities:
  - Handle user login/logout
  - Handle user interaction

Collaboration: 
  - DBManager
  - User

#### Class: DBManager
Responsibilities:
  - Handle database operations
  - Create/Read/Update/Delete Users

Collaboration:
  - User
  - WebSession
  - WebCheckService

#### Class: User
Responsibilities:
  - Store user information
  - Create WebCheck objects
  - Store WebCheck objects
  - Fetch WebCheck objects

Collaboration:
  - WebCheck
  - WebSession
  - DBManager

#### Class: WebCheck
Responsibilities:
  - Store check information
  - Store check results

Collaboration:
  - user
  - notifier


#### Class: WebCheckService
Responsibilities:
  - Check website status (function in webcheck)
  - Notify user of website status (function in notifier)

Collaboration:
  - Database
  - USer
  - WebCheck
  - Notifier