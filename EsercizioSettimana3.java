public class EsercizioSettimana3 {
    
}
/*
 * 1. Login e Sessione Globale – Pattern Singleton

Crea un gestore SessionManager Singleton che mantiene lo stato della sessione utente connesso.

Deve essere accessibile da tutta l'applicazione.
 */


//Inizio Singleton e controllo del login 
class SessionManager
{
 private static SessionManager istanza;//istanza del singleton
 private String userConnesso;// variabile per controllare l'utente che è connesso 
 
 //costruttore privato per impedire istanziazioni esterne
 private SessionManager()
 {

 }
 //creazione dell'istanza unica di sessione
 public static SessionManager getIstanza()
 {
    if(istanza== null)
    {
        istanza= new SessionManager();
    }
    return istanza;
 }
//metodo per il login dell'utente
 public void login(String username)
 {
    this.userConnesso= username;
    System.out.println("Utente loggato: " + username);
 }
 //metodo per il logout dell'utente
 public void logout()
 {
    System.out.println("Logout dell'utente:" + userConnesso);
    this.userConnesso=null;
 }
 //metodo per ottenere l'utente attualmente collegato
 public String getUserConnesso()
 {
    return userConnesso;
 }
}


//--------------------------------------------------------------------------------
/*
 * Comando di avvio/gioco – Pattern Facade
    Implementa una classe GameEngineFacade che coordina avvio del gioco, caricamento giocatore, impostazione strategia,
    iscrizione alle notifiche e avvio partita.
 */
class GameEngineFacade
{
    //dichiare le variabili
    
   
    //costruttore
   GameEngineFacade()
    {

    }
    //metodo per l'avvio del gioco
    public void avvioGioco()
    {

    }

}