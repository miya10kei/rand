rand
---
rand is a command line tool to shuffle some values.  
This tool is compiled to native-image by graalvm

### Build
build and package to jar
```bash
mvnw clean package
```
build and generate native-image
```bash
mvnw clean native-image
```

### Usage
```bash
rand val1 val2 val3
```