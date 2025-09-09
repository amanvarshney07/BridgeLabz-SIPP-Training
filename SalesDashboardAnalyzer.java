import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SalesDashboardAnalyzer {

    static class Item {
        private final String name;
        private final BigDecimal price;
        private final String category;

        public Item(String name, BigDecimal price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }
        public String getName() { return name; }
        public BigDecimal getPrice() { return price; }
        public String getCategory() { return category; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;
            Item other = (Item) o;
            return Objects.equals(name, other.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
        @Override
        public String toString() {
            return String.format("%s (%s) $%s", name, category, price);
        }
    }

    static class Order {
        private final LocalDate date;
        private final List<Item> items;
        public Order(LocalDate date, List<Item> items) {
            this.date = date;
            this.items = items;
        }
        public LocalDate getDate() { return date; }
        public List<Item> getItems() { return items; }
    }

    static class Customer {
        private final String id;
        private final String name;
        public Customer(String id, String name) {
            this.id = id; this.name = name;
        }
        public String getId() { return id; }
        public String getName() { return name; }
        @Override public String toString() { return name + "(" + id + ")"; }
    }

    static class Store {
        private final String id;
        private final Map<Customer, List<Order>> customerOrders;
        public Store(String id, Map<Customer, List<Order>> customerOrders) {
            this.id = id; this.customerOrders = customerOrders;
        }
        public Map<Customer, List<Order>> getCustomerOrders() { return customerOrders; }
        public String getId() { return id; }
    }

    public static void analyze(Map<String, List<Store>> cityToStoresMap) {
        LocalDate now = LocalDate.now();
        LocalDate cutoff = now.minusDays(60);

        List<Item> topAffordablePicks = cityToStoresMap.values().stream()
                .flatMap(List::stream)
                .flatMap(store -> store.getCustomerOrders().entrySet().stream())
                .filter(entry -> entry.getValue().stream()
                        .filter(order -> !order.getDate().isBefore(cutoff))
                        .count() >= 3)
                .flatMap(entry -> entry.getValue().stream()
                        .filter(order -> !order.getDate().isBefore(cutoff))
                        .flatMap(order -> order.getItems().stream()))
                .distinct()
                .sorted(Comparator.comparing(Item::getPrice).reversed())
                .peek(item -> System.out.println("[peek] " + item.getName() + " - $" + item.getPrice()))
                .skip(2)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("\nTop Affordable Picks (after skip/limit):");
        topAffordablePicks.forEach(System.out::println);

        Map<String, List<Item>> groupedByCategory =
                topAffordablePicks.stream().collect(Collectors.groupingBy(Item::getCategory));

        System.out.println("\nGrouped by category:");
        groupedByCategory.forEach((cat, items) -> {
            System.out.println(cat + ": " + items.size() + " items -> " + items);
        });

        int electronicsCount = groupedByCategory.getOrDefault("Electronics", Collections.emptyList()).size();
        System.out.println("\nElectronics count: " + electronicsCount);

        boolean anyOver500 = topAffordablePicks.stream()
                .anyMatch(i -> i.getPrice().compareTo(new BigDecimal("500")) > 0);
        System.out.println("Any item over $500? " + anyOver500);

        boolean allAbove10 = topAffordablePicks.stream()
                .allMatch(i -> i.getPrice().compareTo(new BigDecimal("10")) > 0);
        System.out.println("All items > $10? " + allAbove10);

        boolean noneEmptyNames = topAffordablePicks.stream()
                .noneMatch(i -> i.getName() == null || i.getName().trim().isEmpty());
        System.out.println("None have empty/null names? " + noneEmptyNames);

        Optional<Item> firstHomeAppliance = groupedByCategory.getOrDefault("Home Appliances", Collections.emptyList())
                .stream().findFirst();
        System.out.println("First Home Appliance: " + firstHomeAppliance);

        Optional<Item> anyFitness = groupedByCategory.getOrDefault("Fitness", Collections.emptyList())
                .stream().findAny();
        System.out.println("Any Fitness item: " + anyFitness);

        BigDecimal totalValue = topAffordablePicks.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total value of selected items: $" + totalValue);
    }

    public static void main(String[] args) {
        Item tv = new Item("UltraHD TV", new BigDecimal("1200"), "Electronics");
        Item laptop = new Item("Gaming Laptop", new BigDecimal("1500"), "Electronics");
        Item headphones = new Item("NoiseHeadphones", new BigDecimal("120"), "Electronics");
        Item blender = new Item("SuperBlender", new BigDecimal("80"), "Home Appliances");
        Item kettle = new Item("QuickKettle", new BigDecimal("45"), "Home Appliances");
        Item yogaMat = new Item("YogaMatPro", new BigDecimal("35"), "Fitness");
        Item dumbbells = new Item("DumbbellsSet", new BigDecimal("60"), "Fitness");
        Item phone = new Item("SmartPhone X", new BigDecimal("700"), "Electronics");
        Item toaster = new Item("Toasty", new BigDecimal("25"), "Home Appliances");
        Item mug = new Item("CoffeeMug", new BigDecimal("12"), "Home Appliances");
        Item cheapGadget = new Item("PromoGadget", new BigDecimal("9"), "Electronics");

        LocalDate now = LocalDate.now();
        Order recent1 = new Order(now.minusDays(10), Arrays.asList(tv, headphones));
        Order recent2 = new Order(now.minusDays(20), Arrays.asList(laptop));
        Order recent3 = new Order(now.minusDays(25), Arrays.asList(phone, headphones));
        Order recent4 = new Order(now.minusDays(5), Arrays.asList(kettle, mug));
        Order recent5 = new Order(now.minusDays(30), Arrays.asList(yogaMat, dumbbells));
        Order old = new Order(now.minusDays(120), Arrays.asList(toaster, cheapGadget));

        Customer c1 = new Customer("C1", "Alice");
        Customer c2 = new Customer("C2", "Bob");
        Customer c3 = new Customer("C3", "Carlos");

        Map<Customer, List<Order>> store1CustOrders = new HashMap<>();
        store1CustOrders.put(c1, Arrays.asList(recent1, recent2, recent3, old));
        store1CustOrders.put(c2, Arrays.asList(recent4, recent5));
        store1CustOrders.put(c3, Arrays.asList(recent1, recent3, recent4));

        Store storeA = new Store("Store-A", store1CustOrders);

        Map<Customer, List<Order>> store2CustOrders = new HashMap<>();
        store2CustOrders.put(c2, Arrays.asList(recent1, recent2, old));
        Store storeB = new Store("Store-B", store2CustOrders);

        Map<String, List<Store>> cityToStoresMap = new HashMap<>();
        cityToStoresMap.put("CityOne", Arrays.asList(storeA, storeB));
        cityToStoresMap.put("CityTwo", Collections.singletonList(storeB));

        analyze(cityToStoresMap);
    }
}
