# Java HackerRank Solutions

[My HackerRank Profile](https://www.hackerrank.com/dwarnold)

NB. My latest solutions are in [Python](https://github.com/d-w-arnold/python-hackerrank) ^_^

The `src` directory contains a hierarchy of Java solutions for different HackerRank problems.

The `tests` directory contains a hierarchy of unit test classes, with each unit test class corresponding to a specific
HackerRank problem.

### Run all Unit Tests

```shell
mvn clean test
```

### Add Git Hooks

See `pre-push` shell script in `hooks/`. When pushing to the `main` branch, a push is only successful when all unit
tests pass.

To utilise this `pre-push` git hook, run the following commands in the project root directory:

```shell
# Copy all repo git hooks, into the `.git/hooks/` dir.
cp -av hooks/* .git/hooks

# Set all git hooks to executable, if not already set.
chmod +x .git/hooks/*
```
