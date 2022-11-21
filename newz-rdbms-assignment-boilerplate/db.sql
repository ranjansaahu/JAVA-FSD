------------- Create Tables -------------------
CREATE TABLE News(NewsId INT NOT NULL, Title LONGTEXT NOT NULL, Content LONGTEXT NOT NULL, PublishedAt DATETIME NOT NULL, 
CreatedBy VARCHAR(50) NOT NULL, url LONGTEXT, UrlToImage LONGTEXT, PRIMARY KEY(NewsId), FOREIGN KEY(CreatedBy) REFERENCES UserProfile(UserId));

CREATE TABLE UserProfile(UserId VARCHAR(50) NOT NULL, FirstName LONGTEXT NOT NULL, LastName LONGTEXT NOT NULL, Contact LONGTEXT, Email LONGTEXT, CreatedAt datetime NOT NULL, PRIMARY KEY(UserId));

CREATE TABLE Reminders(ReminderId INT NOT NULL, Schedule DATETIME NOT NULL, NewsId INT NOT NULL, FOREIGN KEY(NewsId) REFERENCES News(NewsId));

CREATE TABLE User(UserId VARCHAR(50) NOT NULL, Password VARCHAR(50) NOT NULL, PRIMARY KEY(UserId));

------------- Insert Tables -------------------
INSERT INTO User VALUES ("Jack", "pass@123");
INSERT INTO User VALUES ("John", "something#121");
INSERT INTO User VALUES ("Kevin", "test@123");

INSERT INTO News VALUES (101, "IT Industry in 2020", "IT industry was facing disruptive changes in 2019. It is expected to have positive growth in 2020", "2019-12-01 00:00:00", "Jack", NULL, NULL);
INSERT INTO News VALUES (102, "2020 FIFA U-17 Women World Cup", "The tournament will be held in India between 2 and 21 November 2020. It will mark the first time that India has hosted a FIFA women football tournament.", "2019-12-05 00:00:00", "Jack", NULL, NULL);
INSERT INTO News VALUES (103, "chandrayyan2-spacecraft", "The lander of chandrayaan2 was named Vikram after Dr Vikram A Sarabhai, the father of the Indian SpaceProgramme, It was designed to function for one lunar day.", "2019-12-05 00:00:00", "John", NULL, NULL);
INSERT INTO News VALUES (104, "NEFT transactions to be available 24x7", "Bank customers will be able to transfer funds through NEFT around the clock on all days including weekends and holidays from December 16.", "2019-12-07 00:00:00", "John", NULL, NULL);

INSERT INTO Reminders VALUES (1, "2019-12-04 00:00:00", 101);
INSERT INTO Reminders VALUES (2, "2019-12-10 00:00:00", 102);
INSERT INTO Reminders VALUES (3, "2019-12-10 00:00:00", 104);

INSERT INTO UserProfile VALUES ("Jack", "Jackson", "James", "8899776655", "jack@ymail.com", "2019-12-07 00:00:00");
INSERT INTO UserProfile VALUES ("John", "Johnson", "Dsouza", "7869543210", "john@gmail.com", "2019-12-25 00:00:00");
INSERT INTO UserProfile VALUES ("Kevin", "Kevin", "Lloyd", "9878685748", "kevin@ymail.com", "2019-12-01 00:00:00");

------------- Queries -------------------
SELECT * FROM UserProfile WHERE CreatedAt >= "2019-12-10 00:00:00";
SELECT * FROM UserProfile u JOIN News n ON u.UserID = n.CreatedBy WHERE u.UserID = "Jack";
SELECT * FROM UserProfile WHERE UserID = (SELECT CreatedBy FROM News WHERE NewsId = 103);
SELECT * FROM UserProfile WHERE UserID NOT IN (SELECT CreatedBy FROM News);
SELECT NewsId, Title FROM News WHERE NewsId IN (SELECT NewsId FROM Reminders);
SELECT count(NewsId) AS total_news, CreatedBy AS User FROM News Group BY CreatedBy;
UPDATE UserProfile SET Contact = "9192939495" WHERE UserId = "John";
UPDATE News SET Title = "IT industry growth can be seen in 2020." WHERE NewsId = 101;
DELETE FROM Reminders WHERE NewsId IN (SELECT NewsId FROM News WHERE CreatedBy = "Jack");
INSERT INTO Reminders VALUES (1, "2019-12-10 00:00:00", 103);
