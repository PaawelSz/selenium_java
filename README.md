# MY_LOCAL_JAVA_SELENIUM

A demo project for UI test automation in Java using Selenium WebDriver, JUnit 5, and Maven. Tests are executed against a locally running application (`http://localhost:8080/`).

## Requirements

- Java 17+
- Maven 3.6+
- Google Chrome (or another supported browser)
- Application running locally at `http://localhost:8080/`

## Installation

1. Clone the repository:
   https://github.com/PaawelSz/MY_LOCAL_JAVA_SELENIUM.git 
2. Install dependencies:

    mvn install
3. ## Running Tests

Make sure your application is running at `http://localhost:8080/`, then execute
## Project Structure

- `src/main/java/` – source code (page objects, base methods, driver providers)
- `src/test/java/` – JUnit tests
- `src/test/resources/` – configuration files

## CI Configuration

The project includes a sample GitHub Actions workflow (`.github/workflows/ci.yml`) for automatic build and test execution.

## Headless Mode

Tests run in headless mode (no GUI), which allows execution on CI servers.

## Author

PaawelSz

---

**Note:** Before running tests, ensure your application is available at `http://localhost:8080/`.
