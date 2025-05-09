# JaCoCo Code Coverage

This project uses JaCoCo for code coverage analysis.

## Configuration

JaCoCo has been configured in the `build.gradle` file with the following features:

1. The JaCoCo plugin is applied to the project
2. Test reports are automatically generated after tests run
3. Both HTML and XML reports are generated
4. A minimum code coverage threshold of 50% is enforced

## Usage

### Running Tests with Coverage

To run tests and generate coverage reports:

```bash
./gradlew test
```

This will automatically generate JaCoCo reports due to the `finalizedBy jacocoTestReport` configuration.

### Verifying Coverage

To verify that code coverage meets the minimum threshold:

```bash
./gradlew checkCoverage
```

This task:
- Runs all tests
- Generates JaCoCo reports
- Verifies that code coverage meets the 50% threshold

### Viewing Reports

JaCoCo reports are generated in the following locations:

- HTML Report: `build/reports/jacoco/index.html`
- XML Report: `build/reports/jacoco/test/jacocoTestReport.xml`

The HTML report provides a user-friendly interface to explore code coverage details.

## Customization

You can customize the JaCoCo configuration in the `build.gradle` file:

- Change the minimum coverage threshold by modifying the `minimum` value in the `jacocoTestCoverageVerification` task
- Adjust report formats by modifying the `reports` section in the `jacocoTestReport` task
- Update the JaCoCo version by changing the `toolVersion` in the `jacoco` block