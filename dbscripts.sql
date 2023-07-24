CREATE TABLE Users (
    UserID INT PRIMARY KEY,
    username VARCHAR(255),
    email_address VARCHAR(255)
);

-- Create the QuestionBank table
CREATE TABLE question_bank (
    QuestionID INT PRIMARY KEY,
    question_text varchar(800)
);

-- Create the Choice table
CREATE TABLE Choice (
    ChoiceID INT PRIMARY KEY,
    choice_value Varchar(20),
    choice_text VARCHAR(255)
);

-- Create the Answer table
CREATE TABLE Answer (
    AnswerID BIGINT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    QuestionID INT,
    ChoiceID INT,
    FOREIGN KEY (UserID) REFERENCES Users (UserID),
    FOREIGN KEY (QuestionID) REFERENCES question_bank (QuestionID),
    FOREIGN KEY (ChoiceID) REFERENCES Choice (ChoiceID)
);

-- Create the QuestionChoice table (bridge table)
CREATE TABLE QuestionChoice (
    QuestionID INT,
    ChoiceID INT,
    FOREIGN KEY (QuestionID) REFERENCES question_bank (QuestionID),
    FOREIGN KEY (ChoiceID) REFERENCES Choice (ChoiceID)
);


-- Insert sample data into the Users table
INSERT INTO Users (UserID, Username, email_address)
VALUES
    (101, 'Alice', 'something@gmail.com'),
    (102, 'Bob', 'something@gmail.com'),
    (103,  'Charlie', 'something@gmail.com');

-- Insert sample data into the QuestionBank table
INSERT INTO question_bank (QuestionID, question_text)
VALUES
    (1, 'A train carrying hundreds of passengers is speeding out of control down the tracks. Ahead, there are five people tied to the rails who will be killed if the train continues its path. However, there is a switch nearby that you can use to divert the train onto another track. On this track, there is only one person tied to the rails. What do you do: let the train continue on its course and kill five people, or pull the switch and save five lives at the cost of one?'),
    (2, 'You are a train conductor, and your train is about to hit a group of people on the tracks. Among them is your sibling. You have the option to divert the train to a different track, saving your sibling but endangering the lives of five strangers. What do you choose: prioritize your family and save your sibling, or prioritize the greater number of people and let the train proceed on its current path?'),
    (3, ' You are an employee at a company that is engaging in harmful practices to maximize profits. By speaking out, you risk losing your job and livelihood. However, staying silent means being complicit in these harmful actions. What do you prioritize: your own well-being or the ethical responsibility to address the companys actions?'),
    (4, 'A deadly disease is spreading rapidly, and a scientist has developed a potential vaccine. However, the vaccine needs to be tested on humans to ensure its effectiveness and safety. You have the option to volunteer yourself for the experiment, knowing it might be risky, or force someone else to participate against their will to potentially save many lives. What choice do you make, and how do you weigh the value of an individuals life against the greater good?');

-- Insert sample data into the Choice table
INSERT INTO Choice (ChoiceID, choice_value, choice_text)
VALUES
    (1, 'A', 'let the train continue'),
    (2, 'B', 'save the 1 persons life'),
    (3, 'A', 'Save your family'),
    (4, 'B', 'Save the 5 strangers'),
    (5, 'A', 'Speak out'),
    (6, 'B', 'Stay silent'),
    (7, 'A', 'Volunteer yourself'),
    (8, 'B', 'Force someone else');

-- Insert sample data into the Answer table
INSERT INTO Answer (UserID, QuestionID, ChoiceID)
VALUES
    (101, 1, 1),
    (102, 1, 2),
    (103, 2, 3),
    (101, 2, 3),
    (103, 1, 1),
    (101, 3, 5),
    (102, 3, 6),
    (103, 3, 6);

-- Insert sample data into the QuestionChoice table
INSERT INTO QuestionChoice (QuestionID, ChoiceID)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8);









-- POTENTIALLY USEFUL QUERIES
-- get all options for a specific quesion
SELECT C.ChoiceID, C.ChoiceValue, C.ChoiceText
FROM QuestionChoice QC
JOIN Choice C ON QC.ChoiceID = C.ChoiceID
WHERE QC.QuestionID = 4;

-- get amount of users that chose specific option for specific question
SELECT COUNT(*) AS NumberOfUsers
FROM Answer A
JOIN Choice C ON A.ChoiceID = C.ChoiceID
WHERE A.QuestionID = 3 AND C.ChoiceValue = 'B';

-- Question Overview
SELECT
qb.QuestionId as QuestionID,
qb.QuestionText,
COUNT(*) AS TotalAnswers,
COUNT(CASE WHEN C.ChoiceValue = 'A' THEN 1 END) AS TotalOptionA,
COUNT(CASE WHEN C.ChoiceValue = 'B' THEN 1 END) AS TotalOptionB
FROM Answer A
JOIN Choice C ON A.ChoiceID = C.ChoiceID
JOIN questionbank qb on A.QuestionId = qb.QuestionId
WHERE A.QuestionID = 1;



SELECT
    QB.QuestionText AS Question,
    C.ChoiceText AS Choice,
    C.ChoiceValue as ChoiceValue
FROM
    QuestionBank QB
JOIN
    QuestionChoice QC ON QB.QuestionID = QC.QuestionID
JOIN
    Choice C ON QC.ChoiceID = C.ChoiceID
WHERE
    QB.QuestionID = 1;