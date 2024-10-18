package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;

public class HowToStoreEnumValueAsStringInDB {

    public static void main(String[] args) {


        System.out.println(ProductSubCategory.SMARTPHONES);
        System.out.println(ProductSubCategory.CLOTHINGTOPWAER);
        System.out.println(ProductSubCategory.CLOTHINGUNDERWEAR);
        System.out.println(ProductSubCategory.CLOTHINGBOTTOMWEAR);
        System.out.println(ProductSubCategory.SHOEFORMAL);
        System.out.println(ProductSubCategory.SHOESPORTS);
        System.out.println(ProductCategory.GROCERY.name());

    }
}
enum ProductSubCategory {

    //Note remove arguments if some mismatch info store in db
    SMARTPHONES(ProductCategory.ELECTRONICS.name()+ "->" +"SMARTPHONES"),
    LAPTOPS(ProductCategory.ELECTRONICS.name()),
    DESKTOP(ProductCategory.ELECTRONICS.name()),
    TABLET(ProductCategory.ELECTRONICS.name()),

    CLOTHINGTOPWAER(ProductCategory.FASHION.name()+"->"+"CLOTHING"+"->"+"TOPWAER"),
    CLOTHINGUNDERWEAR(ProductCategory.FASHION.name()+"->"+"CLOTHING"+"->"+"UNDERWEAR"),
    CLOTHINGBOTTOMWEAR(ProductCategory.FASHION.name()+"->"+"CLOTHING"+"->"+"BOTTOMWEAR"),


    FOOTWEAR(ProductCategory.FASHION.name()),
    SUNGLASS(ProductCategory.FASHION.name()),
    SHOEFORMAL(ProductCategory.FASHION.name()+"->"+"NON-CLOTHING"+"->"+"SHOEFORMAL"),
    SHOESPORTS(ProductCategory.FASHION.name()+"->"+"NON-CLOTHING"+"->"+"SHOESPORTS");

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
    private String parentCategory;

    public String getParentCategory() {
        return getProductSubCategory();
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
