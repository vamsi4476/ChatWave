use ChatWave;



create table if not exists chat_line(
id BIGINT auto_increment,chat_id INT,user_id INT,
line_text text,created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (chat_id) REFERENCES chat(id),
Primary key(id));

select * from chat_line;