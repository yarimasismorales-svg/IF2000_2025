# Copilot Instructions for IF2000_Lab3 Domain Codebase

## Overview
This codebase models a simple banking domain in Java. It consists of several classes representing core entities and their relationships:

- `Account.java`: Abstract base class for bank accounts.
- `CheckingAccount.java` / `SavingAccount.java`: Concrete account types with specific behaviors.
- `Bank.java`: Manages accounts and operations.
- `Person.java`: Represents account holders.
- `LogEntry.java`: Used for logging actions/events.
- `TestProgram.java`: Main entry point for running and testing the system.

## Architecture & Data Flow
- **Accounts** are associated with a `Person` and managed by the `Bank`.
- **Bank** acts as the central service, providing methods to create accounts, perform transactions, and maintain logs.
- **LogEntry** objects are used to record significant actions (e.g., deposits, withdrawals).
- **Inheritance**: `CheckingAccount` and `SavingAccount` extend `Account`, overriding methods for account-specific logic.

## Developer Workflows
- **Build**: Compile all `.java` files in the root directory. Example:
  ```shell
  javac *.java
  ```
- **Run**: Execute the main program:
  ```shell
  java TestProgram
  ```
- **Test**: All testing is performed via `TestProgram.java`. There are no separate test files or frameworks.

## Project-Specific Patterns
- **Logging**: Use `LogEntry` for all significant operations. Logs are typically managed by the `Bank` class.
- **Account Creation**: Always instantiate accounts via the `Bank` class to ensure proper registration and logging.
- **Encapsulation**: Direct field access is discouraged; use getters/setters and methods for all interactions.
- **No External Dependencies**: The project is pure Java, with no third-party libraries or frameworks.

## Examples
- To add a new account type, extend `Account` and implement required methods, then update `Bank` to support the new type.
- To log a transaction, create a `LogEntry` and add it to the bank's log list.

## Key Files
- `Account.java`, `Bank.java`, `CheckingAccount.java`, `SavingAccount.java`, `Person.java`, `LogEntry.java`, `TestProgram.java`

## Conventions
- All classes are in the default package (no package declarations).
- Use descriptive method and variable names reflecting their domain purpose.
- Keep business logic in domain classes; avoid placing it in `TestProgram.java`.

---

**Feedback Requested:**
Please review these instructions. If any architectural details, workflows, or conventions are unclear or missing, let me know so I can refine this guide for your team.
