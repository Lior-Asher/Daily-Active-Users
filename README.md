# Daily-Active-Users  
Count distinct Daily Active Users from a file stream.  
Only TXT and CSV files are supported.  
### Running the app  
Copy "resources" folder to the same folder as the jar file. The jar file is in "target" folder.  
Optional: Add new files to resources folder, in the same format as the example files.  
To run: `java -jar <jar_name> <file_name> <date>`  
The result is the number of distinct users, in the file and date specified.      
### Docker image  
Docker image of the app can be pulled from Docker-Hub: `docker pull devops336/dau:1.2`  
Or built runnig the command `docker build -t <image_name> .`  
   
#### Before running the container  
Copy "resources" directory to the same directory the `docker run` command is executed.  
After creating the resources directory, add TXT or CSV file to directory.  
The file content should be in a table, consisting of two columns, where the left column is an ID and the right column is date.  
  
#### Running the container  
In the same directory as "resources" directory, using the terminal run the command:  
`docker run --rm -v "${PWD}:/app/resources" <image_name>:<tag> <file_to_process> <date>`  
- Windows users: the run command works only with powershell, it will not work with the command line (CMD) 
