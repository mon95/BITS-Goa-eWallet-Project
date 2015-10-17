-------------------
SECTION 1
-------------------


---------------------------------------------------------------------------------------------------------------------------------------------
Name 			Student ID 		Roles 			Role-based Contribution(%) 		Overall  Contribution(%)     
---------------------------------------------------------------------------------------------------------------------------------------------

Shreyash Mohatta	2012B4A7421G		Code Devel			95
						Junit Tests(Final)		30					30	
						Project Req			10					

Sreehari S		2013A7PS126G		Project Manager			100	
						Use Cases,			50
						Project Req.,			20					30
						Junit Tests(Final)		70
						Code Devel			5

Arpit Pandey		2013A7PS075G		CRC Cards,			100
						UML Diag.,			30
						Junit Tests(Initial)		33.33					10
						Project Req			30

Naimil Shah		2013A7PS129G		Use Cases,			50
						UML Diag.,			30					10		
						Junit Tests(Initial)		33.33
	

Apoorva			2012B2A7637G		UML Diag.,			30
						Junit Tests(Initial)		33.33					10
						Project Req			20

Muda Sai Vishal		2013A7PS095G		Project Req.			30					5
						

Akshay Varshney		2012A8PS772G		UML Diag.			30					5



----------------------------------------------------------------------------------------------------------
Topic			Number in Stage-2 Submission 			  Code
								Complete 	Incomplete
----------------------------------------------------------------------------------------------------------
Use cases		11					11		-
Classes			8					8		-	
Sequence diagrams	1					1		-	
Unit Tests		4					4		-
----------------------------------------------------------------------------------------------------------


-----------------------------------------------------------------------
Topic 				Number 			Test Status
				of tests 		Pass 	Fail
-----------------------------------------------------------------------
Unit Tests submitted at 	
the end of Stage-2

LoginTest			1			1	-
PaymentTrackerTest		1			1	-	
RechargeTest			1			1	-
TransactionTest			1			1	-


Tests added later

LoginTest			4			4	-
PaymentTrackerTest		2			2	-	
RechargeTest			4			4	-	
VendorTest			5			5	-
ReceivePaymentTest		2			2	-

----------------------------------------------------------------------

--------------------------
SECTION 2
--------------------------

------------------------------
INSTALLATION INSTRUCTIONS:
------------------------------


The E-Wallet source code, test packages, dependancy libraries and Junit tests can be downloaded from the Submission-4/code/E-Wallet directory. 

This is a NetBeans project which requires the Netbeans IDE. The zip file "E-Wallet.zip" has been provided in the Submission-4/code directory which can be directly imported into NetBeans.
Use import >> from ZIP option available in NetBeans to import the same.

We've also provided an executable .jar file in the Submission-4/code/E-Wallet/dist folder.

All the required libraries are present in Submission-4/code/E-Wallet/libs and the test files are present in Submission-4/code/E-Wallet/test.

-------------------------
REQUIRED LIBRARIES:
-------------------------

The Required Libraries  are:
	
	>mysql-connector(available in /libs)
	>commons-logging(available in /libs)


-------------------------
FRAMEWORK USED
-------------------------

The project uses the spring framework

The spring framework is already included on all new NetBeans versions. As the NetBeans IDE is being used, there will not be any need to download the spring jar files.

In case any other IDE is being used for further development or use, the following links can be used to download the framework.
	> https://github.com/spring-projects/spring-framework/wiki/Downloading-Spring-artifacts

For queries regarding spring download:
	> http://stackoverflow.com/questions/19124445/how-to-download-spring-framework-zip-file
	> http://stackoverflow.com/questions/19082860/where-can-i-download-spring-framework-jars


--------------------------
DATABASE SETUP:
--------------------------

Setting up the Database :
	
Two classes CreateDatabase.java and TableSetup.java have been provided in Submission-4/code/setup/ to setup the initial database and and tables. Dump sql files have also been provided to create test entries.
	
	Test Entry for Student = Name : Shreyash
				 BITS ID : 1111
				 Password : abcd
				 PIN : 1234
	Test Entry for Vendor = Name : Borkar's Super Market
				BITS ID : bk123
				Password : abcd

CreateDatabase requires User priveleges that can be set through phpMyAdmin or any other client. Set USER and PASS in the CreateDatabase/TableSetup class to be able to run them.



Using the Dump files:
	
	The dump files can be easily imported using any mysql admin tool (for eg., phpMyAdmin), into the tables.

	The following dump files have been included in the Submission-4/code/Setup folder:
		
		> student.sql
		> vendor.sql


Relevant Links:
	
	> http://stackoverflow.com/questions/17666249/how-to-import-a-sql-file-using-the-command-line-in-mysql
	> http://stackoverflow.com/questions/4708013/import-multiple-sql-dump-files-into-mysql-database-from-shell
	> https://docs.oracle.com/cd/B10501_01/server.920/a96652/ch02.htm





