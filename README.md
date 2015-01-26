# BITCampRandomQuoteGenerator

Random quote generator (Kostur).

1.Generator. (server - server socket)
2.Client. (socket)
3.File Reader. (server)
4.File struktura (linija, quote) (server) (linija, quote)
5.Spasavati quote-ove u fajl koji ce imati format: [TIMESTAMP]quote.
6.Server ima final pass. Client salje serveru pass if(pass true) vrati random quote. else ispisi pass nije tacan. 4. 6. 7.Logovati pogresan pass kada pokusaj nije tacan i u kom vremenu - format [TIMESTAMP] pass.(server)

(Razrada)

1.Naziv: RQG
2.Java
3.Package: ba.bitcamp.rqg.server - Generator.java ba.bitcamp.rqg.client - User.java
4.File location: Desktop (system agnostic)
5.Port: 1717
6.Repo: BITCampRandomQuoteGenerator
7.15 guotes
8.[yyyy-mm-dd h:i:s]
9.[D] - quote
10.Server IP input
11.pass [input] Client (Password handling (pass se proslijedi na klijentu))
12.pass final static (na serveru je pass zakucan)
13.quotes.txt (fajl iz kojeg citamo quotes)
14.auth_log.txt (dio na serveru koji loguje pogresne pokusaje) - [D] - pass - IP (java socket get IP - procitati)
15.recieved_quotes.txt Client
