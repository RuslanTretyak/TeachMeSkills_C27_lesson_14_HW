## TeachMeSkills_C27_lesson_13_HW 

Homework for the fourteenth lesson

This program reads information from the input file with document numbers and checks these numbers for validity. The path 
to the input file is set via the console. The document number is a string consisting of letters and numbers (without 
service characters). The file must contain each document number on a new line and no other information on the line. A 
valid document number must be 15 characters long and begin with the sequence "docnum" (hereinafter any sequence of 
letters/numbers) or "contract" (hereinafter any sequence of letters/numbers).

The program contains:
- class "Service" for reading a file and writing document numbers to reports;
- class "Utility" for writing information to a report file;
- class "Validator" for checking document numbers for validity;
- "Constants" interface for storing paths to files with reports and logs;
- "Logger" class for logging program operation and errors.

  Valid "docnum" document numbers are written to the "reportDocnum.txt" file. Valid "contract" numbers are written to the 
"reportContract.txt" file. Invalid document numbers are written to the "reportNotValid.txt" file. Errors are written to 
"the error_log.txt" file. Logs of the program's operation are written to the "execution_log.txt" file.