# ReceiptSystem

Receipt Management System
The Receipt Management System is a user-friendly application designed to help users efficiently organize and analyze their spending habits. With features such as receipt input, storage, retrieval, and categorization by store type, the system provides an intuitive platform for managing receipts from various sources like grocery stores, clothing outlets, and electronics retailers. It calculates individual and overall spending, generates detailed reports summarizing expenses by customer, store, or item, and tracks payment methods using polymorphism for flexible handling of cash, credit, and other types of payments.

This project was built using object-oriented programming (OOP) principles, including encapsulation, inheritance, and polymorphism, combined with efficient data structures for managing receipts, customers, and stores. A user-friendly interface facilitates seamless input and retrieval of data, while robust error-handling mechanisms ensure the system gracefully handles invalid inputs, missing data, and edge cases. The project showcases strong technical skills in OOP, data management, and system design, offering a reliable and practical solution for receipt management.

ReceiptSystem.java: Main file containing the program logic and user interface.

Receipt.java: Handles receipt creation and management, including items, customers, and stores.

Store.java: Manages store-specific data, including receipts and categories.

Customer.java: Manages customer-specific data, including linked receipts.

Item.java: Represents individual items on a receipt.

Report.java: Contains methods for generating spending reports.

Payment.java: Abstract class representing payment methods.

	cashPayment.java: Subclass for cash payments.

	creditPayment.java: Subclass for credit card payments.

	debitPayment.java: Subclass for debit card payments.
