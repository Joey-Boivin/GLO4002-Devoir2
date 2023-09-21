package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class StartByTestingThisTest {

    private StartByTestingThis service;
    private static String CLIENT_EMAIL = "abcd@gmail.com";
    private static String PRODUCT_SKU = "SKU";
    @Mock
    private CartFactory cartFactory;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private Cart cart;
    @Mock
    private Product product;
    @BeforeEach
    public void setUp() {
        cartFactory = mock(CartFactory.class);
        productRepository = mock(ProductRepository.class);
        cart = mock(Cart.class);
        product = mock(Product.class);
        service = new StartByTestingThis(cartFactory, productRepository);
    }

    @Test
    public void givenClientEmail_whenOneClickBuy_thenCartIsCreated() {
        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        verify(cartFactory).create(CLIENT_EMAIL);
    }

    @Test
    public void givenProductSku_whenOneClickBy_thenProductIsFoundBySku() {
        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        verify(productRepository).findBySku(PRODUCT_SKU);
    }

    @Test
    public void whenOneClickBuy_thenProductIsAddedToCart() {
        when(cartFactory.create(CLIENT_EMAIL)).thenReturn(cart);
        when(productRepository.findBySku(PRODUCT_SKU)).thenReturn(product);
        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        verify(cart).addProduct(product);
    }


}
