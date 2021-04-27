# scrap-it
recruitment task:

You’ve joined a team that is supporting the ScrapeIt application. The mentioned app is scrapping tones of web pages and extracting useful information which are further stored in flat files (sample file attached). The application is continuously evolving, and new features are still being added. Some of the new features to be added have landed on your plate, below you can find the requirements.
Technology to be used:
 - Java at least 1.11 + Spring Boot
 - any database of your choice (SQL or noSQL)
Requirements:
There are two main tasks you have to code:
Create Spring Boot REST application for parsing and persisting files data into database. You should also persist file name, generate some unique file id, log metadata which can be useful in task 2.
Define additional REST endpoints which will realize the following functionalities

returns the list of all persisted files in JSON format
		{
			“files”: {
				“file”: {
					“id”: “…“
“name”: “….”,	 
}
				“file”: {
					“id”: “…”
“name”: “….”,	 
}
….
		}	
returns details about the specific file in JSON format (feel free to add more metadata if you find them useful)
		{
			“fileId”: “…”
			“fileName”: “….”,
			“numRows”: “….”,
			“createdAt”: “.…”
		}	
returns specific file data as a CSV data
Build your solution on top of the provided sample file. You DO NOT need to create a generic solution which will support any file format. 
When coding, consider additional aspects like error handling, security, validation and sample unit tests. 	
The resulting source code put into your private bitbucket and grant access to all reviewers.

CSV sample:
licenseNumber|lastName|firstName|middleName|city|state|status|issueDate|expirationDate|boardAction
06253|ROOT|AARON||SAN ANTONIO|TX|ACTIVE|7/30/1993|12/1/2022|YES
07296|HENDERSON|AARON|R|HINESVILLE|GA|NON-RENEWABLE|8/8/1997|3/1/1999|NO
08038|FORD|AARON|E|PLANO|TX|ACTIVE|10/1/1998|6/1/2022|NO

