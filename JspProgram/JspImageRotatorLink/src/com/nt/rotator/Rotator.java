package com.nt.rotator;

import java.util.Random;

public class Rotator {
	String[] links= {"https://www.marutisuzuki.com/",
			         "https://www.hondacarindia.com/",
			      	  "https://www.toyotabharat.com/",
			      	  "https://www.tatamotors.com/",
			      	  "https://www.mahindra.com/"};
	String[] image= {"hondacity.jpg",
					 "Mahindra-XUV-500.jpg",
					 "Maruti_Ciaz.jpg",
					 "tata-zest.jpg",
					 "toyta.jpg"};
	
	private int counter=0;
	public String getImage() {
		return image[counter];
	}
	public String getLinks() {
		return links[counter];
	}
	public void nextAdvertisement() {
		Random rd=new Random();
		counter=rd.nextInt(4);
	}
	/*public void setLinks(String[] image) {
		this.image=image;
	}
	public void setILink(String[] links) {
		this.links=links;
	}*/
}
