import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product1 = new Product("Nokia", 999, "made in Finnish");
        Product product2 = new Product("Samsung", 1034, "made in Korea");
        Product product3 = new Product("Xiaomi", 1345, "made in China");
        Product product4 = new Product("Oppo", 1567, "made in China");
        Product product5 = new Product("Iphone", 1678, "made in America");
        Product[] productArr = {product1, product2, product3, product4, product5};

        // 1.	Hiển thị danh sách các sản phẩm có trong mảng
        System.out.println("Danh sách sản phẩm: ");
        printProductsArray(productArr);

        // 2.	Thêm một sản phẩm vào mảng
        Product product6 = new Product("Lenovo", 1120, "made in China");
        product2.setDescription("made in Korea");
        productArr = addToProductsArray(productArr, product6);
        System.out.println("Danh sách sản phẩm sau khi thêm sản phẩm mới: ");
        printProductsArray(productArr);

        // 3.	Xóa một sản phẩm khỏi mảng
        productArr = deleteFromProductsArray(productArr, product5);
        System.out.println("Danh sách sản phẩm sau khi một sản phẩm bị xóa: ");
        printProductsArray(productArr);

        // 4. Sắp xếp các sản phẩm trong mảng theo thứ tự A->Z
        System.out.println("Danh sách sản phẩm sau khi được sắp xếp: ");
        sortProductArrayByName(productArr);
        printProductsArray(productArr);


        // 5. Tìm kiếm một sản phẩm trong mảng dựa vào tên của sản phẩm đó.
        System.out.println();
        System.out.print("Tìm kiếm sản phẩm: ");

        String searchName = scanner.next();
        Product searchResult = searchProductInArrayByName(productArr, searchName);
        if (searchResult != null) {
            System.out.println("Kết quả tìm kiếm: ");
            printProductStringArray("ID", "Name", "Price ($)", "Description");
            printProduct(searchResult);
        } else {
            System.out.println("Tên sản phẩm không được tìm thấy.");
        }
    }


    public static void sortProductArrayByName(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = i + 1; j < products.length; j++) {
                if (products[i].getName().charAt(0) > products[j].getName().charAt(0)) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
    }


    public static Product searchProductInArrayByName(Product[] searchArray, String searchName) {
        for (Product product : searchArray) {
            if (product.getName().equals(searchName)) {
                return product;
            }
        }
        return null;
    }

    public static Product[] deleteFromProductsArray(Product[] sourceArray, Product product) {
        int index = -1;
        for (int i = 0; i < sourceArray.length; i++) {
            if (sourceArray[i].equals(product)) {
                index = i;
                break;
            }
        }

        Product[] result = new Product[sourceArray.length - 1];
        System.arraycopy(sourceArray, 0, result, 0, index);
        System.arraycopy(sourceArray, index + 1, result, index, sourceArray.length - index - 1);
        return result;
    }

    public static Product[] addToProductsArray(Product[] sourceArray, Product product) {
        Product[] result = new Product[sourceArray.length + 1];
        System.arraycopy(sourceArray, 0, result, 0, sourceArray.length);
        result[result.length - 1] = product;
        return result;
    }

    public static void printProductsArray(Product[] productArr) {
        printProductStringArray("ID", "Name", "Price ($)", "Description");
        for (int i = 0; i < productArr.length; i++) {
            printProduct(productArr[i]);
        }
    }

    public static void printProduct(Product product) {
        printProductStringArray(product.toStringArray());
    }

    public static void printProductStringArray(String... str) {
        System.out.printf("%-8s %-24s %-20s %s\n", str[0], str[1], str[2], str[3]);
    }


}