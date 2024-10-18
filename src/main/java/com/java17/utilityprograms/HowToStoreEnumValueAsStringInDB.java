package com.java17.utilityprograms;


public class HowToStoreEnumValueAsStringInDB {

    public static void main(String[] args) {

        System.out.println(ProductSubCategory.SMARTPHONES);
        System.out.println(ProductCategory.GROCERY.name());

    }
}
enum ProductSubCategory {

    //Note remove arguments if some mismatch info store in db
    SMARTPHONES(ProductCategory.ELECTRONICS.name()),
    LAPTOPS(ProductCategory.ELECTRONICS.name()),
    DESKTOP(ProductCategory.ELECTRONICS.name()),
    TABLET(ProductCategory.ELECTRONICS.name()),

    CLOTHING(ProductCategory.FASHION.name()),
    FOOTWEAR(ProductCategory.FASHION.name()),
    SUNGLASS(ProductCategory.FASHION.name());

    public String getProductSubCategory() {
        return productSubCategory;
    }
    String productSubCategory;
    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }
    ProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }
    public String toString() {
        return productSubCategory;
    }


}
enum ProductCategory {
    FASHION("FASHION"),ELECTRONICS("ELECTRONICS"),BEAUTYANDPERSONALCARE("BEAUTYANDPERSONALCARE"),HOMEDECORATION("HOMEDECORATION"),BOOKSMOVIESMUSICGAMES("BOOKSMOVIESMUSICGAMES"),FOODANDBEVERAGE("FOODANDBEVERAGE"),GROCERY("GROCERY");
    String productCategory;
    ProductCategory(String productCategory){
        this.productCategory=productCategory;
    }
    public String toString(){
        return productCategory;
    }
}
