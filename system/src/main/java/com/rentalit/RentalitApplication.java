package com.rentalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



@SpringBootApplication
public class RentalitApplication {

	public static void main(String[] args) {

		SpringApplication.run(RentalitApplication.class, args);

		mongo_DB test = new mongo_DB();


		System.out.println("Enter your Product: ");
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        System.out.println("Enter the Description: ");
        String description = scanner.nextLine();
        System.out.println("What is the condition: (BAD, USED, GOOD, NEW)");
        String condition = scanner.nextLine();
        validator val = new validator();
        if(val.isValid(product,description,condition)) {
            test.setDescription(description);
            test.setProduct_Name(product);
            test.setConditions(mongo_DB.Conditions.valueOf(condition));
            test.setRented(0);
            test.add_Listing(test.getProduct_Name(), test.getConditions().toString(), test.getDescription(), test.getRented());
        }else{
            System.out.println("Your output doesnt fit our requirments, please reenter: ");

        }

	}

}

