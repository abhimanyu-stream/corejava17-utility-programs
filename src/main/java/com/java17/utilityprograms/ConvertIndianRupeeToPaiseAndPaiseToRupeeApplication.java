package com.java17.utilityprograms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ConvertIndianRupeeToPaiseAndPaiseToRupeeApplication {

	/*public static void main(String[] args) {

		SpringApplication.run(ConvertIndianRupeeToPaiseAndPaiseToRupeeApplication.class, args);


	}*/
	private static final Logger logger = LoggerFactory.getLogger(ConvertIndianRupeeToPaiseAndPaiseToRupeeApplication.class);
	public static void main(String args[]) {

		SpringApplication.run(ConvertIndianRupeeToPaiseAndPaiseToRupeeApplication.class, args);

		logger.info("Ruppe in String : " + "    " + "Ruppe in Paise");
		logger.info("\t70" + "  \t\t\t\t" + convertIndianRupeeToPaise("70"));
		logger.info("\t70.00" + "  \t\t\t\t" + convertIndianRupeeToPaise("70.00"));
		logger.info("\t70.50" + "  \t\t\t\t" + convertIndianRupeeToPaise("70.50"));
		logger.info("\t0.50" + "  \t\t\t\t" + convertIndianRupeeToPaise("0.50"));
		logger.info("\t0.50" + "  \t\t\t\t" + convertIndianRupeeToPaise("1.50"));

		logger.info("Paise in String : " + "    " + "Paise in Ruppe");
		logger.info("\t7000" + "  \t\t\t\t" + convertIndianPaiseToRupee("7000"));

	}

	public static String convertIndianRupeeToPaise(String stringValue) {

		if (stringValue != null) {
			BigDecimal amount = new BigDecimal(stringValue);
			amount = amount.multiply(new BigDecimal(100));
			stringValue = amount.toString();
		}
		//System.out.println(stringValue + "  "+convertIndianPaiseToRupee(stringValue));
		return stringValue;
	}

	public static String convertIndianPaiseToRupee(String stringValue) {

		if (stringValue != null) {
			BigDecimal amount = new BigDecimal(stringValue);
			amount = amount.divide(new BigDecimal(100));
			stringValue = amount.toString();
		}
		return stringValue;
	}

}
