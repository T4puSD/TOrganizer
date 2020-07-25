# TOrganizer
Organize your elaborate files in organized folder on one click (JAVA PROJECT). It uses java awt and swing packages to provide user friendly interface.

# Requirements
You need to have JDK (Java Development Kit) version 8 or above installed to run this software.

# How To Run
Download this directory and extract. Open cmd/termminal in the extracted folder and navigate to App.java file in the src folder and type:</br>
 `javac App.java` this will compile java file and create class files.</br>
 After compilation type `java App` to run the program.
**Note:** Or else you can run the jar file with `java -jar <name of the jar with extension>` command that is located in target folder. 

Now copy and past the directory where you want to sort your files. Then press Submit button.</br> 
Submit button will change to display status of the operation.</br>
To perform another sorting action. Press Reset button and past another directory link.

# Predefined Category
The software create 4 predefined folder:
1. TDOCUMENTS
2. TAUDIOS
3. TVIDEOS
4. TCOMPRESSSED

Your files will be organized based on these category. If more category needed code is needed to be changed to acccept more category.

# NOTE
Please use (Ctrl+V) keyboard combination to paste copied directory.</br></br>
Files will be moved to those category folder created earlier from the root directory you provide. So make sure not to terminate the program before every file is moved else your files can be lost. The program don't have progress bar (which can show status of the move operation) as of now. I will add that in near future. </br>This program is still in development phase. So i am not responsible if you loose you file using this software.
