# stockmarketsimulator

This project is part of CCT's Third-year Object-Oriented Design Patterns.

Design Patterns used on the project:

- Observer Pattern = the company and investor classes have variables that need to be modified accordingly after each transaction. 
They implement update methods from their respective interface that will handle any necessary change to their current state.

- Iterator Pattern - the StockMarket class needs to traverse both company and investor lists to decide if it can do a new round of transaction,
depending on the price of shares and budgets available.
