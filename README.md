# Daily-Active-Users  
Count distinct Daily Active Users from a file stream.  
  
### Running the app  
Create a folder called "resources" in the same folder as the jar file.  
Add files to the folder, in the format of two columns, the left is a user id, the right is a date of the format dd/MM/yyyy.  
To run: `java -jar <jar_name> <file_name> <date>`  
The result is the number of distinct users, in the file and date specified.  
  
Only TXT and CSV files are supported.


