# IT-Academy-S1.03-Java Tests-Nivel1

### Exercici 1: Biblioteca

Crea una classe Java que gestioni una col·lecció de llibres en una biblioteca. La classe ha de permetre afegir llibres, recuperar la llista de llibres, obtenir un llibre específic per la seva posició, afegir un llibre en una posició específica i eliminar un llibre per títol.

Implementa les següents funcionalitats:

La classe ha de permetre afegir llibres a la col·lecció.
- S'ha de poder recuperar la llista completa de llibres
- S'ha de poder obtenir el títol d'un llibre donada una posició.
- S'ha de poder afegir un llibre en una posició específica.
- S'ha de poder eliminar un llibre per títol.


Verifica el seu correcte funcionament amb JUnit:
- Verifiquen que la llista de llibres no és nul·la després de crear un nou objecte.
- Confirmen que la llista té una mida esperada després d'inserir diversos llibres.
- Asseguren que la llista conté un llibre específic en la seva posició correcta.
- Verifiquen que no hi ha títols de llibres duplicats a la llista.
- Comproven que es pot recuperar el títol d'un llibre donada una posició específica.
- Asseguren que afegir un llibre modifica correctament la llista.
- Confirmen que eliminar un llibre disminueix la mida de la llista.
- Verifiquen que la llista roman ordenada alfabèticament després d'afegir o eliminar un llibre.


### Tecnologies Utilitzades

Java

### Requisits

Java 23.0

### Instal·lació

Clona aquest repositori: -> git clone  
Accedeix al directori del projecte:   cd Nivell1-Biblioteca

### Contribucions

Les contribucions són benvingudes! Per favor, segueix els següents passos per a contribuir:

Fes un fork del repositori  
Crea una nova branca:  git checkout -b feature/NovaFuncionalitat  
Fes els teus canvis i commiteja'ls: git commit -m 'Afegeix Nova Funcionalitat'  
Puja els canvis a la teva branca: git push origin feature/NovaFuncionalitat  
Fes un pull request

### Notes Exercici 1
He creat un projecte de Java amb Build System Maden per poder afegir dependències. He afegit JUnit.

Per cada test, creo un Library object. Testejo les diferents coses que es demanen respecte a la biblioteca. També testejo que, després de esborrar i afegir llibres, les dues estructures de dades (sorted i unsorted) tenen el mateix tamany.