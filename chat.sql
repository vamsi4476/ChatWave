USE ChatWave;

CREATE TABLE IF NOT EXISTS chat (
    id INT AUTO_INCREMENT,
    user1 INT,
    user2 INT,
    PRIMARY KEY (id)
);

-- Insert data into the table
INSERT INTO chat (user1, user2) VALUES (2, 3);

-- Verify the inserted data
SELECT * FROM chat;
