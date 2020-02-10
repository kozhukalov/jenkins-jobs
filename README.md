## Install Java and Groovy

They must be in your $PATH.

## Build DSL

```
./gradlew build
```

## Create/Edit job files

Put them to `jobs` directory

## Upload jobs to Jenkins

```
./gradlew rest -DbaseUrl=http://localhost:8888 -Dusername=admin -Dpassword=admin -Dpattern=jobs/**
```
