package reactor_tokenizer;

import java.io.InputStreamReader;

public interface Tokenizer<T> {

   /**
    * Get the next complete message if it exists, advancing the reactor_tokenizer to the next message.
    * @return the next complete message, and null if no complete message exist.
    */
   T nextMessage();
   
   /**
    * @return whether the input stream is still alive.
    */
   boolean isAlive();

   /**
    * adding a bufferedReader from which the reactor_tokenizer reads the input.
    */
   void addInputStream(InputStreamReader inputStreamReader);
}
