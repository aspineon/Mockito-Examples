Things you will need to run

1. Maven
2. Derby DB


Setting up Maven
1. Download Maven from http://maven.apache.org/
2. Once installed, set MVN_HOME to the path where you've installed it
3. Add $MVN_HOME/bin to your PATH variable 
4. To compile code, use
	mvn compile


Setting up Derby DB Network Server (For in-memory DB setup, please see next section)
1. Download Derby DB binaries from http://db.apache.org/
2. Once installed, set DERBY_HOME to the path where you've installed it
3. Add $DERBY_HOME/bin to your PATH variable
4. Launch the Derby Network Server by launching the script $DERBY_HOME/bin/startNetworkServer
5. In another window, type "ij"
6. Enter the following command
ij> connect 'jdbc:derby://localhost:1527/mockitoDB;create=true';

insert.sql has the SQL queries to create tables and add initial data

Setting up Derby DB in memory
To use an in-memory DB instead of a network server modify this line in CustomerDao.java 

private static String persistenceType = "persistence-network";

to

private static String persistenceType = "persistence-memory";



