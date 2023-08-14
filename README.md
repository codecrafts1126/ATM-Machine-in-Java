# ATM Project in Java
![Java](https://img.shields.io/badge/Language-Java-red.svg) 
![Status](https://img.shields.io/badge/Status-Complete-orange.svg)

This is a simple ATM project in Java. It allows users to login with their account number and PIN, and then view their balance or withdraw funds from their checking or saving accounts.

## Getting Started
- Clone the repository to your local machine.
- Open the project in your IDE.
- Run the ATM.java file.

## File Structure
The project contains three main files:

- ATM.java: The main class that runs the ATM simulator.
- accountInfo.txt: A text file containing account information in the format CN, PIN, Checking Balance, Saving Balance.
- README.md: This file, providing information about the project.

Note: This is my first Java project, so the code may not follow the best programming practices, and the logic may have room for improvement.

## Usage
- When you run the program, it will prompt you to enter your 8-digit ATM card number and 4-digit PIN.
- The program will authenticate your details by checking them against the accountInfo.txt file.
- After successful authentication, you can select the account you want to access: Checking Account (Type 1) or Saving Account (Type 2).
- Depending on your choice, you can view the account balance (Type 1), withdraw funds (Type 2), or exit the system (Type 3).
- If you choose to withdraw funds, you will need to enter the amount you want to withdraw. The program will then update the account balance accordingly.


## Disclaimer
This project was created as a learning exercise, and it may contain suboptimal programming practices and questionable logic. Use it for educational purposes and do not rely on it for real-world transactions.

Feel free to explore, experiment, and learn from the code. If you have any suggestions or improvements, I would be happy to receive your feedback!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

This project was created by [sawongam](https://github.com/sawongam)
