package com.s1155772.webshop.utils;

import com.s1155772.webshop.dao.*;
import com.s1155772.webshop.models.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Seeder {
    private ProductsRepository productsRepository;

    private BrandRepository brandRepository;

    private CategoryRepository categoryRepository;

    private BestellingRepository bestellingRepository;

    private BestellingProductRepository bestellingProductRepository;



    private UserRepository userRepository;

    public Seeder(ProductsRepository productsRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, BestellingRepository bestellingRepository, BestellingProductRepository bestellingProductRepository, UserRepository userRepository) {
        this.productsRepository = productsRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.bestellingRepository = bestellingRepository;
        this.bestellingProductRepository = bestellingProductRepository;
        this.userRepository = userRepository;
    }

    @EventListener
    public void Seed(ContextRefreshedEvent event){
        CustomUser customUser = new CustomUser();
        customUser.setEmail("user@mail.com");
        customUser.setPassword(new BCryptPasswordEncoder().encode("hallo"));
        customUser.setVoornaam("Jasper");
        userRepository.save(customUser);


        Categorie videokaarten = new Categorie("Videokaarten");
        Categorie processoren = new Categorie("Processoren");
        Categorie moederborden = new Categorie("Moederborden");
        this.categoryRepository.save(videokaarten);
        this.categoryRepository.save(processoren);
        this.categoryRepository.save(moederborden);

        Brand Asus = new Brand("Asus", "https://icon-icons.com/icons2/3911/PNG/512/asus_logo_icon_247542.png");
        Brand MSI = new Brand("MSI", "https://cdn.iconscout.com/icon/free/png-256/free-msi-1-286075.png");
        Brand INNO3D = new Brand("INNO3D", "https://images.seeklogo.com/logo-png/38/1/inno3d-logo-png_seeklogo-386197.png");
        Brand Gigabyte = new Brand("Gigabyte", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzXWXPZo00D9OsewodWmom-B7woZ3OT_EN1Q&s");
        Brand AMD = new Brand("AMD", "https://cdn.freebiesupply.com/logos/large/2x/amd-logo-png-transparent.png");
        this.brandRepository.save(Asus);
        this.brandRepository.save(MSI);
        this.brandRepository.save(INNO3D);
        this.brandRepository.save(Gigabyte);
        this.brandRepository.save(AMD);

        Product product = new Product("ASUS GeForce RTX 4070 DUAL-RTX 4070-O12G-EVO", 244000, Asus, videokaarten, 699, "De ASUS GeForce RTX 4070 DUAL-RTX 4070-O12G-EVO is een krachtige videokaart die ontworpen is voor veeleisende gaming en creatieve toepassingen. Met een GeForce RTX 4070 GPU, 12 GB GDDR6X-geheugen en 5888 CUDA-cores, biedt deze kaart uitstekende prestaties en ondersteuning voor geavanceerde grafische technologieën zoals DLSS 3. De hoge GPU-snelheden tot 2550 MHz zorgen voor soepele en gedetailleerde beeldweergave, waardoor gebruikers kunnen genieten van een immersieve gaming-ervaring of productieve creatieve workflows.", "The ASUS GeForce RTX 4070 DUAL-RTX 4070-O12G-EVO is a powerful graphics card designed for demanding gaming and creative applications. Featuring a GeForce RTX 4070 GPU, 12GB of GDDR6X memory, and 5888 CUDA cores, this card provides excellent performance and support for advanced graphics technologies like DLSS 3. Fast GPU speeds of up to 2550MHz ensure smooth and detailed image rendering, allowing you to enjoy immersive gaming experiences or productive creative workflows.", "https://www.megekko.nl/productimg/1104777/mini/1_ASUS-GeForce-RTX-4070-DUAL-RTX-4070-O12G-EVO-Videokaart.jpg");
        Product product2 = new Product("INNO3D GeForce RTX 5090 X3 32GB", 215000, INNO3D, videokaarten, 3899, "De INNO3D GeForce RTX 5090 X3 32GB Videokaart is een krachtige grafische kaart ontworpen voor de meest veeleisende pc-gebruikers. Met een geheugen van 32 GB GDDR7, een GPU-snelheid van maximaal 2467 MHz en 21760 CUDA-cores, biedt deze videokaart uitstekende prestaties voor veeleisende toepassingen zoals gamen, video-editing en GPU-accelerated computing. De kaart ondersteunt de nieuwste DLSS 4-technologie, waardoor gebruikers de beste beeldkwaliteit en prestaties kunnen ervaren.", "The INNO3D GeForce RTX 5090 X3 32GB Video Card is a powerful graphics card designed for the most demanding PC users. With 32GB GDDR7 memory, a GPU speed of up to 2467MHz and 21760 CUDA cores, this video card offers excellent performance for demanding applications such as gaming, video editing and GPU-accelerated computing. The card supports the latest DLSS 4 technology, allowing users to experience the best image quality and performance.", "https://www.megekko.nl/productimg/199615/mini/1_INNO3D-GeForce-RTX-5090-X3-32GB-Videokaart.jpg");
        Product product3 = new Product("MSI GeForce RTX 5070 Ti 16G VANGUARD SOC LAUNCH EDITION", 290000, MSI, videokaarten, 1329, "De MSI GeForce RTX 5070 Ti 16G VANGUARD SOC LAUNCH EDITION is een krachtige videokaart die gamers en creatieve professionals een hoogwaardige grafische prestatie biedt. Met 16 GB GDDR7-geheugen, een GPU-snelheid tot 2602 MHz en 8960 CUDA-cores kan deze videokaart veeleisende taken aan. De DLSS 4-technologie en RGB-verlichting maken deze videokaart tot een aantrekkelijke keuze voor liefhebbers van toonaangevende grafische prestaties.", "The MSI GeForce RTX 5070 Ti 16G VANGUARD SOC LAUNCH EDITION is a powerful graphics card that offers gamers and creative professionals high-end graphics performance. With 16GB of GDDR7 memory, a GPU speed of up to 2602MHz and 8960 CUDA cores, this graphics card can handle demanding tasks. The DLSS 4 technology and RGB lighting make this graphics card an attractive choice for enthusiasts of leading graphics performance.", "https://www.megekko.nl/productimg/967789/mini/1_MSI-GeForce-RTX-5070-Ti-16G-VANGUARD-SOC-LAUNCH-EDITION-Videokaart.jpg");
        Product product4 = new Product("MSI GeForce RTX 5080 16G VANGUARD SOC LAUNCH EDITION", 300000, MSI, videokaarten, 1500, "De MSI GeForce RTX 5080 16G VANGUARD SOC LAUNCH EDITION is een krachtige videokaart die is uitgerust met de nieuwste NVIDIA GeForce RTX 5080-graphics engine. Met 16 GB GDDR7-videogeheugen, een maximale GPU-snelheid van 2745 MHz en 10.752 CUDA-cores biedt deze videokaart uitstekende prestaties voor veeleisende gaming en content creation. Daarnaast ondersteunt deze videokaart de nieuwste DLSS 4-technologie voor verbeterde beeldkwaliteit en efficiëntie. De LED-verlichting geeft de kaart een stijlvolle uitstraling.", "The MSI GeForce RTX 5080 16G VANGUARD SOC LAUNCH EDITION is a powerful graphics card equipped with the latest NVIDIA GeForce RTX 5080 graphics engine. With 16 GB of GDDR7 video memory, a maximum GPU speed of 2745 MHz and 10,752 CUDA cores, this graphics card offers excellent performance for demanding gaming and content creation. In addition, this graphics card supports the latest DLSS 4 technology for improved image quality and efficiency. The LED lighting gives the card a stylish look.", "https://www.megekko.nl/productimg/967246/mini/1_MSI-GeForce-RTX-5080-16G-VANGUARD-SOC-LAUNCH-EDITION-Videokaart.jpg");
        Product product5 = new Product("ASUS Geforce RTX 4060 DUAL-RTX 4060-O8G-EVO", 288000, Asus, videokaarten, 349, "De ASUS Geforce RTX 4060 DUAL-RTX 4060-O8G-EVO is een krachtige videokaart die profiteert van de nieuwste NVIDIA GeForce RTX 4060-architectuur. Met 8 GB GDDR6-videogeheugen en snelheden tot 2535/2505 MHz biedt deze kaart uitstekende prestaties voor een breed scala aan gaming- en creatieve toepassingen. De 3072 CUDA-cores, gecombineerd met ondersteuning voor DLSS 3, maken van deze videokaart een aantrekkelijke keuze voor gebruikers op zoek naar een hoogwaardige grafische ervaring.", "The ASUS Geforce RTX 4060 DUAL-RTX 4060-O8G-EVO is a powerful graphics card that takes advantage of the latest NVIDIA GeForce RTX 4060 architecture. With 8GB of GDDR6 video memory and speeds of up to 2535/2505 MHz, this card provides excellent performance for a wide range of gaming and creative applications. Its 3072 CUDA cores, combined with support for DLSS 3, make this graphics card a compelling choice for users seeking a high-end graphics experience." ,"https://www.megekko.nl/productimg/1111046/mini/1_ASUS-Geforce-RTX-4060-DUAL-RTX-4060-O8G-EVO-Videokaart.jpg");


        Product product6 = new Product("AMD Ryzen 7 9800X3D", 315000, AMD, processoren, 574, "De AMD Ryzen 7 9800X3D is een krachtige 8-core processor in de Socket AM5-serie. Met een standaardkloksnelheid van 4.70 GHz en een turbokloksnelheid tot 5.20 GHz biedt deze processor uitstekende prestaties voor gaming en veeleisende workloads. De processor is uitgerust met AMD Radeon Graphics, maar wordt niet geleverd met een koeler. Dit maakt het een aantrekkelijke keuze voor pc-bouwers die op zoek zijn naar een flexibele en efficiënte processor voor hun nieuwe AM5-systeem.", "The AMD Ryzen 7 9800X3D is a powerful 8-core processor in the Socket AM5 series. With a base clock speed of 4.70 GHz and a turbo clock speed of up to 5.20 GHz, this processor offers excellent performance for gaming and demanding workloads. The processor is equipped with AMD Radeon Graphics, but does not come with a cooler. This makes it an attractive choice for PC builders looking for a flexible and efficient processor for their new AM5 system.", "https://www.megekko.nl/productimg/1752769/mini/1_AMD-Ryzen-7-9800X3D-Processor.jpg");
        Product product7 = new Product("AMD Ryzen 7 9700X", 928000, AMD, processoren, 355, "De AMD Ryzen 7 9700X is een krachtige processor in de Socket AM5-serie. Met 8 cores en een basiskloksnelheid van 3,80 GHz die kan worden opgevoerd tot 5,50 GHz, biedt deze processor uitstekende prestaties voor veeleisende taken. De processor ondersteunt AMD Radeon Graphics voor grafische taken, maar wordt geleverd zonder een eigen koeler. Deze AMD Ryzen 7-processor is een goede keuze voor gebruikers die op zoek zijn naar een robuuste en efficiënte processor voor hun desktop-pc.", "The AMD Ryzen 7 9700X is a powerful processor in the Socket AM5 series. With 8 cores and a base clock speed of 3.80 GHz that can be boosted up to 5.50 GHz, this processor offers excellent performance for demanding tasks. The processor supports AMD Radeon Graphics for graphical tasks, but does not come with its own cooler. This AMD Ryzen 7 processor is a good choice for users looking for a robust and efficient processor for their desktop PC.", "https://www.megekko.nl/productimg/295029/mini/1_AMD-Ryzen-7-9700X-Processor.jpg");
        Product product8 = new Product("AMD Ryzen 5 7600", 756000, AMD, processoren, 209, "De AMD Ryzen 5 7600 is een krachtige 6-core processor met een basiskloksnelheid van 3,80 GHz en een turbokloksnelheid tot 5,10 GHz. Dankzij de nieuwe AM5-socket en de geïntegreerde AMD Radeon Graphics biedt deze processor een uitstekende prestatie voor een breed scala aan toepassingen. Met de meegeleverde koeler is deze processor klaar voor gebruik.", "The AMD Ryzen 5 7600 is a powerful 6-core processor with a base clock speed of 3.80 GHz and a turbo clock speed of up to 5.10 GHz. Thanks to the new AM5 socket and the integrated AMD Radeon Graphics, this processor offers excellent performance for a wide range of applications. With the included cooler, this processor is ready for use.", "https://www.megekko.nl/productimg/294942/mini/1_AMD-Ryzen-5-7600-Processor.jpg");
        Product product9 = new Product("AMD Ryzen 7 8700G", 346000, AMD, processoren, 275, "De AMD Ryzen 7 8700G processor biedt een krachtige 8-cores CPU met een basiskloksnelheid van 4,20 GHz en een turbocloksnelheid tot 5,10 GHz. Deze processor is uitgerust met de geïntegreerde AMD Radeon 780M grafische eenheid, waardoor hij geschikt is voor zowel veeleisende toepassingen als lichtere taken. De Ryzen 7 8700G is ontworpen voor socket AM5 en wordt geleverd met een bijbehorende koeler, waardoor hij een veelzijdige en prestatiegerichte keuze kan zijn voor desktopcomputers.", "The AMD Ryzen 7 8700G processor offers a powerful 8-core CPU with a base clock speed of 4.20 GHz and a turbo clock speed of up to 5.10 GHz. This processor is equipped with the integrated AMD Radeon 780M graphics unit, making it suitable for both demanding applications and lighter tasks. The Ryzen 7 8700G is designed for socket AM5 and comes with a matching cooler, making it a versatile and performance-oriented choice for desktop computers.", "https://www.megekko.nl/productimg/261317/mini/1_AMD-Ryzen-7-8700G-Processor.jpg");
        Product product10 = new Product("AMD Ryzen 7 8700F", 723000, AMD, processoren, 249, "De AMD Ryzen 7 8700F is een krachtige processor uit de Ryzen 7-serie, ontworpen voor socket AM5. Met een basiskloktempo van 4,10 GHz en een turbosnelheid tot 5,00 GHz, biedt deze 8-core CPU uitstekende prestaties voor veeleisende taken. Hoewel er geen geïntegreerde grafische functies aanwezig zijn, wordt de processor geleverd met een bijpassende koeler voor een complete setup. Deze Ryzen 7-processor kan een waardevolle toevoeging zijn aan uw high-end computersysteem.", "The AMD Ryzen 7 8700F is a powerful processor from the Ryzen 7 series, designed for socket AM5. With a base clock of 4.10 GHz and a turbo speed of up to 5.00 GHz, this 8-core CPU offers excellent performance for demanding tasks. Although there are no integrated graphics features, the processor comes with a matching cooler for a complete setup. This Ryzen 7 processor can be a valuable addition to your high-end computer system.", "https://www.megekko.nl/productimg/261325/mini/1_AMD-Ryzen-7-8700F-Processor.jpg");


        Product product11 = new Product("MSI B760 GAMING PLUS WIFI", 388000, MSI, moederborden, 164, "Het MSI B760 GAMING PLUS WIFI moederbord is een krachtig en veelzijdig Intel Socket 1700 moederbord dat is uitgerust met de Intel B760-chipset. Met 4 geheugenslots en ondersteuning voor maximaal 192 GB DDR5-geheugen biedt het uitstekende prestaties. Daarnaast is het moederbord voorzien van Wi-Fi-connectiviteit en 2 M.2-slots voor snelle SSD-opslag. Het ATX-formaat maakt het geschikt voor diverse pc-configuraties.", "The MSI B760 GAMING PLUS WIFI motherboard is a powerful and versatile Intel Socket 1700 motherboard that is equipped with the Intel B760 chipset. With 4 memory slots and support for up to 192GB DDR5 memory, it offers excellent performance. In addition, the motherboard is equipped with Wi-Fi connectivity and 2 M.2 slots for fast SSD storage. The ATX format makes it suitable for various PC configurations.", "https://www.megekko.nl/productimg/1080950/mini/1_MSI-B760-GAMING-PLUS-WIFI-moederbord.jpg");
        Product product12 = new Product("ASUS ROG STRIX Z790-H GAMING WIFI", 4992000, Asus, moederborden, 245, "Het ASUS ROG STRIX Z790-H GAMING WIFI moederbord is een high-end ATX-formaat moederbord voor Intel Socket 1700 processoren. Het biedt ondersteuning voor maximaal 128GB DDR5-geheugen verspreid over 4 geheugenslots. Met één PCI-E 5.0 x16-slot en vier M.2-slots is dit moederbord uitgerust voor krachtige gaming-pc's. Daarnaast beschikt het over ingebouwde Wi-Fi-connectiviteit, waardoor je gemakkelijk kunt profiteren van draadloze internetverbindingen.", "The ASUS ROG STRIX Z790-H GAMING WIFI motherboard is a high-end ATX-sized motherboard for Intel Socket 1700 processors. It supports up to 128GB of DDR5 memory across 4 memory slots. With one PCI-E 5.0 x16 slot and four M.2 slots, this motherboard is equipped for powerful gaming PCs. In addition, it features built-in Wi-Fi connectivity, allowing you to easily enjoy wireless internet connections.", "https://www.megekko.nl/productimg/1075982/mini/1_ASUS-ROG-STRIX-Z790-H-GAMING-WIFI-moederbord.jpg");
        Product product13 = new Product("MSI PRO B760M-P DDR4", 273000, MSI, moederborden, 99, "Het MSI PRO B760M-P DDR4 moederbord is een krachtig Micro-ATX-moederbord voor de Intel Socket 1700-chipset. Het biedt vier geheugenslots voor maximaal 128 GB DDR4-geheugen, evenals twee M.2-slots voor snelle opslagoplossingen. Dit moederbord is ontworpen voor een breed scala aan toepassingen, van gaming tot professioneel gebruik, en biedt een solide basis voor uw pc-bouw.", "The MSI PRO B760M-P DDR4 motherboard is a powerful Micro-ATX motherboard for the Intel Socket 1700 chipset. It offers four memory slots for up to 128GB of DDR4 memory, as well as two M.2 slots for high-speed storage solutions. Designed for a wide range of applications from gaming to professional use, this motherboard provides a solid foundation for your PC build.", "https://www.megekko.nl/productimg/1074833/mini/1_MSI-PRO-B760M-P-DDR4-moederbord.jpg");
        Product product14 = new Product("MSI MAG Z790 TOMAHAWK WIFI", 383000, MSI, moederborden, 259, "Het MSI MAG Z790 TOMAHAWK WIFI is een krachtig ATX-moederbord voor Intel Socket 1700-processors. Met de Intel Z790-chipset, ondersteuning voor maximaal 128 GB DDR5-geheugen en 4 M.2-sleuven biedt dit moederbord de nodige prestaties en flexibiliteit voor veeleisende desktopcomputers. Daarnaast is het uitgerust met Wi-Fi en een enkele PCI-E 5.0 x16-sleuf voor geavanceerde grafische kaarten. Dit MSI-moederbord is een solide keuze voor enthousiastelingen die op zoek zijn naar een robuust en veelzijdig Intel Socket 1700-platform.", "The MSI MAG Z790 TOMAHAWK WIFI is a powerful ATX motherboard for Intel Socket 1700 processors. With the Intel Z790 chipset, support for up to 128GB DDR5 memory and 4 M.2 slots, this motherboard offers the necessary performance and flexibility for demanding desktop computers. In addition, it is equipped with Wi-Fi and a single PCI-E 5.0 x16 slot for advanced graphics cards.", "https://www.megekko.nl/productimg/1070478/mini/1_MSI-MAG-Z790-TOMAHAWK-WIFI-moederbord.jpg");
        Product product15 = new Product("Gigabyte B760 GAMING X", 222000, Gigabyte, moederborden, 388, "Het Gigabyte B760 GAMING X moederbord is een krachtig Intel Socket 1700 moederbord dat is ontworpen voor gaming en high-performance toepassingen. Met een ATX form factor, 4 geheugenslots voor maximaal 256 GB DDR5 geheugen en 3 M.2 slots, biedt dit moederbord de flexibiliteit en capaciteit die gebruikers nodig hebben voor hun high-end systemen. Het Intel B760 chipset zorgt voor een betrouwbare en efficiënte prestatie, waardoor dit moederbord een geweldige keuze is voor zowel gaming als professioneel gebruik.", "The Gigabyte B760 GAMING X motherboard is a powerful Intel Socket 1700 motherboard designed for gaming and high-performance applications. Featuring an ATX form factor, 4 memory slots for up to 256GB DDR5 memory and 3 M.2 slots, this motherboard offers the flexibility and capacity users need for their high-end systems.", "https://www.megekko.nl/productimg/1076241/mini/1_Gigabyte-B760-GAMING-X-moederbord.jpg");

        this.productsRepository.save(product5);
        this.productsRepository.save(product14);
        this.productsRepository.save(product7);
        this.productsRepository.save(product);
        this.productsRepository.save(product13);
        this.productsRepository.save(product6);
        this.productsRepository.save(product3);
        this.productsRepository.save(product10);
        this.productsRepository.save(product15);
        this.productsRepository.save(product8);
        this.productsRepository.save(product4);
        this.productsRepository.save(product12);
        this.productsRepository.save(product2);
        this.productsRepository.save(product9);
        this.productsRepository.save(product11);


    }

}
