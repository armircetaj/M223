DELETE FROM blog;

INSERT INTO blog (id, title, date, category, author, likes, content)
VALUES
    (NEXT VALUE FOR blog_seq, 'Tech Trends 2026', '2026-03-05', 'Tech', 'Carlo Canonico', 42, 'Novità e tendenze tecnologiche del 2026'),
    (NEXT VALUE FOR blog_seq, 'Viaggio in Svizzera', '2026-02-20', 'Travel', 'Matteo Matico', 28, 'Racconto di un viaggio tra le Alpi svizzere');