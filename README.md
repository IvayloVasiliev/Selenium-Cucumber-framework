# Automation POM Framework

## Overview

This project is an automation framework based on the Page Object Model (POM) design pattern. It uses Java 21, Cucumber for BDD, Selenium 4 for web automation, and Maven for build and dependency management. The project is developed using IntelliJ IDEA.

## Technologies Used

- **Java**: 21
- **Cucumber**: For Behavior-Driven Development (BDD)
- **Selenium**: 4
- **Maven**: 3.9.5
- **IDE**: IntelliJ IDEA

## Features

- **Modular Design**: Based on the Page Object Model for better maintainability and scalability.
- **BDD with Cucumber**: Write test scenarios in a human-readable format.
- **Cross-browser Testing**: Supports multiple browsers.
- **Easy Integration**: Easily integrate with CI/CD tools.

## Project Structure
- ├── src
- │ ├── main
- │ │ ├── java
- │ │ │ └── com
- │ │ │ └── example
- │ │ │ ├── pages
- │ │ │ └── utils
- │ │ └── resources
- │ └── test
- │ ├── java
- │ │ └── com
- │ │ └── example
- │ │ ├── runners
- │ │ └── stepdefinitions
- │ └── resources
- │ └── features
- ├── pom.xml
- └── README.md

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 21**: Make sure JDK 21 is installed and `JAVA_HOME` is set.
- **Maven 3.9.5**: Ensure Maven is installed and `MAVEN_HOME` is set.
- **IntelliJ IDEA**: Recommended IDE for development.

### Installation

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/IvayloVasiliev/Selenium-Cucumber-framework.git
    cd Selenium-Cucumber-framework
    ```

2. **Open the Project in IntelliJ IDEA**:
    - Open IntelliJ IDEA.
    - Click on `File` > `Open` and select the `automation-pom-framework` directory.

3. **Import Maven Dependencies**:
    - IntelliJ should automatically detect the `pom.xml` file and import the Maven dependencies. If not, right-click on the `pom.xml` file and select `Maven` > `Reload Project`.

4. **Build the Project**:
    - Open the terminal in IntelliJ IDEA and run:
      ```bash
      mvn clean install
      ```

### Running Tests

1. **Using Maven**:
    - Run the tests using the following command:
      ```bash
      mvn test
      ```

2. **Using IntelliJ IDEA**:
    - Right-click on the test runner class or the feature file and select `Run`.

### Project Configuration

- **Cucumber Feature Files**: Located in `src/test/resources/features`.
- **Step Definitions**: Located in `src/test/java/com/example/stepdefinitions`.
- **Page Objects**: Located in `src/main/java/com/example/pages`.
- **Utility Classes**: Located in `src/main/java/com/example/utils`.

### Adding New Tests

1. **Create a New Feature File**:
    - Add a new `.feature` file in `src/test/resources/features`.

2. **Add Step Definitions**:
    - Create a corresponding step definition class in `src/test/java/com/example/stepdefinitions`.

3. **Create/Modify Page Objects**:
    - Add or modify page object classes in `src/main/java/com/example/pages`.

## Contributing

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-branch`.
3. Make your changes and commit them: `git commit -m 'Add new feature'`.
4. Push to the branch: `git push origin feature-branch`.
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or suggestions, feel free to open an issue or contact me at [ivailo_vasiliev@hotmail.com](mailto:your-email@example.com).
