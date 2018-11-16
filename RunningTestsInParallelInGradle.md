###

```
test{
  maxParallelForks = 3
}  
```

However, not possible to  un tests in a single Test class in parallel (per method), the finest level of parallelisation is at the test class level

```
./gradlew clean test
```