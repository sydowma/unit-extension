# JUnit Extensions

This repository contains a custom JUnit extension to handle global timeouts for test methods. The GlobalTimeOutExtension class helps to monitor the execution time of each test case and interrupts the test if it exceeds the specified timeout limit.

## Features

Automatically starts a timer before each test method.
Periodically prints the elapsed time for each test method.
Cancels the timer after each test method execution.
## Usage
Adding the Extension

To use the GlobalTimeOutExtension, add it to your JUnit test class with the @ExtendWith annotation:

```java
import com.sydowma.unitextension.GlobalTimeOutExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(GlobalTimeOutExtension.class)
public class MyTest {

    @Test
    void testMethod1() {
        // Your test code here
    }

    @Test
    void testMethod2() {
        // Your test code here
    }
}
```
## Implementation Details

The GlobalTimeOutExtension implements BeforeEachCallback and AfterEachCallback interfaces to manage the timer around each test method execution.


## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or additions.


