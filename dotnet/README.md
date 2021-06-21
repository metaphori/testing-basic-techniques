# Basic Testing Techniques (.NET Core)

## Project setup

```
dotnet new sln --name testing-basics
dotnet new classlib -n u02-unit-testing
dotnet build u02-unit-testing
dotnet new xunit -n test-u02-unit-testing
dotnet add test-u02-unit-testing reference u02-unit-testing
dotnet test test-u02-unit-testing
```

## Units

## Contacts

- Roberto Casadei, roby [dot] casadei [at] unibo [dot] it
