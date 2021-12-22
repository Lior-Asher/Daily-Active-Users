# Daily-Active-Users  
Count distinct Daily Active Users from a file stream.  
Only TXT and CSV files are supported.  
### Running the app  
Create a folder called "resources" in the same folder as the jar file. The jar file is in "target" folder.  
Add files to the folder, in the format of two columns, the left is a user id, the right is a date of the format dd/MM/yyyy.  
To run: `java -jar <jar_name> <file_name> <date>`  
The result is the number of distinct users, in the file and date specified.      
### Docker image  
Docker image of the app can be pulled using: `docker pull devops336/dau`  
or built runnig the command `docker build -t <image_name> .`  
   
#### Before using the container  
The app reads files places in a directory named "resources" (which you need to add yourself).  
This directory must be created in the same directory the `docker run` command is executed.  
After creating the resources directory, add TXT or CSV file to directory.  
The file content should be in a table, consisting of two columns, where the left column is an ID and the right column is date.  
  
#### Running the container  
In the same directory as "resources" directory, using the terminal run the command:  
`docker run --rm -v "${PWD}:/app/resources" <image_name> <file_to_process> <date>`  
  
The result is a message stating the number of DAUs in the specified file at the specified date.
