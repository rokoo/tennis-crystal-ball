DELETE FROM team_tournament_event_winner;
INSERT INTO team_tournament_event_winner
(season, level, winner_id, runner_up_id, score)
VALUES
-- Davis Cup
(1968, 'D', 'USA', 'AUS', '4–1'),
(1969, 'D', 'USA', 'ROU', '5–0'),
(1970, 'D', 'USA', 'GER', '5–0'),
(1971, 'D', 'USA', 'ROU', '3–2'),
(1972, 'D', 'USA', 'ROU', '3–2'),
(1973, 'D', 'AUS', 'USA', '5–0'),
(1974, 'D', 'RSA', 'IND', 'W/O'),
(1975, 'D', 'SWE', 'CZE', '3–2'),
(1976, 'D', 'ITA', 'CHI', '4–1'),
(1977, 'D', 'AUS', 'ITA', '3–1'),
(1978, 'D', 'USA', 'GBR', '4–1'),
(1979, 'D', 'USA', 'ITA', '5-0'),
(1980, 'D', 'CZE', 'ITA', '4–1'),
(1981, 'D', 'USA', 'ARG', '3–1'),
(1982, 'D', 'USA', 'FRA', '4–1'),
(1983, 'D', 'AUS', 'SWE', '3–2'),
(1984, 'D', 'SWE', 'USA', '4–1'),
(1985, 'D', 'SWE', 'GER', '3–2'),
(1986, 'D', 'AUS', 'SWE', '3–2'),
(1987, 'D', 'SWE', 'IND', '5-0'),
(1988, 'D', 'GER', 'SWE', '4–1'),
(1989, 'D', 'GER', 'SWE', '3–2'),
(1990, 'D', 'USA', 'AUS', '3–2'),
(1991, 'D', 'FRA', 'USA', '3–1'),
(1992, 'D', 'USA', 'SUI', '3–1'),
(1993, 'D', 'GER', 'AUS', '4–1'),
(1994, 'D', 'SWE', 'RUS', '4–1'),
(1995, 'D', 'USA', 'RUS', '3–2'),
(1996, 'D', 'FRA', 'SWE', '3–2'),
(1997, 'D', 'SWE', 'USA', '5-0'),
(1998, 'D', 'SWE', 'ITA', '4–1'),
(1999, 'D', 'AUS', 'FRA', '3–2'),
(2000, 'D', 'ESP', 'AUS', '3–1'),
(2001, 'D', 'FRA', 'AUS', '3–2'),
(2002, 'D', 'RUS', 'FRA', '3–2'),
(2003, 'D', 'AUS', 'ESP', '3–1'),
(2004, 'D', 'ESP', 'USA', '3–2'),
(2005, 'D', 'CRO', 'SVK', '3–2'),
(2006, 'D', 'RUS', 'ARG', '3–2'),
(2007, 'D', 'USA', 'RUS', '4–1'),
(2008, 'D', 'ESP', 'ARG', '3–1'),
(2009, 'D', 'ESP', 'CZE', '5–0'),
(2010, 'D', 'SRB', 'FRA', '3–2'),
(2011, 'D', 'ESP', 'ARG', '3–1'),
(2012, 'D', 'CZE', 'ESP', '3–2'),
(2013, 'D', 'CZE', 'SRB', '3–2'),
(2014, 'D', 'SUI', 'FRA', '3–1'),
(2015, 'D', 'GBR', 'BEL', '3–1'),
(2016, 'D', 'ARG', 'CRO', '3–2'),
-- World Team Cup
(1975, 'T', 'USA', 'GBR', '2–1'),
(1978, 'T', 'ESP', 'AUS', '2–1'),
(1979, 'T', 'AUS', 'ITA', '2-1'),
(1980, 'T', 'ARG', 'ITA', '3-0'),
(1981, 'T', 'CZE', 'AUS', '2-1'),
(1982, 'T', 'USA', 'AUS', '2-0'),
(1983, 'T', 'ESP', 'AUS', '2-1'),
(1984, 'T', 'USA', 'CZE', '2-1'),
(1985, 'T', 'USA', 'CZE', '2-1'),
(1986, 'T', 'FRA', 'SWE', '2-1'),
(1987, 'T', 'CZE', 'USA', '2-1'),
(1988, 'T', 'SWE', 'USA', '2-0'),
(1989, 'T', 'GER', 'ARG', '2-1'),
(1990, 'T', 'YUG', 'USA', '3-0'),
(1991, 'T', 'SWE', 'YUG', '2-1'),
(1992, 'T', 'ESP', 'CZE', '2-0'),
(1993, 'T', 'USA', 'GER', '3-0'),
(1994, 'T', 'GER', 'ESP', '2-1'),
(1995, 'T', 'SWE', 'CRO', '2-1'),
(1996, 'T', 'SUI', 'CZE', '2-1'),
(1997, 'T', 'ESP', 'AUS', '3-0'),
(1998, 'T', 'GER', 'CZE', '3-0'),
(1999, 'T', 'AUS', 'SWE', '2-1'),
(2000, 'T', 'SVK', 'RUS', '3-0'),
(2001, 'T', 'AUS', 'RUS', '2-1'),
(2002, 'T', 'ARG', 'RUS', '3-0'),
(2003, 'T', 'CHI', 'CZE', '2-1'),
(2004, 'T', 'CHI', 'AUS', '2-1'),
(2005, 'T', 'GER', 'ARG', '2-1'),
(2006, 'T', 'CRO', 'GER', '2-1'),
(2007, 'T', 'ARG', 'CZE', '2-1'),
(2008, 'T', 'SWE', 'RUS', '2-1'),
(2009, 'T', 'SRB', 'GER', '2-1'),
(2010, 'T', 'ARG', 'USA', '2-1'),
(2011, 'T', 'GER', 'ARG', '2-1'),
(2012, 'T', 'SRB', 'CZE', '3-0');

COMMIT;