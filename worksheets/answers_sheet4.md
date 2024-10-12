## Sheet 4

To test.test the system in a controlled environment, I installed 
Apache2 in a couple of simple steps:

### Apache2

Installation:
```
sudo apt update
sudo apt install apache2
sudo service apache2 webTracker
```

Now you can change the website on localhost quickly whenever and however is 
needed to test.test the website Monitor.
```
sudo nano /var/www/html/index.html
```


### Question 5. Options to reduce coupling

- abstraction, information hiding, encapsulation
  - information hiding: implementation details hidden, only expose what is necessary for interaction
  with other classes
  - encapsulation principle: bundle data and methods that operate on that data into a single unit (class)
  with the purpose of hiding the internal state
- modular design, separation of concerns, 
  - separation of concerns: break system into distinct loosely couple components,
  each responsible for a single aspect of functionality
    - impact: changes to one part of the system are less likely to affect other parts;
    modules are easier to change and reuse; allows easier development, testing and maintenance
  - (open closed principle: software should be open for extension, but closed for modification)
- package structure
  - group related classes together based on functionality and responsibility
  - classes that collaborate closely or server similar purposes should be in the same package
  - aiming for low coupling and high cohesion within packages
- no function call chains (law of demeter)
  - goal: decrease indirect dependencies between systems
  - Example 1:
    ```java
    person.getCar().getEngine().start(); // violates law of demeter
    person.startCar(); // hides the implementation details of the car class
    ```
    - Example 2:
    ```java
    String street = car.getOwner().getAddress().getStreet(); // violates law of demeter
    String string = car.getOwnerAdressStreet(); // follows law of demeter, but not really better as this is not really
    // following principle of "least knowledge", as the car class still knows about the street
    ```
    - Instead, think about the responsibilities of the car class.
      Does it really need to know about the owner's address?
    - Think about why this part of the programm needs the street from the cars owners address, maybe you want to know
      if the currently parked car is allowed to park in a certain street, so create `car.allowedToPark(Address address)`
      that returns a boolean. Then, the responsibility of checking the street is in the car class.
    ```java
    Address currentAddress = AddressService.getCurrentAddress();
    Boolean allowedToPark = car.allowedToPark(currentAddress);
  
    // in car class, implement a method that checks if the car is allowed to park in a certain street
    // also, the address class is responsible now for doing street comparisons
    public Boolean allowedToPark(Address address) {
        return address.streetWithin(owner.getAddress());
    }
    ```
- Dependency injection:
  - Constructor injection:
  ```java
  public interface ConnectionSetup {
      JdbcConnection getConnection();
  }
      
  public class JdbcConnectionSetup implements ConnectionSetup {
      @Override
      public JdbcConnection getConnection() {
          // Setup and return a JdbcConnection instance
          return new JdbcConnection();
      }
  }
      
  public class DatabaseService {
      private final JdbcConnection connection;

      public DatabaseService(ConnectionSetup connectionSetup) {
          this.connection = connectionSetup.getConnection();
      }

      // Other methods...
  }
  ```
  - The idea here is, that setting up the connection in the object, and other responsibility of the JdbcConnection can be handled elsewhere,
  and then the ready JdbcConnection can be injected when it's ready.
  - Also, these setup JdbcConnection objects can be injected anywhere, so we avoid code duplication.
  - Also, for testing purposes a mock object can be injected easily.



##### Questions:
1. Creator principle vs dependency injection:
   - creator principle says to assign the responsibility of creating an object to the class that frequently uses it
   - dependecy injection says create the object somewhere else and inject it where it's needed
   - so what's the difference?
   - 
2. Law of demeter vs creator principle
   - 