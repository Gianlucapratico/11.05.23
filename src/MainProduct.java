
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainProduct {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Il Signore degli Anelli", "Books", 150.0));
        products.add(new Product(2L, "iPhone 13", "Electronics", 999.0));
        products.add(new Product(3L, "pallone", "Gioco", 2.0));
        products.add(new Product(4L, "PokerStrategy", "Books", 120.0));
        products.add(new Product(5L, "Mouse senza fili", "Electronics", 20.0));
        products.add(new Product(6L, "Gatto", "Animal", 150.0));
        

        List<Product> expensiveBooks = products.stream()
                .filter(p -> p.getCategory().equals("Books"))
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(expensiveBooks);
        
        List<Customer> customer = new ArrayList<>();
        customer.add(new Customer(1L,"latte",2));
        customer.add(new Customer(2L,"biscotti",3));
        customer.add(new Customer(3L,"bicicletta",2));
        customer.add(new Customer(4L,"pallone",1));
        
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, "pending", LocalDate.now(), LocalDate.of(2023, 5, 18), products, customer.get(0)));
        orders.add(new Order(2L, "delivered", LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 15), products, customer.get(1)));
        orders.add(new Order(3L, "canceled", LocalDate.of(2021, 1, 1), null, products, customer.get(2)));
        orders.add(new Order(4L, "pending", LocalDate.now(), LocalDate.of(2023, 5, 18), 
                List.of(new Product(7L, "Pannolini", "baby", 15.0)), customer.get(3)));
        orders.add(new Order(5L, "pending", LocalDate.now(), LocalDate.of(2023, 5, 18), 
                List.of(new Product(8L, "latte", "baby", 15.0)), customer.get(3)));
        orders.add(new Order(5L, "pending", LocalDate.now(), LocalDate.of(2023, 5, 18), 
                List.of(new Product(8L, "latte", "kid", 15.0)), customer.get(3)));



        
       
        
        List<Order> babyOrders = orders.stream()
                .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals("baby")))
                .collect(Collectors.toList());
        System.out.println(babyOrders);
    }
}

