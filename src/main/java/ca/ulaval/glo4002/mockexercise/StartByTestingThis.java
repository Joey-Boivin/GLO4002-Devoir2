package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

public class StartByTestingThis {

    private CartFactory cartFactory;
    private ProductRepository productRepository;

    public StartByTestingThis(CartFactory cartFactory, ProductRepository productRepository){
        this.cartFactory = cartFactory;
        this.productRepository = productRepository;
    }
    public Invoice oneClickBuy(String clientEmail, String productSku) {
        Cart cart = cartFactory.create(clientEmail);
        Product product = productRepository.findBySku(productSku);
        cart.addProduct(product);
        // Étape 1 : Créer le cart avec le CartFactory
        // Étape 2 : Trouver le produit avec le ProductRepository
        // Étape 3 : Ajouter le produit au cart
        // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
        // Étape 5 : Retourner l'invoice
        return null;
    }
}
