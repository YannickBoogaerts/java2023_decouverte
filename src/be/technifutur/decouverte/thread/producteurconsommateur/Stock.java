package be.technifutur.decouverte.thread.producteurconsommateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stock {
    private List<String> stock = new ArrayList<>();
    private boolean open = false;

    public boolean isOpen() {
        return open;
    }

    public Stock setOpen(boolean open) {
        this.open = open;
        return this;
    }

    public boolean add(String produit) {
        boolean add = false;
        if (stock.size() < 3 && open) {
            add = stock.add(produit);
            System.out.println(produit+ " ajouté");
        }
        return add;
    }

    public Optional<String> remove() {
        Optional<String> produit;
        if(stock.size()>0 && open){
            produit = Optional.of(stock.remove(0));
            System.out.printf("%s retirer par %s%n",produit.get(), Thread.currentThread().getName());
        }else{
            produit = Optional.empty();
        }
        return produit;
    }
}
