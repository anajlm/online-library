-- Insert sample data into the Genres table
INSERT INTO Genres (name) VALUES
('Fiction'),
('Classic'),
('Mystery'),
('Fantasy'),
('Science Fiction'),
('Adventure'),
('Romance'),
('Historical Fiction'),
('Horror'),
('Thriller');

-- Insert sample data into the Publishers table
INSERT INTO Publishers (name, address) VALUES
('Penguin Random House', '123 Main St, New York'),
('HarperCollins Publishers', '456 Elm St, London'),
('Simon & Schuster', '789 Oak St, San Francisco'),
('Macmillan Publishers', '101 Maple St, Boston'),
('Hachette Livre', '202 Pine St, Paris');


-- Insert sample data into the Authors table
INSERT INTO Authors (name, biography) VALUES
('Jane Austen', 'Jane Austen was an English novelist known primarily for her six major novels, which interpret, critique and comment upon the British landed gentry at the end of the 18th century.'),
('Stephen King', 'American author known for his horror and supernatural fiction.'),
('George R.R. Martin', 'American author famous for the A Song of Ice and Fire series.'),
('George Orwell', 'George Orwell was an English novelist and journalist, best known for his dystopian novel "1984" and the allegorical novella "Animal Farm".'),
('J.R.R. Tolkien', 'J.R.R. Tolkien was an English writer, poet, philologist, and academic, best known as the author of the high fantasy works "The Hobbit" and "The Lord of the Rings".'),
('Leo Tolstoy', 'Leo Tolstoy was a Russian writer who is regarded as one of the greatest authors of all time. His novels "War and Peace" and "Anna Karenina" are considered masterpieces of realist fiction.'),
('Sir Arthur Conan Doyle', 'Sir Arthur Conan Doyle was a British writer and physician, best known for his detective fiction featuring the character Sherlock Holmes.');

-- Insert sample data into the Books table
INSERT INTO Books (title, genre_id, author_id, publisher_id, isbn, publication_year) VALUES
('Pride and Prejudice', 7, 1, 2, '9780141439518', 1813),
('The Shining', 9, 2, 2, '9780307743657', 1977),
('A Game of Thrones', 3, 3, 3, '9780553381689', 1996),
('1984', 8, 4, 4, '9780451524935', 1949, '9780547928210', 1954),
('The Lord of the Rings: The Fellowship of the Ring', 4, 5, 5),
('Anna Karenina', 2, 6, 1, '9780143035008', 1877),
('A Study in Scarlet', 3, 7, 1, '9780143111229', 1887);