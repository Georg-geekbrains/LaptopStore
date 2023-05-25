package org.example;

import java.util.*;

public class Store {
    public static void main(String[] args) {
        List<Laptop> laptops = createLaptops();

        Map<Integer, String> criteriaMap = createCriteriaMap();
        Map<Integer, Object> filterMap = getFilterValues(criteriaMap);

        List<Laptop> filteredLaptops = filterLaptops(laptops, filterMap);
        displayLaptops(filteredLaptops);
    }

    private static List<Laptop> createLaptops() {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Asus", 8, 512, "Windows 8", "Silver"));
        laptops.add(new Laptop("Dell", 16, 1024, "Windows 10", "Black"));
        laptops.add(new Laptop("Huawei", 8, 256, "Ubuntu", "Gray"));
        laptops.add(new Laptop("Apple", 16, 512, "macOS", "Silver"));
        return laptops;
    }

    private static Map<Integer, String> createCriteriaMap() {
        Map<Integer, String> criteriaMap = new HashMap<>();
        criteriaMap.put(1, "RAM");
        criteriaMap.put(2, "HDD capacity");
        criteriaMap.put(3, "Operating system");
        criteriaMap.put(4, "Color");
        return criteriaMap;
    }

    private static Map<Integer, Object> getFilterValues(Map<Integer, String> criteriaMap) {
        Map<Integer, Object> filterMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<Integer, String> entry : criteriaMap.entrySet()) {
            System.out.println("Enter the value for " + entry.getValue() + ": ");
            String value = scanner.nextLine();
            if (entry.getKey() == 1 || entry.getKey() == 2) {
                int intValue = Integer.parseInt(value);
                filterMap.put(entry.getKey(), intValue);
            } else {
                filterMap.put(entry.getKey(), value);
            }
        }

        return filterMap;
    }


    private static List<Laptop> filterLaptops(List<Laptop> laptops, Map<Integer, Object> filterMap) {
        List<Laptop> filteredLaptops = new ArrayList<>();

        for (Laptop laptop : laptops) {
            boolean meetsCriteria = true;

            for (Map.Entry<Integer, Object> entry : filterMap.entrySet()) {
                int criteriaId = entry.getKey();
                Object criteriaValue = entry.getValue();

                switch (criteriaId) {
                    case 1:
                        if (laptop.getRam() < (int) criteriaValue) {
                            meetsCriteria = false;
                        }
                        break;
                    case 2:
                        if (laptop.getHddCapacity() < (int) criteriaValue) {
                            meetsCriteria = false;
                        }
                        break;
                    case 3:
                        if (!laptop.getOperatingSystem().
                                equals(criteriaValue)) {
                            meetsCriteria = false;
                        }
                        break;
                    case 4:
                        if (!laptop.getColor().equals(criteriaValue)) {
                            meetsCriteria = false;
                        }
                        break;
                }
            }

            if (meetsCriteria) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }

    private static void displayLaptops(List<Laptop> laptops) {
        if (laptops.isEmpty()) {
            System.out.println("No laptops found matching the criteria.");
        } else {
            System.out.println("Filtered Laptops:");
            for (Laptop laptop : laptops) {
                System.out.println("Brand: " + laptop.getBrand());
                System.out.println("RAM: " + laptop.getRam());
                System.out.println("HDD Capacity: " + laptop.getHddCapacity());
                System.out.println("Operating System: " + laptop.getOperatingSystem());
                System.out.println("Color: " + laptop.getColor());
                System.out.println();
            }
        }
    }
}


