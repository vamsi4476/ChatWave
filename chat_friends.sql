use ChatWave;

-- In this sql file
-- we are considering friend2 is friend1, but this does not imply
-- friend1 is friend2. We have explicity enter a new row for that.

-- We check the friends of a person by checking the number of friends 
-- friend2 column



create table if not exists chat_friends(
id int auto_increment,
friend1_id INT,friend2_id INT,
FOREIGN KEY (friend1_id) REFERENCES user(id),
FOREIGN KEY (friend2_id) REFERENCES user(id),
primary key(id));

-- INSERT INTO chat_friends (friend1_id, friend2_id) VALUES (3, 1);

select * from chat_friends where friend1_id=1;




