package com.s1155772.webshop.utils;

import com.s1155772.webshop.dao.brandRepository;
import com.s1155772.webshop.dao.productsRepository;
import com.s1155772.webshop.models.brand;
import com.s1155772.webshop.models.products;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Seeder {
    private productsRepository productsRepository;

    private brandRepository brandRepository;

    public Seeder(com.s1155772.webshop.dao.productsRepository productsRepository, com.s1155772.webshop.dao.brandRepository brandRepository) {
        this.productsRepository = productsRepository;
        this.brandRepository = brandRepository;
    }

    @EventListener
    public void Seed(ContextRefreshedEvent event){
        brand Asus = new brand("Asus", "NULL");
        brand MSI = new brand("MSI", "NULL");
        brand INNO3D = new brand("INNO3D", "NULL");
        brand Gigabyte = new brand("Gigabyte", "NULL");
        brand PNY = new brand("PNY", "NULL");
        this.brandRepository.save(Asus);
        this.brandRepository.save(MSI);
        this.brandRepository.save(INNO3D);
        this.brandRepository.save(Gigabyte);
        this.brandRepository.save(PNY);

        products product = new products("ASUS GeForce RTX 4070 DUAL-RTX 4070-O12G-EVO Videokaart", 2, Asus, "GeForce RTX 4070", "12GB", 2, 699, "De ASUS GeForce RTX 4070 DUAL-RTX 4070-O12G-EVO is een krachtige videokaart die ontworpen is voor veeleisende gaming en creatieve toepassingen. Met een GeForce RTX 4070 GPU, 12 GB GDDR6X-geheugen en 5888 CUDA-cores, biedt deze kaart uitstekende prestaties en ondersteuning voor geavanceerde grafische technologieën zoals DLSS 3. De hoge GPU-snelheden tot 2550 MHz zorgen voor soepele en gedetailleerde beeldweergave, waardoor gebruikers kunnen genieten van een immersieve gaming-ervaring of productieve creatieve workflows.", "https://www.megekko.nl/productimg/1104777/mini/1_ASUS-GeForce-RTX-4070-DUAL-RTX-4070-O12G-EVO-Videokaart.jpg");
        products product2 = new products("INNO3D GeForce RTX 5090 X3 32GB Videokaart", 215, INNO3D, "GeForce RTX 5090", "32GB", 3, 3899, "De INNO3D GeForce RTX 5090 X3 32GB Videokaart is een krachtige grafische kaart ontworpen voor de meest veeleisende pc-gebruikers. Met een geheugen van 32 GB GDDR7, een GPU-snelheid van maximaal 2467 MHz en 21760 CUDA-cores, biedt deze videokaart uitstekende prestaties voor veeleisende toepassingen zoals gamen, video-editing en GPU-accelerated computing. De kaart ondersteunt de nieuwste DLSS 4-technologie, waardoor gebruikers de beste beeldkwaliteit en prestaties kunnen ervaren.", "https://www.megekko.nl/productimg/199615/mini/1_INNO3D-GeForce-RTX-5090-X3-32GB-Videokaart.jpg");
        products product3 = new products("MSI GeForce RTX 5070 Ti 16G VANGUARD SOC LAUNCH EDITION Videokaart", 29, MSI, "GeForce RTX 5070 Ti", "16GB", 2, 1329, "De MSI GeForce RTX 5070 Ti 16G VANGUARD SOC LAUNCH EDITION is een krachtige videokaart die gamers en creatieve professionals een hoogwaardige grafische prestatie biedt. Met 16 GB GDDR7-geheugen, een GPU-snelheid tot 2602 MHz en 8960 CUDA-cores kan deze videokaart veeleisende taken aan. De DLSS 4-technologie en RGB-verlichting maken deze videokaart tot een aantrekkelijke keuze voor liefhebbers van toonaangevende grafische prestaties.", "https://www.megekko.nl/productimg/967789/mini/1_MSI-GeForce-RTX-5070-Ti-16G-VANGUARD-SOC-LAUNCH-EDITION-Videokaart.jpg");
        products product4 = new products("MSI GeForce RTX 5080 16G VANGUARD SOC LAUNCH EDITION Videokaart", 300, MSI, "GeForce RTX 5080", "16GB", 2, 1500, "De MSI GeForce RTX 5080 16G VANGUARD SOC LAUNCH EDITION is een krachtige videokaart die is uitgerust met de nieuwste NVIDIA GeForce RTX 5080-graphics engine. Met 16 GB GDDR7-videogeheugen, een maximale GPU-snelheid van 2745 MHz en 10.752 CUDA-cores biedt deze videokaart uitstekende prestaties voor veeleisende gaming en content creation. Daarnaast ondersteunt deze videokaart de nieuwste DLSS 4-technologie voor verbeterde beeldkwaliteit en efficiëntie. De LED-verlichting geeft de kaart een stijlvolle uitstraling.", "https://www.megekko.nl/productimg/967246/mini/1_MSI-GeForce-RTX-5080-16G-VANGUARD-SOC-LAUNCH-EDITION-Videokaart.jpg");
        products product5 = new products("ASUS Geforce RTX 4060 DUAL-RTX 4060-O8G-EVO Videokaart", 288, Asus, "GeForce RTX 4060", "8GB", 1, 349, "De ASUS Geforce RTX 4060 DUAL-RTX 4060-O8G-EVO is een krachtige videokaart die profiteert van de nieuwste NVIDIA GeForce RTX 4060-architectuur. Met 8 GB GDDR6-videogeheugen en snelheden tot 2535/2505 MHz biedt deze kaart uitstekende prestaties voor een breed scala aan gaming- en creatieve toepassingen. De 3072 CUDA-cores, gecombineerd met ondersteuning voor DLSS 3, maken van deze videokaart een aantrekkelijke keuze voor gebruikers op zoek naar een hoogwaardige grafische ervaring.", "https://www.megekko.nl/productimg/1111046/mini/1_ASUS-Geforce-RTX-4060-DUAL-RTX-4060-O8G-EVO-Videokaart.jpg");
        this.productsRepository.save(product);
        this.productsRepository.save(product2);
        this.productsRepository.save(product3);
        this.productsRepository.save(product4);
        this.productsRepository.save(product5);
    }

}
