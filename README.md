# rand
This is a command line tool to shuffle some values.  

# Usage
```bash
rand val1 val2 val3
```

# Build
## Requirements
- Java 11+
- GraalVM 20.2.0

## Command
build and package to jar
```bash
mvnw clean package
```
build and generate native-image
```bash
mvnw clean native-image
```
