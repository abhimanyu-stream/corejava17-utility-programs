package com.java17.utilityprograms;

import java.util.UUID;

public class SKUCodeCreator {

    private static String skuCode;
    public static void main(String[] args) {

        String resultSkuCode = generateSkuCode("Dell", "InspironAIO", "ELECTRONICS", "COMPUTER");
        System.out.println(resultSkuCode);

    }



    public static String generateSkuCode(String brandName, String productName, String category, String subCategory) {
        String categoryCode = category.substring(0, 3).toUpperCase(); // First 3 letters of the category
        String subCategoryCode = subCategory.substring(0, 3).toUpperCase(); // First 3 letters of the subcategory
        String uniqueID = UUID.randomUUID().toString().substring(0, 8).toUpperCase(); // 8-character unique ID
        skuCode = brandName + "-" + productName + "-"+ categoryCode + "-" + subCategoryCode + "-" + uniqueID;
        return skuCode;
    }
}
