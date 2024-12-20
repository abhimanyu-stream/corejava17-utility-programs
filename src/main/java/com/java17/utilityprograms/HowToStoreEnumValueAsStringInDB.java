package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;

import java.util.EnumSet;
import java.util.stream.Collectors;

public class HowToStoreEnumValueAsStringInDB {

    public static void main(String[] args) {


        /*System.out.println(ProductSubCategory.SMARTPHONES);
        System.out.println(ProductSubCategory.CLOTHINGTOPWAER);
        System.out.println(ProductSubCategory.CLOTHINGUNDERWEAR);
        System.out.println(ProductSubCategory.CLOTHINGBOTTOMWEAR);
        System.out.println(ProductSubCategory.SHOEFORMAL);csss
        System.out.println(ProductCategory.GROCERY.name());*/
        System.out.println(ProductSubCategory.enumSet);
        //ProductCategory.productCategoryEnumSet.stream().filter(f->f.name()).collect(Collectors.toList());
       // ProductSubCategory.enumSet.stream().map();

    }
}
enum ProductSubCategory {

    //Note remove arguments if some mismatch info store in db
    /*SMARTPHONES(ProductCategory.ELECTRONICS.name()+ "->" +"SMARTPHONES"),
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
    }*/
    SMARTPHONES("SMARTPHONES",ProductCategory.ELECTRONICS.name()),
    //LAPTOPS(ProductCategory.ELECTRONICS.name()),
    LAPTOPS("LAPTOPS",ProductCategory.ELECTRONICS.name());
    /*DESKTOP(ProductCategory.ELECTRONICS.name()),
    TABLET(ProductCategory.ELECTRONICS.name()),

    CLOTHINGTOPWAER(ProductCategory.FASHION.name()+"->"+"CLOTHING"+"->"+"TOPWAER"),
    CLOTHINGUNDERWEAR(ProductCategory.FASHION.name()+"->"+"CLOTHING"+"->"+"UNDERWEAR"),
    CLOTHINGBOTTOMWEAR(ProductCategory.FASHION.name()+"->"+"CLOTHING"+"->"+"BOTTOMWEAR"),


    FOOTWEAR(ProductCategory.FASHION.name()),
    SUNGLASS(ProductCategory.FASHION.name()),
    SHOEFORMAL(ProductCategory.FASHION.name()+"->"+"NON-CLOTHING"+"->"+"SHOEFORMAL"),
    SHOESPORTS(ProductCategory.FASHION.name()+"->"+"NON-CLOTHING"+"->"+"SHOESPORTS"),



    DININGTABLE(ProductCategory.HOMEDECORATION.name()),
    BEDSHEET(ProductCategory.HOMEDECORATION.name()),

    RICE(ProductCategory.FOODANDBEVERAGE.name()),

    MIXERGRINDER(ProductCategory.GROCERY.name()),
    UTENSIL(ProductCategory.GROCERY.name()),
    KITCHEN_APPLIANCES(ProductCategory.GROCERY.name()),

    LITERATURE(ProductCategory.BOOKSMOVIESMUSICGAMES.name()),
    BOOK(ProductCategory.BOOKSMOVIESMUSICGAMES.name()),


    PERFUME(ProductCategory.BEAUTYANDPERSONALCARE.name()),
    CREAM(ProductCategory.BEAUTYANDPERSONALCARE.name()),
    SOAP(ProductCategory.BEAUTYANDPERSONALCARE.name()),
    SKINCARE(ProductCategory.BEAUTYANDPERSONALCARE.name());
*/

    String productSubCategory;
    String parentCategory;
    ProductSubCategory(String productSubCategory, String parentCategory) {
        this.productSubCategory = productSubCategory;
        this.parentCategory=parentCategory;
    }

    /*public String getProductSubCategory() {
        return productSubCategory;
    }*/
   /* public String getParentCategory() {
        return getProductSubCategory();
    }*/

    public static final EnumSet<ProductSubCategory> enumSet = EnumSet.of(SMARTPHONES, LAPTOPS);

    @Override
    public String toString() {
        return "ProductSubCategory{" +
                "productSubCategory='" + productSubCategory + '\'' +
                ", parentCategory='" + parentCategory + '\'' +
                '}';
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
    public static final EnumSet<ProductCategory> productCategoryEnumSet = EnumSet.of(    FASHION,ELECTRONICS,BEAUTYANDPERSONALCARE,HOMEDECORATION,BOOKSMOVIESMUSICGAMES,FOODANDBEVERAGE,GROCERY);

}
