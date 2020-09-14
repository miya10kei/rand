# rand
![CI](https://github.com/miya10kei/rand/workflows/CI/badge.svg)  

This is a command line tool to do following tasks
- shuffle some values
- generate random values

# Usage
## shuffle
```bash
$ rand val1 val2 val3
1: val1
2: val3
3: val2
```

## generate
```bash
$ rand -n 5 --min 10 --max 15
1: 12
2: 15
3: 15
4: 15
5: 14
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
build and package to jar then generate native-image
```bash
mvnw clean package -Dnative.skip=false
```
