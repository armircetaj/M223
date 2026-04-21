DELETE FROM blog;

INSERT INTO blog (id, title, date, category, author, likes, content)
VALUES
    (NEXT VALUE FOR blog_seq, '******** 2026', '2026-03-05', '*****', '*****', 999, 'Novità e ***** tecnologiche del *****'),
    (NEXT VALUE FOR blog_seq, 'Viaggio in *******', '2026-02-20', '*****', '*********', 999, 'Racconto di un ****** tra le ************');