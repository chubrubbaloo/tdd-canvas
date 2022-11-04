<h2>Beskrivning:</h2>

Bygg samma backend din grupp byggde i tidigare kurs (Avancerad JavaScript) som slutuppgift. Detta projekt skall byggas i Java och använda ’Javalin’ ramverket, men skall fungera likt din grupps tidigare projekt. Javalin är likt ExpressJs + NodeJs. Gruppen skall följa TDD metodik och därmed skriva tester först. Data skall sparas lokalt på valfritt sätt (inga databaser) och behöver också testas. Skriv tester först och följ upp med kod för att göra testerna gröna. Glöm inte att göra en git commit efter varje test och lösning, annars blir det struligt.

 

Förslag på kodupplägg/struktur:

·        Ett system som hanterar sparning av objekt (alla sorters objekt) och testas

·        Ett system som hanterar request-response och testas

·        Ett system som hanterar ’business logic’ och testas

·        Kod som testar att alla system fungerar tillsammans (integrationstester)

 

Motivering:

Anledningen till att ni skall bygga samma projekt igen är för att ni redan har koll på logiken för det projektet och har applicerat era idéer för hur det kan byggas. Ni kan följa samma principer på detta projekt med vissa ändringar för att inkludera tester. Javalin ramverket används för att det är ett väldigt lätt/litet ramverk som ändå tillåter oss att bygga realistiska projekt med många förkunskaper ni redan tränat in. Principerna för ExpressJs är väldigt likt Javalin med några skillnader, samt några Java-specifika skillnader.

<h2>Användning</h2>
Starta upp programmet från Main som gör att programmet kommer köras på localhost:7070. Vi har en endpoint på localhost:7070/pixels vart vi får ut varje indivduella pixels färg per kordinat i vår canvas. Genom postman kan man uppdatera färgen för en specifik pixel. <br><br> Du kan även köra testmappen för att se att alla tester faktiskt går genom.

<img width="600" alt="tester" src="https://user-images.githubusercontent.com/71407043/200075427-e9b4b17e-620a-4a68-b81e-1ca5f1a8a24a.png">
<img width="500" alt="test2" src="https://user-images.githubusercontent.com/71407043/200076080-cab90e8e-40a6-43ae-9853-b7112cc29595.png">



