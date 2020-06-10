package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product smartphone = new Product("Samsung Galaxy");
        Product laptop = new Product("Asus Laptop");
        Product console = new Product("SONY Playstation 5");

        Item samsungGal = new Item(smartphone, new BigDecimal(2000), 7500);
        Item samsungGal_LowerCapacity = new Item(smartphone, new BigDecimal(1500), 2000);
        Item asusLap = new Item(laptop, new BigDecimal(6000), 1500);
        Item asusLap_LowerCapacity = new Item(laptop, new BigDecimal(4500), 2000);
        Item ps5 = new Item(console, new BigDecimal(2200), 5500);
        Item ps5_LowerCapacity = new Item(console, new BigDecimal(1800), 2000);

        smartphone.getItems().add(samsungGal);
        smartphone.getItems().add(samsungGal_LowerCapacity);
        laptop.getItems().add(asusLap);
        laptop.getItems().add(asusLap_LowerCapacity);
        console.getItems().add(ps5);
        console.getItems().add(ps5_LowerCapacity);

        Invoice mostWantedProducts = new Invoice("0988889");
        mostWantedProducts.getItems().addAll(smartphone.getItems());
        mostWantedProducts.getItems().addAll(laptop.getItems());
        mostWantedProducts.getItems().addAll(console.getItems());

        samsungGal.setInvoice(mostWantedProducts);
        samsungGal_LowerCapacity.setInvoice(mostWantedProducts);
        asusLap.setInvoice(mostWantedProducts);
        asusLap_LowerCapacity.setInvoice(mostWantedProducts);
        ps5.setInvoice(mostWantedProducts);
        ps5_LowerCapacity.setInvoice(mostWantedProducts);

        //When
        invoiceDao.save(mostWantedProducts);
        int mostWantedProductsID = mostWantedProducts.getId();

        //Then
        Assert.assertNotEquals(0, mostWantedProductsID);

        //CleanUp
        invoiceDao.deleteById(mostWantedProductsID);
    }
}

