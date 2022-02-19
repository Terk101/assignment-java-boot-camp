package com.tantai.assignment;

import com.tantai.assignment.domain.Customer;
import com.tantai.assignment.domain.CustomerContact;
import com.tantai.assignment.domain.Product;
import com.tantai.assignment.repository.CustomerRepository;
import com.tantai.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JavaAssignmentApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JavaAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer();
		customer.setCustomerName("นาย สมมุติ ทดสอบ");
		CustomerContact customerContact = new CustomerContact();
		customerContact.setHouseNo("111/11");
		customerContact.setSoi("Main");
		customerContact.setDistrict("หลักสี่");
		customerContact.setSubdistrict("ทุ้งสอง");
		customerContact.setProvince("กรุงเทพ");
		customerContact.setZipCode("10210");
		customerContact.setEmail("test@gmail.com");
		customerContact.setPhoneNo("0984438421");
		customer.setCustomerContact(customerContact);


		Product nike = new Product();
		nike.setProductName("NIKE Downshifter 11 รองเท้าวิ่งผู้ชาย");
		nike.setProductDes("อัปเปอร์ตัดเย็บจากผ้าตาข่ายน้ำหนักเบาระบายอากาศได้ดี แต่งทับด้วยวัสดุสังเคราะห์ช่วยเพิ่มความทนทาน\n" +
				"พื้นรองเท้าด้านในและส่วนกลางทำจากโฟมนุ่มช่วยดูดซับแรงกระแทกและมอบความนุ่มสบายอย่างสูงสุดขณะสวมใส่\n" +
				"พื้นรองเท้าด้านนอกทำจากยางทนทาน แต่งแพทเทิร์นช่วยยึดเกาะ");
		nike.setProductPrice(BigDecimal.valueOf(1680.00));
		nike.setProductQuantity(40);

		Product nikeQuest4 = new Product();
		nikeQuest4.setProductName("NIKE QUEST4");
		nikeQuest4.setProductDes("อัปเปอร์น้ำหนักเบาและมินิมอลโดดเด่นด้วยตาข่ายระบายอากาศที่ปลายเท้า\n" +
				"ดีไซน์โปร่งแสงแสดงเทคโนโลยี Flywire ผ่านส่วนกลางเท้า\n" +
				"เชือก Flywire เพื่อให้รองรับส่วนกลางเท้าได้มากขึ้น\n" +
				"พื้นรองเท้าโฟมชั้นกลางแบบมีเท็กซ์เจอร์ช่วยเพิ่มความทนทานใน");
		nikeQuest4.setProductPrice(BigDecimal.valueOf(2160));
		nikeQuest4.setProductQuantity(10);

		Product nikeAirZoom = new Product();
		nikeAirZoom.setProductName("NIKE Air Zoom Rival Fly 3 รองเท้าวิ่งผู้ชาย");
		nikeAirZoom.setProductDes("พื้นโฟมที่ปรับปรุงใหม่ให้การรองรับที่นุ่มนวลกว่ารุ่นก่อนหน้า\n" +
				"เทคโนโลยี Zoom Air ที่ใต้เท้าเพื่อการตอบสนองและเด้งตัวได้ดี\n" +
				"ผ้าตาข่ายรอบนิ้วเท้าให้ความรู้สึกเบาและระบายอากาศได้ดี\n" +
				"ส่วนหุ้มข้อแบบดั้งเดิมให้ความกระชับพอดีที่ส้นเท้า\n" +
				"พื้นรองเท้าด้านนอกผลิตจากยางทนทานต่อแรงเสียดสีสูง");
		nikeAirZoom.setProductPrice(BigDecimal.valueOf(2640));
		nikeAirZoom.setProductQuantity(5);

		Product newBalance = new Product();
		newBalance.setProductName("NEW BALANCE FuelCell RC Elite V2 รองเท้าวิ่งผู้หญิง");
		newBalance.setProductDes("พอัปเปอร์ทำจากผ้าถักระบายอากาศได้ดี\n" +
				"โฟม FuelCell ให้ความรู้สึกคล่องตัวเพื่อช่วยให้คุณก้าวไปข้างหน้า\n" +
				"เพลทคาร์บอนไฟเบอร์แบบเต็มความยาวเท้าเพื่อช่วยส่งเสริมการส่งแรงกลับและการขับเคลื่อน");
		newBalance.setProductPrice(BigDecimal.valueOf(7490));
		newBalance.setProductQuantity(2);

		List<Product> shoes = Arrays.asList(nike, nikeQuest4, nikeAirZoom, newBalance);

		productRepository.saveAll(shoes);

		customerRepository.save(customer);
	}
}
