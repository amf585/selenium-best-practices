# Best Practices to Improve Your Selenium / Cucumber / TestNG Project

## Summary
The goal for this is to demonstrate some simple best practice examples for Selenium / Cucumber / TestNG

### **8 Best Practices for Selenium / Cucumber / TestNG**
1. Use **Page Object Model (POM)** for maintainability (LoginPage.java)
2. Implement `Data-Driven Testing` with Cucumber's `Scenario Outline` and `Examples` - (Login.feature#15)
3. Prefer **Explicit Waits** over `Thread.sleep()` - (LoginPage.java#33)
4. **Run tests in parallel** using TestNG - (testng.xml#2)
5. Use **Hooks/Annotations (`@Before`, `@After`)** in Cucumber for setup/teardown - (LoginSteps.java#19)
6. Manage dependencies with **Maven** - (pom.xml)
7. Use Assertions for Validations - (LoginSteps.java#59,64)

### Project Structure
selenium-best-practices/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/               # Page Object Model (POM) classes
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/               # TestNG test classes
│   │   │   ├── stepDefinitions/     # Cucumber step definitions
│   │   │   ├── runners/             # Cucumber TestNG runner classes
│   ├── resources/
│   │   ├── features/                # Cucumber feature files
│   │   ├── testng.xml               # TestNG suite configuration
│── pom.xml                          # Maven dependencies
│── .gitignore                       # Git ignore
│── README.md                        # Project documentation
