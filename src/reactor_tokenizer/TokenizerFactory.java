package reactor_tokenizer;

public interface TokenizerFactory<T> {
   MessageTokenizer<T> create();
}
